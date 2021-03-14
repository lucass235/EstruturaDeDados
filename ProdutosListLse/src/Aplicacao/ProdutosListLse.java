package Aplicacao;

import Logica.*;
import java.util.Scanner;

public class ProdutosListLse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Produto p;
        LSESemRepitidos<Produto> list = new LSESemRepitidos();
        int op,estoque;
        double preco;
        String codigo, descricao;
        System.out.println("Bem vindo(a)!!");
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch  (op){
                case 1:
                    System.out.print("Informe o codigo do produto: ");
                    codigo = in.nextLine();
                    System.out.print("Informe o preço do produto: ");
                    preco = in.nextDouble();
                    in.nextLine();
                    System.out.print("Informe a descrição do produto: ");
                    descricao = in.nextLine();
                    System.out.print("Informe o estoque do produto: ");
                    estoque = in.nextInt();
                    p = new Produto(codigo, descricao, preco, estoque);
                    list.inserirProdutoI(p);
                    break;
                case 2:
                    System.out.print("Informe o codigo do produto: ");
                    codigo = in.nextLine();
                    System.out.print("Informe o preço do produto: ");
                    preco = in.nextDouble();
                    in.nextLine();
                    System.out.print("Informe a descrição do produto: ");
                    descricao = in.nextLine();
                    System.out.print("Informe o estoque do produto: ");
                    estoque = in.nextInt();
                    p = new Produto(codigo, descricao, preco, estoque);
                    list.inserirProdutoF(p);
                    break;
                case 3:
                    list.removerProdutoP();
                    break;
                case 4:
                    list.removerProdutoF();
                    break;
                case 5:
                    list.exibirProdutos();
                    break;
                case 6:
                    System.out.print("Informe o código do produto: ");
                    codigo = in.nextLine();
                    p = new Produto(codigo, "", 0, 0);
                    list.buscarProduto(p);
                    break;
                case 7:
                    System.out.print("Informe o código do produto: ");
                    codigo = in.nextLine();
                    p = new Produto(codigo, "", 0, 0);
                    list.alterarDados(p, in);
                    break;
                case 0:
                    System.out.println("=======================================");
                    System.out.println("Obrigado por usar nosso programa!!"
                            + "\nBy Lucas dos Santos");
                    System.out.println("=======================================");
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        } while (op != 0);
        
    }

    public static void menu() {
        System.out.print("1 - Inserir Produto no inicio da lista"
                + "\n2 - Inserir produto no final da lista\n3 - Remover o primeiro"
                + "produto da lista\n4 - Remover o último produto da lista"
                + "\n5 - Exibir todos os produtos da lista\n6 - Exibir os dados"
                + "de um produto da lista\n7 - Alterar os dados de um produto da lista"
                + "\n0 - Sair do produto\nInforme a opção desejada: ");
    }
}
