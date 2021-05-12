package Execucao;

import java.util.Scanner;
import List.LDEC;
import Exception.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDEC<Integer> lista1 = new LDEC();
        LDEC<Integer> lista2 = new LDEC();
        int op;
        int num;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Informe o valor para ser inserir na lista 1: ");
                    num = in.nextInt();
                    try {
                        lista1.inserirValorFinal(num);
                        System.out.printf("%S%n%S%n%S%n",
                                "==============================================",
                                "Valor inserido!",
                                "==============================================");
                    } catch (RepeatedValue e) {
                        System.out.printf("%S%n%S%n%S%n",
                                "==============================================",
                                e.getMessage(),
                                "==============================================");
                    }
                    break;
                case 2:
                    System.out.print("Informe o valor a ser inserido na lista 2: ");
                    num = in.nextInt();
                    try {
                        lista2.inserirValorFinal(num);
                        System.out.printf("%S%n%S%n%S%n",
                                "==============================================",
                                "valor inserido!",
                                "==============================================");
                    } catch (RepeatedValue e) {
                        System.out.printf("%S%n%S%n%S%n",
                                "==============================================",
                                e.getMessage(),
                                "==============================================");
                    }
                    break;
                case 3:
                    lista1.concatenar(lista2);
                    System.out.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "lista concatenadas!",
                            "==============================================");
                    break;
                case 4:
                    lista2 = lista1.dividir();
                    System.out.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "lista dividida!",
                            "==============================================");
                    break;
                case 5:
                    try {
                        lista1.exibirLista();
                    } catch (EmptyList e) {
                        System.out.printf("%S%n%S%n%S%n",
                                "==============================================",
                                e.getMessage(),
                                "==============================================");
                    }
                    break;
                case 6:
                    try {
                        lista2.exibirLista();
                    } catch (EmptyList e) {
                        System.out.printf("%S%n%S%n%S%n",
                                "==============================================",
                                e.getMessage(),
                                "==============================================");
                    }
                    break;
                case 0:
                    System.out.println("=======================================");
                    System.out.println("Obrigado por usar nosso programa!");
                    System.out.println("By Lucas dos Santos");
                    System.out.println("=======================================");
                    break;
                default:
                    System.out.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "opçao invalida!",
                            "==============================================");
            }
        } while (op != 0);
        in.close(); // fechar a entrada
    }

    public static void menu() {
        System.out.print("1- Inserir um novo valor na lista 1\n2 - Inserir um valor na lista 2"
                + "\n3 - Conctenar Listas"
                + "\n4 - Dividir Listas\n5 - Exibir valores da lista 1"
                + "\n6 - Exibir valores da lista 2"
                + "\n0 - Encerrar\nInforme o opção desejada: ");
    }
}
