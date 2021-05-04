package List;

class LSENode<T extends Comparable<T> > {

    private T info; // atributo contendo a informação do nó adicionado.
    private LSENode<T> prox; // atributo contendo o endereço do prox nó.
    
    LSENode (T valor){ // metodo construtor, inicializa a informação do nó.
        this.info = valor;
    }
    
    void setInfo(T valor) { // metodo set, atualizando a informação do nó.
        this.info = valor;
    }
    
    void setProx(LSENode<T> prox) { // metodo set, atualizando a o endereço do prox nó.
        this.prox = prox;
    }
    
    T getInfo() { // metodo get, enviando a informação do nó.
        return this.info;
    }
    
    LSENode<T> getProx() { // metodo get, enviando o endereço do prox nó.
        return this.prox;
    }
}
