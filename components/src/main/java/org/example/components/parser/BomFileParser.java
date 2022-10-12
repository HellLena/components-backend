package org.example.components.parser;

import lombok.Getter;
import org.example.components.model.parser.BomFileData;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BomFileParser extends CommonFileParser<BomFileData> {

    private final char separator = ',';
    private final int skipLines = 2;

    @Override
    public Class<BomFileData> getSupportedType() {
        return BomFileData.class;
    }

}
