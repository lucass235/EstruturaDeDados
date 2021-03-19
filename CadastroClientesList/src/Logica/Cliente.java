package Logica;

public class Cliente implements Comparable<Cliente> {

    private String cpf;
    private String nome;
    private String fone;
    private String email;

    public Cliente(String c, String n, String f, String e) {
        this.cpf = c;
        this.nome = n;
        this.fone = f;
        this.email = e;
    }

    void setCpf(String newCpf) {
        this.cpf = newCpf;
    }

    void setNome(String newNome) {
        this.cpf = newNome;
    }

    void setFone(String newFone) {
        this.cpf = newFone;
    }

    void setEmail(String newEmail) {
        this.cpf = newEmail;
    }

    String getCpf() {
        return this.cpf;
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
        String f = "Telefone: " + this.getFone() + "\n";
        String n = "Nome: " + this.getNome() + "\n";
        String dados = n + e + f;
        return dados;
    }

    @Override
    public int compareTo(Cliente cli) {

        return this.cpf.compareTo(cli.cpf);
    }
}
