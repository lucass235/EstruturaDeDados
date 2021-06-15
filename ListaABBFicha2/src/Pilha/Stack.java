package Pilha;

public class Stack<T> {

    private StackNode<T> topo;

    public boolean isEmpty() { 
        return topo == null;
    }

    public boolean isFull() {  
        return false;
    }

    public void push(T valor) { // empilhar
        StackNode<T> novo = new StackNode(valor);

        if (isEmpty() == true) {
            topo = novo;
        } else {
            novo.setProx(topo);
            topo = novo;
        }
    }

    public T pop() {  // desempilhar
        T val = topo.getInfo();
        topo = topo.getProx();
        return val;
    }

    public T top() { // informa o topo
        return topo.getInfo();
    }
}
