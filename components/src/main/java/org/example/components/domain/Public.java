/*
 * This file is generated by jOOQ.
 */
package org.example.components.domain;


import java.util.Arrays;
import java.util.List;

import org.example.components.domain.tables.Bom;
import org.example.components.domain.tables.Element;
import org.example.components.domain.tables.ElementType;
import org.example.components.domain.tables.Footprint;
import org.example.components.domain.tables.Manufacturer;
import org.example.components.domain.tables.Unit;
import org.example.components.domain.tables.UnitType;
import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -303039622;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.bom</code>.
     */
    public final Bom BOM = Bom.BOM;

    /**
     * The table <code>public.element</code>.
     */
    public final Element ELEMENT = Element.ELEMENT;

    /**
     * The table <code>public.element_type</code>.
     */
    public final ElementType ELEMENT_TYPE = ElementType.ELEMENT_TYPE;

    /**
     * The table <code>public.footprint</code>.
     */
    public final Footprint FOOTPRINT = Footprint.FOOTPRINT;

    /**
     * The table <code>public.manufacturer</code>.
     */
    public final Manufacturer MANUFACTURER = Manufacturer.MANUFACTURER;

    /**
     * The table <code>public.unit</code>.
     */
    public final Unit UNIT = Unit.UNIT;

    /**
     * The table <code>public.unit_type</code>.
     */
    public final UnitType UNIT_TYPE = UnitType.UNIT_TYPE;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.<Sequence<?>>asList(
            Sequences.BOM_ID_SEQ,
            Sequences.ELEMENT_ID_SEQ,
            Sequences.ELEMENT_TYPE_ID_SEQ,
            Sequences.FOOTPRINT_ID_SEQ,
            Sequences.MANUFACTURER_ID_SEQ,
            Sequences.UNIT_ID_SEQ,
            Sequences.UNIT_TYPE_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Bom.BOM,
            Element.ELEMENT,
            ElementType.ELEMENT_TYPE,
            Footprint.FOOTPRINT,
            Manufacturer.MANUFACTURER,
            Unit.UNIT,
            UnitType.UNIT_TYPE);
    }
}
