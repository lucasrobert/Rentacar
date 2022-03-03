package com.myhotel.rentacar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder(toBuilder=true)
@Table(schema = "rentacar",  name = "automovil")
@PrimaryKeyJoinColumn(name = "ID")
public class Automovil extends Vehiculo{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_ID", referencedColumnName = "ID")
    private AutomovilTipo tipo;

//    @Column(name = "TIPO_ID")
//    private Integer tipoId;

    @Column(name = "CANT_PUERTAS")
    private Integer cantPuertas;

    @Column(name = "CANT_PASAJEROS")
    private Integer cantPasajeros;

    @Column(name = "CAPACIDAD_BAUL")
    private Integer capacidadBaul;

}
