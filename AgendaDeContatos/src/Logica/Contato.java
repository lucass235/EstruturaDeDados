package Logica;

public class Contato implements Comparable<Contato> {

    private String nome;
    private String fone;
    private String email;

    public Contato(String n, String f, String e) {
        this.nome = n;
        this.fone = f;
        this.email = e;
    }

    void setNome(String newNome) {
        this.nome = newNome;
    }

    void setFone(String newFone) {
        this.fone = newFone;
    }

    void setEmail(String newEmail) {
        this.email = newEmail;
    }


    String getNome() {
        return this.nome;
    }

    String getFone() {
        return this.fone;
    }

    String getEmail() {
        return this.email;
    }

    @Override
    public String toString (){
        String e = "Email: " + this.getEmail() + "\n";
        String f = "Telefone: " + this.getFone();
        String n = "Nome: " + this.getNome()+ "\n";
        String dados = n + e + f;
        return dados;
    }

    @Override
    public int compareTo(Contato cli) {
        return this.nome.compareTo(cli.nome);
    }
}
