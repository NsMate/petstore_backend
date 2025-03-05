package org.petstore.endpoint;

import com.org.petstore.endpoint.rest.model.Pet;
import org.petstore.service.PetService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/pets")
public class PetController{

    private PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping(path = "/allPets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping(path = "/{petId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> getAllPets(@PathVariable Long petId) {
        return ResponseEntity.ok(petService.getPetById(petId));
    }
}
