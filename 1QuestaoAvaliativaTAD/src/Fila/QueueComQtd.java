package Fila;

public class QueueComQtd<T> {

    private QueueNode<T> prim;
    private QueueNode<T> ult;
    private int limit;
    private int qtd;

    public QueueComQtd(int limite) {
        this.limit = limite;
    }

    public boolean isEmpty() {
        return this.prim == null;
    }

    public boolean isFull() {
        return this.qtd == limit;
    }

    public T head() { // exibir o prim.
        return this.prim.getInfo();
    }

    public void enqueue(T val) { // inserir no final.
        QueueNode<T> novoVal = new QueueNode(val);
        if (isEmpty()) {
            this.prim = novoVal;
            this.ult = novoVal;
            this.qtd++;
        } else {
            this.ult.setProx(novoVal);
            this.ult = novoVal;
            this.qtd++;
        }
    }

    public T dequeue() { // remover o prim.
        QueueNode<T> aux = prim;
        if (this.prim == this.ult) {
            this.prim = null;
            this.ult = null;
            this.qtd = 0;
        } else {
            prim = prim.getProx();
            this.qtd--;
        }
        return aux.getInfo();
    }
}
