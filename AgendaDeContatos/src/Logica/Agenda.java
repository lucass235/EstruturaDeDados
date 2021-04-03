package Logica;

import List.LSESemRepitidosOrdenada;
import java.util.Scanner;

public class Agenda {

    private LSESemRepitidosOrdenada<Contato> lse;

    public Agenda() { // costrutor.
        this.lse = new LSESemRepitidosOrdenada();
    }

    Contato c;
    Scanner in = new Scanner(System.in);

    public void adicinarContato(String nome) {
        Contato achou;
        c = new Contato(nome, "", "");
        achou = lse.buscarContato(c);
        if (achou == null) {
            String fo, em;
            System.out.print("Informe o Telefone: ");
            fo = in.nextLine();
            System.out.print("Informe o Email: ");
            em = in.nextLine();
            c = new Contato(nome, fo, em);
            lse.inserirContato(c);
        } else {
            System.out.println("=======================================");
            System.err.println("Esse nome já se encontra cadastrado!");
            System.out.println("=======================================");
        }
    }

    public void listarContatos() {
        lse.exibirContatos();
    }

    public void removerContato(String nome) {
        c = new Contato(nome, "", "");
        lse.removerContato(c);
    }

    public void consultarContato(String nome) {
        Contato achou;
        c = new Contato(nome, "", "");
        achou = lse.buscarContato(c);
        if (achou == null) {
            System.out.println("=======================================");
            System.err.println("Contato não encontrado!");
            System.out.println("=======================================");
        } else {
            System.out.println(achou);
        }
    }

    public void AlterarDados(String nome) {
        Contato achou;
        c = new Contato(nome, "", "");
        achou = lse.buscarContato(c);
        
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
                        System.out.println("==================================================");
                        System.out.println("Alteraçoes efetuada com Sucesso!");
                        System.out.println("==================================================");
                        break;
                    case 2:
                        System.out.print("Informe o novo e-mail: ");
                        e = in.nextLine();
                        achou.setEmail(e);
                        System.out.println("==================================================");
                        System.out.println("Alteração efetuada com Sucesso!");
                        System.out.println("==================================================");
                        break;
                    case 3:
                        System.out.print("Informe o novo Telefone: ");
                        f = in.nextLine();
                        achou.setFone(f);
                        System.out.println("==================================================");
                        System.out.println("Alteração efetuada com Sucesso!");
                        System.out.println("==================================================");
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
            System.out.println("==================================================");
            System.err.println("Contato não encontrado!");
            System.out.println("==================================================");
        }
    }

    private void menu() {
        System.out.println("Escolha uma opção de alteração\n1 - E-mail e "
                + "telefone\n2 - E-mail\n3 - Telefone\nInforme a opção: ");
    }

    public void exibirContatos() {
            System.out.println("Aqui estão todos os contatos da agenda: ");
            System.out.println("==================================================");
            lse.exibirContatos();
    }
}
