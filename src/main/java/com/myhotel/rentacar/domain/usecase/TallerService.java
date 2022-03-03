package com.myhotel.rentacar.domain.usecase;//package com.myhotel.rentacar.domain.usecase;

import com.myhotel.rentacar.domain.model.Taller;
import com.myhotel.rentacar.domain.usecase.dto.TallerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TallerService {
    Taller create(TallerDto taller);

    TallerDto get(Integer id);

    void update(Integer id, TallerDto taller);

    List<TallerDto> getAll(Pageable pageable);

    void delete(Integer id);
}
