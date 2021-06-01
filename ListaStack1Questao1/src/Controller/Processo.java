package Controller;

import Pilha.Stack; // minha classe
//import java.util.Stack; // classe nativa do java

public class Processo {

    Stack<Character> pilha = new Stack();

    public boolean verificarString(String phrase) {
        char carac;
        for (int i = 0; i < phrase.length(); i++) {
            carac = phrase.charAt(i);
            if (Character.isLetter(carac) == false ) {
                if (carac != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void empilharString(String phrase) {
        char carac;
        for (int i = 0; i < phrase.length(); i++) {
            carac = phrase.charAt(i);
            if (carac != ' ') {
                pilha.push(carac);
            }
        }
    }

    private String gerarString() {
        char carac;
        boolean loop = true;
        carac = pilha.pop();
        String frase =  Character.toString(carac);
        do {
            if (pilha.isEmpty()) {
                loop = false;
            } else {
                carac = pilha.pop();
                frase += carac;
            }
        } while (loop);
        return frase;
    }

    public boolean compararString(String phrase) {
        String f2;
        char c;
        c = phrase.charAt(0);
        String f1 = Character.toString(c);
        for (int i = 1; i < phrase.length(); i++) {
            c = phrase.charAt(i);
            if (c != ' ') {
                f1 += c;
            }
        }
        f2 = this.gerarString();
        return f1.compareTo(f2) == 0;
    }
    
}
