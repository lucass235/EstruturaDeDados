package Aplicacao;
import List.LSEOrdenada;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
     LSEOrdenada<Integer> lse = new LSEOrdenada();
      int op;
        int num;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch  (op) {
                case 1:
                    System.out.print("Informe o valor para inserir: ");
                    num = in.nextInt();
                    lse.inserirValor(num);
                    break;
                case 2:
                    System.out.print("Informe o valor a ser removido: ");
                    num = in.nextInt();
                    lse.removerValor(num);
                    break;
                case 3:
                    System.out.println("======================================");
                    lse.exibirValores();
                    System.out.println("======================================");
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
        System.out.print("1- Inserir um novo valor na lista\n2 - Remover um valor"
                + "\n3 - Exibir valores\n0 - Encerrar\nInforme o opção desejada: ");
    }
}
