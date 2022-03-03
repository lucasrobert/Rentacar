package com.myhotel.rentacar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder(toBuilder=true)
@Table(schema = "rentacar", name = "camion")
@PrimaryKeyJoinColumn(name = "ID")
public class Camion extends Vehiculo{

    @OneToOne
    @JoinColumn(name = "TIPO_ID", referencedColumnName = "ID")
    private CamionTipo tipo;

    @Column(name = "CAPACIDAD_CARGA")
    private Integer capacidadCarga;

    @Column(name = "CANT_EJES")
    private Integer cantEjes;

}
