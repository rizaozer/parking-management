package com.example.demo.mapper;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);
    CarDto mapToCarDto(Car car);
    Car mapToCar(CarDto carDto);

}
