package org.example.components.handler.bom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.components.handler.ParserHandler;
import org.example.components.model.create.FootprintCreateDto;
import org.example.components.model.parser.BomDataWrapper;
import org.example.components.model.parser.BomFileData;
import org.example.components.repository.FootprintRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Order(1)
@Component
@RequiredArgsConstructor
public class BomFootprintParserHandler implements ParserHandler<BomDataWrapper> {

    private final FootprintRepository footprintRepository;

    @Override
    public Class<BomDataWrapper> getSupportedType() {
        return BomDataWrapper.class;
    }

    @Override
    public void handle(BomDataWrapper dataWrapper) {
        log.debug("Footprints parsing started for unit id={}", dataWrapper.getUnitId());

        Set<FootprintCreateDto> footprints = dataWrapper.getData().stream()
                .map(BomFileData::getFootprint)
                .filter(StringUtils::isNotBlank)
                .map(String::trim)
                .map(FootprintCreateDto::new)
                .collect(Collectors.toSet());

        footprintRepository.batchCreate(footprints);
    }
}
