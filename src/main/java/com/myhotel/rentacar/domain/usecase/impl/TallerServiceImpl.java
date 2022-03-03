package com.myhotel.rentacar.domain.usecase.impl;

import com.myhotel.rentacar.domain.model.Taller;
import com.myhotel.rentacar.domain.repository.TallerRepository;
import com.myhotel.rentacar.domain.usecase.TallerService;
import com.myhotel.rentacar.domain.usecase.dto.TallerDto;
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
public class TallerServiceImpl implements TallerService {

    private final TallerRepository repository;
    private final MapStructMapper mapper;

    @Override
    public Taller create(TallerDto taller) {
        if (taller.getId() != null) {
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "El nuevo taller no puede contener un Id");
        }
        return repository.save(mapper.dtoToTaller(taller));
    }


    @Override
    public TallerDto get(Integer id) {
        return mapper.tallerToDto(findByIdorThrow(id));
    }

    @Override
    public void update(Integer id, TallerDto taller) {

        if (!Objects.equals(id, taller.getId())) {
            throw new ApiResponseException(HttpStatus.BAD_REQUEST, "Los IDs no coinciden: " + id + "<>" + taller.getId());
        }

        findByIdorThrow(id);

        taller.setId(id);

        repository.save(mapper.dtoToTaller(taller));
    }

    @Override
    public List<TallerDto> getAll(Pageable pageable) {
        Page<Taller> page = repository.findAll(pageable);

        return page.getContent().stream()
                .map(mapper::tallerToDto)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public void delete(Integer id) {
        findByIdorThrow(id);
        repository.deleteById(id);
    }

    private Taller findByIdorThrow(Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> {
                    throw new ApiResponseException(HttpStatus.NOT_FOUND, "No se encontraron datos para el id de respuesto: " + id);
                });
    }
}
