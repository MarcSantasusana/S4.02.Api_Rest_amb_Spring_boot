package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.services.impl;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.domain.Fruit;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.exceptions.FruitAlreadyExistsException;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.services.FruitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void update(String id, String name, Integer quantityKg) {

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
    public void delete(String id) {

        Optional<Fruit> fruit = fruitRepository.findById(id);

        if(fruit.isEmpty())
        {
            throw new FruitNotFoundException("Fruit with id " + id + " is not found");
        }

        this.fruitRepository.deleteById(id);

    }

    @Override
    public Fruit getOne(String id) throws FruitNotFoundException {

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
