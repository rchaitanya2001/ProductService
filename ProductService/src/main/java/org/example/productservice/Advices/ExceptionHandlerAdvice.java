package org.example.productservice.Advices;

import org.example.productservice.DTOs.ArithmeticExceptionDto;
import org.example.productservice.DTOs.ArrayIndexOutOfBoundExceptionDto;
import org.example.productservice.DTOs.ExceptionDto;
import org.example.productservice.Exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handlerArithmeticException()
    {
        ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
        dto.setMessage("Something went wrong");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<ArrayIndexOutOfBoundExceptionDto> handleIOException()
    {
        return null;
    }
    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDto> handleInvalidProductIdException(InvalidProductIdException exception)
    {
       ExceptionDto exceptionDto = new ExceptionDto();
       exceptionDto.setMessage("Invalid productId passed, please retry with a valid product id");
       exceptionDto.setProductId(exception.getProductId());
        return new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);
    }

}
