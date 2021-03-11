package Aplicação;

import java.util.Scanner;
import logica.LSE;

public class InsersaoNumParImpar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, op;
        LSE<Integer> listA = new LSE();
        LSE<Integer> listB = new LSE();
        System.out.println("Bem vindo!!");
        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Informe o número a ser adicionado: ");
                    num = in.nextInt();
                    if ((num % 2) == 0) {
                        listA.inserirInfo(num);
                    } else {
                        listB.inserirInfo(num);
                    }
                    break;
                case 2:
                    LSE<Integer> no;
                    boolean achou;
                    System.out.print("Informe o número a ser procurado: ");
                    num = in.nextInt();
                    if ((num / 2) == 0) {
                        achou = listA.buscarInfo(num);
                    } else {
                        achou = listB.buscarInfo(num);
                    }
                    if (achou == true) {
                        System.out.println("===================================");
                        System.out.println("O valor " + num + " foi encontrado!!");
                        System.out.println("================================================");
                    } else {
                        System.out.println("================================================");
                        System.err.println("O valor " + num + " não foi encontrado!!");
                        System.out.println("================================================");
                    }
                    break;
                case 3:
                    listB.exibirInfo();
                    break;
                case 4:
                    listA.exibirInfo();
                    break;
                case 0:
                    System.out.println("================================================");
                    System.out.println("Obrigado por usar nosso programa!");
                    System.out.println("By Lucas Santos");
                    System.out.println("================================================");
                    break;
                default:
                    System.out.println("================================================");
                    System.err.println("Opção Inválida!");
                    System.out.println("================================================");
            }
        } while (op != 0);
    }
    public static void menu() {
        System.out.print("1 - Armazenar um valor na lista\n2 - Procurar número"
                + "\n3 - Exibir lista de numeros Impares\n4 - Exibir Lista de numeros Pares"
                + "\n0 - Encerrar programa\nInforme a opção desejada: ");
    }
}
