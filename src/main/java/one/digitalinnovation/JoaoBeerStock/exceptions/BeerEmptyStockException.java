package one.digitalinnovation.JoaoBeerStock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerEmptyStockException extends Exception {

    public BeerEmptyStockException(Long id, int quantityToDecrement) {
        super(String.format("Beer with %s ID have no stock capacity to decrement %s", id, quantityToDecrement));
    }
}
