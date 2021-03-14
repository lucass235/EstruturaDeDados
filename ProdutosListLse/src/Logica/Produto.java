package Logica;

public class Produto implements Comparable <Produto>{

    private String codigo;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(String c, String d, double p, int e) {
        this.codigo = c;
        this.descricao = d;
        this.estoque = e;
        this.preco = p;
    }
    
    private void setCodigo (String c) {
        this.codigo = c;
    }
    
    private String getCodigo () {
        return this.codigo;
    }
    
    private void setDescricao (String d) {
        this.descricao = d;
    }
    
    private String getDescricao () {
        return this.descricao;
    }
    
    private void setPreco (double p) {
        this.preco = p;
    }
    
    private double getPreco () {
        return this.preco;
    }
    
    private void setEstoque (int e) {
        this.estoque = e;
    }
    
    private int getEstoque () {
        return this.estoque;
    }
    
    public void alterarPreco (double p){
        if (p <= 0) {
            System.out.println("Informe um preço maior que 0");
        } else {
            this.preco = p;
            System.out.println("Preço atualizado!");
        }
    }
    
    public void alterarEstoque (int e){
        if (e < 0) {
            System.out.println("Informe uma quantidade maior ou igual a 0");
        } else {
            this.estoque = e;
            System.out.println("Estoque atualizado!");
        }
    }
    
    @Override
    public String toString(){
        String c = this.codigo;
        String d = this.descricao;
        int e = this.estoque;
        double p = this.preco;
        String dados ="Produto de codigo: "+c+"\nDescrição: "+d+"\n"
                + "Estoque: "+e+"\nPreço: "+p+"\n===============================";
        return dados;
    }
    
    @Override
    public int compareTo(Produto p) {
        return this.codigo.compareTo(p.codigo);
    }
}
