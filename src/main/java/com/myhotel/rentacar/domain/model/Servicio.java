package com.myhotel.rentacar.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(schema = "rentacar",  name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FECHA_RECEPCION")
    private Date fechaRecepcion;

    @Column(name = "FECHA_ENTREGA")
    private Date fechaEntrega;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "COMENTARIO")
    private String comentario;

    @Column(name = "BORRADO")
    private boolean borrado = false;

    @ManyToOne
    @JoinColumn(name = "VEHICULO_ID", referencedColumnName = "ID")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "TALLER_ID", referencedColumnName = "ID")
    private Taller taller;

    @Column(name = "KILOMETRAJE")
    private Integer kilometraje;

    @Column(name = "PRECIO")
    private BigDecimal precio;




//    @JoinTable(
//            name = "servicio_repuesto",
//            joinColumns = @JoinColumn(name = "servicio_id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name="repuesto_id", nullable = false)
//    )
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Repuesto> repuestos;

//    @OneToMany(
//            mappedBy = "servicioId",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<ServicioRepuesto> servicioRepuestos;
//
//    @JoinTable(
//            name = "servicio_trabajo",
//            joinColumns = @JoinColumn(name = "servicio_id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name="trabajo_id", nullable = false)
//    )
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Trabajo> trabajos;
//
//    @Transient
//    private List<Repuesto> repuestos;
//
//    public List<Repuesto> getRepuestos() {
//        return  servicioRepuestos != null ? servicioRepuestos.stream()
//                    .map(servRep -> { return servRep.getRepuesto();})
//                    .collect(Collectors.toCollection(ArrayList::new)) : new ArrayList<>();
//    }
}
