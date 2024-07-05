package org.example.productservice.Exceptions;

public class ProductControllerSpecificException extends Exception {
    ProductControllerSpecificException(String message)
    {
        super(message);
    }
}
