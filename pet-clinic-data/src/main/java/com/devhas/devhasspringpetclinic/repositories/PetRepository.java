package com.devhas.devhasspringpetclinic.repositories;

import com.devhas.devhasspringpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
