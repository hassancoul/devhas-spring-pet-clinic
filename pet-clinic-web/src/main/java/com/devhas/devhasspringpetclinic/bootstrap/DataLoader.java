package com.devhas.devhasspringpetclinic.bootstrap;

import com.devhas.devhasspringpetclinic.models.Owner;
import com.devhas.devhasspringpetclinic.models.Vet;
import com.devhas.devhasspringpetclinic.services.OwnerService;
import com.devhas.devhasspringpetclinic.services.VetService;
import com.devhas.devhasspringpetclinic.services.map.OwnerServiceMap;
import com.devhas.devhasspringpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Eric");
        owner1.setLastName("Rainer");
        owner1.setId(1L);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Aziz");
        owner2.setLastName("Koné");
        owner2.setId(2L);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Firmin");
        vet1.setLastName("Kossonou");
        vet1.setId(1L);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ismaël");
        vet2.setLastName("Ouattara");
        vet2.setId(2L);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
