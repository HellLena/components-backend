package org.example.components.model.parser;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BomFileData {

    @CsvBindByName(column = "Designator")
    private final String designator;
    @CsvBindByName(column = "BOM_type")
    private final String bomType;
    @CsvBindByName(column = "BOM_value")
    private final String bomValue;
    @CsvBindByName(column = "BOM_description")
    private final String bomDescription;
    @CsvBindByName(column = "BOM_manufacturer")
    private final String bomManufacturer;
    @CsvBindByName(column = "Footprint")
    private final String footprint;
    @CsvBindByName(column = "Quantity")
    private final int quantity;
    @CsvBindByName(column = "Fitted")
    private final String fitted;

}
