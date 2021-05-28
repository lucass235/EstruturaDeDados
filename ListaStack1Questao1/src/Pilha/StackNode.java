package Pilha;

public class StackNode<T> {

    private T info;
    private StackNode<T> prox;

    StackNode(T info) {
        this.info = info;
    }

    T getInfo() {
        return info;
    }

    void setInfo(T info) {
        this.info = info;
    }

    StackNode<T> getProx() {
        return prox;
    }

    void setProx(StackNode<T> prox) {
        this.prox = prox;
    }
}
