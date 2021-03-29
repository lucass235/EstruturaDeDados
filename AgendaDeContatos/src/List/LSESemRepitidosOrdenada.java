package List;

public class LSESemRepitidosOrdenada<T extends Comparable<T>> {

    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;
    
    public void inserirContato(T con) {
        LSENode<T> newCon = new LSENode(con);
        if (qtd == 0) { // lista vazia.
            this.prim = newCon;
            this.ult = newCon;
            this.qtd++;
        } else if (newCon.getInfo().compareTo(this.prim.getInfo()) < 0) {
            // valor menor que o prim.getInfo, inserção no inico da lista.
            newCon.setProx(this.prim);
            this.prim = newCon;
            this.qtd++;
        } else if (newCon.getInfo().compareTo(this.ult.getInfo()) > 0) {
            // valor maior que o ult.getInfo, inserção no final da lista.
            this.ult.setProx(newCon);
            this.ult = newCon;
            this.qtd++;
        } else { // inserir valor no meio da lista, entrem o prim e o ult.
            LSENode<T> atu = this.prim.getProx();
            LSENode<T> ant = this.prim;
            while (atu.getProx() != null) {
                if (newCon.getInfo().compareTo(atu.getInfo()) < 0) {
                    newCon.setProx(atu);
                    ant.setProx(newCon);
                    this.qtd++;
                } else {
                    ant = atu;
                    atu = atu.getProx();
                }
            }
        }
        System.out.println("=======================================");
        System.out.println("Contato Inserido!");
        System.out.println("=======================================");
    }

    public void exibirContatos() {
        if (qtd == 0) {
            System.out.println("==============================================");
            System.err.println("Agenda vazia!");
            System.out.println("==============================================");
        } else {
            LSENode<T> aux = this.prim;
            for (int i = 0; i < qtd; i++) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
                if (this.qtd > 1) {
                    System.out.println("==================================================");
                }
            }
        }
        if (this.qtd == 1) {
            System.out.println("==============================================");
        }
    }

    private LSENode<T> buscarNo(T c) { // metodo de busca principal.
        LSENode<T> aux = prim;
        T auxContato = aux.getInfo();
        for (int i = 0; i < qtd; i++) {
            if (c.compareTo(auxContato) == 0) {
                return aux; // achou o valor.
            }
            aux = aux.getProx();
        }
        return null; // valor não encontrado.
    }

    public T buscarContato(T c) {
        LSENode<T> retorno;
        if (qtd == 0) {
            return null;
        } else {
            retorno = buscarNo(c);
            if (retorno == null) {
                return null;
            } else {
                return retorno.getInfo();
            }
        }
    }

    public void removerContato(T con) {
        if (this.qtd == 0) {
            System.out.println("=============================================");
            System.err.println("Agenda vazia!!");
            System.out.println("=============================================");
        } else {
        int meQuePrim = con.compareTo(this.prim.getInfo());
        int maQueUlt = con.compareTo(this.ult.getInfo());
            if (meQuePrim < 0 || maQueUlt > 0) {
                System.out.println("=============================================");
                System.err.println("Contato não encontrado!!");
                System.out.println("=============================================");
                return;
            }
            if (this.qtd == 1) {
                this.prim = null;
                this.ult = null;
                this.qtd--;
                System.out.println("=============================================");
                System.out.println("Contato removido, sua Agenda está vazia!");
                System.out.println("=============================================");
            } else if (con.compareTo(prim.getInfo()) == 0) {
                this.prim = this.prim.getProx();
                this.qtd--;
                System.out.println("=======================================");
                System.out.println("Primeiro Contato Removido!");
                System.out.println("=======================================");
            } else if (con.compareTo(ult.getInfo()) == 0) {
                LSENode<T> aux = this.prim;
                while (aux != this.ult) {
                    aux = aux.getProx();
                }
                this.ult = aux;
                this.qtd--;
                System.out.println("=======================================");
                System.out.println("Ultimo Contato Removido!");
                System.out.println("=======================================");
            } else {
                LSENode<T> atu = this.prim.getProx();
                LSENode<T> ant = this.prim;
                while (atu.getProx() != null) {
                    if (con == atu) {
                        break;
                    }
                    ant = atu;
                    atu = atu.getProx();
                }
                ant.setProx(atu.getProx());
                this.qtd--;
                System.out.println("=======================================");
                System.out.println("Contato Removido!");
                System.out.println("=======================================");
            }

        }
    }
}
