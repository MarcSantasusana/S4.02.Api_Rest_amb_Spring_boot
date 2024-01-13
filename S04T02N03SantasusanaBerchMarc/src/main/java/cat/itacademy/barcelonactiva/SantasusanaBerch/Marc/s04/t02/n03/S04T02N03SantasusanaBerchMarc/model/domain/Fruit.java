package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("fruit")
public class Fruit {

    @Id
    @Indexed(unique=true)
    private String id;
    String name;
    Integer quantityKg;

    public Fruit()
    {

    }

    public Fruit(String name, Integer quantityKg)
    {
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Integer getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(Integer quantityKg) {
        this.quantityKg = quantityKg;
    }

    @Override
    public String toString()
    {
        return "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Quantity: " + quantityKg + "Kg" + "\n";

    }
}