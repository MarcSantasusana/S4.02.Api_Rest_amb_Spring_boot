package cat.itacademy.barcelonactiva.SantasusanaBerch.Marc.s04.t02.n02.S04T02N02SantasusanaBerchMarc.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ControllerAdvice
public class FruitExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FruitNotFoundException.class )
    public final ResponseEntity<Object> handleFruitNotFoundException(FruitNotFoundException e)
    {

        HttpStatus notFound = HttpStatus.NOT_FOUND;

      ApiException apiException = new ApiException(
              e.getMessage(),
              notFound,
              ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(FruitAlreadyExistsException.class )
    public final ResponseEntity<Object> handleFruitAlreadyExistsException(FruitAlreadyExistsException e)
    {
        HttpStatus notFound = HttpStatus.IM_USED;

        ApiException apiException = new ApiException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, notFound);
    }

}
