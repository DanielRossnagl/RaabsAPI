package com.daniel.api.rest.Repo;

import com.daniel.api.rest.Models.Sightseeing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightseeingRepo extends JpaRepository<Sightseeing, Long> {
}
