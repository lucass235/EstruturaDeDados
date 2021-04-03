package Aplicacao;

import Logica.Agenda;
import java.util.Scanner;

public class GerenciaAgenda {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Agenda a = new Agenda();
        int op;
        String nome;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch  (op) {
                case 1:
                    System.out.print("Informe o nome do novo contato: ");
                    nome = in.nextLine();
                    a.adicinarContato(nome);
                    break;
                case 2:
                    System.out.print("Informe o nome do contato a ser removido: ");
                    nome = in.nextLine();
                    a.removerContato(nome);
                    break;
                case 3:
                    System.out.print("Informe o nome do contato para a alteração: ");
                    nome = in.nextLine();
                    a.AlterarDados(nome);
                    break;
                case 4:
                    System.out.print("Informe o nome do contato a ser consultado: ");
                    nome = in.nextLine();
                    a.consultarContato(nome);
                    break;
                case 5:
                    a.exibirContatos();
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
        System.out.println("1- Inserir um novo contato na Agenda\n2 - Remover um contato"
                + "\n3 - Alterar os dados de um contato\n4 - Consultar os dados"
                + "de um contato\n5 - Exibir os dados de todos os contatos\n"
                + "0 - Sair do Programa\nInforme a opção desejada: ");
    }
}
