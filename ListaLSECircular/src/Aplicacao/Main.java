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
                    lseCircular.inserirValorInicio(num);
                    break;
                case 2:
                    System.out.print("Informe o valor para ser inserir: ");
                    num = in.nextInt();
                    lseCircular.inserirValorFinal(num);
                    break;
                case 3:
                    lseCircular.removerInicio();
                    break;
                case 4:
                    lseCircular.removerFinal();
                    break;
                case 5:
                    System.out.print("Informe o valor para ser virificado: ");
                    num = in.nextInt();
                    int qtd = lseCircular.qtdValor(num);
                    System.out.println("=======================================");
                    System.out.println("Existem " +qtd+ " Valores!");
                    System.out.println("========================================");
                    break;
                case 6:
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
        System.out.print("1- Inserir valor no inicio da lista\n2 - Inserir valor"
                + "no final da lista\n3 - Remover o primeiro valor da lista"
                + "\n4 - Remover ultimo valor da lista\n5 - Verificar a"
                + "quantidade de vezes do valor informado na lista\n6 - "
                + "Exibir valores da lista"
                + "\n0 - Encerrar\nInforme o opção desejada: ");
    }
}
