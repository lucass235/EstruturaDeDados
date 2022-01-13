package Controler;

import Trees.ABB;
import java.util.Scanner;

public class CadastroProduto {

    Scanner in = new Scanner(System.in);
    private ABB<Produto> arvoreBB;

    public CadastroProduto() { // construtor.
        this.arvoreBB = new ABB();
    }

    public void cadastrarProduto(Produto produto) {
        arvoreBB.insert(produto);
    }

    public void exibirProdutos() {
        arvoreBB.emOrdem();
    }

    private Produto buscarProduto(String codigo) {
        Produto retorno;
        Produto produto = new Produto(codigo);
        retorno = arvoreBB.buscarValor(produto);
        return retorno;
    }

    public void alterarPrecoProduto(String codigo) {
        Produto retorno;
        double novoPreco;
        retorno = buscarProduto(codigo);
        if (retorno != null) {
            System.out.print("Informe o novo preço do produto: ");
            novoPreco = in.nextDouble();
            while (novoPreco <= 0) {
                System.out.print("preço inválido, digite novamente: ");
                novoPreco = in.nextDouble();
            }
            retorno.setPreco(novoPreco);
            System.out.println("=============================================");
            System.out.println("Preço alterado!");
            System.out.println("=============================================");
        } else {
            System.out.println("=============================================");
            System.err.println("Produto não encontrado!");
            System.out.println("=============================================");
        }
    }

    public void alterarQtdEstoqueProduto(String codigo) {
        Produto retorno;
        int novoQtd;
        retorno = buscarProduto(codigo);
        if (retorno != null) {
            System.out.print("Informe o novo preço do produto: ");
            novoQtd = in.nextInt();
            retorno.setQtdEstoque(novoQtd);
            while (novoQtd <= 0) {
                System.out.print("Quantidade inválido, digite novamente: ");
                novoQtd = in.nextInt();
            }
            System.out.println("=============================================");
            System.out.println("Quantidade do estoque alterado!");
            System.out.println("=============================================");
        } else {
            System.out.println("============================================");
            System.err.println("Produto não encontrado!");
            System.out.println("============================================");
        }
    }

    public void exibirInfoProduto(String codigo) {
        Produto retorno;
        retorno = buscarProduto(codigo);
        if (retorno != null) {
            System.out.println(retorno);
        } else {
            System.out.println("============================================");
            System.err.println("Produto não encontrado!");
            System.out.println("============================================");
        }
    }

    public void remover(String codigo) {
        Produto retorno;
        retorno = buscarProduto(codigo);
        arvoreBB.remover(retorno);
        if (retorno != null) {
            arvoreBB.remover(retorno);
            System.out.println("============================================");
            System.out.println("Produto removido!");
            System.out.println("============================================");
        } else {
            System.out.println("============================================");
            System.err.println("Produto não encontrado!");
            System.out.println("============================================");
        }
    }
}
