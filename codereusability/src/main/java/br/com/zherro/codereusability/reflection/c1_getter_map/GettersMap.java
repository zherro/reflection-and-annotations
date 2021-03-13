package br.com.zherro.codereusability.reflection.c1_getter_map;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import br.com.zherro.codereusability.model.Produto;


public class GettersMap {

    public static Map<String, Object> gerarMapa(Object o) {

        // identifica o tipo do objeto
        Class<?> classe = o.getClass();

        Map<String, Object> mapa = new HashMap<>();

        for (Method m : classe.getMethods()) {
            try {
                if (isGetter(m)) {
                    String propriedade = deGetterParaPropriedade(m.getName());

                    // invoca o methodo do objeto
                    Object valor = m.invoke(o);
                    mapa.put(propriedade, valor);
                }
            } catch (Exception e) {
                throw new RuntimeException("Problema	ao	gerar	o	mapa", e);
            }
        }
        return mapa;
    }

    private static boolean isGetter(Method m) {
        return m.getName().startsWith("get") && 
            m.getReturnType() != void.class && 
            m.getParameterTypes().length == 0;
    }

    private static String deGetterParaPropriedade(String nomeGetter) {
        StringBuffer retorno = new StringBuffer();
        retorno.append(nomeGetter.substring(3, 4).toLowerCase());
        retorno.append(nomeGetter.substring(4));
        return retorno.toString();
    }

    // Código que executa o método de geração do mapa e imprime
    public static void main(String[] args) {
        Produto p = new Produto("Design	Patterns", "LIVRO", 59.90, "Publicado	pela	Casa	do	Codigo");
        Map<String, Object> props = GettersMap.gerarMapa(p);
        for (String prop : props.keySet()) {
            System.out.println(prop + "	=	" + props.get(prop));
        }
    }

}