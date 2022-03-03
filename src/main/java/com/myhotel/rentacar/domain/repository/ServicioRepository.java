package com.myhotel.rentacar.domain.repository;

import com.myhotel.rentacar.domain.model.Servicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Override
    @Modifying
    @Query("update Servicio s set borrado = true where s.id = :id")
    void deleteById(Integer id);


    @Query("select s FROM Servicio s " +
            "WHERE (:vehiculoId is null or s.vehiculo.id = :vehiculoId) " +
            "AND (:fechaDesde is null or s.fechaEntrega >= :fechaDesde) " +
            "AND (:fechaHasta is null or s.fechaEntrega <= :fechaHasta) " +
            "AND s.borrado = false")
    Page<Servicio> findAll(@Param("vehiculoId") Integer vehiculoId, @Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta, Pageable pageable);

}
