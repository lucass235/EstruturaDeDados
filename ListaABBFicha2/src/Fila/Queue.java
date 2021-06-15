
package Fila;

public class Queue <T> {
    private QueueNode<T> prim;
    private QueueNode<T> ult;
    
    public boolean isEmpty() {
        return prim == null;
    }
    
    public boolean isFull () {
        return false;
    }
    
    public T head () { // exibir o prim.
        return prim.getInfo();
    }
    
    public void enqueue (T val) { // inserir no final.
        QueueNode<T> novoVal = new QueueNode(val);
        if (isEmpty()) {
            prim = novoVal;
            ult = novoVal;
        } else {
            ult.setProx(novoVal);
            ult = novoVal;
        }
    }
    
    public T dequeue () { // remover o prim.
        QueueNode<T> aux = prim;
        if (prim == ult) {
            prim = null;
            ult = null;
        } else {
            prim = prim.getProx();
        }
        return aux.getInfo();
    }
}
