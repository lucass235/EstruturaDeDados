package List;

class LDENode<T extends Comparable<T>> {

    private T info;
    private LDENode<T> prox;
    private LDENode<T> ant;

    LDENode(T info) { // construtor.
        this.info = info;
    }

    void setInfo(T newInfo) {
        this.info = newInfo;
    }

    void setProx(LDENode<T> newProx) {
        this.prox = newProx;
    }

    T getInfo() {
        return this.info;
    }

    LDENode<T> getProx() {
        return this.prox;
    }

    LDENode<T> getAnt() {
        return this.ant;
    }

    void setAnt(LDENode<T> newAnt) {
        this.ant = newAnt;
    }

}
