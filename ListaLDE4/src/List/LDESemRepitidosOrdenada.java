package List;

public class LDESemRepitidosOrdenada<T extends Comparable<T>> {

    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;

    public int getQtd() {
        return qtd;
    }

    public boolean isEmpty() {
        return this.qtd == 0;// ele retornara o resultado dessa condiçao
    }

    public void inserirValorOrdenadoDecrescente(T valor) {
        LDENode<T> novoValor = new LDENode(valor);
        if (isEmpty()) { // lista vazia.
            this.prim = novoValor;
            this.ult = novoValor;
            this.qtd++;
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "Primeiro valor inserido!",
                    "==============================================");
        } else if (novoValor.getInfo().compareTo(this.prim.getInfo()) > 0) {
            // valor maior que o prim.getInfo, inserção no inico da lista.
            novoValor.setProx(this.prim);
            this.prim.setAnt(novoValor);
            this.prim = novoValor;
            this.qtd++;
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "valor inserido no inicio da lista!",
                    "==============================================");
        } else if (novoValor.getInfo().compareTo(this.ult.getInfo()) < 0) {
            // valor menor que o ult.getInfo, inserção no final da lista.
            this.ult.setProx(novoValor);
            novoValor.setAnt(this.ult);
            this.ult = novoValor;
            this.ult.setProx(null);
            this.qtd++;
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "valor inserido no final da lista!",
                    "==============================================");
        } else { // inserir valor no meio da lista, entrem o prim e o ult.
            LDENode<T> atu = this.prim;
            while (atu != null) {
                if (novoValor.getInfo().compareTo(atu.getInfo()) == 0) {
                    //Valor repitido, processo de inserção interrompido...
                    System.out.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "valor já se encontra na lista!",
                            "==============================================");
                    return;
                } else { // valor não repitido, processo de inserção...
                    if (novoValor.getInfo().compareTo(atu.getInfo()) > 0) {
                        atu.getAnt().setProx(novoValor);
                        novoValor.setAnt(atu.getAnt());
                        novoValor.setProx(atu);
                        this.qtd++;
                        return;
                    } else {
                        atu = atu.getProx();
                    }
                }
            }
        }
    }

    public void removerValor(T valor) {

        if (isEmpty()) {
            System.out.println("===============================================");
            System.err.println("lista vazia!");
            System.out.println("===============================================");
        } else if (this.qtd == 1) { // remoçao da unica novoNo da lista.
            LDENode<T> pessoa = new LDENode(valor);
            if (this.prim.getInfo().compareTo(pessoa.getInfo()) == 0) { // verificaçao da novoNo escolhida para ser removida.
                this.prim = null;
                this.ult = null;
                this.qtd--;
                System.out.printf("%S%n%S%n%S%n",
                        "==============================================",
                        "valor removido, lista vazia!",
                        "==============================================");
            } else { // caso da novoNo escolhida não está na lista,
                System.out.printf("%S%n%S%n%S%n",
                        "==============================================",
                        "valor não encontrado!",
                        "==============================================");
            }
        } else { // remoçao geral, com qtd maior que 0.
            LDENode<T> novoNo = buscarValor(valor); // funçao de buscar novoNo na lista.
            if (novoNo != null) { // caso de novoNo encontrada na lista, processo de remoçao...
                if (this.prim.getInfo().compareTo(novoNo.getInfo()) == 0) { // caso da novoNo ser a primeira da lista.
                    // processo de remoçao do primeiro valor da lista.
                    this.prim = this.prim.getProx();
                    this.prim.setAnt(null);
                    this.qtd--;
                } else if (this.ult.getInfo().compareTo(novoNo.getInfo()) == 0) { // caso da novoNo ser a ultima da lista.
                    // processo de remoçao do ultimo valor da lista.
                    this.ult = this.ult.getAnt();
                    this.ult.setProx(null);
                    this.qtd--;
                } else { // processo de remoçao no meio da lista.
                    novoNo.getAnt().setProx(novoNo.getProx());
                    novoNo.getProx().setAnt(novoNo.getAnt());
                    this.qtd--;
                }
                System.out.printf("%S%n%S%n%S%n",
                        "==============================================",
                        "valor removido!",
                        "==============================================");
            } else { // caso da novoNo escolhida não ser encontrada, remoçao não efetuada.
                System.out.printf("%S%n%S%n%S%n",
                        "==============================================",
                        "valor não encontrado!",
                        "==============================================");
            }
        }
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

    public void exibirValoresDecrescente() {
        LDENode<T> aux = this.prim;
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    public void exibirValoresCrescente() {
        LDENode<T> aux = this.ult;
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getAnt();
        }
        System.out.println();
    }
    
    public void exibirInfo (T valor) {
        LDENode<T> no = buscarValor(valor);
        if (no != null) {
            System.out.println("=============================================");
            System.out.println(no.getInfo());
            System.out.println("=============================================");
        } else {
            System.err.printf("%S%n%S%n%S%n",
                            "==============================================",
                            "valor não encontrado!",
                            "==============================================");
        }
    }

}
