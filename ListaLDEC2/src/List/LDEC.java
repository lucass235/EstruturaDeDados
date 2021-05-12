package List;

import Exception.*;

public class LDEC<T extends Comparable<T>> {

    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;

    public boolean isEmpty() {
        return this.qtd == 0;
    }

    public void inserirValorFinal(T valor) throws RepeatedValue {
        LDENode<T> newValor = new LDENode(valor);
        if (isEmpty()) {
            this.prim = newValor;
            this.prim.setAnt(this.ult);
            this.ult = newValor;
            this.ult.setProx(this.prim);
            this.qtd++;
        } else {
            this.ult.setProx(newValor);
            newValor.setAnt(this.ult);
            this.ult = newValor;
            this.ult.setProx(this.prim);
            this.prim.setAnt(this.ult);
            this.qtd++;
        }
    }

    public void concatenar(LDEC<T> list) {
        while(list.qtd != 0) {
            // valores da lista vai sendo removindo, apos a insercao dos
            //seus valores na  lista principal.
            this.inserirValorFinalC(list.prim.getInfo());
            list.removerPrim();
            // parada do while, no qtd da list igual a zero.
        }
        // lista concatenada.
    }

    public LDEC dividir() {
        LDEC list = new LDEC();
        int metade = (this.qtd / 2) + (this.qtd % 2);
        LDENode<T> aux = this.prim;
        LDENode<T> aux2 = this.prim;
        // processo de busca do ponto de corte do NO para dividir os valores...
        for (int i = 1; i <= this.qtd; i++) {
            if (i == metade) {
                aux2 = aux.getProx();
                aux.setProx(this.prim);
                this.ult = aux;
                this.prim.setAnt(this.ult);
                this.qtd = metade;
                break;
            } else {
                aux = aux.getProx();
            }
        }
        // processo de insercao da metade da lista original na lista nova...
        do {
            list.inserirValorFinalD(aux2.getInfo());
            aux2 = aux2.getProx();
        } while (aux.getProx() != aux2);
        return list;
    }

    public void inserirValorFinalC(T valor) {
        // metodo de insercao usado no concatenar.
        LDENode<T> newValor = new LDENode(valor);
        this.ult.setProx(newValor);
        newValor.setAnt(this.ult);
        this.ult = newValor;
        this.ult.setProx(this.prim);
        this.qtd++;
    }

    public void inserirValorFinalD(T valor) {
        // metodo de insercao usado no dividir.
        LDENode<T> newValor = new LDENode(valor);
        if (isEmpty()) {
            this.prim = newValor;
            this.ult = newValor;
            this.ult.setAnt(this.prim);
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
            this.qtd++;
        } else {
            this.ult.setProx(newValor);
            newValor.setAnt(this.ult);
            this.ult = newValor;
            this.ult.setProx(this.prim);
            this.qtd++;
        }
    }

    public void exibirLista() throws EmptyList {
        if (isEmpty()) {
            throw new EmptyList();
        } else {
            LDENode<T> aux = this.prim;
            do {
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            } while (aux != this.prim);
            System.out.println();
        }
    }
    
    private void removerPrim () {
        // metodo usado no
        if (this.qtd == 1) {
            this.prim = null;
            this.ult = null;
            this.qtd = 0;
        } else {
            this.prim = this.prim.getProx();
            this.prim.setAnt(this.ult);
            this.ult.setProx(this.prim);
            this.qtd--;
        }
    }
}
