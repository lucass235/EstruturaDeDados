package Logica;

import java.util.Scanner;

public class LSESemRepitidos<Produto extends Comparable<Produto>> {

    private LSENode<Produto> prim;
    private LSENode<Produto> ult;
    private int qtd;
    private Produto prod ;

    public void inserirProdutoI(Produto p) {
        LSENode<Produto> newPro = new LSENode(p);
        if (qtd == 0) {
            this.prim = newPro;
            this.ult = newPro;
            this.qtd++;
            System.out.println("==============================================");
            System.out.println("Produto cadastrado!");
            System.out.println("==============================================");
        } else {
            LSENode<Produto> resul = buscar(p);
            if (resul != null ) {
                System.out.println("=========================================");
                System.err.println("O produto já foi cadastrado!");
                System.out.println("==========================================");
            } else {
                newPro.setProx(this.prim);
                this.prim = newPro;
                qtd++;
                System.out.println("==============================================");
                System.out.println("Produto cadastrado!");
                System.out.println("==============================================");
            }
        }
    }

    public void inserirProdutoF(Produto p) {
        LSENode<Produto> newPro = new LSENode(p);
        if (qtd == 0) {
            this.prim = newPro;
            this.ult = newPro;
            this.qtd++;
            System.out.println("==============================================");
            System.out.println("Produto cadastrado!");
            System.out.println("==============================================");
        } else {
            LSENode<Produto> resul = buscar(p);
            if (resul != null) {
                System.out.println("==========================================");
                System.err.println("O produto já foi cadastrado!");
                System.out.println("==========================================");
            } else {
                this.ult.setProx(newPro);
                this.ult = newPro;
                qtd++;
                System.out.println("==============================================");
                System.out.println("Produto cadastrado!");
                System.out.println("==============================================");
            }
        }
    }

    public void exibirProdutos() {
        if (qtd == 0) {
            System.out.println("==============================================");
            System.err.println("Lista vazia!");
            System.out.println("==============================================");
        } else {
            LSENode<Produto> aux = this.prim;
            System.out.println("Segue a lista dos produtos Registrados: ");
            System.out.println("==============================================");
            for (int i = 0; i < qtd; i++) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void removerProdutoP() {
        if (qtd == 0) {
            System.out.println("================================================");
            System.err.println("Lista vazia!");
            System.out.println("================================================");
        } else {
            this.prim = this.prim.getProx();
            qtd--;
            System.out.println("================================================");
            System.out.println("Produto removido!");
            System.out.println("================================================");
        }
    }

    public void removerProdutoF() {
        if (qtd == 0) {
            System.out.println("================================================");
            System.err.println("Lista vazia!");
            System.out.println("================================================");
        } else {
            LSENode<Produto> aux = this.prim;
            for (int i = 0; i < qtd - 1; i++) {
                aux = aux.getProx();
            }
            this.ult = aux;
            qtd--;
            System.out.println("================================================");
            System.out.println("Produto removido!");
            System.out.println("================================================");
        }
    }

    private LSENode<Produto> buscar(Produto p) {
        if (qtd == 0) {
            return null;
        } else {
            LSENode<Produto> aux = this.prim;
            Produto auxProduto = aux.getInfo();
            for (int i = 0; i < qtd; i++) {
                auxProduto = aux.getInfo();
                if (auxProduto.compareTo(p) == 0) {
                    return aux;
                }
                aux = aux.getProx();
            }
        }
        return null;
    }

    public void buscarProduto(Produto p) {
        LSENode<Produto> retorno;
        if (qtd == 0) {
            System.err.println("Lista vazia!");
        } else {
            retorno = buscar(p);
            if (retorno == null) {
                System.err.println("O produto informado não está cadastrado!");
            } else {
                System.out.println(retorno.getInfo());
            }
        }
    }

    public void alterarDados(Produto p, Scanner in) {
        if (qtd == 0) {
            System.err.println("Lista vazia!");
        } else {
            LSENode<Produto> retorno;
            retorno = buscar(p);
            if (retorno == null) {
                System.out.println("==========================================");
                System.err.println("O produto informado não está cadastrado!");
                 System.out.println("==========================================");
            } else {
                int op, estoque;
                double preco;
                do {
                    menu();
                    
                    op = in.nextInt();
                    switch (op) {
                        case 1:
                            System.out.print("Informe o  Novo preço: ");
                            preco = in.nextDouble();
                            System.out.print("Informe o Novo estoque: ");
                            estoque = in.nextInt();
                            break;
                        case 2:
                            System.out.print("Informe o  Novo estoque: ");
                            estoque = in.nextInt();
                            break;
                        case 3:
                            System.out.print("Informe o Novo preço: ");
                            preco = in.nextDouble();
                            break;
                        case 0:
                            System.out.println("==============================");
                            System.out.println("Operação Encerrada!");
                            System.out.println("==============================");
                            break;
                        default:
                            System.err.println("Opção inválida!!");
                    }
                } while (op != 1 && op != 2 && op != 3 && op != 0);

            }
        }
    }

    private void menu() {
        System.out.println("Voce deseja qual opção:\n1 - Alterar preço e estoque"
                + "\n2 - Estoque\n3 - Preço\n0 - Encerrar operação\n");
    }

}
