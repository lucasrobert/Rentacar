package com.myhotel.rentacar.domain.usecase.impl;

import com.myhotel.rentacar.domain.model.Camion;
import com.myhotel.rentacar.domain.repository.CamionRepository;
import com.myhotel.rentacar.domain.usecase.CamionService;
import com.myhotel.rentacar.domain.usecase.dto.CamionDto;
import com.myhotel.rentacar.domain.usecase.mapper.MapStructMapper;
import com.myhotel.rentacar.infraestructure.handler.ApiResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CamionServiceImpl implements CamionService {

    private final CamionRepository repository;
    private final MapStructMapper mapper;

    @Override
    public Integer create(CamionDto camion) {
        if (camion.getId() != null) {
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "El nuevo camión no puede contener un Id");
        }
        return repository.save(mapper.dtoToCamion(camion)).getId();
    }


    @Override
    public CamionDto get(Integer id) {
        return mapper.camionToDto(findByIdorThrow(id));
    }

    @Override
    public void update(Integer id, CamionDto camion) {

        if (!Objects.equals(id, camion.getId())) {
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "Los IDs no coinciden: " + id + "<>" + camion.getId());
        }
        findByIdorThrow(id);

        camion.setId(id);

        repository.save(mapper.dtoToCamion(camion));
    }

    @Override
    public List<CamionDto> getAll(Pageable pageable) {
        Page<Camion> page = repository.findAll(pageable);

        return page.getContent().stream()
                .map(mapper::camionToDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public void delete(Integer id) {
        findByIdorThrow(id);
        repository.deleteById(id);
    }

    private Camion findByIdorThrow(Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> {
                    throw new ApiResponseException(HttpStatus.NOT_FOUND, "No se encontraron datos para el id de camión: " + id);
                });
    }
}
