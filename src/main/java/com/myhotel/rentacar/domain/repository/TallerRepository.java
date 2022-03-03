package com.myhotel.rentacar.domain.repository;

import com.myhotel.rentacar.domain.model.Taller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TallerRepository extends JpaRepository<Taller, Integer> {
    @Override
    @Modifying
    @Query("update Taller t set borrado = true where t.id = :id")
    void deleteById(Integer id);

    @Query("select t FROM Taller t WHERE t.borrado = false")
    Page<Taller> findAll(Pageable pageable);
}
