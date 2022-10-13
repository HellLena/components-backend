/*
 * This file is generated by jOOQ.
 */
package org.example.components.domain;


import org.example.components.domain.tables.Bom;
import org.example.components.domain.tables.Element;
import org.example.components.domain.tables.ElementType;
import org.example.components.domain.tables.Footprint;
import org.example.components.domain.tables.Manufacturer;
import org.example.components.domain.tables.Unit;
import org.example.components.domain.tables.UnitType;
import org.example.components.domain.tables.records.BomRecord;
import org.example.components.domain.tables.records.ElementRecord;
import org.example.components.domain.tables.records.ElementTypeRecord;
import org.example.components.domain.tables.records.FootprintRecord;
import org.example.components.domain.tables.records.ManufacturerRecord;
import org.example.components.domain.tables.records.UnitRecord;
import org.example.components.domain.tables.records.UnitTypeRecord;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<BomRecord, Long> IDENTITY_BOM = Identities0.IDENTITY_BOM;
    public static final Identity<ElementRecord, Long> IDENTITY_ELEMENT = Identities0.IDENTITY_ELEMENT;
    public static final Identity<ElementTypeRecord, Long> IDENTITY_ELEMENT_TYPE = Identities0.IDENTITY_ELEMENT_TYPE;
    public static final Identity<FootprintRecord, Long> IDENTITY_FOOTPRINT = Identities0.IDENTITY_FOOTPRINT;
    public static final Identity<ManufacturerRecord, Long> IDENTITY_MANUFACTURER = Identities0.IDENTITY_MANUFACTURER;
    public static final Identity<UnitRecord, Long> IDENTITY_UNIT = Identities0.IDENTITY_UNIT;
    public static final Identity<UnitTypeRecord, Long> IDENTITY_UNIT_TYPE = Identities0.IDENTITY_UNIT_TYPE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BomRecord> BOM_PKEY = UniqueKeys0.BOM_PKEY;
    public static final UniqueKey<BomRecord> BOM_UNIT_ID_DESIGNATOR_KEY = UniqueKeys0.BOM_UNIT_ID_DESIGNATOR_KEY;
    public static final UniqueKey<ElementRecord> ELEMENT_PKEY = UniqueKeys0.ELEMENT_PKEY;
    public static final UniqueKey<ElementRecord> ELEMENT_MANUFACTURER_NUMBER_DESCRIPTION_KEY = UniqueKeys0.ELEMENT_MANUFACTURER_NUMBER_DESCRIPTION_KEY;
    public static final UniqueKey<ElementTypeRecord> ELEMENT_TYPE_PKEY = UniqueKeys0.ELEMENT_TYPE_PKEY;
    public static final UniqueKey<ElementTypeRecord> ELEMENT_TYPE_NAME_KEY = UniqueKeys0.ELEMENT_TYPE_NAME_KEY;
    public static final UniqueKey<FootprintRecord> FOOTPRINT_PKEY = UniqueKeys0.FOOTPRINT_PKEY;
    public static final UniqueKey<FootprintRecord> FOOTPRINT_NAME_KEY = UniqueKeys0.FOOTPRINT_NAME_KEY;
    public static final UniqueKey<ManufacturerRecord> MANUFACTURER_PKEY = UniqueKeys0.MANUFACTURER_PKEY;
    public static final UniqueKey<ManufacturerRecord> MANUFACTURER_NAME_KEY = UniqueKeys0.MANUFACTURER_NAME_KEY;
    public static final UniqueKey<UnitRecord> UNIT_PKEY = UniqueKeys0.UNIT_PKEY;
    public static final UniqueKey<UnitRecord> UNIT_DECIMAL_NAME_KEY = UniqueKeys0.UNIT_DECIMAL_NAME_KEY;
    public static final UniqueKey<UnitTypeRecord> UNIT_TYPE_PKEY = UniqueKeys0.UNIT_TYPE_PKEY;
    public static final UniqueKey<UnitTypeRecord> UNIT_TYPE_NAME_KEY = UniqueKeys0.UNIT_TYPE_NAME_KEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BomRecord, UnitRecord> BOM__BOM_UNIT_ID_FKEY = ForeignKeys0.BOM__BOM_UNIT_ID_FKEY;
    public static final ForeignKey<BomRecord, ElementRecord> BOM__BOM_ELEMENT_ID_FKEY = ForeignKeys0.BOM__BOM_ELEMENT_ID_FKEY;
    public static final ForeignKey<BomRecord, FootprintRecord> BOM__BOM_FOOTPRINT_ID_FKEY = ForeignKeys0.BOM__BOM_FOOTPRINT_ID_FKEY;
    public static final ForeignKey<ElementRecord, ElementTypeRecord> ELEMENT__ELEMENT_ELEMENT_TYPE_ID_FKEY = ForeignKeys0.ELEMENT__ELEMENT_ELEMENT_TYPE_ID_FKEY;
    public static final ForeignKey<ElementRecord, ManufacturerRecord> ELEMENT__ELEMENT_MANUFACTURER_ID_FKEY = ForeignKeys0.ELEMENT__ELEMENT_MANUFACTURER_ID_FKEY;
    public static final ForeignKey<UnitRecord, UnitTypeRecord> UNIT__UNIT_UNIT_TYPE_ID_FKEY = ForeignKeys0.UNIT__UNIT_UNIT_TYPE_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<BomRecord, Long> IDENTITY_BOM = Internal.createIdentity(Bom.BOM, Bom.BOM.ID);
        public static Identity<ElementRecord, Long> IDENTITY_ELEMENT = Internal.createIdentity(Element.ELEMENT, Element.ELEMENT.ID);
        public static Identity<ElementTypeRecord, Long> IDENTITY_ELEMENT_TYPE = Internal.createIdentity(ElementType.ELEMENT_TYPE, ElementType.ELEMENT_TYPE.ID);
        public static Identity<FootprintRecord, Long> IDENTITY_FOOTPRINT = Internal.createIdentity(Footprint.FOOTPRINT, Footprint.FOOTPRINT.ID);
        public static Identity<ManufacturerRecord, Long> IDENTITY_MANUFACTURER = Internal.createIdentity(Manufacturer.MANUFACTURER, Manufacturer.MANUFACTURER.ID);
        public static Identity<UnitRecord, Long> IDENTITY_UNIT = Internal.createIdentity(Unit.UNIT, Unit.UNIT.ID);
        public static Identity<UnitTypeRecord, Long> IDENTITY_UNIT_TYPE = Internal.createIdentity(UnitType.UNIT_TYPE, UnitType.UNIT_TYPE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<BomRecord> BOM_PKEY = Internal.createUniqueKey(Bom.BOM, "bom_pkey", new TableField[] { Bom.BOM.ID }, true);
        public static final UniqueKey<BomRecord> BOM_UNIT_ID_DESIGNATOR_KEY = Internal.createUniqueKey(Bom.BOM, "bom_unit_id_designator_key", new TableField[] { Bom.BOM.UNIT_ID, Bom.BOM.DESIGNATOR }, true);
        public static final UniqueKey<ElementRecord> ELEMENT_PKEY = Internal.createUniqueKey(Element.ELEMENT, "element_pkey", new TableField[] { Element.ELEMENT.ID }, true);
        public static final UniqueKey<ElementRecord> ELEMENT_MANUFACTURER_NUMBER_DESCRIPTION_KEY = Internal.createUniqueKey(Element.ELEMENT, "element_manufacturer_number_description_key", new TableField[] { Element.ELEMENT.MANUFACTURER_NUMBER, Element.ELEMENT.DESCRIPTION }, true);
        public static final UniqueKey<ElementTypeRecord> ELEMENT_TYPE_PKEY = Internal.createUniqueKey(ElementType.ELEMENT_TYPE, "element_type_pkey", new TableField[] { ElementType.ELEMENT_TYPE.ID }, true);
        public static final UniqueKey<ElementTypeRecord> ELEMENT_TYPE_NAME_KEY = Internal.createUniqueKey(ElementType.ELEMENT_TYPE, "element_type_name_key", new TableField[] { ElementType.ELEMENT_TYPE.NAME }, true);
        public static final UniqueKey<FootprintRecord> FOOTPRINT_PKEY = Internal.createUniqueKey(Footprint.FOOTPRINT, "footprint_pkey", new TableField[] { Footprint.FOOTPRINT.ID }, true);
        public static final UniqueKey<FootprintRecord> FOOTPRINT_NAME_KEY = Internal.createUniqueKey(Footprint.FOOTPRINT, "footprint_name_key", new TableField[] { Footprint.FOOTPRINT.NAME }, true);
        public static final UniqueKey<ManufacturerRecord> MANUFACTURER_PKEY = Internal.createUniqueKey(Manufacturer.MANUFACTURER, "manufacturer_pkey", new TableField[] { Manufacturer.MANUFACTURER.ID }, true);
        public static final UniqueKey<ManufacturerRecord> MANUFACTURER_NAME_KEY = Internal.createUniqueKey(Manufacturer.MANUFACTURER, "manufacturer_name_key", new TableField[] { Manufacturer.MANUFACTURER.NAME }, true);
        public static final UniqueKey<UnitRecord> UNIT_PKEY = Internal.createUniqueKey(Unit.UNIT, "unit_pkey", new TableField[] { Unit.UNIT.ID }, true);
        public static final UniqueKey<UnitRecord> UNIT_DECIMAL_NAME_KEY = Internal.createUniqueKey(Unit.UNIT, "unit_decimal_name_key", new TableField[] { Unit.UNIT.DECIMAL_NAME }, true);
        public static final UniqueKey<UnitTypeRecord> UNIT_TYPE_PKEY = Internal.createUniqueKey(UnitType.UNIT_TYPE, "unit_type_pkey", new TableField[] { UnitType.UNIT_TYPE.ID }, true);
        public static final UniqueKey<UnitTypeRecord> UNIT_TYPE_NAME_KEY = Internal.createUniqueKey(UnitType.UNIT_TYPE, "unit_type_name_key", new TableField[] { UnitType.UNIT_TYPE.NAME }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<BomRecord, UnitRecord> BOM__BOM_UNIT_ID_FKEY = Internal.createForeignKey(Keys.UNIT_PKEY, Bom.BOM, "bom_unit_id_fkey", new TableField[] { Bom.BOM.UNIT_ID }, true);
        public static final ForeignKey<BomRecord, ElementRecord> BOM__BOM_ELEMENT_ID_FKEY = Internal.createForeignKey(Keys.ELEMENT_PKEY, Bom.BOM, "bom_element_id_fkey", new TableField[] { Bom.BOM.ELEMENT_ID }, true);
        public static final ForeignKey<BomRecord, FootprintRecord> BOM__BOM_FOOTPRINT_ID_FKEY = Internal.createForeignKey(Keys.FOOTPRINT_PKEY, Bom.BOM, "bom_footprint_id_fkey", new TableField[] { Bom.BOM.FOOTPRINT_ID }, true);
        public static final ForeignKey<ElementRecord, ElementTypeRecord> ELEMENT__ELEMENT_ELEMENT_TYPE_ID_FKEY = Internal.createForeignKey(Keys.ELEMENT_TYPE_PKEY, Element.ELEMENT, "element_element_type_id_fkey", new TableField[] { Element.ELEMENT.ELEMENT_TYPE_ID }, true);
        public static final ForeignKey<ElementRecord, ManufacturerRecord> ELEMENT__ELEMENT_MANUFACTURER_ID_FKEY = Internal.createForeignKey(Keys.MANUFACTURER_PKEY, Element.ELEMENT, "element_manufacturer_id_fkey", new TableField[] { Element.ELEMENT.MANUFACTURER_ID }, true);
        public static final ForeignKey<UnitRecord, UnitTypeRecord> UNIT__UNIT_UNIT_TYPE_ID_FKEY = Internal.createForeignKey(Keys.UNIT_TYPE_PKEY, Unit.UNIT, "unit_unit_type_id_fkey", new TableField[] { Unit.UNIT.UNIT_TYPE_ID }, true);
    }
}
