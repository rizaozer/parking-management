package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class CarController {

    private CarService carService;

    @GetMapping(value = "/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok()
                .body(carService.findAllCars());
    }

    @PostMapping(value = "/cars", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<CarDto> createSubscription(@RequestBody CarDto carDto) {
        return ResponseEntity.ok()
                .body(carService.saveNewSubscription(carDto));
    }

    @DeleteMapping(value = "/cars/{id}", produces = {"application/json"})
    public ResponseEntity<Car> deleteSubscription(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(carService.deleteSubscription(id));
    }

    @GetMapping(value = "/cars/{id}", produces = {"application/json"})
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(carService.findCarById(id));
    }

    @PutMapping(value = "/cars/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @RequestBody CarDto carDetails) {
        return ResponseEntity.ok()
                .body(carService.updateSubscription(carDetails, id));
    }

//    @GetMapping(value="/divisions", produces = {"application/json"})
//    public ResponseEntity<PaginatedResponseDto<CarDto>> getAllDivisions(
//            DivisionSearchDto<Car> searchDto
//    ) {
//
//        PaginatedResponseDto<DivisionDto> divisions = divisionService.findAllDivision(searchDto);
//        return ResponseEntity
//                .ok()
//                .body(divisions);
//    }











}
