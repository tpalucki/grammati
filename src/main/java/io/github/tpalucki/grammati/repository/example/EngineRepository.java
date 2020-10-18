package io.github.tpalucki.grammati.repository.example;

import io.github.tpalucki.grammati.domain.example.Engine;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EngineRepository extends CrudRepository<Engine, UUID> {
}
