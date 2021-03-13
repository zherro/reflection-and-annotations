package br.com.zherro.codereusability.reflection.c3_getter_map_performance;

import java.util.Map;

import br.com.zherro.codereusability.model.Produto;
import br.com.zherro.codereusability.reflection.c1_getter_map.GettersMap;

public class TestPerformance {
    public static void main(String[] args) {
        Produto p = new Produto("Design	Patterns", "LIVRO", 59.90, "Publicado	pela	Casa	do	Codigo");

        long millis = System.nanoTime();
        Map<String, Object> props = GettersMap.gerarMapa(p);
        long diferencaA = System.nanoTime() - millis;
        System.out.println("A	classe	" + GettersMap.class.getSimpleName() + "	demorou	" + diferencaA + "	nano	segundos");
     
        long millis1 = System.nanoTime();
        Map<String, Object> props1 = new GeradorMapaPerformance(Produto.class).gerarMapa(p);
        long diferencaB = System.nanoTime() - millis1;
        System.out.println("A	classe	" + GeradorMapaPerformance.class.getSimpleName() + "	demorou	" + diferencaB + "	nano	segundos");


        System.out.println(( diferencaA / diferencaB) + "	vezes	mais rapido");
    }
}
