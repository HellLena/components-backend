/*
 * This file is generated by jOOQ.
 */
package org.example.components.domain.tables.records;


import org.example.components.domain.tables.Element;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElementRecord extends UpdatableRecordImpl<ElementRecord> implements Record6<Long, Long, Long, String, String, String> {

    private static final long serialVersionUID = -1023965998;

    /**
     * Setter for <code>public.element.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.element.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.element.element_type_id</code>.
     */
    public void setElementTypeId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.element.element_type_id</code>.
     */
    public Long getElementTypeId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.element.manufacturer_id</code>.
     */
    public void setManufacturerId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.element.manufacturer_id</code>.
     */
    public Long getManufacturerId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.element.manufacturer_number</code>.
     */
    public void setManufacturerNumber(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.element.manufacturer_number</code>.
     */
    public String getManufacturerNumber() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.element.description</code>.
     */
    public void setDescription(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.element.description</code>.
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.element.status</code>.
     */
    public void setStatus(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.element.status</code>.
     */
    public String getStatus() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, Long, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, Long, Long, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Element.ELEMENT.ID;
    }

    @Override
    public Field<Long> field2() {
        return Element.ELEMENT.ELEMENT_TYPE_ID;
    }

    @Override
    public Field<Long> field3() {
        return Element.ELEMENT.MANUFACTURER_ID;
    }

    @Override
    public Field<String> field4() {
        return Element.ELEMENT.MANUFACTURER_NUMBER;
    }

    @Override
    public Field<String> field5() {
        return Element.ELEMENT.DESCRIPTION;
    }

    @Override
    public Field<String> field6() {
        return Element.ELEMENT.STATUS;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getElementTypeId();
    }

    @Override
    public Long component3() {
        return getManufacturerId();
    }

    @Override
    public String component4() {
        return getManufacturerNumber();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public String component6() {
        return getStatus();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getElementTypeId();
    }

    @Override
    public Long value3() {
        return getManufacturerId();
    }

    @Override
    public String value4() {
        return getManufacturerNumber();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public String value6() {
        return getStatus();
    }

    @Override
    public ElementRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ElementRecord value2(Long value) {
        setElementTypeId(value);
        return this;
    }

    @Override
    public ElementRecord value3(Long value) {
        setManufacturerId(value);
        return this;
    }

    @Override
    public ElementRecord value4(String value) {
        setManufacturerNumber(value);
        return this;
    }

    @Override
    public ElementRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public ElementRecord value6(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public ElementRecord values(Long value1, Long value2, Long value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ElementRecord
     */
    public ElementRecord() {
        super(Element.ELEMENT);
    }

    /**
     * Create a detached, initialised ElementRecord
     */
    public ElementRecord(Long id, Long elementTypeId, Long manufacturerId, String manufacturerNumber, String description, String status) {
        super(Element.ELEMENT);

        set(0, id);
        set(1, elementTypeId);
        set(2, manufacturerId);
        set(3, manufacturerNumber);
        set(4, description);
        set(5, status);
    }
}
