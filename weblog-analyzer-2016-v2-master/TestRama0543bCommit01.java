

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
public class TestRama0543bCommit01
{
    /**
     * Default constructor for test class TestRama0543bCommit01
     */
    public TestRama0543bCommit01()
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
        assertEquals(null, analizad1.paginaWebMasSolicitada());
        analizad1.analizarArchivoDeLog("access01.log");
        assertEquals("noticias/general.html", analizad1.paginaWebMasSolicitada());
        analizad1.analizarArchivoDeLog("access02.log");
        assertEquals("estudios/bachillerato.html", analizad1.paginaWebMasSolicitada());
        analizad1.analizarArchivoDeLog("access03.log");
        assertEquals("noticias/ciclosformativos.html", analizad1.paginaWebMasSolicitada());
        analizad1.analizarArchivoDeLog("access04.log");
        assertEquals("index.html", analizad1.paginaWebMasSolicitada());        
    }
}

