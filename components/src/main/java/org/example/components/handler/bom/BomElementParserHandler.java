package org.example.components.handler.bom;

import lombok.RequiredArgsConstructor;
import org.example.components.handler.ParserHandler;
import org.example.components.model.create.ElementCreateDto;
import org.example.components.model.parser.BomDataWrapper;
import org.example.components.repository.ElementRepository;
import org.example.components.service.ElementTypeService;
import org.example.components.service.ManufacturerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

        elementRepository.batchCreate(elements);
    }

}
