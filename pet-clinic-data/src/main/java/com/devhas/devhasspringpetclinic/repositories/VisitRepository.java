package com.devhas.devhasspringpetclinic.repositories;

import com.devhas.devhasspringpetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
