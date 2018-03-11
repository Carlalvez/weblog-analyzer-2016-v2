

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestRama0543bCommit01.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestRama0543bCommit02
{
    /**
     * Default constructor for test class TestRama0543bCommit01
     */
    public TestRama0543bCommit02()
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
    public void testPaginaWebMasSolicitada()
    {
        AnalizadorAccesosAServidor analizad1 = new AnalizadorAccesosAServidor();
        assertEquals(null, analizad1.clienteConMasAccesosExitosos());
        analizad1.analizarArchivoDeLog("access01.log");
        assertEquals("192.168.1.5", analizad1.clienteConMasAccesosExitosos());
        analizad1.analizarArchivoDeLog("access02.log");
        assertEquals("192.168.1.28", analizad1.clienteConMasAccesosExitosos());
        analizad1.analizarArchivoDeLog("access03.log");
        assertEquals("192.168.1.26", analizad1.clienteConMasAccesosExitosos());
        analizad1.analizarArchivoDeLog("access04.log");
        assertEquals("192.168.1.30", analizad1.clienteConMasAccesosExitosos());        
    }
}

