package List;

public class LDESemRepitidos<T extends Comparable<T>> {

    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;

    public int getQtd() {
        return qtd;
    }

    public boolean isEmpty() {
        return this.qtd == 0;// ele retornara o resultado dessa condiçao
    }

    public void inserirValorNaoOrdenado(T valor) {
        LDENode<T> newValor = new LDENode(valor);
        if (isEmpty()) { // verificaçao de lista vazia.
            this.prim = newValor;
            this.ult = newValor;
            this.qtd++;
            System.out.println("===============================================");
            System.out.println("Primeiro valor inserido!");
            System.out.println("===============================================");
        } else { // caso geral de cadastramento, com qtd maior que 0.
            if (buscarValor(valor) != null) { // busca de val ja cadastrada.
                System.out.println("==============================================");
                System.err.println("Esse valor já se encontra na lista!");
                System.out.println("==============================================");
            } else { // garantia de val não encontrada no cadastro, processo de cadastramento...
                this.ult.setProx(newValor);
                newValor.setAnt(this.ult);
                this.ult = newValor;
                this.qtd++;
                System.out.println("===============================================");
                System.out.println("Valor inserido com sucesso!");
                System.out.println("===============================================");
            }
        }
    }

    public void exibirValores() {
        LDENode<T> aux = this.prim;
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    private LDENode<T> buscarValor(T valor) {
        LDENode<T> val = new LDENode(valor);
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

    public void removerValor(T valor) {
        if (this.qtd == 1) { // remoçao do unico valor da lista.
            this.prim = null;
            this.ult = null;
            this.qtd--;
        } else { // remoçao geral, com qtd maior que 0.
            LDENode<T> val = new LDENode(valor);
            if (this.prim.getInfo().compareTo(val.getInfo()) == 0) { // caso da val ser a primeira da lista.
                // processo de remoçao do primeiro valor da lista.
                this.prim = this.prim.getProx();
                this.prim.setAnt(null);
                this.qtd--;
            } else if (this.ult.getInfo().compareTo(val.getInfo()) == 0) { // caso da val ser a ultima da lista.
                // processo de remoçao do ultimo valor da lista.
                this.ult = this.ult.getAnt();
                this.ult.setProx(null);
                this.qtd--;
            } else { // processo de remoçao no meio da lista.
                val.getAnt().setProx(val.getProx());
                val.getProx().setAnt(val.getAnt());
                this.qtd--;
            }
        }
    }

    public LDESemRepitidos ordenar(char op) {
        LDESemRepitidos novaLista = new LDESemRepitidos();
        LDENode<T> aux = this.prim;
        if (op == 'c') {
            while (aux != null) {
                // inserindo os valores da lista antiga na nova de forma ordenada.
                novaLista.inserirValorOrdenadoCrescente(aux.getInfo());
                // removendo o valor da lista antiga ja adicionado na nova lista.
                this.removerValor(aux.getInfo());
                aux = aux.getProx();
            }
        } else {
            while (aux != null) {
                // inserindo os valores da lista antiga na nova de forma ordenada.
                novaLista.inserirValorOrdenadoDecrescente(aux.getInfo());
                // removendo o valor da lista antiga ja adicionado na nova lista.
                this.removerValor(aux.getInfo());
                aux = aux.getProx();
            }
        }

        return novaLista;
    }

    private void inserirValorOrdenadoCrescente(T valor) {
        LDENode<T> novoValor = new LDENode(valor);
        if (isEmpty()) { // lista vazia.
            this.prim = novoValor;
            this.ult = novoValor;
            this.qtd++;
        } else if (novoValor.getInfo().compareTo(this.prim.getInfo()) < 0) {
            // valor menor que o prim.getInfo, inserção no inico da lista.
            novoValor.setProx(this.prim);
            this.prim.setAnt(novoValor);
            this.prim = novoValor;
            this.qtd++;
        } else if (novoValor.getInfo().compareTo(this.ult.getInfo()) > 0) {
            // valor maior que o ult.getInfo, inserção no final da lista.
            this.ult.setProx(novoValor);
            novoValor.setAnt(this.ult);
            this.ult = novoValor;
            this.ult.setProx(null);
            this.qtd++;
        } else { // inserir valor no meio da lista, entrem o prim e o ult.
            LDENode<T> atu = this.prim;
            while (atu != null) {
                if (novoValor.getInfo().compareTo(atu.getInfo()) < 0) {
                    atu.getAnt().setProx(novoValor);
                    novoValor.setProx(atu);
                    novoValor.setAnt(atu.getAnt());
                    this.qtd++;
                    return;
                } else {
                    atu = atu.getProx();
                }
            }
        }
    }

    private void inserirValorOrdenadoDecrescente(T valor) {
        LDENode<T> novoValor = new LDENode(valor);
        if (isEmpty()) { // lista vazia.
            this.prim = novoValor;
            this.ult = novoValor;
            this.qtd++;
        } else if (novoValor.getInfo().compareTo(this.prim.getInfo()) > 0) {
            // valor maior que o prim.getInfo, inserção no inico da lista.
            novoValor.setProx(this.prim);
            this.prim.setAnt(novoValor);
            this.prim = novoValor;
            this.qtd++;
        } else if (novoValor.getInfo().compareTo(this.ult.getInfo()) < 0) {
            // valor menor que o ult.getInfo, inserção no final da lista.
            this.ult.setProx(novoValor);
            novoValor.setAnt(this.ult);
            this.ult = novoValor;
            this.ult.setProx(null);
            this.qtd++;
        } else { // inserir valor no meio da lista, entrem o prim e o ult.
            LDENode<T> atu = this.prim;
            while (atu != null) {
                if (novoValor.getInfo().compareTo(atu.getInfo()) > 0) {
                    atu.getAnt().setProx(novoValor);
                    novoValor.setProx(atu);
                    novoValor.setAnt(atu.getAnt());
                    this.qtd++;
                    return;
                } else {
                    atu = atu.getProx();
                }
            }
        }
    }
}
