
package Controler;

public class Produto implements Comparable <Produto>{
    private  String codigo;
    private  String descricao;
    private String fornecedor;
    private double preco;
    private int qtdEstoque;
    
    public Produto (String codigo) {
        this.codigo = codigo;
    }
    
    public Produto (String cod, String des, String forn, double pre, int qtd) {
        this.codigo = cod;
        this.descricao = des;
        this.fornecedor = forn;
        this.preco = pre;
        this.qtdEstoque = qtd;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String getFornecedor() {
        return fornecedor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
    @Override
    public String toString() {
        String c, d, f, p, q;
        c = "Código: " + this.getCodigo() + "\n";
        d = "Descrição: " + this.getDescricao() + "\n";
        f = "Fornecedor: " + this.getFornecedor() + "\n";
        p = "Preço: " + this.getPreco() + "\n";
        q = "Quantidade de estoque: " + this.getQtdEstoque() + "\n";
        return c + d + f + p + q;
    }

    @Override
    public int compareTo(Produto pro) {
        return this.codigo.compareTo(pro.getCodigo());
    }
}
