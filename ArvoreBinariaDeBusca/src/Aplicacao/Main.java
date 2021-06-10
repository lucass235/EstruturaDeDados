package Aplicacao;

import java.util.Scanner;
import Trees.ABB;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ABB <Integer> arvore = new ABB();
        char op;
        int num, valor, qtd;
        System.out.printf("%S%n", "bem vindo a arvore binaria de busca");
        do {
            menu();
            op = in.next().charAt(0);
            switch (op) {
                case '1':
                    System.out.println("informe o valor a ser inserido: ");
                    num = in.nextInt();
                    arvore.insert(num);
                    break;
                case '2':
                    valor = arvore.menorValor();
                    System.out.println();
                    System.out.println("Menor valor: " + valor);
                    System.out.println();
                    break;
                case '3':
                    valor = arvore.maiorValor();
                    System.out.println();
                    System.out.println("Maior valor: " + valor);
                    System.out.println();
                    break;
                case '4':
                    System.out.println("informe o valor a ser inserido: ");
                    num = in.nextInt();
                    arvore.inserirNo(num);
                    break;
                case '5':
                    qtd = arvore.qtdNo(arvore.getRaiz());
                    System.out.println();
                    System.out.println("Quantidade de nos: " + qtd);
                    System.out.println();
                    break;
                case '6':
                    qtd = arvore.qtdFolhas(arvore.getRaiz());
                    System.out.println();
                    System.out.println("Quantidade de folhas: " + qtd);
                    System.out.println();
                    break;
                case '7':
                    qtd = arvore.qtdNosNaoTerminais(arvore.getRaiz());
                    System.out.println();
                    System.out.println("Quantidade de nos nao terminais: " + qtd);
                    System.out.println();
                    break;
                case '8':
                    System.out.println();
                    arvore.emOrdem();
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
        } while (op != '0');

    }

    public static void menu() {
        System.out.println("1 - Inserir valor");
        System.out.println("2 - Exibir menor valor");
        System.out.println("3 - Exibir maior valor");
        System.out.println("4 - inserir valor nao recursivo");
        System.out.println("5 - Exibir quantidades de nos");
        System.out.println("6 - Exibir quantidades de folhas");
        System.out.println("7 - Exibir quantidades de nos nao terminais");
        System.out.println("8 - Exibir nos");
        System.out.println("0 - Sair do programa");
        System.out.print("Escolha uma opcao: ");
    }
    
}
