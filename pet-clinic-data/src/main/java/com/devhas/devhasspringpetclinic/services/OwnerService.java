package com.devhas.devhasspringpetclinic.services;

import com.devhas.devhasspringpetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName();
}
