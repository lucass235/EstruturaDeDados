package Aplicacao;

import Controller.Processo;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String phrase;
        boolean eIgual = false;
        boolean resul;
        Processo pro = new Processo();
        menu();
        phrase = in.nextLine();
        resul = pro.verificarString(phrase);
        if (resul) {
            pro.empilharString(phrase);
            eIgual = pro.compararString(phrase);
            if (eIgual == true) {
                System.out.printf("%S%n", "a frase e palidroma");
            } else {
                System.err.printf("%S%n", "a frase nao e palidroma");
            }
        } else {
            System.err.printf("%S%n", "frase invalida!");
        }

    }

    public static void menu() {
        System.out.printf("%S", "digite uma frase: ");
    }
}
