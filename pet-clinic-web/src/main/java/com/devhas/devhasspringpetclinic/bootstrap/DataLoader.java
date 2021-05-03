package com.devhas.devhasspringpetclinic.bootstrap;

import com.devhas.devhasspringpetclinic.models.*;
import com.devhas.devhasspringpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded PetType...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Eric");
        owner1.setLastName("Rainer");
        owner1.setAddress("123 Attoban");
        owner1.setCity("Abidjan");
        owner1.setTelephone("0710300405");

        Pet ericsPet = new Pet();
        ericsPet.setPetType(savedDogType);
        ericsPet.setOwner(owner1);
        ericsPet.setBirthDate(LocalDate.now());
        ericsPet.setName("Tanita");

        owner1.getPets().add(ericsPet);
        ownerService.save(owner1);

        Visit visitEricPet = new Visit();
        visitEricPet.setDate(LocalDate.now());
        visitEricPet.setDescription("Mal a la tête");
        visitEricPet.setPet(ericsPet);
        visitService.save(visitEricPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Aziz");
        owner2.setLastName("Koné");
        owner2.setAddress("145 Attoban");
        owner2.setCity("Abidjan");
        owner2.setTelephone("0708300405");

        Pet azizsPet = new Pet();
        azizsPet.setPetType(savedDogType);
        azizsPet.setOwner(owner2);
        azizsPet.setBirthDate(LocalDate.now());
        azizsPet.setName("Nicks");

        Pet nadiyasPet = new Pet();
        nadiyasPet.setPetType(savedCatType);
        nadiyasPet.setOwner(owner2);
        nadiyasPet.setBirthDate(LocalDate.now());
        nadiyasPet.setName("Fiona");

        owner2.getPets().add(azizsPet);
        owner2.getPets().add(nadiyasPet);
        ownerService.save(owner2);

        Visit visitNadiyaPet = new Visit();
        visitNadiyaPet.setDate(LocalDate.now());
        visitNadiyaPet.setDescription("Sneezy kitty");
        visitNadiyaPet.setPet(nadiyasPet);
        visitService.save(visitNadiyaPet);

        System.out.println("Loaded Owners...");
        System.out.println("Loaded Visit...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Firmin");
        vet1.setLastName("Kossonou");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ismaël");
        vet2.setLastName("Ouattara");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
