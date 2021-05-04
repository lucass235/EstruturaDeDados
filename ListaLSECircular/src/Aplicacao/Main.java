package Aplicacao;

import java.util.Scanner;
import List.LSECircular;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSECircular<Integer> lseCircular = new LSECircular();
        int op;
        int num;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Informe o valor para ser inserir: ");
                    num = in.nextInt();
                    lseCircular.inserirValor(num);
                    break;
                case 2:
                    lseCircular.exibirInfo();
                    break;
                case 0:
                    System.out.println("=======================================");
                    System.out.println("Obrigado por usar nosso programa!");
                    System.out.println("By Lucas dos Santos");
                    System.out.println("=======================================");
                    break;
                default:
                    System.out.println("=======================================");
                    System.err.println("Opção inválida!!");
                    System.out.println("=======================================");
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.print("1- Inserir um novo valor\n2 - Exibir valor"
                + "\n0 - Encerrar\nInforme o opção desejada: ");
    }
}
