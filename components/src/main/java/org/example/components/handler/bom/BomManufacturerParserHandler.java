package org.example.components.handler.bom;

import lombok.RequiredArgsConstructor;
import org.example.components.handler.ParserHandler;
import org.example.components.model.create.ManufacturerCreateDto;
import org.example.components.model.parser.BomDataWrapper;
import org.example.components.model.parser.BomFileData;
import org.example.components.repository.ManufacturerRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

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
        Set<ManufacturerCreateDto> manufacturers = dataWrapper.getData().stream()
                .map(BomFileData::getBomManufacturer)
                .map(ManufacturerCreateDto::new)
                .collect(Collectors.toSet());

        manufacturerRepository.batchCreate(manufacturers);
    }
}
