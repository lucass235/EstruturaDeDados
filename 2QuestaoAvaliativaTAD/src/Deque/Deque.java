package Deque;

public class Deque<T> {

    private DequeNode<T> prim;
    private DequeNode<T> ult;

    public void push(T val) { // inserir val no inicio
        DequeNode<T> novoVal = new DequeNode(val);
        if (isEmpty()) {
            this.prim = novoVal;
            this.ult = novoVal;
        } else {
            this.prim.setAnt(novoVal);
            novoVal.setProx(this.prim);
            this.prim = novoVal;

        }
    }

    public T pop() { // remover o prim.
        DequeNode<T> aux = prim;
        if (this.prim == this.ult) {
            this.prim = null;
            this.ult = null;
        } else {
            prim = prim.getProx();
            this.prim.setAnt(null);
        }
        return aux.getInfo();
    }

    public void inject(T val) { // inserir no final.
        DequeNode<T> novoVal = new DequeNode(val);
        if (isEmpty()) {
            this.prim = novoVal;
            this.ult = novoVal;
        } else {
            this.ult.setProx(novoVal);
            novoVal.setAnt(this.ult);
            this.ult = novoVal;
        }
    }

    public T eject() { // remover ultimo val
        DequeNode<T> aux = prim;
        if (this.prim == this.ult) {
            this.prim = null;
            this.ult = null;
        } else {
            this.ult = this.ult.getAnt();
            this.ult.setProx(null);
        }
        return aux.getInfo();
    }

    public boolean isEmpty() {
        return this.prim == null;
    }

    public boolean isFull() {
        return false;
    }

}
