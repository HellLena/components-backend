/*
 * This file is generated by jOOQ.
 */
package org.example.components.domain.tables;


import org.example.components.domain.Keys;
import org.example.components.domain.Public;
import org.example.components.domain.tables.records.UnitRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Unit extends TableImpl<UnitRecord> {

    private static final long serialVersionUID = -150208711;

    /**
     * The reference instance of <code>public.unit</code>
     */
    public static final Unit UNIT = new Unit();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UnitRecord> getRecordType() {
        return UnitRecord.class;
    }

    /**
     * The column <code>public.unit.id</code>.
     */
    public final TableField<UnitRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('unit_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.unit.unit_type_id</code>.
     */
    public final TableField<UnitRecord, Integer> UNIT_TYPE_ID = createField(DSL.name("unit_type_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.unit.decimal_name</code>.
     */
    public final TableField<UnitRecord, String> DECIMAL_NAME = createField(DSL.name("decimal_name"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.unit.created_at</code>.
     */
    public final TableField<UnitRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.unit.updated_at</code>.
     */
    public final TableField<UnitRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>public.unit.bomfiledata</code>.
     */
    public final TableField<UnitRecord, String> BOMFILEDATA = createField(DSL.name("bomfiledata"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.unit.bomfilename</code>.
     */
    public final TableField<UnitRecord, String> BOMFILENAME = createField(DSL.name("bomfilename"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.unit.bomstatus</code>.
     */
    public final TableField<UnitRecord, String> BOMSTATUS = createField(DSL.name("bomstatus"), org.jooq.impl.SQLDataType.VARCHAR(25), this, "");

    /**
     * Create a <code>public.unit</code> table reference
     */
    public Unit() {
        this(DSL.name("unit"), null);
    }

    /**
     * Create an aliased <code>public.unit</code> table reference
     */
    public Unit(String alias) {
        this(DSL.name(alias), UNIT);
    }

    /**
     * Create an aliased <code>public.unit</code> table reference
     */
    public Unit(Name alias) {
        this(alias, UNIT);
    }

    private Unit(Name alias, Table<UnitRecord> aliased) {
        this(alias, aliased, null);
    }

    private Unit(Name alias, Table<UnitRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Unit(Table<O> child, ForeignKey<O, UnitRecord> key) {
        super(child, key, UNIT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<UnitRecord, Long> getIdentity() {
        return Keys.IDENTITY_UNIT;
    }

    @Override
    public UniqueKey<UnitRecord> getPrimaryKey() {
        return Keys.UNIT_PKEY;
    }

    @Override
    public List<UniqueKey<UnitRecord>> getKeys() {
        return Arrays.<UniqueKey<UnitRecord>>asList(Keys.UNIT_PKEY, Keys.UNIT_DECIMAL_NAME_KEY);
    }

    @Override
    public List<ForeignKey<UnitRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UnitRecord, ?>>asList(Keys.UNIT__UNIT_UNIT_TYPE_ID_FKEY);
    }

    public UnitType unitType() {
        return new UnitType(this, Keys.UNIT__UNIT_UNIT_TYPE_ID_FKEY);
    }

    @Override
    public Unit as(String alias) {
        return new Unit(DSL.name(alias), this);
    }

    @Override
    public Unit as(Name alias) {
        return new Unit(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Unit rename(String name) {
        return new Unit(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Unit rename(Name name) {
        return new Unit(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Integer, String, LocalDateTime, LocalDateTime, String, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
