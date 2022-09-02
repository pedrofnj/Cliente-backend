package io.github.pedrofnj.clientes.rest;

import io.github.pedrofnj.clientes.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiErrors handleValidationErros(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();
        List<String> msg = bindingResult.getAllErrors()
                .stream().map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiErrors(msg);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResposeStatusException(ResponseStatusException exception){
        String msgErros = exception.getMessage();
        HttpStatus status = exception.getStatus();
        ApiErrors apiErrors = new ApiErrors(msgErros);
        return new ResponseEntity(apiErrors, status);
    }
}
