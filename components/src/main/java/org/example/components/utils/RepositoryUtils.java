package org.example.components.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Field;

import java.util.Objects;

import static org.jooq.impl.DSL.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RepositoryUtils {

    public static Field<Object> getSortedField(String sortBy, String order) {
        Objects.requireNonNull(sortBy);

        if (StringUtils.isBlank(order)) {
            return field(sortBy);
        }

        return field(sortBy + " " + order);
    }

}
