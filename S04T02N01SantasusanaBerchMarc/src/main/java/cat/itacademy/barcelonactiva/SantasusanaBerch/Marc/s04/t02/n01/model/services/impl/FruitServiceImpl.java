package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.services.impl;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.exceptions.FruitAlreadyExistsException;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.services.FruitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository)
    {
        this.fruitRepository = fruitRepository;

    }


    @Override
    public void add(Fruit fruit) {

        if(fruitRepository.findByName(fruit.getName()).isPresent())
        {
            throw new FruitAlreadyExistsException("Fruit with name " + fruit.getName() + " already exists");
        }

        this.fruitRepository.save(fruit);

    }

    @Override
    @Transactional
    public void update(Long id, String name, Integer quantityKg) {

        Fruit fruit = getOne(id);


        if(name != null && !name.isEmpty())
        {
            if(fruitRepository.findByName(name).isPresent())
            {
                throw new FruitAlreadyExistsException("Fruit with name " + name + " already exists");
            }

            fruit.setName(name);
        }

        if(quantityKg != null)
        {
            fruit.setQuantityKg(quantityKg);
        }

    }

    @Override
    public void delete(Long id) {

        Optional<Fruit> fruit = fruitRepository.findById(id);

        if(fruit.isEmpty())
        {
            throw new FruitNotFoundException("Fruit with id " + id + " is not found");
        }

        this.fruitRepository.deleteById(id);

    }

    @Override
    public Fruit getOne(Long id) throws FruitNotFoundException{

        Optional<Fruit> fruit = fruitRepository.findById(id);

        if(fruit.isEmpty())
        {
            throw new FruitNotFoundException("Fruit with id " + id + " is not found");
        }

        return fruit.get();

    }


    @Override
    public List<Fruit> getAll() {
        return fruitRepository.findAll();
    }


}
