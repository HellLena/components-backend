package org.example.components.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jooq.SortOrder;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    private int page;
    private int pageSize;
    private String sortBy;
    private SortOrder order;
    private String query;

}
