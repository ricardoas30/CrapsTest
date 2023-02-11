package br.edu.utfpr.jogocraps;

import java.util.Scanner;

/**
 *
 * @author Ricardo A. Silveira
 * Disciplina: Teste de Software
 * Mock Objects (Parte 1)
 */
public class JogoCraps {

    public static void main(String[] args){
        Craps craps = new Craps();
        Scanner scan = new Scanner(System.in);
        
        while(!craps.isFimDeJogo()){
         System.out.println("Digite enter para continuar.");
         scan.nextLine(); int soma = craps.rolarDados();
         System.out.println("Soma: " + soma);
        }
        scan.close();
        
        if(craps.getVencedor() == 1)
            System.out.println("Você ganhou!");
        else if(craps.getVencedor() == 2)
            System.out.println("A banca ganhou!");
        else
            throw new IllegalStateException();
    }
}
