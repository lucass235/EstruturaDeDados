package aplicacaolistas;

import br.unicap.c3.ed1.listasP.LSE;
import java.util.Scanner;

public class AplicacaoListas {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSE<Integer> num = new LSE();
        int op, valor;
        System.out.println("Bem vindo!!");
       
        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Informe o valor a ser adicionado: ");
                    valor = in.nextInt();
                    num.inserirInfo(valor);
                    break;
                case 2:
                    num.exibirInfo();
                    break;
                case 0:
                    System.out.println("================================================");
                    System.out.println("Obrigado por usar nosso programa!");
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
        System.out.print("1 - Inserir valor na lista\n2 - Exibir Lista"
                + "\n0 - Encerrar Programa\nInforme a opção desejada: ");
    }
}
