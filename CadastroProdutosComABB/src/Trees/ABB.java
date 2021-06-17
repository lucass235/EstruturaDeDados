package Trees;

public class ABB< T extends Comparable<T>> {

    private ABBNode<T> raiz;

    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(T valor) {
        if (isEmpty()) {
            raiz = new ABBNode(valor);
            System.out.println("=============================================");
            System.out.println("Produto cadastrado!");
            System.out.println("=============================================");
        } else {
            raiz.insertNode(valor);
        }
    }

    public void emOrdem() {
        if (isEmpty()) {
            System.out.println("============================");
            System.err.println("A empresa não tem produtos!");
            System.out.println("============================");
        } else {
            pecorrerEmOrdem(this.raiz);
        }
    }

    private void pecorrerEmOrdem(ABBNode<T> no) {
        if (no != null) {
            pecorrerEmOrdem(no.getEsquerda());
            System.out.println(no.getInfo());
            pecorrerEmOrdem(no.getDireita());
        }
    }

    private ABBNode<T> buscarNo(T valor) {
        ABBNode<T> aux;
        aux = raiz;
        while (aux != null) {
            if (aux.getInfo().compareTo(valor) == 0) {
                return aux;
            } else if (aux.getInfo().compareTo(valor) < 0) {
                if (aux.getDireita() == null) {
                    return null;
                } else {
                    aux = aux.getDireita(); // anda para o proximo no.
                }
            } else {
                if (aux.getEsquerda() == null) {
                    return null;
                } else {
                    aux = aux.getEsquerda(); // anda para o proximo no.
                }
            }
        }
        return null;
    }

    public T buscarValor(T valor) {
        ABBNode<T> info;
        if (isEmpty()) {
            return null;
        } else {
            info = this.buscarNo(valor);
            if (info == null) {
                return null;
            } else {
                return info.getInfo();
            }
        }
    }

    public void remover(T valor) {
        if (isEmpty()) {
            System.out.println("============================");
            System.err.println("A empresa não tem produtos!");
            System.out.println("============================");
        } else {
            raiz = removerNo(raiz, valor);
        }
    }

    private ABBNode<T> removerNo(ABBNode<T> raiz, T valor) {
        if (raiz != null) {
            if (valor.compareTo(raiz.getInfo()) == 0) {
                ABBNode<T> pai, filho;
                if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
                    raiz = null;
                } else if (raiz.getEsquerda() == null) {
                    raiz = raiz.getDireita();
                } else if (raiz.getDireita() == null) {
                    raiz = raiz.getEsquerda();
                } else {
                    pai = raiz;
                    filho = pai.getEsquerda();
                    while (filho.getEsquerda() != null) {
                        pai = filho;
                        filho = filho.getDireita();
                    }
                    pai.setDireita(filho.getEsquerda());
                    raiz.setInfo(filho.getInfo());
                }
            } else if (valor.compareTo(raiz.getInfo()) < 0) {
                raiz.setEsquerda(removerNo(raiz.getEsquerda(), valor));
            } else {
                raiz.setDireita(removerNo(raiz.getDireita(), valor));
            }
        }
        return raiz;
    }
}
