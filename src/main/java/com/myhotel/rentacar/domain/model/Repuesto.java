//package com.myhotel.rentacar.domain.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.SuperBuilder;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.Table;
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Builder
//@Table(schema = "rentacar",  name = "repuesto")
//public class Repuesto {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    private Integer id;
//
//    @Column(name = "CODIGO")
//    private String codigo;
//
//    @Column(name = "DESCRIPCION")
//    private String descripcion;
//
//    @Column(name = "PRECIO")
//    private BigDecimal precio;
//
//    @Column(name = "BORRADO")
//    private Boolean borrado;
//
//}
