package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.repository;

import cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.domain.Fruit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, String> {


}
