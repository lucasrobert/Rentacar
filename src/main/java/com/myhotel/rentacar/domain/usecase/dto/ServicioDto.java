package com.myhotel.rentacar.domain.usecase.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ServicioDto {

    private Integer id;

    private Date fechaRecepcion;

    private Date fechaEntrega;

    private String descripcion;

    private String comentario;

    private Integer vehiculoId;

    private VehiculoDto vehiculo;

    private Integer tallerId;

    private TallerDto taller;

    private Integer kilometraje;

    private BigDecimal precio;


}
