package Logica;

import java.util.Scanner;

public class LSESemRepitidos<T extends Comparable<T>> {

    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;

    public void inserirProdutoI(T p) {
        LSENode<T> newPro = new LSENode(p);
        if (qtd == 0) {
            this.prim = newPro;
            this.ult = newPro;
            this.qtd++;
            System.out.println("==============================================");
            System.out.println("Produto cadastrado!");
            System.out.println("==============================================");
        } else {
            LSENode<T> resul = buscar(p);
            if (resul != null) {
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

    public void inserirProdutoF(T p) {
        LSENode<T> newPro = new LSENode(p);
        if (qtd == 0) {
            this.prim = newPro;
            this.ult = newPro;
            this.qtd++;
            System.out.println("==============================================");
            System.out.println("Produto cadastrado!");
            System.out.println("==============================================");
        } else {
            LSENode<T> resul = buscar(p);
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
            LSENode<T> aux = this.prim;
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
            LSENode<T> aux = this.prim;
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

    private LSENode<T> buscar(T p) {
        if (qtd == 0) {
            return null;
        } else {
            LSENode<T> aux = this.prim;
            T auxProduto = aux.getInfo();
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

    public void buscarProduto(T p) {
        LSENode<T> retorno;
        if (qtd == 0) {
            System.out.println("=========================================");
            System.err.println("Lista vazia!");
            System.out.println("=========================================");
        } else {
            retorno = buscar(p);
            if (retorno == null) {
                System.out.println("=========================================");
                System.err.println("O produto informado não está cadastrado!");
                System.out.println("=========================================");
            } else {
                System.out.println(retorno.getInfo());
            }
        }
    }

    public void alterarDados(T p, Scanner in) {
        if (qtd == 0) {
            System.out.println("==============================");
            System.err.println("Lista vazia!");
            System.out.println("==============================");
        } else {
            LSENode<T> retorno;
            retorno = buscar(p);
            if (retorno == null) {
                System.out.println("==========================================");
                System.err.println("O produto informado não está cadastrado!");
                System.out.println("==========================================");
            } else {
                int op, estoque;
                double preco;
                Produto prod = (Produto) retorno.getInfo();
                do {
                    menu();
                    op = in.nextInt();
                    switch (op) {
                        case 1:
                            System.out.print("Informe o  Novo preço: ");
                            preco = in.nextDouble();
                            System.out.print("Informe o Novo estoque: ");
                            estoque = in.nextInt();
                            prod.alterarEstoque(estoque);
                            prod.alterarPreco(preco);
                            break;
                        case 2:
                            System.out.print("Informe o  Novo estoque: ");
                            estoque = in.nextInt();
                            prod.alterarEstoque(estoque);
                            break;
                        case 3:
                            System.out.print("Informe o Novo preço: ");
                            preco = in.nextDouble();
                            prod.alterarPreco(preco);
                            break;
                        case 0:
                            System.out.println("==============================");
                            System.out.println("Operação Encerrada!");
                            System.out.println("==============================");
                            break;
                        default:
                            System.out.println("==============================");
                            System.err.println("Opção inválida!!");
                            System.out.println("==============================");
                    }
                } while (op != 1 && op != 2 && op != 3 && op != 0);

            }
        }
    }

    private void menu() {
        System.out.println("O que você deseja Alterar?:\n1 - Alterar preço e estoque"
                + "\n2 - Estoque\n3 - Preço\n0 - Encerrar operação");
    }

}
