package List;

import java.util.Scanner;

public class LDESemRepitidos<T extends Comparable<T>> {

    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;

    public boolean isEmpty() {
        return this.qtd == 0;// ele retornara o resultado dessa condiçao
    }

    public void cadastrarPessoa(T rg, Scanner in) {
        LDENode<T> newValor = new LDENode(rg);
        if (isEmpty()) { // verificaçao de lista vazia.
            this.prim = newValor;
            this.ult = newValor;
            this.qtd++;
            System.out.println("===============================================");
            System.out.println("Primeiro pessoa cadastrada!");
            System.out.println("===============================================");
        } else { // caso geral de cadastramento, com qtd maior que 0.
            if (buscarPessoa(rg) != null) { // busca de pessoa ja cadastrada.
                System.err.println("Essa pessoa já se encontra registrada!");
                return;
            } else { // garantia de pessoa não encontrada no cadastro, processo de cadastramento...
                this.ult.setProx(newValor);
                newValor.setAnt(this.ult);
                this.ult = newValor;
                this.qtd++;
                System.out.println("===============================================");
                System.out.println("Pessoa cadastrada com sucesso!");
                System.out.println("===============================================");
            }
        }
        // confirmaçao de cadastramento...
        System.out.print("Deseja efetivar seu cadastro? digite 1- para sim ou 2- para não: ");
        int decisao = in.nextInt();
        if (decisao == 2) {
            removerUltimo(); // chamada da funçao de remoçao da pessoa cadastrada recentimente.
            System.out.println("==============================================");
            System.err.println("Cadastro cancelado!");
            System.out.println("==============================================");
        } else {
            System.out.println("==============================================");
            System.out.println("Cadastro efetivado com sucesso!");
            System.out.println("==============================================");
        }

    }

    public void removerPessoa(T rg) {

        if (isEmpty()) {
            System.out.println("===============================================");
            System.err.println("lista vazia!");
            System.out.println("===============================================");
        } else if (this.qtd == 1) { // remoçao da unica pessoa da lista.
            LDENode<T> pessoa = new LDENode(rg);
            if (this.prim.getInfo().compareTo(pessoa.getInfo()) == 0) { // verificaçao da pessoa escolhida para ser removida.
                this.prim = null;
                this.ult = null;
                this.qtd--;
                System.out.println("===============================================");
                System.out.println("Pessoa removida!");
                System.out.println("===============================================");
            } else { // caso da pessoa escolhida não está na lista,
                System.out.println("==============================================");
                System.err.println("Pessoa não encontrada!");
                System.out.println("==============================================");
            }
        } else { // remoçao geral, com qtd maior que 0.
            LDENode<T> pessoa = buscarPessoa(rg); // funçao de buscar pessoa na lista.
            if (pessoa != null) { // caso de pessoa encontrada na lista, processo de remoçao...
                if (this.prim.getInfo().compareTo(pessoa.getInfo()) == 0) { // caso da pessoa ser a primeira da lista.
                    // processo de remoçao do primeiro valor da lista.
                    this.prim = this.prim.getProx();
                    this.prim.setAnt(null);
                    this.qtd--;
                } else if (this.ult.getInfo().compareTo(pessoa.getInfo()) == 0) { // caso da pessoa ser a ultima da lista.
                    // processo de remoçao do ultimo valor da lista.
                    this.ult = this.ult.getAnt();
                    this.ult.setProx(null);
                    this.qtd--;
                } else { // processo de remoçao no meio da lista.
                    pessoa.getAnt().setProx(pessoa.getProx());
                    pessoa.getProx().setAnt(pessoa.getAnt());
                    this.qtd--;
                }
                System.out.println("===============================================");
                System.out.println("Pessoa removida!");
                System.out.println("===============================================");
            } else { // caso da pessoa escolhida não ser encontrada, remoçao não efetuada.
                System.out.println("==============================================");
                System.err.println("Pessoa não encontrada!");
                System.out.println("==============================================");
            }
        }
    }

    public void exibirPessoas() {
        if (isEmpty()) {
            System.out.println("===============================================");
            System.out.println("Lista vazia!");
            System.out.println("===============================================");
        } else {
            LDENode<T> aux = this.prim;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public LDENode<T> buscarPessoa(T rg) {
        LDENode<T> val = new LDENode(rg);
        LDENode<T> aux = this.prim;
        while (aux != null) {
            if (aux.getInfo().compareTo(val.getInfo()) == 0) {
                return aux;
            } else {
                aux = aux.getProx();
            }
        }
        return null;
    }

    public void removerUltimo() {
        if (this.qtd == 1) {
            this.prim = null;
            this.ult = null;
            this.qtd--;
        } else {
            this.ult = this.ult.getAnt();
            this.ult.setProx(null);
            this.qtd--;
        }
    }

    public boolean verificarRg(T rg) {
        LDENode<T> achou = buscarPessoa(rg);
        return achou != null;
    }
}
