package Trees;

import Pilha.Stack;

public class ABB<T extends Comparable<T>> {

    private ABBNode<T> raiz;

    public boolean isEmpty() {
        return raiz == null;
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

    public int qtdValorNaArvore(T value) {
        ABBNode<T> aux = raiz;
        int qtd = 0;
        if (!isEmpty()) {
            while (aux != null) {

                if (aux.getInfo().compareTo(value) == 0) {
                    qtd++;
                }
                if (aux.getInfo().compareTo(value) > 0) {
                    aux = aux.getLeft();
                } else {
                    aux = aux.getRight();
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
}
