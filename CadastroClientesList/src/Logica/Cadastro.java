package Logica;

import List.LSESemRepitidos;
import java.util.Scanner;

public class Cadastro {

    private LSESemRepitidos<Cliente> lse;

    public Cadastro() { // costrutor.
        this.lse = new LSESemRepitidos();
    }

    Cliente c;
    Scanner in = new Scanner(System.in);

    public void adicinarCliente(String cpf) {
        Cliente achou;
        c = new Cliente(cpf, "", "", "");
        achou = lse.buscarCliente(c);
        if (achou == null) {
            String no, fo, em;
            System.out.print("Informe o nome: ");
            no = in.nextLine();
            System.out.print("Informe o Telefone: ");
            fo = in.nextLine();
            System.out.print("Informe o Email: ");
            em = in.nextLine();
            c = new Cliente(cpf, no, fo, em);
            lse.inserirCliente(c);
        } else {
            System.out.println("=======================================");
            System.err.println("Esse cpf já se encontra cadastrado!");
            System.out.println("=======================================");
        }
    }

    public void listarClientes() {
        lse.exibirClientes();
    }

    public void removerCliente(String cpf) {
        c = new Cliente(cpf, "", "", "");
        lse.removerCliente(c);
    }

    public void consultarCliente(String cpf) {
        Cliente achou;
        c = new Cliente(cpf, "", "", "");
        achou = lse.buscarCliente(c);
        if (achou == null) {
            System.out.println("=======================================");
            System.err.println("Cliente não encontrado!");
            System.out.println("=======================================");
        } else {
            System.out.println(achou.toString());
        }
    }

    public void AlterarDados(String cpf) {
        Cliente achou;
        c = new Cliente(cpf, "", "", "");
        achou = lse.buscarCliente(c);
        if (achou != null) {
            int op;
            String f, e;
            do {
                menu();
                op = in.nextInt();
                in.nextLine();
                switch (op) {
                    case 1:
                        System.out.print("Informe o novo e-mail: ");
                        e = in.nextLine();
                        achou.setEmail(e);
                        System.out.print("Informe o novo Telefone: ");
                        f = in.nextLine();
                        achou.setFone(f);
                        break;
                    case 2:
                        System.out.print("Informe o novo e-mail: ");
                        e = in.nextLine();
                        achou.setEmail(e);
                        break;
                    case 3:
                        System.out.print("Informe o novo Telefone: ");
                        f = in.nextLine();
                        achou.setFone(f);
                        break;
                    case 0:
                        System.out.println("=======================================");
                        System.out.println("Operação Encerrada!!");
                        System.out.println("=======================================");
                        break;
                    default:
                        System.out.println("=======================================");
                        System.err.println("Opção inválida!");
                        System.out.println("=======================================");
                }
            } while (op != 1 && op != 2 && op != 3 && op != 0);

        } else {
            System.err.println("Cliente não encontrado!");
        }
    }

    private void menu() {
        System.out.println("Escolha uma opção de alteração\n1 - E-mail e "
                + "telefone\n2 - E-mail\n3 - Telefone\nInforme a opção: ");
    }

    public void exibirClientes() {
        lse.exibirClientes();
    }
}
