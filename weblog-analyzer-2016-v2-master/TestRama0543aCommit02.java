

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestRama0543bCommit02.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestRama0543aCommit02
{
    /**
     * Default constructor for test class TestRama0543bCommit02
     */
    public TestRama0543aCommit02()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testObtenerHoraMasAccesos()
    {
        AnalizadorAccesosAServidor analizad1 = new AnalizadorAccesosAServidor();
        assertEquals(-1, analizad1.obtenerHoraMasAccesos());        
        analizad1.analizarArchivoDeLog("access01.log");
        assertEquals(20, analizad1.obtenerHoraMasAccesos());
        analizad1.analizarArchivoDeLog("access02.log");
        assertEquals(19, analizad1.obtenerHoraMasAccesos());
        analizad1.analizarArchivoDeLog("access03.log");
        assertEquals(22, analizad1.obtenerHoraMasAccesos());
        analizad1.analizarArchivoDeLog("access04.log");
        assertEquals(19, analizad1.obtenerHoraMasAccesos());        
    }
}

