package br.com.zherro.codereusability.reflection.c4_classes;

public class RecuperandoPeloObjeto {
    public static void main(String[] args) {
        Number object = Integer.valueOf(100);
        Class<? extends Number> c = object.getClass();

        // Number is abstract and Integer extends Number
        System.out.println(object.getClass().getName());
        System.out.println(c.getName());
        // ...
    }
}