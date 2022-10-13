package org.example.components.handler.bom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.enumerations.CommonStatus;
import org.example.components.handler.ParserHandler;
import org.example.components.model.ElementDto;
import org.example.components.model.ElementKey;
import org.example.components.model.FootprintDto;
import org.example.components.model.create.BomCreateDto;
import org.example.components.model.parser.BomDataWrapper;
import org.example.components.repository.BomRepository;
import org.example.components.service.ElementService;
import org.example.components.service.FootprintService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static org.example.components.enumerations.CommonStatus.APPROVED;
import static org.example.components.enumerations.CommonStatus.MODERATION;

@Slf4j
@Order(2)
@Component
@RequiredArgsConstructor
public class BomParserHandler implements ParserHandler<BomDataWrapper> {

    private final BomRepository bomRepository;
    private final ElementService elementService;
    private final FootprintService footprintService;

    private static final String FITTED = "Fitted";

    @Override
    public Class<BomDataWrapper> getSupportedType() {
        return BomDataWrapper.class;
    }

    @Override
    public void handle(BomDataWrapper dataWrapper) {
        log.debug("BoM parsing started for unit id={}", dataWrapper.getUnitId());

        Map<ElementKey, ElementDto> elements = new HashMap<>();
        Map<String, FootprintDto> footprints = new HashMap<>();
        Set<BomCreateDto> boms = dataWrapper.getData().stream()
                .map(bom -> {
                    ElementDto elementDto = elementService.findByNameCached(
                            elements, new ElementKey(bom.getBomValue(), bom.getBomDescription()));
                    FootprintDto footprintDto = footprintService.findByNameCached(footprints, bom.getFootprint());
                    return BomCreateDto.builder()
                            .unitId(dataWrapper.getUnitId())
                            .designator(bom.getDesignator())
                            .elementId(ofNullable(elementDto).map(ElementDto::getId).orElse(null))
                            .footprintId(ofNullable(footprintDto).map(FootprintDto::getId).orElse(null))
                            .quantity(bom.getQuantity())
                            .fitted(FITTED.equals(bom.getFitted()))
                            .canBeReplaced(false) // TODO
                            .status(getStatus(elementDto, footprintDto))
                            .build();
                })
                .collect(Collectors.toSet());

        bomRepository.batchCreate(boms);
    }

    private CommonStatus getStatus(ElementDto elementDto, FootprintDto footprintDto) {
        return Objects.nonNull(elementDto) && MODERATION.equals(elementDto.getStatus())
                || Objects.nonNull(footprintDto) && MODERATION.equals(footprintDto.getStatus())
                ? MODERATION : APPROVED;
    }

}
