package Aplicacao;

import ListTeste1.LSESemRepitidos;
import java.util.Scanner;

public class TesteList1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSESemRepitidos<Integer> list1 = new LSESemRepitidos();
        LSESemRepitidos<Integer> list2 = new LSESemRepitidos();
        int num, op;
        do {
            System.out.println("lis 1 e lista 2, 3-compara!");
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Informe o o valor da lista 1: ");
                    num = in.nextInt();
                    list1.inserirCliente(num);
                    break;
                case 2:
                    System.out.print("Informe o o valor da lista 2: ");
                    num = in.nextInt();
                    list2.inserirCliente(num);
                    break;
                case 3:
                    boolean eIgual;
                    eIgual = list1.aListaEIgual(list2);
                    if (eIgual == true) {
                        System.out.println("Listas iguais!");
                    } else {
                        System.out.println("Listas diferentes!");
                    }
                    break;
                case 0:
                    System.out.println("Encerrado!");
                    break;
                default:
                    System.out.println("=======================================");
                    System.err.println("Opção inválida!!");
                    System.out.println("=======================================");
            }
        } while (op != 0);

    }

}
