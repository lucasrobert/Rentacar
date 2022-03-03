package com.myhotel.rentacar.infraestructure.rest;

import com.myhotel.rentacar.domain.model.Servicio;
import com.myhotel.rentacar.domain.usecase.ServicioService;
import com.myhotel.rentacar.domain.usecase.dto.EntityIdDto;
import com.myhotel.rentacar.domain.usecase.dto.ServicioDto;
import com.myhotel.rentacar.infraestructure.handler.ResponseEntityBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/v1/servicios")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServicioController {

    private final ServicioService service;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ServicioDto servicio) {
        return new ResponseEntityBuilder(HttpStatus.CREATED).data(new EntityIdDto(Servicio.class.getSimpleName(), service.create(servicio))).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return new ResponseEntityBuilder(HttpStatus.OK).data(service.get(id)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ServicioDto servicio) {
        service.update(id, servicio);
        return new ResponseEntityBuilder(HttpStatus.NO_CONTENT).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntityBuilder(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping()
    public ResponseEntity<?> getAll(@RequestParam(name = "vehiculoId", required = false) Integer vehiculoId,
                                    @RequestParam(name = "fechaDesde", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date fechaDesde,
                                    @RequestParam(name = "fechaHasta", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date fechaHasta,
                                    Pageable pageable) {
        return new ResponseEntityBuilder(HttpStatus.OK).data(service.getAll(vehiculoId, fechaDesde, fechaHasta, pageable)).build();
    }
}
