package com.myhotel.rentacar.domain.usecase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder(toBuilder = true)
public class VehiculoDto {

    private Integer id;

    private String marca;

    private String modelo;

    private String patente;

    private Integer anio;

    private Integer kilometraje;

    private String cilindrada;


}
