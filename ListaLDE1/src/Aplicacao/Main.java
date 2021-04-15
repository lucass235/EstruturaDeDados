package Aplicacao;

import java.util.Scanner;
import List.LDE;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDE<Integer> lde = new LDE();
        int op;
        int num;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Informe o valor para ser inserir no inicio: ");
                    num = in.nextInt();
                    lde.inserirValorInicio(num);
                    break;
                case 2:
                    System.out.print("Informe o valor a ser inserido no final: ");
                    num = in.nextInt();
                    lde.inserirValorFinal(num);
                    break;
                case 3:
                    lde.removerValorInicio();
                    break;
                case 4:
                    lde.removerValorFinal();
                    break;
                case 5:
                    lde.exibirLista();
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
        System.out.print("1- Inserir um novo valor no inicio da lista\n2 - Inserir um valor no final da lista"
                + "\n3 - Remover o primeiro valor da lista"
                + "\n4 - Remover o ultimo valor da lista\n5 - Exibir valores da lista"
                + "\n0 - Encerrar\nInforme o opção desejada: ");
    }
}
