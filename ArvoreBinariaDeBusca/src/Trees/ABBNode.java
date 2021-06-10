package Trees;

class ABBNode<T extends Comparable<T>> {

    private T info;
    private ABBNode<T> left;
    private ABBNode<T> right;

    ABBNode(T info) {
        this.info = info;
    }

    T getInfo() {
        return info;
    }

    void setInfo(T info) {
        this.info = info;
    }

    ABBNode<T> getLeft() {
        return left;
    }

    void setLeft(ABBNode<T> left) {
        this.left = left;
    }

    ABBNode<T> getRight() {
        return right;
    }

    void setRight(ABBNode<T> righ) {
        this.right = righ;
    }

    // procedimento de insersao de valor no no.
    void insertNode(T value) {
        if (value.compareTo(this.getInfo()) == 0) {
            // condicao do valor ser igual ao no atual.
            System.out.println("Valor repetido.");
        } else if (value.compareTo(this.getInfo()) < 0) {
            // condicao do valor ser menor do que o no atual.
            if (this.left == null) {
                // cindicao do no atual ser null.
                this.left = new ABBNode(value); // fim da insersao.
            } else {
                // condicao do no atual estar com valor.
                this.left.insertNode(value); // chamada recursiva
            }
        } else {
            // condicao do valor ser maior do que o no atual.
            if (this.right == null) {
                // condicao do no atual ser null.
                this.right = new ABBNode(value); // fim da insersao.
            } else {
                // condicao do no atual com valor.
                this.right.insertNode(value); // chamada recursiva
            }
        }
    }

}
