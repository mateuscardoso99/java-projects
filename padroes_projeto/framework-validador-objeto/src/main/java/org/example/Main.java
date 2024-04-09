package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main implements Validator<ClasseExemplo>{
    public static void main(String[] args) {
        ClasseExemplo classeExemplo = new ClasseExemplo(null, 12, 4, "25.836.828/0001-05");
        try {
            new Main().validate(classeExemplo);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void validate(ClasseExemplo obj) throws ValidationException {
        StringBuilder erros = new StringBuilder();

        Field[] atributos = obj.getClass().getDeclaredFields();
        for(Field attr : atributos){
            if(attr.getAnnotation(Validate.class) != null){//tem anotação @validate
                Validate anotacaoValidate = (Validate) attr.getAnnotation(Validate.class);

                Object valor = null;

                try {
                    //invocando o getter do atributo
                    Method getter = obj.getClass().getDeclaredMethod("get" + (attr.getName().substring(0,1).toUpperCase() + attr.getName().substring(1)));
                    valor = getter.invoke(obj);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }


                if(attr.getAnnotation(NotNull.class) != null){
                    String errorMessage = attr.getAnnotation(NotNull.class).message();
                    if(valor == null){
                        erros.append(attr.getName()).append(errorMessage).append("\n");
                    }
                }

                if(attr.getAnnotation(Max.class) != null){
                    long maxValue = attr.getAnnotation(Max.class).tamanho();
                    if(valor == null || ((long) valor > maxValue)){
                        erros.append(anotacaoValidate.message()).append("\n");
                    }
                }

                if(attr.getAnnotation(Min.class) != null){
                    int minValue = attr.getAnnotation(Min.class).tamanho();
                    if(valor == null || ((int) valor < minValue)){
                        erros.append(anotacaoValidate.message()).append("\n");
                    }
                }

                if(attr.getAnnotation(Pattern.class) != null){
                    String pattern = attr.getAnnotation(Pattern.class).regex();
                    String message = attr.getAnnotation(Pattern.class).message();
                    if(valor == null || !valor.toString().matches(pattern)){
                        erros.append(message).append("\n");
                    }
                }
            }
        }

        if (!erros.isEmpty()) {
            throw new ValidationException(erros.toString());
        }
    }
}