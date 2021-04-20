package Logica;

import List.LDESemRepitidos;
import java.util.Scanner;

public class Cadastro {

    Scanner in = new Scanner(System.in);
    private final LDESemRepitidos<Pessoa> list;
    private Pessoa pe;

    public Cadastro() {
        list = new LDESemRepitidos();
    }

    public void Cadastrar(String nome, String rg) {
        pe = new Pessoa(nome, rg);
        list.cadastrarPessoa(pe, in);
    }

    public void exibir() {
        list.exibirPessoas();
    }

    public void verificarPessoa(String rg) {
        pe = new Pessoa("", rg);
        if (list.verificarRg(pe)) {
            System.out.println("==============================================");
            System.out.println("A pessoa se encontra cadastrada!");
            System.out.println("==============================================");
        } else {
            System.out.println("==============================================");
            System.err.println("A pessoa não se encontra cadastrada!");
            System.out.println("==============================================");
        }
    }

    public void remover(String rg) {
        pe = new Pessoa("", rg);
        list.removerPessoa(pe);
    }
}
