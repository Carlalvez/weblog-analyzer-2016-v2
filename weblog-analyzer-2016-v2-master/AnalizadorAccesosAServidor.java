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
        HashMap<String, Integer> urlAccesos = new HashMap<>();
        int AccesosUrl = 0;
        if(accesos.size() > 0){
            for(Acceso urlActual : accesos){
                String urlAcceso = urlActual.getUrl();
                
                                if (urlAccesos.get(urlAcceso) == null){
                    urlAccesos.put(urlAcceso, 1);
                } else {
                    urlAccesos.replace(urlAcceso, urlAccesos.get(urlAcceso) + 1);                    
                }

                if(urlAccesos.get(urlAcceso) > AccesosUrl){
                    paginaWebMasAccesos = urlAcceso;
                    AccesosUrl = urlAccesos.get(urlAcceso);
                }
            }
            
        } else {
            System.out.println("Error Inesperado");
        }
        return paginaWebMasAccesos;
    }

    public String clienteConMasAccesosExitosos()
    {
        String ipMasAccesosExitosos = null;
        ArrayList<Acceso> ipsBuenas = new ArrayList<>();
        HashMap<String, Integer> AccesosIp = new HashMap<>();
        int RepetidaIp = 0;
        int ipMayor = 0;
       for(Acceso acceso : accesos){
            if(acceso.getCode() < 400){
               ipsBuenas.add(acceso);
            }
        }
       if(ipsBuenas.size() > 0){
            for(Acceso ipActual : ipsBuenas){
                String ipAcceso = ipActual.getIp();
                if(AccesosIp.get(ipAcceso) == null){
                    AccesosIp.put(ipAcceso, 1);
               }
                else{
                    AccesosIp.replace(ipAcceso, AccesosIp.get(ipAcceso) + 1);
                }
                int Octeto = Integer.parseInt(ipAcceso.split(".")[3]);
                int Conexiones = AccesosIp.get(ipAcceso);
                if(Conexiones > RepetidaIp || (Conexiones == RepetidaIp && Octeto > ipMayor)){
                    RepetidaIp = Conexiones;
                    ipMayor = Octeto;
                   ipMasAccesosExitosos = ipAcceso;
                }
            }
            
        } else {
            System.out.println("Ocurrio algun error al leer el archivo, no hay datos que procesar.");
        }
       return ipMasAccesosExitosos;
    }
}