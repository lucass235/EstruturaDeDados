package List;

public class LSECircular<T extends Comparable<T> > {

    private LSENode<T> prim; // atributo que guarda o endereço do prim nó.
    private LSENode<T> ult; // atributo que guarda o endereço do ult nó.
    private int qtd; // atributo que guarda a qtd de nós na lista.

    public boolean isEmpty() {
        return this.qtd == 0;
    }

    public void inserirValorFinal(T info) {
        LSENode<T> newNo = new LSENode(info); // criação do novo nó para inserir na lista.
        if (isEmpty()) {
            this.prim = newNo;
            this.ult = newNo;
            ult.setProx(this.prim);
            qtd++;
        } else {
            this.ult.setProx(newNo);
            this.ult = newNo;
            ult.setProx(prim);
            qtd++;
        }
        System.out.printf("%S%n%S%n%S%n",
                "==============================================",
                "valor inserido no final da lista!",
                "==============================================");
    }

    public void inserirValorInicio(T info) {
        LSENode<T> newNo = new LSENode(info); // criação do novo nó para inserir na lista.
        if (isEmpty()) {
            this.prim = newNo;
            this.ult = newNo;
            ult.setProx(this.prim);
            qtd++;
        } else {
            newNo.setProx(this.prim);
            this.prim = newNo;
            qtd++;
        }
        System.out.printf("%S%n%S%n%S%n",
                "==============================================",
                "valor inserido no inicio da lista!",
                "==============================================");
    }

    public void exibirInfo() {
        if (this.qtd == 0) {
            System.out.println("================================================");
            System.err.println("Lista vazia!!");
            System.out.println("================================================");
        } else {
            LSENode<T> aux;
            aux = this.prim;
            System.out.println("================================================");
            for (int i = 0; i < this.qtd; i++) {
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            }
            System.out.println();
            System.out.println("===============================================");
        }
    }

    public void removerInicio() {
        if (isEmpty()) {
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "lista vazia!",
                    "==============================================");
        } else if (this.qtd == 1) {
            this.prim = null;
            this.prim = null;
            this.qtd = 0;
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "valor removido, lista vazia!",
                    "==============================================");
        } else {
            this.prim = this.prim.getProx();
            this.qtd--;
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "valor removido!",
                    "==============================================");
        }
    }

    public void removerFinal() {
        if (isEmpty()) {
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "lista vazia!",
                    "==============================================");
        } else if (this.qtd == 1) {
            this.prim = null;
            this.prim = null;
            this.qtd = 0;
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "valor removido, lista vazia!",
                    "==============================================");
        } else {
            LSENode<T> aux = this.prim;
            LSENode<T> ant = this.prim;
            for (int i = 0; i < this.qtd; i++) {
                ant = aux;
                if (aux != this.ult) {
                    aux = aux.getProx();
                }
            }
            this.ult = ant;
            this.ult.setProx(this.prim);
            this.qtd--;
            System.out.printf("%S%n%S%n%S%n",
                    "==============================================",
                    "valor removido!",
                    "==============================================");
        }
    }
    
    public int qtdValor (T val) {
       int vezes = 0;
        if (isEmpty()) {
           return 0;
        } else {
            LSENode<T> aux = this.prim;
            for (int i = 0; i < this.qtd; i++) {
                if (aux.getInfo().compareTo(val) == 0) {
                    vezes++;
                }
                aux = aux.getProx();
            }
        }
        return vezes;
    }

}
