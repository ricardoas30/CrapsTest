package br.edu.utfpr.jogocraps;

import java.util.Random;

/**
 *
 * @author Ricardo A. Silveira
 * Disciplina: Teste de Software
 * Mock Objects (Parte 1)
 */
public class Dado {
    private Random rand = new Random();
    
    public int rolar(){
        return rand.nextInt(6) + 1;
    }
}
