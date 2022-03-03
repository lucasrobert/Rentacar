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
public class AutomovilDto extends VehiculoDto {

    private Integer tipoId;

    private AutomovilTipoDto tipo;

    private Integer cantPuertas;

    private Integer cantPasajeros;

    private Integer capacidadBaul;

    private VehiculoDto vehiculo;
}
