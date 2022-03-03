package com.myhotel.rentacar.domain.usecase.impl;

import com.myhotel.rentacar.domain.model.Automovil;
import com.myhotel.rentacar.domain.repository.AutomovilRepository;
import com.myhotel.rentacar.domain.usecase.AutomovilService;
import com.myhotel.rentacar.domain.usecase.dto.AutomovilDto;
import com.myhotel.rentacar.domain.usecase.mapper.MapStructMapper;
import com.myhotel.rentacar.infraestructure.handler.ApiResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutomovilServiceImpl implements AutomovilService {

    private final AutomovilRepository repository;
    private final MapStructMapper mapper;

    @Override
    public Integer create(AutomovilDto automovil) {
        if (automovil.getId() != null) {
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "El nuevo automóvil no puede contener un Id");
        }
        return repository.save(mapper.dtoToAutomovil(automovil)).getId();
    }


    @Override
    public AutomovilDto get(Integer id) {
        return mapper.automovilToDto(findByIdorThrow(id));
    }

    @Override
    public void update(Integer id, AutomovilDto automovil) {

        if (!Objects.equals(id, automovil.getId())) {
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "Los IDs no coinciden: " + id + "<>" + automovil.getId());
        }

        findByIdorThrow(id);

        automovil.setId(id);

        repository.save(mapper.dtoToAutomovil(automovil));
    }

    @Override
    public List<AutomovilDto> getAll(Pageable pageable) {
        Page<Automovil> page = repository.findAll(pageable);

        return page.getContent().stream()
                .map(mapper::automovilToDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(Integer id) {
        findByIdorThrow(id);
        repository.deleteById(id);
    }

    private Automovil findByIdorThrow(Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> {
                    throw new ApiResponseException(HttpStatus.NOT_FOUND, "No se encontraron datos para el id de automóvil: " + id);
                });
    }

}
