package Aplicacao;

import java.util.Scanner;
import Fila.Queue;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue <Integer>fila = new Queue();
        int pedido;
        char op;
        System.out.printf("%S%n", "empresa los porocas");
        do {
            menu();
            op = in.next().charAt(0);
            switch (op) {
                case '1':
                    System.out.printf("%S", "informe o numero do projeto: ");
                    pedido = in.nextInt();
                    fila.enqueue(pedido);
                    System.out.printf("%n%S%n%n", "projeto cadastrado!");
                    break;
                case '2':
                    if (fila.isEmpty()) {
                        System.err.printf("%n%S%n%n", "nao existe projetos pendentes");
                    } else {
                    int numPedido = (int) fila.head();
                    fila.dequeue();
                    System.out.printf("%n%S(%d)%S%n%n", "projeto: ", numPedido, "concluido!");
                    }
                    break;
                case '0':
                    System.out.println("=======================================");
                    System.out.println("Obrigado por usar nosso programa!!"
                            + "\nBy Lucas dos Santos");
                    System.out.println("=======================================");
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        } while (op != '0');

    }

    public static void menu() {
        System.out.printf("%S%n%S%n%S%n%S", "1 - cadastrar projeto","2 - concluir projeto",
                "0 - encerrar processo", "escolha uma opcao: ");
    }
}
