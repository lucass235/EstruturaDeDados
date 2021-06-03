
package Deque;

public class DequeNode <T>{
    private T info;
    private DequeNode<T> prox;
    private DequeNode<T> ant;

    public DequeNode<T> getAnt() {
        return ant;
    }

    public void setAnt(DequeNode<T> ant) {
        this.ant = ant;
    }
    
    DequeNode (T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public DequeNode<T> getProx() {
        return prox;
    }

    public void setProx(DequeNode<T> prox) {
        this.prox = prox;
    }
}
