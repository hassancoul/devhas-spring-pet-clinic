package com.devhas.devhasspringpetclinic.services.map;

import com.devhas.devhasspringpetclinic.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    private Long ownerId = 1L;
    private String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);

        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner savedOwner = new Owner();
        savedOwner.setId(id);
        ownerMapService.save(savedOwner);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = new Owner();
        ownerMapService.save(savedOwner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastName);

        assertNotNull(smith);
        assertEquals(ownerId, smith.getId());
    }
}