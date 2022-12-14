/*
 * This file is generated by jOOQ.
 */
package org.example.components.domain.tables;


import org.example.components.domain.Keys;
import org.example.components.domain.Public;
import org.example.components.domain.tables.records.ElementTypeRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElementType extends TableImpl<ElementTypeRecord> {

    private static final long serialVersionUID = -2047008152;

    /**
     * The reference instance of <code>public.element_type</code>
     */
    public static final ElementType ELEMENT_TYPE = new ElementType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ElementTypeRecord> getRecordType() {
        return ElementTypeRecord.class;
    }

    /**
     * The column <code>public.element_type.id</code>.
     */
    public final TableField<ElementTypeRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('element_type_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.element_type.name</code>.
     */
    public final TableField<ElementTypeRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.element_type.status</code>.
     */
    public final TableField<ElementTypeRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false).defaultValue(org.jooq.impl.DSL.field("'MODERATION'::character varying", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>public.element_type</code> table reference
     */
    public ElementType() {
        this(DSL.name("element_type"), null);
    }

    /**
     * Create an aliased <code>public.element_type</code> table reference
     */
    public ElementType(String alias) {
        this(DSL.name(alias), ELEMENT_TYPE);
    }

    /**
     * Create an aliased <code>public.element_type</code> table reference
     */
    public ElementType(Name alias) {
        this(alias, ELEMENT_TYPE);
    }

    private ElementType(Name alias, Table<ElementTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private ElementType(Name alias, Table<ElementTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> ElementType(Table<O> child, ForeignKey<O, ElementTypeRecord> key) {
        super(child, key, ELEMENT_TYPE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<ElementTypeRecord, Long> getIdentity() {
        return Keys.IDENTITY_ELEMENT_TYPE;
    }

    @Override
    public UniqueKey<ElementTypeRecord> getPrimaryKey() {
        return Keys.ELEMENT_TYPE_PKEY;
    }

    @Override
    public List<UniqueKey<ElementTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<ElementTypeRecord>>asList(Keys.ELEMENT_TYPE_PKEY, Keys.ELEMENT_TYPE_NAME_KEY);
    }

    @Override
    public ElementType as(String alias) {
        return new ElementType(DSL.name(alias), this);
    }

    @Override
    public ElementType as(Name alias) {
        return new ElementType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ElementType rename(String name) {
        return new ElementType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ElementType rename(Name name) {
        return new ElementType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
