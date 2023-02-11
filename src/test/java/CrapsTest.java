import br.edu.utfpr.jogocraps.Craps;
import br.edu.utfpr.jogocraps.Dado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

/**
 *
 * @author Ricardo A. Silveira
 * Disciplina: Teste de Software
 * Mock Objects (Parte 1)
 */
public class CrapsTest {
    
    public CrapsTest() {
    }    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testRolarDados_1(){
        Craps craps = new Craps();
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(2, craps.getVencedor());
    }
    
    @Test
    public void testRolarDados_2(){
        Dado dadoMock = Mockito.mock(Dado.class);
        //notar que são feitas duas rolagens de dado
        Mockito.when(dadoMock.rolar()).thenReturn(5, 2);
        Craps craps = new Craps();
        craps.setDado(dadoMock);
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(1, craps.getVencedor());
    }
    
    @Test
    public void testRolarDados_3(){
        Dado dadoMock = Mockito.mock(Dado.class);
        Craps craps = new Craps();
        craps.setDado(dadoMock);
        Mockito.when(dadoMock.rolar()).thenReturn(3, 5);
        
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());
        Mockito.when(dadoMock.rolar()).thenReturn(6, 5);
        
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());
        Mockito.when(dadoMock.rolar()).thenReturn(5, 2);
        
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(2, craps.getVencedor());
    }
    
    @Test
    public void testRolarDados_4(){
        Dado dadoMock = Mockito.mock(Dado.class);
        Craps craps = new Craps();
        craps.setDado(dadoMock);
        Mockito.when(dadoMock.rolar()).thenReturn(1, 3);
        
        craps.rolarDados();
        assertFalse(craps.isFimDeJogo());
        Mockito.when(dadoMock.rolar()).thenReturn(2, 2);
        
        craps.rolarDados();
        assertTrue(craps.isFimDeJogo());
        assertEquals(1, craps.getVencedor());
    }
}
