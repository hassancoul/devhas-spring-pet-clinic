package com.devhas.devhasspringpetclinic.repositories;

import com.devhas.devhasspringpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
