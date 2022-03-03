package com.myhotel.rentacar.domain.usecase;

import com.myhotel.rentacar.domain.usecase.dto.ServicioDto;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ServicioService {
    Integer create(ServicioDto servicio);

    ServicioDto get(Integer id);

    void update(Integer id, ServicioDto servicio);

    List<ServicioDto> getAll(Integer vehiculoId, Date fechaDesde, Date fechaHasta, Pageable pageable);

    void delete(Integer id);
}
