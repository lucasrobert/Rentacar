package com.myhotel.rentacar.service;

import com.myhotel.rentacar.domain.model.Taller;
import com.myhotel.rentacar.domain.repository.TallerRepository;
import com.myhotel.rentacar.domain.usecase.dto.TallerDto;
import com.myhotel.rentacar.domain.usecase.impl.TallerServiceImpl;
import com.myhotel.rentacar.domain.usecase.mapper.MapStructMapper;
import com.myhotel.rentacar.infraestructure.handler.ApiResponseException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@Slf4j
@SpringBootTest
public class TallerServiceTest {

    @Mock
    private TallerRepository repository;

    @InjectMocks
    private TallerServiceImpl service;

    @Spy
    private MapStructMapper mapper = Mappers.getMapper(MapStructMapper.class);

    @Test
    @DisplayName("Test create Taller completado")
    public void testCreateTaller() {
        TallerDto tallerDto = TallerDto.builder().nombre("Teller Test").build();

        Taller saveTaller = mapper.dtoToTaller(tallerDto);

        doReturn(saveTaller).when(repository).save(any());

        Taller taller = service.create(tallerDto);

        Assertions.assertNotNull(taller, "EL taller guardado no puede ser null");
        Assertions.assertEquals(tallerDto.getNombre(), taller.getNombre(), "The nombre del taller no coincide");
        verify(repository).save(taller);
    }

    @Test
    @DisplayName("Test get completado")
    void testGetTallerById() {
        TallerDto tallerDto = TallerDto.builder().id(1).nombre("Teller Test").build();

        Taller taller = mapper.dtoToTaller(tallerDto);
        doReturn(Optional.of(taller)).when(repository).findById(1);

        TallerDto returnedWidget = service.get(1);

        Assertions.assertNotNull(returnedWidget, "Taller no encontrado");
        Assertions.assertTrue(new ReflectionEquals(tallerDto).matches(returnedWidget), "El taller encontrado no es igual al esperado");

    }

    @Test
    @DisplayName("Test get Not Found completado")
    void testGetTallerByIdNotFound() {
        doReturn(Optional.empty()).when(repository).findById(1);

        ApiResponseException thrown = Assertions.assertThrows(ApiResponseException.class, () -> {
            service.get(1);
        }, "Excepcion Not Found esperada");

    }

    @Test
    @DisplayName("Test getAll completado")
    void testgetAll() {
        Taller taller1 = Taller.builder().id(1).nombre("Teller Test 1").build();
        Taller taller2 = Taller.builder().id(1).nombre("Teller Test 2").build();

        Pageable pageable = PageRequest.of(0, 5);


        Page<Taller> page = new PageImpl<Taller>(Arrays.asList(taller1, taller2));
        doReturn(page).when(repository).findAll(pageable);

        List<TallerDto> widgets = service.getAll(pageable);

        Assertions.assertEquals(2, widgets.size(), "Debe retornar 2 talleres");
    }
}