package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n03.S04T02N03SantasusanaBerchMarc.model.exceptions;

public class FruitAlreadyExistsException extends RuntimeException{

    public FruitAlreadyExistsException(String message, Throwable cause)
    {
        super(message, cause);

    }

    public FruitAlreadyExistsException(String message)
    {

        super(message);

    }
}
