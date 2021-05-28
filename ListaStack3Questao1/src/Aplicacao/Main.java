package Aplicacao;

import java.util.Scanner;
//import Pilha.Stack;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack pilha = new Stack();
        int num, resto;
        boolean loop = true;

        System.out.print("Informe um numero: ");
        num = in.nextInt();
        do {
            if (num / 2 >= 0) {
                resto = num % 2;
                pilha.push(resto);
                if (num == 1) {
                    loop = false;
                }
                num = num / 2;
            }

        } while (loop);

        exibirBinario(pilha);

    }

    private static void exibirBinario(Stack p) {
        boolean loop = true;
        int val;
        System.out.println("O numero informado em binario e: ");
        do {
            if (p.isEmpty()) {
                loop = false;
                System.out.println();
            } else {
                val = (int) p.pop();
                System.out.print(val + " ");
            }
        } while (loop);
    }

}
