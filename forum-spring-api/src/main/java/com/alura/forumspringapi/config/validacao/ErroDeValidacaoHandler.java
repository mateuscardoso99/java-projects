package com.alura.forumspringapi.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//@ControllerAdvice é uma especialização da anotação @Component que permite manipular exceções em 
//todo o aplicativo em um componente de manipulação global. Ele pode ser visto como um interceptador 
//de exceções lançadas por métodos anotados com @RequestMapping e similares

public class ErroDeValidacaoHandler {
    @Autowired
    private MessageSource messageSource;
    //converte msg de erro no idioma passado no cabeçalho accept-language da requisição

    //erro de validação de formulário uma exception chamada MethodArgumentNotValidException é lançada
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
        List<ErroDeFormularioDto> erros = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e->{
            String msg = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), msg);
            erros.add(erro);
        });
        return erros;
    }
}
