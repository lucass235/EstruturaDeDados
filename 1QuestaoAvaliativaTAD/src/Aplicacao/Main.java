package Aplicacao;

import java.util.Scanner;
import Fila.QueueComQtd;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        QueueComQtd<Integer> fila;
        int senha = 1, qtdClientes;
        char op;
        System.out.printf("%S%n", "bem vindo(a) ao banco sodinheiro");
        System.out.printf("%S", "informe o numero de clientes maximo: ");
        qtdClientes = in.nextInt();
        fila = new QueueComQtd(qtdClientes);
        do {
            menu();
            op = in.next().charAt(0);
            switch (op) {
                case '1':
                    if (fila.isFull()) {
                        System.err.printf("%n%S%n%n", "volte em outro momento, fila cheia!");
                    } else if (fila.isEmpty()) {
                        fila.enqueue(senha);
                        System.out.printf("%n%S(%d)%S%n%n", "sua senha e: ", senha, " va ao caixa!");
                        senha++;
                    } else {
                        fila.enqueue(senha);
                        System.out.printf("%n%S(%d)%S%n%n", "sua senha e: ", senha, " aguarde!");
                        senha++;
                    }
                    break;
                case '2':
                    if (fila.isEmpty()) {
                        System.err.printf("%n%S%n%n", "nao existe clientes em espera");
                    } else {
                        int senhaAtual = fila.dequeue();
                        System.out.printf("%n%S(%d)%S%S%n%n", "cliente de senha: ", senhaAtual, " atendido(a)!",
                                "obrigado!");
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
        System.out.printf("%S%n%S%n%S%n%S", "1 - emitir senha", "2 - chamar senha",
                "0 - fechar banco", "escolha uma opcao: ");
    }
}
