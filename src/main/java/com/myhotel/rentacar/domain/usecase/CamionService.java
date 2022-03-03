package com.myhotel.rentacar.domain.usecase;

import com.myhotel.rentacar.domain.usecase.dto.CamionDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CamionService {
    Integer create(CamionDto camion);

    CamionDto get(Integer id);

    void update(Integer id, CamionDto camion);

    List<CamionDto> getAll(Pageable pageable);

    void delete(Integer id);
}
