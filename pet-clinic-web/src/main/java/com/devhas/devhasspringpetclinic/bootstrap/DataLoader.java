package com.devhas.devhasspringpetclinic.bootstrap;

import com.devhas.devhasspringpetclinic.models.Owner;
import com.devhas.devhasspringpetclinic.models.Vet;
import com.devhas.devhasspringpetclinic.services.OwnerService;
import com.devhas.devhasspringpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
