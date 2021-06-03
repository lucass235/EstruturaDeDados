package Aplicacao;

import java.util.Scanner;
import Deque.Deque;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new Deque();
        int val, valorAtual;
        char op;
        System.out.printf("%S%n", "bem vindo(a) ao nosso programa");
        do {
            menu();
            op = in.next().charAt(0);
            switch (op) {
                case '1':
                    System.out.printf("%S", "informe o valor: ");
                    val = in.nextInt();
                    deque.push(val);
                    System.out.printf("%n%S(%d)%S%n%n", "valor: ", val, " inserido no inicio!");
                    break;
                case '2':
                    if (deque.isEmpty()) {
                        System.err.printf("%n%S%n%n", "nao existe valor para remover");
                    } else {
                        valorAtual = deque.pop();
                        System.out.printf("%n%S(%d)%S%n%n", "valor: ", valorAtual, " removido!");
                    }
                    break;
                case '3':
                    System.out.printf("%S", "informe o valor: ");
                    val = in.nextInt();
                    deque.inject(val);
                    System.out.printf("%n%S(%d)%S%n%n", "valor: ", val, " inserido no final!");
                    break;
                case '4':
                    if (deque.isEmpty()) {
                        System.err.printf("%n%S%n%n", "nao existe valor para remover");
                    } else {
                        valorAtual = deque.eject();
                        System.out.printf("%n%S(%d)%S%n%n", "valor: ", valorAtual, " removido!");
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
        in.close();
    }

    public static void menu() {
        System.out.printf("%S%n%S%n%S%n%S%n%S%n%S", "1 - inserir valor no inicio", "2 - remover "
                + "valor no inicio", "3 - inserir valor no final", "4 - remover"
                + "valor no final", "0 - encerrar", "escolha uma opcao: ");
    }
}
