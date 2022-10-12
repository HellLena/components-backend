/*
 * This file is generated by jOOQ.
 */
package org.example.components.domain.tables;


import org.example.components.domain.Keys;
import org.example.components.domain.Public;
import org.example.components.domain.tables.records.BomRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bom extends TableImpl<BomRecord> {

    private static final long serialVersionUID = -1033804350;

    /**
     * The reference instance of <code>public.bom</code>
     */
    public static final Bom BOM = new Bom();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BomRecord> getRecordType() {
        return BomRecord.class;
    }

    /**
     * The column <code>public.bom.id</code>.
     */
    public final TableField<BomRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('bom_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.bom.unit_id</code>.
     */
    public final TableField<BomRecord, Integer> UNIT_ID = createField(DSL.name("unit_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.bom.designator</code>.
     */
    public final TableField<BomRecord, String> DESIGNATOR = createField(DSL.name("designator"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>public.bom.element_id</code>.
     */
    public final TableField<BomRecord, Integer> ELEMENT_ID = createField(DSL.name("element_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.bom.footprint_id</code>.
     */
    public final TableField<BomRecord, Integer> FOOTPRINT_ID = createField(DSL.name("footprint_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.bom.quantity</code>.
     */
    public final TableField<BomRecord, Integer> QUANTITY = createField(DSL.name("quantity"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.bom.fitted</code>.
     */
    public final TableField<BomRecord, Boolean> FITTED = createField(DSL.name("fitted"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.bom.can_be_replaced</code>.
     */
    public final TableField<BomRecord, Boolean> CAN_BE_REPLACED = createField(DSL.name("can_be_replaced"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.bom.status</code>.
     */
    public final TableField<BomRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * Create a <code>public.bom</code> table reference
     */
    public Bom() {
        this(DSL.name("bom"), null);
    }

    /**
     * Create an aliased <code>public.bom</code> table reference
     */
    public Bom(String alias) {
        this(DSL.name(alias), BOM);
    }

    /**
     * Create an aliased <code>public.bom</code> table reference
     */
    public Bom(Name alias) {
        this(alias, BOM);
    }

    private Bom(Name alias, Table<BomRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bom(Name alias, Table<BomRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Bom(Table<O> child, ForeignKey<O, BomRecord> key) {
        super(child, key, BOM);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<BomRecord, Long> getIdentity() {
        return Keys.IDENTITY_BOM;
    }

    @Override
    public UniqueKey<BomRecord> getPrimaryKey() {
        return Keys.BOM_PKEY;
    }

    @Override
    public List<UniqueKey<BomRecord>> getKeys() {
        return Arrays.<UniqueKey<BomRecord>>asList(Keys.BOM_PKEY, Keys.BOM_UNIT_ID_DESIGNATOR_KEY);
    }

    @Override
    public List<ForeignKey<BomRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BomRecord, ?>>asList(Keys.BOM__BOM_UNIT_ID_FKEY, Keys.BOM__BOM_ELEMENT_ID_FKEY, Keys.BOM__BOM_FOOTPRINT_ID_FKEY);
    }

    public Unit unit() {
        return new Unit(this, Keys.BOM__BOM_UNIT_ID_FKEY);
    }

    public Element element() {
        return new Element(this, Keys.BOM__BOM_ELEMENT_ID_FKEY);
    }

    public Footprint footprint() {
        return new Footprint(this, Keys.BOM__BOM_FOOTPRINT_ID_FKEY);
    }

    @Override
    public Bom as(String alias) {
        return new Bom(DSL.name(alias), this);
    }

    @Override
    public Bom as(Name alias) {
        return new Bom(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bom rename(String name) {
        return new Bom(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bom rename(Name name) {
        return new Bom(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, Integer, String, Integer, Integer, Integer, Boolean, Boolean, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
