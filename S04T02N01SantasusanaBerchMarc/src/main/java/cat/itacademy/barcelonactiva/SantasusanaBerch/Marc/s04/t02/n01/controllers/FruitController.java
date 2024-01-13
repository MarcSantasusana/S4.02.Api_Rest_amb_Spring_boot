package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.controllers;


import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.services.FruitService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitController {


    private FruitService fruitService;
    @Autowired
    public FruitController(FruitService fruitService)
    {
        this.fruitService = fruitService;
    }

   @GetMapping()
    public String viewHomePage()
    {
        return "Fruit home page";
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit)
    {
        fruitService.add(fruit);

        return new ResponseEntity(fruit, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestParam Long id,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) Integer quantityKg)
    {

        Optional<Fruit> fruitOpt = fruitService.getOne(id);

        if(fruitOpt.isPresent())
        {
            fruitService.update(fruitOpt.get(), name, quantityKg);
            return new ResponseEntity(fruitOpt.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Fruit with id " + id + " is not found", HttpStatus.NOT_FOUND);
        }




    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable(name = "id") Long id)
    {
        Optional<Fruit> fruitOpt = fruitService.getOne(id);

        if(fruitOpt.isPresent())
        {
            fruitService.delete(id);
            return new ResponseEntity("Fruit with id " + id + " has been deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Fruit with id " + id + " is not found", HttpStatus.NOT_FOUND);
        }



    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable(name = "id") Long id)
    {
       Optional<Fruit> fruitOpt = fruitService.getOne(id);

        if(fruitOpt.isPresent())
        {
            return new ResponseEntity(fruitOpt.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Fruit with id " + id + " is not found", HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/getAll")
    public List<Fruit> getAllFruits()
    {
        return fruitService.getAll();
    }


}
