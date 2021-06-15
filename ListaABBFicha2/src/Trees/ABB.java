package Trees;

import Fila.Queue;
import Pilha.Stack;

public class ABB<T extends Comparable<T>> {

    private ABBNode<T> raiz;

    public boolean isEmpty() {
        return raiz == null;
    }

    // procediemnto de insersao de valores na arvore.
    public void insert(T value) {
        if (isEmpty()) {
            raiz = new ABBNode(value);
            System.out.println("Valor inserido!");
        } else {
            // chamada do procediemnto de insersao da classe ABBNode
            raiz.insertNode(value);
        }
    }

    public void insertRepetidos(T value) {
        if (isEmpty()) {
            raiz = new ABBNode(value);
            System.out.println("Valor inserido!");
        } else {
            // chamada do procediemnto de insersao da classe ABBNode
            raiz.insertNodeRepetidos(value);
        }
    }

    public void emOrdemSemRecursao() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            // procediemento para exibicao de valores da arvore.
            pecorrerEmOrdemNaoRecusivo();
        }
    }

    public void preOrdemSemRecursao() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            // procediemento para exibicao de valores da arvore.
            pecorrerPreOrdemNaoRecusivo();
        }
    }

    public T buscarValor(T value) {
        ABBNode<T> aux;
        if (isEmpty()) {
            return null;
        } else {
            aux = raiz;
            while (aux != null) {
                if (value.compareTo(aux.getInfo()) == 0) {
                    // condicao do valor ser igual ao no atual.
                    return aux.getInfo();
                } else if (value.compareTo(aux.getInfo()) < 0) {
                    // condicao do valor ser menor do que o no atual.
                    if (aux.getLeft() == null) {
                        // condicao do no atual ser null.
                        return null;
                    } else {
                        // condicao do no atual estar com valor.
                        aux = aux.getLeft(); // anda para o proximo no.
                    }
                } else {
                    // condicao do valor ser maior do que o no atual.
                    if (aux.getRight() == null) {
                        // condicao do no atual ser null.
                        return null;
                    } else {
                        // condicao do no atual com valor.
                        aux = aux.getRight(); // anda para o proximo no.
                    }
                }
            }
            return null;
        }
    }

    public int qtdValorNaArvore(T value) {
        Queue<ABBNode<T>> fila;
        ABBNode<T> aux;
        int qtd = 0;
        if (!isEmpty()) {
            fila = new Queue();
            fila.enqueue(raiz);
            while (!fila.isEmpty()) {
                aux = fila.dequeue();
                if (aux.getLeft() != null) {
                    fila.enqueue(aux.getLeft());
                }
                if (aux.getRight() != null) {
                    fila.enqueue(aux.getRight());
                }
                if (aux.getInfo().compareTo(value) == 0) {
                    qtd++;
                }
            }
        } else {
            return 0;
        }
        return qtd;
    }

    private void pecorrerEmOrdemNaoRecusivo() {
        Stack<ABBNode<T>> pilha;
        ABBNode<T> aux = raiz;
        pilha = new Stack();
        while (!pilha.isEmpty() || aux != null) {
            if (aux != null) {
                pilha.push(aux);
                aux = aux.getLeft();
            } else {
                aux = pilha.pop();
                System.out.println(aux.getInfo());
                aux = aux.getRight();
            }
        }
    }

    private void pecorrerPreOrdemNaoRecusivo() {
        Stack<ABBNode<T>> pilha;
        ABBNode<T> aux = raiz;
        pilha = new Stack();
        while (!pilha.isEmpty() || aux != null) {
            if (aux != null) {
                System.out.println(aux.getInfo());
                pilha.push(aux);
                aux = aux.getLeft();
            } else {
                aux = pilha.pop();
                aux = aux.getRight();
            }
        }
    }
}
