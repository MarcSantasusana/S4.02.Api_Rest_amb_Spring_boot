package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.exceptions;

public class FruitNotFoundException extends RuntimeException{

    public FruitNotFoundException(String message, Throwable cause)
    {
        super(message, cause);

    }

    public FruitNotFoundException(String message)
    {

        super(message);

    }
}
