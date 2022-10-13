package org.example.components.model.parser;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BomFileData {

    @CsvBindByPosition(position = 0)
    private String designator;
    @CsvBindByPosition(position = 1)
    private String bomType;
    @CsvBindByPosition(position = 2)
    private String bomValue;
    @CsvBindByPosition(position = 3)
    private String bomDescription;
    @CsvBindByPosition(position = 4)
    private String bomManufacturer;
    @CsvBindByPosition(position = 5)
    private String footprint;
    @CsvBindByPosition(position = 6)
    private int quantity;
    @CsvBindByPosition(position = 7)
    private String fitted;

}
