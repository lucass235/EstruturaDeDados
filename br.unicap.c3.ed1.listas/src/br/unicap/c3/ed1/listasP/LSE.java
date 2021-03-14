package br.unicap.c3.ed1.listasP;

public class LSE<T> {

    private LSENode<T> prim; // atributo que guarda o endereço do prim nó.
    private LSENode<T> ult; // atributo que guarda o endereço do ult nó.
    private int qtd; // atributo que guarda a qtd de nós na lista.

    public void inserirInfo(T info) {
        LSENode<T> newNo = new LSENode(info); // criação do novo nó para inserir na lista.
        if (qtd == 0) {
            this.prim = newNo;
            this.ult = newNo;
            qtd++;
        } else {
            this.ult.setProx(newNo);
            this.ult = newNo;
            qtd++;
        }
        System.out.println("================================================");
        System.out.println("Valor inserido com sucesso!");
        System.out.println("================================================");
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
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
            System.out.println("===============================================");
        }
    }
}
