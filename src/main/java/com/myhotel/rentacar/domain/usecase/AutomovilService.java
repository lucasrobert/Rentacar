package com.myhotel.rentacar.domain.usecase;

import com.myhotel.rentacar.domain.usecase.dto.AutomovilDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AutomovilService {
    Integer create(AutomovilDto automovil);

    AutomovilDto get(Integer id);

    void update(Integer id, AutomovilDto automovil);

    List<AutomovilDto> getAll(Pageable pageable);

    void delete(Integer id);
}
