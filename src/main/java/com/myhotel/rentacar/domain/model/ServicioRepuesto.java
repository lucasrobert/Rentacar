//package com.myhotel.rentacar.domain.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Builder
//@Table(schema = "rentacar",  name = "servicio_repuesto")
//public class ServicioRepuesto {
//
//
//    @Column(name = "ID")
//    private Integer id;
//
//    @EmbeddedId
//    private ServicioRepuestoId idEmbdded;
//
//    @Column(name = "SERVICIO_ID")
//    private Integer servicioId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("repuestoId")
//    private Repuesto repuesto;
//
//    @Column(name = "CANTIDAD")
//    private BigDecimal cantidad;
//
//
//
//}
