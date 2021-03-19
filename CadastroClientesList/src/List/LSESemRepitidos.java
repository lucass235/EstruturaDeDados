package List;

public class LSESemRepitidos<T extends Comparable<T>> {

    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;

    public void inserirCliente(T cli) {
        LSENode<T> newPro = new LSENode(cli);
        if (qtd == 0) {
            this.prim = newPro;
            this.ult = newPro;
            this.qtd++;
            System.out.println("=======================================");
            System.out.println("Cliente cadastrado!");
            System.out.println("=======================================");
        } else {
            this.ult.setProx(newPro);
            this.ult = newPro;
            qtd++;
            System.out.println("=======================================");
            System.out.println("Cliente Cadastrado!");
            System.out.println("=======================================");
        }
    }

    public void exibirClientes() {
        if (qtd == 0) {
            System.out.println("==============================================");
            System.err.println("Lista vazia!");
            System.out.println("==============================================");
        } else {
            LSENode<T> aux = this.prim;
            System.out.println("Segue a lista dos Clientes Registrados: ");
            System.out.println("==============================================");
            for (int i = 0; i < qtd; i++) {
                System.out.println(aux.getInfo().toString());
                aux = aux.getProx();
            }
        }
    }

    private LSENode<T> buscarNo(T p) {
        LSENode<T> aux = this.prim;
        T auxCliente = aux.getInfo();
        for (int i = 0; i < qtd; i++) {
            auxCliente = aux.getInfo();
            if (auxCliente.compareTo(p) == 0) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public T buscarCliente(T c) {
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

    public void removerCliente(T cli) {
        LSENode<T> achou = buscarNo(cli);

        if (achou == null) {
            System.out.println("=======================================");
            System.err.println("Cliente não cadastrao!");
            System.out.println("=======================================");
        } else {
            if (this.qtd == 0) {
                System.out.println("=======================================");
                System.out.println("Lista vazia");
                System.out.println("=======================================");
            } else if (this.qtd == 1) {
                this.prim = null;
                this.ult = null;
                this.qtd--;
                System.out.println("=======================================");
                System.out.println("Cliente Removido!");
                System.out.println("=======================================");
            } else if (achou.getInfo().compareTo(prim.getInfo()) == 0) {
                this.prim = this.prim.getProx();
                this.qtd--;
                System.out.println("=======================================");
                System.out.println("Cliente Removido!");
                System.out.println("=======================================");
            } else if (achou.getInfo().compareTo(ult.getInfo()) == 0) {
                LSENode<T> aux = this.prim;
                while (aux != this.ult) {
                    aux = aux.getProx();
                }
                this.ult = aux;
                this.qtd--;
                System.out.println("=======================================");
                System.out.println("Cliente Removido!");
                System.out.println("=======================================");
            } else {
                LSENode<T> aux = this.prim;
                LSENode<T> aux2 = this.prim.getProx();
                for (int i = 1; i < this.qtd - 1; i++) {
                    if (achou == aux2) {
                        break;
                    }
                    aux = aux.getProx();
                    aux2 = aux2.getProx();
                }
                aux.setProx(aux2.getProx());
                this.qtd--;
                System.out.println("=======================================");
                System.out.println("Cliente Removido!");
                System.out.println("=======================================");
            }
        }
    }
}
