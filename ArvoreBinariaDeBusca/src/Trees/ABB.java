package Trees;

public class ABB<T extends Comparable<T>> {

    private ABBNode<T> raiz;

    public ABBNode<T> getRaiz() {
        return raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    // procediemnto de insersao de valores na arvore.
    public void insert(T value) {
        if (isEmpty()) {
            raiz = new ABBNode(value);
        } else {
            // chamada do procediemnto de insersao da classe ABBNode
            raiz.insertNode(value);
        }
    }

    //procediemnto para exibir valores.
    public void emOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            // procediemento para exibicao de valores da arvore.
            percorrerEmOrdem(raiz);
        }
    }

    // procediemento privado interno para exibir todos os valores da arvore. 
    private void percorrerEmOrdem(ABBNode<T> no) {
        if (no != null) {
            percorrerEmOrdem(no.getLeft());
            System.out.println(no.getInfo());
            percorrerEmOrdem(no.getRight());
        }
    }

    // funcao interna recursiva que pega o no que contem o menor valor.
    private ABBNode<T> menorNo(ABBNode<T> no) {
        if (no.getLeft() != null) {
            no = menorNo(no.getLeft());
        }
        return no;
    }

    // funcao para retorna o menor valor do no apartir da chamada da funcao menorNo.
    public T menorValor() {
        if (isEmpty()) {
            return null;
        } else {
            ABBNode<T> retorno;
            retorno = menorNo(raiz);
            return retorno.getInfo();
        }
    }

    private ABBNode<T> maiorNo(ABBNode<T> no) {
        if (no.getRight() != null) {
            no = maiorNo(no.getRight());
        }
        return no;
    }

    public T maiorValor() {
        if (isEmpty()) {
            return null;
        } else {
            ABBNode<T> aux;
            aux = maiorNo(raiz);
            return aux.getInfo();
        }
    }

    public void inserirNo(T value) {
        ABBNode<T> aux;
        ABBNode<T> newNo = new ABBNode(value);
        if (isEmpty()) {
            raiz = new ABBNode(value);
        } else {
            aux = raiz;
            while (aux != null) {
                if (value.compareTo(aux.getInfo()) == 0) {
                    // condicao do valor ser igual ao no atual.
                    System.out.println("Valor repetido.");
                    return;
                } else if (value.compareTo(aux.getInfo()) < 0) {
                    // condicao do valor ser menor do que o no atual.
                    if (aux.getLeft() == null) {
                        // condicao do no atual ser null.
                        aux.setLeft(newNo); // fim da insersao.
                        return;
                    } else {
                        // condicao do no atual estar com valor.
                        aux = aux.getLeft();
                    }
                } else {
                    // condicao do valor ser maior do que o no atual.
                    if (aux.getRight() == null) {
                        // condicao do no atual ser null.
                        aux.setRight(newNo); // fim da insersao.
                        return;
                    } else {
                        // condicao do no atual com valor.
                        aux = aux.getRight();
                    }
                }
            }
        }
    }

    public int qtdNo(ABBNode<T> no) {
        if (no != null) {
            return qtdNo(no.getLeft()) + qtdNo(no.getRight()) + 1;
        }
        return 0;
    }

    public int qtdFolhas(ABBNode<T> no) {
        int qtd = 0;
        if (no == null) {
            return 0;
        } else {
            if (no.getLeft() == null && no.getRight() == null) {
                return qtdNo(no.getLeft()) + qtdNo(no.getRight()) + 1;
            } else {
                return qtdNo(no.getLeft()) + qtdNo(no.getRight());
            }

        }
    }
    
    public int qtdNosNaoTerminais(ABBNode<T> no) {
        if (no == null) {
            return 0;
        } else {
            if (no.getLeft() != null || no.getRight() != null) {
                return qtdNosNaoTerminais(no.getLeft()) + qtdNosNaoTerminais(no.getLeft()) + 1;
            } else {
                return qtdNosNaoTerminais(no.getLeft()) + qtdNosNaoTerminais(no.getLeft());
            }
        }
    }
}
