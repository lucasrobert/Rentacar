package com.myhotel.rentacar.infraestructure.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Generated;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"code", "description", "field", "value"})
public class ErrorDetails {
    @NotNull
    private Integer code;
    @NotNull
    private String description;
    private String field;
    private Object value;

    @Generated
    public Integer getCode() {
        return this.code;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public String getField() {
        return this.field;
    }

    @Generated
    public Object getValue() {
        return this.value;
    }

    @Generated
    public void setCode(Integer code) {
        this.code = code;
    }

    @Generated
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated
    public void setField(String field) {
        this.field = field;
    }

    @Generated
    public void setValue(Object value) {
        this.value = value;
    }

    @Generated
    public ErrorDetails(Throwable e) {
        this(HttpStatus.INTERNAL_SERVER_ERROR.value(), getMessage(e), null, null);
    }

    public static String getMessage(Throwable e) {
        if (e == null) {
            return null;
        }
        return StringUtils.isBlank(e.getMessage()) ? e.toString() : e.getMessage();
    }

    @Generated
    public ErrorDetails(Integer code, String description, String field, Object value) {
        this.code = code;
        this.description = description;
        this.field = field;
        this.value = value;
    }

    @Generated
    public ErrorDetails(String description) {
        this.description = description;
    }


    @Generated
    public ErrorDetails() {
    }

}
