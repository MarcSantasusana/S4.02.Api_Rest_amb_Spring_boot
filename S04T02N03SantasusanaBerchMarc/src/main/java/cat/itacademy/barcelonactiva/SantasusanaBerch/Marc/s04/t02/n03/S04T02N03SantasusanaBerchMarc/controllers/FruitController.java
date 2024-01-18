package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.controllers;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.domain.Fruit;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/fruita")
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
    public ResponseEntity<Fruit> updateFruit(@RequestParam String id,
                                             @RequestParam(required = false) String name,
                                             @RequestParam(required = false) Integer quantityKg)
    {


        fruitService.update(id, name, quantityKg);
        return new ResponseEntity("Fruit with id " + id + " has been updated successfully", HttpStatus.OK);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable(name = "id") String id)
    {
        Fruit fruit = fruitService.getOne(id);

        fruitService.delete(id);
        return new ResponseEntity("Fruit with id " + id + " has been deleted successfully", HttpStatus.OK);

    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable(name = "id") String id)
    {
        Fruit fruit = fruitService.getOne(id);

        return new ResponseEntity(fruit, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Fruit> getAllFruits()
    {
        return fruitService.getAll();
    }




}