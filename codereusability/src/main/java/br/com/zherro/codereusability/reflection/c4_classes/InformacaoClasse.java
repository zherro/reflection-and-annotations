package br.com.zherro.codereusability.reflection.c4_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InformacaoClasse {
    public static void main(String[] args) {
        System.out.println("Entre	com	o	nome	da	classe	que	deseja	informação:");
        Scanner in = new Scanner(System.in);
        String nomeClasse = in.nextLine();
        try {
            Class<?> c = Class.forName(nomeClasse);
            imprimirHierarquia(c, 1);
        } catch (ClassNotFoundException e) {
            System.out.println("A	classe	" + nomeClasse + "	não	foi	encontrada");
        }
        in.close();
    }

    private static void imprimirHierarquia(Class<?> c, int nivel) {
        List<Class<?>> lista = getSuperclasseEInterfaces(c);
        String recuo = "";
        for (int i = 0; i < nivel; i++) {
            recuo += "			";
        }
        for (Class<?> clazz : lista) {
            System.out.println(recuo + "|->	" + clazz.getName());
            if (clazz != Object.class) {
                imprimirHierarquia(clazz, nivel + 1);
            }
        }
    }

    private static List<Class<?>> getSuperclasseEInterfaces(Class<?> c) {
        List<Class<?>> lista = new ArrayList<>();
        if (c.getSuperclass() != null)
            lista.add(c.getSuperclass());
        lista.addAll(Arrays.asList(c.getInterfaces()));
        return lista;
    }
}