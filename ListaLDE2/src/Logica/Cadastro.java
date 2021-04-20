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
        list.cadastrarPessoa(pe);
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
    
    public void qtdPessoas () {
        int qtd = list.getQtd();
        if (qtd == 0) {
            System.out.println("==============================================");
            System.err.println("Lista vazia!");
            System.out.println("==============================================");
        } else {
            System.out.println("==============================================");
            System.out.println("Existem: "+qtd+" Pessoas cadastradas!");
            System.out.println("==============================================");
        }
    }

    public void remover(String rg) {
        pe = new Pessoa("", rg);
        list.removerPessoa(pe);
    }

    public void removerUltimaPessoa(String rg) {
        pe = new Pessoa("", rg);
        if (!list.verificarRg(pe)) {
            System.out.print("Deseja efetivar seu cadastro? digite 1- para sim ou 2- para não: ");
            int decisao = in.nextInt();
            while (decisao != 1 && decisao != 2) {
                System.err.print("Opçao inválida, digite 1 ou 2: ");
                decisao = in.nextInt();
            }
            if (decisao == 2) {
                list.removerPessoa(pe); // chamada da funçao de remoçao da pessoa cadastrada recentimente.
                System.out.println("==============================================");
                System.err.println("Cadastro cancelado!");
                System.out.println("==============================================");
            } else {
                System.out.println("==============================================");
                System.out.println("Cadastro efetivado com sucesso!");
                System.out.println("==============================================");
            }
        }
    }
}
