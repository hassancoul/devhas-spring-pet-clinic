package com.devhas.devhasspringpetclinic.repositories;

import com.devhas.devhasspringpetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
