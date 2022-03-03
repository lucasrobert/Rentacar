package com.myhotel.rentacar.domain.usecase.mapper;

import com.myhotel.rentacar.domain.model.Automovil;
import com.myhotel.rentacar.domain.model.AutomovilTipo;
import com.myhotel.rentacar.domain.model.Camion;
import com.myhotel.rentacar.domain.model.CamionTipo;
import com.myhotel.rentacar.domain.model.Servicio;
import com.myhotel.rentacar.domain.model.Taller;
import com.myhotel.rentacar.domain.model.Vehiculo;
import com.myhotel.rentacar.domain.usecase.dto.AutomovilDto;
import com.myhotel.rentacar.domain.usecase.dto.AutomovilTipoDto;
import com.myhotel.rentacar.domain.usecase.dto.CamionDto;
import com.myhotel.rentacar.domain.usecase.dto.CamionTipoDto;
import com.myhotel.rentacar.domain.usecase.dto.ServicioDto;
import com.myhotel.rentacar.domain.usecase.dto.TallerDto;
import com.myhotel.rentacar.domain.usecase.dto.VehiculoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    AutomovilDto automovilToDto(Automovil automovil);

    @Mapping(source = "tipoId", target = "tipo.id")
    Automovil dtoToAutomovil(AutomovilDto automovilDto);

    AutomovilTipoDto automovilTipoToDto(AutomovilTipo automovilTipo);

    CamionDto camionToDto(Camion automovil);

    @Mapping(source = "tipoId", target = "tipo.id")
    Camion dtoToCamion(CamionDto automovilDto);

    CamionTipoDto camionTipoToDto(CamionTipo camion);

    VehiculoDto vehiculoToDto(Vehiculo vehiculo);

    ServicioDto servicioToDto(Servicio servicio);

    @Mapping(source = "vehiculoId", target = "vehiculo.id")
    @Mapping(source = "tallerId", target = "taller.id")
    Servicio dtoToServicio(ServicioDto servicioDto);

    TallerDto tallerToDto(Taller servicio);

    Taller dtoToTaller(TallerDto servicioDto);
}