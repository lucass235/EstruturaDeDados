
package Exception;

public class RemoverException extends Exception{
    
    public RemoverException () {
        super("Lista vazia");
        
        
    }
    public void valorNaoEn () {
            System.out.println("Valor nao encontrado!");
        }
}
