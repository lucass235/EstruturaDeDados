package List;

public class LDE <T extends Comparable<T>>{

    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;
    
    public void inserirValorInicio (T valor) {
        LDENode<T> newValor = new LDENode(valor);
        if (this.qtd == 0) {
            this.prim = newValor;
            this.ult = newValor;
            this.ult.setAnt(this.prim);
            this.qtd++;
            System.out.println("===============================================");
            System.out.println("Primeiro Valor inserido!");
            System.out.println("===============================================");
        } else {
            newValor.setProx(this.prim);
            newValor.getProx().setAnt(newValor);
            this.prim = newValor;
            this.qtd++;
            System.out.println("===============================================");
            System.out.println("Valor inserido no inicio da lista!");
            System.out.println("===============================================");
        }
    }
    
    public void inserirValorFinal (T valor) {
        LDENode<T> newValor = new LDENode(valor);
        if (this.qtd == 0) {
            this.prim = newValor;
            this.ult = newValor;
            this.ult.setAnt(this.prim);
            this.qtd++;
            System.out.println("===============================================");
            System.out.println("Primeiro Valor inserido!");
            System.out.println("===============================================");
        } else {
            this.ult.setProx(newValor);
            newValor.setAnt(this.ult);
            this.ult = newValor;
            this.qtd++;
            System.out.println("===============================================");
            System.out.println("Valor inserido no final da lista!");
            System.out.println("================================================");
        }
    }
    
    public void removerValorInicio () {
        switch (this.qtd) {
            case 0:
                System.out.println("===============================================");
                System.err.println("lista vazia!");
                System.out.println("===============================================");
                break;
            case 1:
                this.prim = null;
                this.ult  = null;
                this.qtd--;
                System.out.println("===============================================");
                System.out.println("Valor removido, lista vazia!");
                System.out.println("===============================================");
                break;
            default:
                this.prim = this.prim.getProx();
                this.prim.setAnt(null);
                this.qtd--;
                System.out.println("===============================================");
                System.out.println("Primeiro valor da lista removido!");
                System.out.println("===============================================");
                break;
        }
    }
    
    public void removerValorFinal () {
        switch (this.qtd) {
            case 0:
                System.out.println("===============================================");
                System.err.println("lista vazia!");
                System.out.println("===============================================");
                break;
            case 1:
                this.prim = null;
                this.ult  = null;
                this.qtd--;
                System.out.println("===============================================");
                System.out.println("Valor removido, lista vazia!");
                System.out.println("===============================================");
                break;
            default:
                this.ult = this.ult.getAnt();
                this.ult.setProx(null);
                this.qtd--;
                System.out.println("===============================================");
                System.out.println("Ultimo valor da lista removido!");
                System.out.println("===============================================");
                break;
        }
    }
    
    public void exibirLista () {
        if (this.qtd == 0) {
            System.out.println("===============================================");
            System.out.println("Lista vazia!");
            System.out.println("===============================================");
        } else {
            LDENode<T> aux = this.prim;
            while (aux != null) {
                System.out.print(aux.getInfo() +" ");
                aux = aux.getProx();
            }
            System.out.println();
        }
    }
    
}
