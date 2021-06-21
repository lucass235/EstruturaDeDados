package Aplicacao;

import java.util.Scanner;
import Trees.ABB;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ABB <Integer> arvoreBB = new ABB();
        char opcao;
        int entrada, resultado;
        System.out.printf("%S%n", "bem vindo a arvore binaria de busca");
        do {
            menu();
            opcao = in.next().charAt(0);
            switch (opcao) {
                case '1':
                    System.out.println("informe o valor a ser inserido: ");
                    entrada = in.nextInt();
                    System.out.println();
                    arvoreBB.insertRepetidos(entrada);
                    System.out.println();
                    break;
                case '2':
                    System.out.println("Digite um valor a ser informado a sua quantidade na arvore: ");
                    entrada = in.nextInt();
                    System.out.println();
                    resultado = arvoreBB.qtdValorNaArvore(entrada);
                    System.out.println("Resultado: "+ resultado);
                    System.out.println();
                    break;
                case '3':
                    System.out.println();
                    arvoreBB.emOrdemSemRecursao();
                    System.out.println();
                    break;
                case '0':
                    System.out.println("=======================================");
                    System.out.println("Obrigado por usar nosso programa!!"
                            + "\nBy Lucas dos Santos");
                    System.out.println("=======================================");
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        } while (opcao != '0');

    }

    public static void menu() {
        System.out.println("1 - Inserir valor");
        System.out.println("2 - quantidade de valor na arvore");
        System.out.println("3 - pecorrer em ordem");
        System.out.println("0 - Sair do programa");
        System.out.print("Escolha uma opcao: ");
    }
}
