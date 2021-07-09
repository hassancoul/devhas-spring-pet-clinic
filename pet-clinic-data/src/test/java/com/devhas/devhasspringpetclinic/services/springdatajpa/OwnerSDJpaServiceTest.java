package com.devhas.devhasspringpetclinic.services.springdatajpa;

import com.devhas.devhasspringpetclinic.models.Owner;
import com.devhas.devhasspringpetclinic.repositories.OwnerRepository;
import com.devhas.devhasspringpetclinic.repositories.PetRepository;
import com.devhas.devhasspringpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;

    private Owner returnOwner;
    private String lastName = "Smith";

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(lastName);
        ownerRepository.save(returnOwner);
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(lastName)).thenReturn(returnOwner);

        Owner smith = service.findByLastName(lastName);

        assertEquals(lastName, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        Owner owner2 = new Owner();
        owner2.setId(2L);

        returnOwnerSet.add(returnOwner);
        returnOwnerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}