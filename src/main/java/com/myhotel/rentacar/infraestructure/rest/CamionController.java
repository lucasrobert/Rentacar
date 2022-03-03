package com.myhotel.rentacar.infraestructure.rest;

import com.myhotel.rentacar.domain.model.Camion;
import com.myhotel.rentacar.domain.usecase.CamionService;
import com.myhotel.rentacar.domain.usecase.dto.CamionDto;
import com.myhotel.rentacar.domain.usecase.dto.EntityIdDto;
import com.myhotel.rentacar.infraestructure.handler.ResponseEntityBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/camiones")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CamionController {

    private final CamionService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CamionDto camion) {
        return new ResponseEntityBuilder(HttpStatus.CREATED).data(new EntityIdDto(Camion.class.getSimpleName(), service.create(camion))).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return new ResponseEntityBuilder(HttpStatus.OK).data(service.get(id)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CamionDto camion) {
        service.update(id, camion);
        return new ResponseEntityBuilder(HttpStatus.NO_CONTENT).build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntityBuilder(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping()
    public ResponseEntity<?> get(Pageable pageable, String filters) {
        return new ResponseEntityBuilder(HttpStatus.OK).data(service.getAll(pageable)).build();
    }
}
