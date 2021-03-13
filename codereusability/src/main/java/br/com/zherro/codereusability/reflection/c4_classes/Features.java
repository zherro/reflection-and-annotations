package br.com.zherro.codereusability.reflection.c4_classes;

import java.lang.reflect.Modifier;

public class Features {
    public static void main(String[] args) {
        int	modificadores	=	Integer.valueOf(1).getClass().getModifiers();
        
        System.out.println("Modificadores::: " + modificadores);
        System.out.println(" ");
        
        System.out.println("Is Abstract::: " + Modifier.isAbstract(modificadores));
        System.out.println("Is Public::: " + Modifier.isPublic(modificadores));
        System.out.println("Is Interface::: " + Modifier.isInterface(modificadores));

    }
}
