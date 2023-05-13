package com.example.demo.service;

import com.example.demo.dto.CarDto;
import com.example.demo.exeption.UserException;
import com.example.demo.mapper.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Slf4j
@AllArgsConstructor
@Service
public class CarService {

    private CarRepository carRepository;

    public CarDto  saveNewSubscription(CarDto carDto) {

        Car user = CarMapper.MAPPER.mapToCar(carDto);
        Car savedUser = carRepository.save(user);
        return CarMapper.MAPPER.mapToCarDto(savedUser);
    }

    public CarDto updateSubscription(CarDto carDto, Long id) {
        Car existingCar = carRepository.findById(id).orElseThrow(() ->
                new UserException("Car plate number: " + carDto.getId() + "not found!"));

        existingCar.setBrand(carDto.getBrand());
        existingCar.setColor(carDto.getColor());
        existingCar.setOwner(carDto.getOwner());
        existingCar.setPlateNumber(carDto.getPlateNumber());

        Car updatedCar = carRepository.save(existingCar);
        return CarMapper.MAPPER.mapToCarDto(updatedCar);
    }

    public Optional<Car> deleteSubscription(Long id) {
        carRepository.deleteById(id);
        return carRepository.findById(id);
    }


    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }
}
