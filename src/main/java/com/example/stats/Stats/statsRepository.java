package com.example.stats.Stats;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface statsRepository extends JpaRepository<stats, Integer> {

    Optional<stats> findByProviderId(int providerId);
    Optional<stats> findByDate(LocalDate date);
}
