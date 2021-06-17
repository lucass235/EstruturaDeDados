
package Trees;
public class ABBNode < T extends Comparable<T> >{
    private T info;
    private ABBNode<T> esquerda;
    private ABBNode<T> direita;

    ABBNode (T info) {
        this.info = info;
    }
    
    void insertNode(T valor) {
        if (this.getInfo().compareTo(valor) == 0) {
            System.out.println("=================================");
            System.err.println("Este produto ja se encontra cadastrado!");
            System.out.println("=================================");
        } else if (this.getInfo().compareTo(valor) < 0) {
            if (this.direita == null) {
                this.direita = new ABBNode(valor);
            System.out.println("=============================================");
            System.out.println("Produto cadastrado!");
            System.out.println("=============================================");
            } else {
                this.direita.insertNode(valor); // chamada recursiva para o proximo no.
            }
        } else {
            if (this.esquerda == null) {
                this.esquerda = new ABBNode(valor);
            System.out.println("=============================================");
            System.out.println("Produto cadastrado!");
            System.out.println("=============================================");
            } else {
                this.esquerda.insertNode(valor); // chamada recursiva para o proximo no.
            }
        }
    }
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public ABBNode<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(ABBNode<T> esquerda) {
        this.esquerda = esquerda;
    }

    public ABBNode<T> getDireita() {
        return direita;
    }

    public void setDireita(ABBNode<T> direita) {
        this.direita = direita;
    }
}
