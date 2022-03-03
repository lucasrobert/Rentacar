package com.myhotel.rentacar.domain.repository;

import com.myhotel.rentacar.domain.model.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Override
    @Modifying
    @Query("update Vehiculo v set borrado = true where v.id = :id")
    void deleteById(Integer id);

    @Query("select v FROM Vehiculo v WHERE v.borrado = false")
    Page<Vehiculo> findAll(Pageable pageable);
}
