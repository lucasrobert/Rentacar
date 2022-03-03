package com.myhotel.rentacar.domain.usecase.impl;

import com.myhotel.rentacar.domain.model.Servicio;
import com.myhotel.rentacar.domain.repository.ServicioRepository;
import com.myhotel.rentacar.domain.usecase.ServicioService;
import com.myhotel.rentacar.domain.usecase.dto.ServicioDto;
import com.myhotel.rentacar.domain.usecase.mapper.MapStructMapper;
import com.myhotel.rentacar.infraestructure.handler.ApiResponseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository repository;
    private final MapStructMapper mapper;

    @Override
    public Integer create(ServicioDto servicio) {

        if (servicio.getId() != null) {
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "El nuevo servicio no puede contener un Id");
        }

        return repository.save(mapper.dtoToServicio(servicio)).getId();
    }


    @Override
    public ServicioDto get(Integer id) {
        return mapper.servicioToDto(findByIdorThrow(id));
    }

    @Override
    public void update(Integer id, ServicioDto servicio) {

        if (!Objects.equals(id, servicio.getId())) {
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "Los IDs no coinciden: " + id + "<>" + servicio.getId());
        }

        findByIdorThrow(id);

        servicio.setId(id);

        repository.save(mapper.dtoToServicio(servicio));
    }

    @Override
    public List<ServicioDto> getAll(Integer vehiculoId, Date fechaDesde, Date fechaHasta, Pageable pageable) {
        Page<Servicio> page = repository.findAll(vehiculoId, fechaDesde, fechaHasta, pageable);

        return page.getContent().stream()
                .map(mapper::servicioToDto)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public void delete(Integer id) {
        findByIdorThrow(id);
        repository.deleteById(id);
    }

    private Servicio findByIdorThrow(Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> {
                    throw new ApiResponseException(HttpStatus.NOT_FOUND, "No se encontraron datos para el id de respuesto: " + id);
                });
    }
}
