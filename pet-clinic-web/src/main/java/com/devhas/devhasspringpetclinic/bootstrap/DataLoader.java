package com.devhas.devhasspringpetclinic.bootstrap;

import com.devhas.devhasspringpetclinic.models.Owner;
import com.devhas.devhasspringpetclinic.models.PetType;
import com.devhas.devhasspringpetclinic.models.Vet;
import com.devhas.devhasspringpetclinic.services.OwnerService;
import com.devhas.devhasspringpetclinic.services.PetTypeService;
import com.devhas.devhasspringpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded PetType...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Eric");
        owner1.setLastName("Rainer");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Aziz");
        owner2.setLastName("Koné");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Firmin");
        vet1.setLastName("Kossonou");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ismaël");
        vet2.setLastName("Ouattara");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
