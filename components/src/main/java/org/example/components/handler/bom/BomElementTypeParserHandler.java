package org.example.components.handler.bom;

import lombok.RequiredArgsConstructor;
import org.example.components.handler.ParserHandler;
import org.example.components.model.create.ElementTypeCreateDto;
import org.example.components.model.parser.BomDataWrapper;
import org.example.components.model.parser.BomFileData;
import org.example.components.repository.ElementTypeRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Order(1)
@Component
@RequiredArgsConstructor
public class BomElementTypeParserHandler implements ParserHandler<BomDataWrapper> {

    private final ElementTypeRepository elementTypeRepository;

    @Override
    public Class<BomDataWrapper> getSupportedType() {
        return BomDataWrapper.class;
    }

    @Override
    public void handle(BomDataWrapper dataWrapper) {
        Set<ElementTypeCreateDto> elementTypes = dataWrapper.getData().stream()
                .map(BomFileData::getBomType)
                .map(ElementTypeCreateDto::new)
                .collect(Collectors.toSet());

        elementTypeRepository.batchCreate(elementTypes);
    }
}
