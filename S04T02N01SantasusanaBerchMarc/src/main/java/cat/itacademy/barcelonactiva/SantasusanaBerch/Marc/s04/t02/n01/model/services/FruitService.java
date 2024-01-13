package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.domain.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {

    void add(Fruit fruit);
    void update(Fruit fruit, String name, Integer quantityKg);
    void delete(Long id);

    Optional<Fruit> getOne(Long id);

    List<Fruit> getAll();
}