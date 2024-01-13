package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n02.S04T02N02SantasusanaBerchMarc.model.services;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n02.S04T02N02SantasusanaBerchMarc.model.domain.Fruit;
import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n02.S04T02N02SantasusanaBerchMarc.model.repository.FruitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository)
    {
        this.fruitRepository = fruitRepository;

    }


    @Override
    public void add(Fruit fruit) {

        this.fruitRepository.save(fruit);

    }

    @Override
    @Transactional
    public void update(Fruit fruit, String name, Integer quantityKg) {


        if(name != null && !name.isEmpty())
        {
            fruit.setName(name);

        }

        if(quantityKg != null)
        {
            fruit.setQuantityKg(quantityKg);
        }

    }

    @Override
    public void delete(Long id) {


        this.fruitRepository.deleteById(id);

    }

    @Override
    public Optional<Fruit> getOne(Long id) {

        return fruitRepository.findById(id);

    }

    @Override
    public List<Fruit> getAll() {
        return fruitRepository.findAll();
    }
}