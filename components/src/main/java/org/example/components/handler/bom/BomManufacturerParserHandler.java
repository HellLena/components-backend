package org.example.components.handler.bom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.handler.ParserHandler;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.model.parser.BomDataWrapper;
import org.example.components.model.parser.BomFileData;
import org.example.components.repository.ManufacturerRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Order(1)
@Component
@RequiredArgsConstructor
public class BomManufacturerParserHandler implements ParserHandler<BomDataWrapper> {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    public Class<BomDataWrapper> getSupportedType() {
        return BomDataWrapper.class;
    }

    @Override
    public void handle(BomDataWrapper dataWrapper) {
        log.debug("Manufacturer parsing started for unit id={}", dataWrapper.getUnitId());

        Set<ManufacturerCreateDto> manufacturers = dataWrapper.getData().stream()
                .map(BomFileData::getBomManufacturer)
                .map(ManufacturerCreateDto::new)
                .collect(Collectors.toSet());

        manufacturerRepository.batchCreate(manufacturers);
    }
}
