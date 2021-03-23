package ListTeste1;

public class LSESemRepitidos<T extends Comparable<T>> {

    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;
    
    public LSENode<T> getPrim() {
        return this.prim;
    }
    
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
            LSENode<T> achou = buscarNo(cli);
            if (achou != null) {
                System.out.println("Igual!");
            } else {
            this.ult.setProx(newPro);
            this.ult = newPro;
            this.qtd++;
            System.out.println("=======================================");
            System.out.println("Cliente Cadastrado!");
            System.out.println("=======================================");
            }
        }
    }

    private LSENode<T> buscarNo(T c) { // metodo de busca principal.
        LSENode<T> aux = prim;
        T auxCliente = aux.getInfo();
        for (int i = 0; i < qtd; i++) {
            if (auxCliente.compareTo(c) == 0) {
                return aux; // achou o valor.
            }
            aux = aux.getProx();
        }
        return null; // valor não encontrado.
    }
    
    public boolean aListaEIgual(LSESemRepitidos<T> list2) {
        if (this.qtd != list2.qtd) {
            return false;
        } else {
            LSENode<T> aux = this.prim;
            LSENode<T> aux2 = list2.getPrim();
            for (int i = 0; i< qtd; i++) {
                if (aux.getInfo().compareTo(aux2.getInfo()) != 0) {
                    return false;
                }
                aux = aux.getProx();
                aux2 = aux2.getProx();
            }
            return true;
        }
    }
}
