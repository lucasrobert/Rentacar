package com.myhotel.rentacar.domain.repository;

import com.myhotel.rentacar.domain.model.Camion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CamionRepository extends JpaRepository<Camion, Integer> {
    @Override
    @Modifying
    @Query("update Vehiculo v set borrado = true where v.id = :id")
    void deleteById(Integer id);

    @Query("select c FROM Camion c INNER JOIN Vehiculo v ON c.id = v.id WHERE v.borrado = false")
    Page<Camion> findAll(Pageable pageable);
}
