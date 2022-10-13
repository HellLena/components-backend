package org.example.components.handler.bom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.handler.ParserHandler;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.model.parser.BomDataWrapper;
import org.example.components.repository.ElementRepository;
import org.example.components.service.ElementTypeService;
import org.example.components.service.ManufacturerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Order(2)
@Component
@RequiredArgsConstructor
public class BomElementParserHandler implements ParserHandler<BomDataWrapper> {

    private final ElementRepository elementRepository;
    private final ElementTypeService elementTypeService;
    private final ManufacturerService manufacturerService;

    @Override
    public Class<BomDataWrapper> getSupportedType() {
        return BomDataWrapper.class;
    }

    @Override
    public void handle(BomDataWrapper dataWrapper) {
        log.debug("Elements parsing started for unit id={}", dataWrapper.getUnitId());

        Map<String, Long> elementTypes = new HashMap<>();
        Map<String, Long> manufacturers = new HashMap<>();
        Set<ElementCreateDto> elements = dataWrapper.getData().stream()
                .map(bom -> ElementCreateDto.builder()
                        .elementTypeId(elementTypeService.findIdByNameCached(elementTypes, bom.getBomType()))
                        .manufacturerId(manufacturerService.findIdByNameCached(manufacturers, bom.getBomManufacturer()))
                        .manufacturerNumber(bom.getBomValue())
                        .description(bom.getBomDescription())
                        .build())
                .collect(Collectors.toSet());

        elementRepository.batchCreate(deduplicateElements(elements));
    }

    /**
     * Search for elements with the same manufacturer number but different descriptions.
     *
     * @param elements set of elements
     * @return new set of elements where instead of multiple elements with the same manufacturer number returns only
     * one element with max length of description
     */
    private Set<ElementCreateDto> deduplicateElements(Set<ElementCreateDto> elements) {
        Set<ElementCreateDto> result = elements.stream()
                .filter(e -> Objects.isNull(e.getManufacturerNumber()))
                .collect(Collectors.toSet());

        Map<String, List<ElementCreateDto>> duplicatedElements = elements.stream()
                .filter(e -> Objects.nonNull(e.getManufacturerNumber()))
                .collect(Collectors.groupingBy(ElementCreateDto::getManufacturerNumber));

        duplicatedElements.values()
                .forEach(elementsList -> {
                    if (1 == elementsList.size()) {
                        result.add(elementsList.get(0));
                    } else {
                        elementsList.stream()
                                .max(Comparator.comparing(ElementCreateDto::getDescription))
                                .ifPresent(result::add);
                    }
                });

        return result;
    }

}
