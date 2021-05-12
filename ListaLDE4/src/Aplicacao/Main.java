package Aplicacao;

import java.util.Scanner;
import List.LDESemRepitidosOrdenada;
import Exception.RemoverException;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDESemRepitidosOrdenada<Integer> lde = new LDESemRepitidosOrdenada();
        int valor;
        char op;
        do {
            menu();
            op = in.next().charAt(0);
            switch (op) {
                case '1':
                    System.out.print("Informe o valor: ");
                    valor = in.nextInt();
                    lde.inserirValorOrdenadoDecrescente(valor);
                    break;
                case '2':
                    System.out.print("Informe o valor a ser removido: ");
                    valor = in.nextInt();
                    try {
                        lde.removerValor(valor);
                    } catch (RemoverException listVazia) {
                        System.out.println(listVazia.getMessage());
                    }
                    break;
                case '3':
                    lde.exibirValoresDecrescente();
                    break;
                case '4':
                    lde.exibirValoresCrescente();
                    break;
                case '5':
                    System.out.print("Informe o valor a ser consultado: ");
                    valor = in.nextInt();
                    lde.exibirInfo(valor);
                    break;
                case '0':
                    System.out.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "obrigado por usar nosso programa!",
                            "==============================================");
                    break;
                default:
                    System.err.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "opçao inválida!",
                            "==============================================");
            }
        } while (op != '0');
    }

    public static void menu() {
        System.out.printf("%S%n%S%n%S%n%S%n%S%n%S%n%S",
                "1- inserir valor", "2 - remover valor",
                "3 - exibir valor em ordem decrescente", "4 - exibir valor em "
                + "ordem crescente", "5 - exibir informação do objeto",
                "0 - encerrar", "informe a opçao desejada: ");
    }
}
