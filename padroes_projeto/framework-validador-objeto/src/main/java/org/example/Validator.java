package org.example;

public interface Validator<T> {
    /**
    * Valida um objeto.
    *
    * @param obj O objeto a ser validado.
    * @throws ValidationException Se a validação falhar.
    */
    void validate(T obj) throws ValidationException;
}
