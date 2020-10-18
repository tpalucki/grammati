package io.github.tpalucki.grammati.repository.example;

import io.github.tpalucki.grammati.domain.example.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarRepository extends CrudRepository<Car, UUID> {
}
