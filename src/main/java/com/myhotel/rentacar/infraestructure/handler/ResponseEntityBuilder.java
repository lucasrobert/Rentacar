package com.myhotel.rentacar.infraestructure.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Generated;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"_data", "_errors", "_status"})
public class ResponseEntityBuilder<T> {
    @JsonProperty("_data")
    private T data;
    @JsonProperty("_errors")
    private List<ErrorDetails> errors;
    @JsonProperty("_status")
    private HttpStatus status;
    @JsonIgnore
    private final MultiValueMap<String, String> headers = new HttpHeaders();

    public ResponseEntityBuilder(@NotNull HttpStatus status) {
        this.errors = new ArrayList();
        this.status = status;
    }

    public static <T> ResponseEntityBuilder<T> builder() {
        return new ResponseEntityBuilder(HttpStatus.I_AM_A_TEAPOT);
    }

    public ResponseEntityBuilder<T> status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ResponseEntityBuilder<T> data(T data) {
        this.data = data;
        return this;
    }


    public ResponseEntityBuilder<T> addError(ErrorDetails err) {
        this.errors.add(err);
        return this;
    }

    public List<ErrorDetails> getErrors() {
        return new ArrayList(this.errors);
    }

    public ResponseEntityBuilder<T> errors(List<ErrorDetails> errors) {
        this.errors = errors;
        return this;
    }

    public ResponseEntityBuilder<T> addHeader(String k, String v) {
        this.headers.add(k, v);
        return this;
    }

    public MultiValueMap<String, String> getHeaders() {
        return CollectionUtils.unmodifiableMultiValueMap(this.headers);
    }

    public ResponseEntityBuilder<T> headers(MultiValueMap<String, String> headers) {
        this.headers.addAll(headers);
        return this;
    }

    public ResponseEntity<T> build() {
        return Objects.isNull(this.getData()) && this.getErrors().isEmpty() ? new ResponseEntity(this.headers, this.getStatus()) : new ResponseEntity(this, this.headers, this.getStatus());
    }

    @Generated
    public T getData() {
        return this.data;
    }

    @Generated
    public HttpStatus getStatus() {
        return this.status;
    }

    @Generated
    public ResponseEntityBuilder() {
    }

}
