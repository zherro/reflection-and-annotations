package br.com.zherro.codereusability.reflection.c3_getter_map_performance;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import br.com.zherro.codereusability.annotation.c1_getter_map.NomePropriedade;

public class GeradorMapaPerformance {
    private Map<String, Method> propriedades = new HashMap<>();
    private Class<?> classe;

    public GeradorMapaPerformance(Class<?> classe) {
        this.classe = classe;
        for (Method m : classe.getMethods()) {
            if (isGetter(m)) {
                String propriedade = null;
                if (m.isAnnotationPresent(NomePropriedade.class)) {
                    propriedade = m.getAnnotation(NomePropriedade.class).value();
                } else {
                    propriedade = deGetterParaPropriedade(m.getName());
                }
                propriedades.put(propriedade, m);
            }
        }
    }

    public Map<String, Object> gerarMapa(Object o) {
        if (!classe.isInstance(o)) {
            throw new RuntimeException("O	objeto	não	é	da	classe" + classe.getName());
        }
        Map<String, Object> mapa = new HashMap<>();
        for (String propriedade : propriedades.keySet()) {
            try {
                Method m = propriedades.get(propriedade);
                Object valor = m.invoke(o);
                mapa.put(propriedade, valor);
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

}
