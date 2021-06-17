
package Aplicacao;
import Controler.CadastroProduto;
import Controler.Produto;
import java.util.Scanner;

public class Empresa {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Produto produto;
        CadastroProduto cadastro = new CadastroProduto();
        String codigo, descricao, fornecedor;
        Double preco;
        int qtdEstoque;
        char opcao;
        do {
            menu();
            opcao = in.next().charAt(0);
            in.nextLine();
            switch (opcao) {
                case '1':
                    System.out.print("informe o código do produto: ");
                    codigo = in.nextLine();
                    System.out.print("informe a descrição do produto: ");
                    descricao = in.nextLine();
                    System.out.print("informe o fornecedor do produto: ");
                    fornecedor = in.nextLine();
                    System.out.print("informe o preço do produto: ");
                    preco = in.nextDouble();
                    while (preco <= 0) {
                    System.out.print("preço inválido, digite novamente: ");
                    preco = in.nextDouble();
                    }
                    System.out.print("informe a quantidade de estoque do produto: ");
                    qtdEstoque = in.nextInt();
                    while (qtdEstoque <= 0) {
                    System.out.print("quantidade inválido, digite novamente: ");
                    qtdEstoque = in.nextInt();
                    }
                    produto = new Produto(codigo, descricao, fornecedor, preco, qtdEstoque);
                    cadastro.cadastrarProduto(produto);
                    break;
                case '2':
                    cadastro.exibirProdutos();
                    break;
                case '3':
                    System.out.print("informe o código do produto para alterar seu preço: ");
                    codigo = in.nextLine();
                    cadastro.alterarPrecoProduto(codigo);
                    break;
                case '4':
                    System.out.print("informe o código do produto para alterar sua quantidade de estoque: ");
                    codigo = in.nextLine();
                    cadastro.alterarQtdEstoqueProduto(codigo);
                    break;
                case '5':
                    System.out.print("informe o código do produto para exibir suas informações: ");
                    codigo = in.nextLine();
                    cadastro.exibirInfoProduto(codigo);
                    
                    break;
                case '6':
                    System.out.print("informe o código do produto para ser removido: ");
                    codigo = in.nextLine();
                    cadastro.remover(codigo);
                    
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
        } while (opcao != '0');
    }
    public static void menu() {
        System.out.printf("1 - %S\n2 - %S\n3 - %S\n4 - %S\n5 - %S\n6 - %S\n0 - %S\n%S"
                ,"cadastar produto", "exibir todos os produtos", 
                "alterar preço de um produto", "alterar quantidade de estoque de um produto",
                "exibir informacao de um produto", "remover produto", "encerrar programa",
                "escolha uma opção: ");
    }
}
