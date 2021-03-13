package br.com.zherro.codereusability.reflection.c2_performance;

public class InvocadorNormal implements InvocadorMetodo {
    public void invocarMetodo(int vezes) {
        ClasseTeste ct = new ClasseTeste();
        for (int i = 0; i < vezes; i++) {
            ct.metodoVazio();
        }
    }
}