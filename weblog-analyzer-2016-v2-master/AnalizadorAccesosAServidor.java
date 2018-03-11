import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalizadorAccesosAServidor
{   
    private ArrayList<Acceso> accesos;

    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }

    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();
                Acceso accesoActual = new Acceso(lineaLeida);
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }

    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;

        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];

            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }

            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }

            valorADevolver = horaDeAccesosMasAlto;                      
        }

        return valorADevolver;
    }

    public String paginaWebMasSolicitada() 
    {
        String paginaWebMasAccesos = null;
        HashMap<String, Integer> urlsYAccesos = new HashMap<>();
        int numeroAccesosUrl = 0;
        if(accesos.size() > 0){
            for(Acceso urlActual : accesos){
                String urlAcceso = urlActual.getUrl();
                
                                if (urlsYAccesos.get(urlAcceso) == null){
                    urlsYAccesos.put(urlAcceso, 1);
                } else {
                    urlsYAccesos.replace(urlAcceso, urlsYAccesos.get(urlAcceso) + 1);                    
                }

                if(urlsYAccesos.get(urlAcceso) > numeroAccesosUrl){
                    paginaWebMasAccesos = urlAcceso;
                    numeroAccesosUrl = urlsYAccesos.get(urlAcceso);
                }
            }
            
        } else {
            System.out.println("Error Inesperado");
        }
        return paginaWebMasAccesos;
    }

    public String clienteConMasAccesosExitosos()
    {
        return "";
    }
}
