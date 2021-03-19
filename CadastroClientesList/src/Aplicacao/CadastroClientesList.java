package Aplicacao;

import Logica.Cadastro;
import java.util.Scanner;

public class CadastroClientesList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cadastro c = new Cadastro();
        int op;
        String cpf;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch  (op) {
                case 1:
                    System.out.print("Informe o cpf do novo cliente: ");
                    cpf = in.nextLine();
                    c.adicinarCliente(cpf);
                    break;
                case 2:
                    System.out.print("Informe o cpf do cliente a ser removido: ");
                    cpf = in.nextLine();
                    c.removerCliente(cpf);
                    break;
                case 3:
                    System.out.print("Informe o cpf do cliente para a alteração: ");
                    cpf = in.nextLine();
                    c.AlterarDados(cpf);
                    break;
                case 4:
                    System.out.print("Informe o cpf do cliente a ser consultado: ");
                    cpf = in.nextLine();
                    c.consultarCliente(cpf);
                    break;
                case 5:
                    c.exibirClientes();
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
        System.out.println("1- Cadastrar um novo cliente\n2 - Remover um cliente"
                + "\n3 - Alterar os dados de um cliente\n4- Consultar os dados"
                + "de um cliente\n5 - Exibir os dados de todos os clientes\n"
                + "0 - Sair do Programa\nInforme a opção desejada: ");
    }
}
