package List;

public class LSEOrdenada<T extends Comparable<T>> {

    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;

    public void inserirValor(T con) {
        LSENode<T> novoValor = new LSENode(con);
        if (qtd == 0) { // lista vazia.
            this.prim = novoValor;
            this.ult = novoValor;
            this.qtd++;
            System.out.println("==================================================");
            System.out.println("Primeiro valor inserido!");
            System.out.println("==================================================");
        } else if (novoValor.getInfo().compareTo(this.prim.getInfo()) < 0) {
            // valor menor que o prim.getInfo, inserção no inico da lista.
            novoValor.setProx(this.prim);
            this.prim = novoValor;
            this.qtd++;
            System.out.println("==================================================");
            System.out.println("Valor inserido no inicio da lista!");
            System.out.println("==================================================");
        } else if (novoValor.getInfo().compareTo(this.ult.getInfo()) >= 0) {
            // valor maior que o ult.getInfo, inserção no final da lista.
            this.ult.setProx(novoValor);
            this.ult = novoValor;
            this.qtd++;
            System.out.println("==================================================");
            System.out.println("valor inserido no final da lista!");
            System.out.println("==================================================");
        } else { // inserir valor no meio da lista, entrem o prim e o ult.
            LSENode<T> atu = this.prim.getProx();
            LSENode<T> ant = this.prim;
            while (atu != null) {
                if (novoValor.getInfo().compareTo(atu.getInfo()) == 0) {
                    while (atu.getProx().getInfo().compareTo(novoValor.getInfo()) == 0) {
                        ant = atu;
                        atu = atu.getProx();
                    }
                    ant.setProx(novoValor);
                    novoValor.setProx(atu);
                    this.qtd++;
                    System.out.println("==================================================");
                    System.out.println("valor inserido no meio!!");
                    System.out.println("==================================================");
                    return;
                } else if (novoValor.getInfo().compareTo(atu.getInfo()) < 0) {
                    ant.setProx(novoValor);
                    novoValor.setProx(atu);
                    this.qtd++;
                    System.out.println("==================================================");
                    System.out.println("valor inserido no meio!!");
                    System.out.println("==================================================");
                    return;
                } else {
                    ant = atu;
                    atu = atu.getProx();
                }
            }
        }
    }

    public void exibirValores() {
        if (qtd == 0) {
            System.out.println("==============================================");
            System.err.println("Lista vazia!");
            System.out.println("==============================================");
        } else {
            LSENode<T> aux = this.prim;
            for (int i = 0; i < qtd; i++) {
                System.out.print(aux.getInfo()+", ");
                aux = aux.getProx();
            }
            System.out.println();
        }
    }

    public void removerValor(T val) {
        if (this.qtd == 0) {
            System.out.println("=============================================");
            System.err.println("Lista vazia!!");
            System.out.println("=============================================");
        } else {
            int meQuePrim = val.compareTo(this.prim.getInfo());
            int maQueUlt = val.compareTo(this.ult.getInfo());
            if (meQuePrim < 0 || maQueUlt > 0) {
                System.out.println("=============================================");
                System.err.println("valor não encontrado!!");
                System.out.println("=============================================");
                return;
            }
            int qtdAnterior = this.qtd;
            int valRemovidos;
            LSENode<T> atu;
            LSENode<T> ant;
            int valComparablePrim = val.compareTo(this.prim.getInfo());
            int valComparableUlt = val.compareTo(this.ult.getInfo());
            if (this.qtd == 1 || (valComparablePrim == 0 && valComparableUlt == 0)) {
                // comparação se os valores de toda lista são iguais.
                // se verdadeiro, a lista se torna vazia.
                this.prim = null;
                this.ult = null;
                this.qtd = 0;
                valRemovidos = qtdAnterior - this.qtd;
                System.out.println("=============================================");
                System.out.println("Valor removido, sua lista está vazia!");
                System.out.println("Foram removidos: '" + valRemovidos + "' Valores.");
                System.out.println("=============================================");
            } else {
                atu = this.prim;
                ant = this.prim;
                while (atu != null) {
                    if (val.compareTo(atu.getInfo()) == 0) {
                        int qtdDeRemocao = 1;
                        while (val.compareTo(atu.getProx().getInfo()) == 0) {
                            // vereficação de valores repetidos e implementação
                            // do qtd de valores a serem removidos.
                            atu = atu.getProx();
                            qtdDeRemocao++;
                             if (atu.getInfo().compareTo(this.ult.getInfo()) == 0) {
                                 // condição da variavel atu ser igual ao ult.
                                 break;
                             }
                        }
                        if (atu.getInfo().compareTo(this.ult.getInfo()) == 0) {
                            ant.setProx(null);
                            // valor de remoção igual ao ult.
                            this.ult = ant;
                            this.qtd = this.qtd - qtdDeRemocao; 
                        } else if(atu.getInfo().compareTo(this.prim.getInfo()) == 0) {
                            // valor de remoção igual ao prim.
                            this.prim = atu.getProx();
                            this.qtd = this.qtd - qtdDeRemocao; 
                        } else{
                            // remoção do valor no meio da lista.
                            ant.setProx(atu.getProx());
                            this.qtd = qtdAnterior - qtdDeRemocao;
                        }
                            valRemovidos = qtdAnterior - this.qtd;
                            System.out.println("=======================================");
                            System.out.println("Valor Removido!");
                            System.out.println("Foram removidos: '" + valRemovidos + "' Valores.");
                            System.out.println("=======================================");
                            return;
                    } else {
                        ant = atu;
                        atu = atu.getProx();
                    }
                }
            }
        }
    }
}
