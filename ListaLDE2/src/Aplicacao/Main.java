package Aplicacao;

import java.util.Scanner;
import Logica.Cadastro;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cadastro ca = new Cadastro();
        char op;
        String nome, rg;
        do {
            menu();
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '1':
                    System.out.print("Informe o nome da pessoa: ");
                    nome = in.nextLine();
                    System.out.print("Informe o RG da pessoa: ");
                    rg = in.nextLine();
                    ca.Cadastrar(nome, rg);
                    ca.removerUltimaPessoa(rg);
                    break;
                case '2':
                    System.out.print("Informe o RG da pessoa a ser removida: ");
                    rg = in.nextLine();
                    ca.remover(rg);
                    break;
                case '3':
                    System.out.print("Informe o RG da pessoa a ser verificada: ");
                    rg = in.nextLine();
                    ca.verificarPessoa(rg);
                    break;
                case '4':
                    ca.exibir();
                    break;
                case '5':
                    ca.qtdPessoas();
                    break;
                case '0':
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
        } while (op != '0');
    }

    public static void menu() {
        System.out.print("1- Cadastrar pessoa"
                + "\n2 - Remover pessoa"
                + "\n3 - Verificar pessoa"
                + "\n4 - Exibir pessoas cadastradas"
                + "\n5 - Exibir quantidades de pessoas cadastradas"
                + "\n0 - Encerrar\nInforme o opção desejada: ");
    }
}
