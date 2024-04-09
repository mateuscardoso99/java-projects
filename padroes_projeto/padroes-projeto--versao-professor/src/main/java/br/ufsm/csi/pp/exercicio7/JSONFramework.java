package br.ufsm.csi.pp.exercicio7;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JSONFramework {

    public String toJSON(Object objeto) throws InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Method m : objeto.getClass().getMethods()) {
            if (m.getName().startsWith("get") && m.getParameterCount() == 0
                    && m.getAnnotation(JSON.class) != null) {
                String nomeAtrib = m.getName().substring(3);
                nomeAtrib = nomeAtrib.substring(0, 1).toLowerCase() + nomeAtrib.substring(1);
                Object valorObj = m.invoke(objeto);
                sb.append("\"").append(nomeAtrib).append("\": ").append(getValorJSON(valorObj))
                        .append(",\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        sb.append("\n}");
        return sb.toString();
    }

    @SneakyThrows
    private String getValorJSON(Object valor) {
        StringBuilder sb = new StringBuilder();
        if (valor.getClass().isArray()) {
            sb.append("[");
            for (Object oArray : (Object[]) valor) {
                sb.append(getValorJSON(oArray)).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
            sb.append("]");
        } else if (valor instanceof String) {
            sb.append("\"").append(valor).append("\"");
        } else if (valor instanceof Number) {
            sb.append(valor);
        } else {
            sb.append(toJSON(valor));//objeto
        }
        return sb.toString();
    }

    @SneakyThrows
    public static void main(String[] args) {
        ClasseExemplo exemplo = new ClasseExemplo();
        exemplo.setId(23l);
        exemplo.setUmPrimitivo(10);
        exemplo.setNome("Fulano");
        exemplo.setTipo("TIPO1");
        ClasseExemplo.InnerObject innerObject = new ClasseExemplo.InnerObject();
        innerObject.setaStr("asdf");
        innerObject.setCod(123);
        exemplo.setInnerObject(innerObject);
        exemplo.setReferencias(new String[] { "referenci1", "referencia2", "referencia3" });
        System.out.println(new JSONFramework().toJSON(exemplo));
    }

}
