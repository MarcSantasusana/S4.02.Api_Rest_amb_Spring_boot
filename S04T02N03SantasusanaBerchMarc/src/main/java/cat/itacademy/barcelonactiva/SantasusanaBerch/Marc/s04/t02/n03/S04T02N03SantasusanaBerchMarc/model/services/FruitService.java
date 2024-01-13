package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.services;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.domain.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {

    void add(Fruit fruit);
    void update(Fruit fruit, String name, Integer quantityKg);
    void delete(String id);

    Optional<Fruit> getOne(String id);

    List<Fruit> getAll();
}