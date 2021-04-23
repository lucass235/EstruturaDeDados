package Aplicacao;

import java.util.Scanner;
import List.LDESemRepitidos;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDESemRepitidos<Integer> lde = new LDESemRepitidos();
        int valor;
        char op;
        do {
            menu();
            op = in.next().charAt(0);
            switch (op) {
                case '1':
                    System.out.print("Informe o valor: ");
                    valor = in.nextInt();
                    lde.inserirValorNaoOrdenado(valor);
                    break;
                case '2':
                    lde = lde.ordenar('c');
                    System.out.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "lista ordenada de forma crescente!",
                            "==============================================");
                    break;
                case '3':
                    lde = lde.ordenar('d');
                    System.out.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "lista ordenada de forma decrescente!",
                            "==============================================");
                    break;
                case '4':
                    if (lde.isEmpty()) {

                        System.err.printf("%S%n%S%n%S%n",
                                "==============================================",
                                "Lista vazia!",
                                "==============================================");
                    } else {
                        lde.exibirValores();
                    }
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
        System.out.printf("%S%n%S%n%S%n%S%n%S%n%S",
                "1- inserir valor", "2 - ordenar a lista em ordem crescente",
                "3 - ordenar a lista em ordem decrescente","4 - exibir lista",
                "0 - encerrar", "informe a opçao desejada: ");
    }
}
