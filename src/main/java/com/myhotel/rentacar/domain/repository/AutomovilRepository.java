package com.myhotel.rentacar.domain.repository;

import com.myhotel.rentacar.domain.model.Automovil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AutomovilRepository extends JpaRepository<Automovil, Integer> {
    @Override
    @Modifying
    @Query("update Vehiculo v set borrado = true where v.id = :id")
    void deleteById(Integer id);

    @Query("select a FROM Automovil a INNER JOIN Vehiculo v ON a.id = v.id WHERE v.borrado = false")
    Page<Automovil> findAll(Pageable pageable);
}
