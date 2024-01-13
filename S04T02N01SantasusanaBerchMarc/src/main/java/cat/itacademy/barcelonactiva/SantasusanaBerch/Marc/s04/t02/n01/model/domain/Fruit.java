package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n01.model.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
