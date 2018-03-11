public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private String ip;
    private String url;
    private int code;
    
   public Acceso(String fecha)
    {
       String[] arrayLogs = fecha.split(" ");

       ip = arrayLogs[0];
       ano = Integer.parseInt(arrayLogs[1].substring(1, arrayLogs[1].length()));
       mes = Integer.parseInt(arrayLogs[2]);
       dia = Integer.parseInt(arrayLogs[3]);
       hora = Integer.parseInt(arrayLogs[4]);
       minutos = Integer.parseInt(arrayLogs[5].substring(0, arrayLogs[5].length() -1));
       url = arrayLogs[6];
       code = Integer.parseInt(arrayLogs[7]);
    }
    
   /**
    * Devuelve año
    * @return año int
    */ 
   public int getAno() 
    {
        return ano;
    }
    
    /**
    * Devuelve mes
    * @return mes int
    */ 
   public int getMes()
    {
        return mes;
    }
    
   /**
    * Devuelve dia
    * @return dia int
    */ 
   public int getDia()
    {
        return dia;
    }
   
   /**
    * Devuelve hora
    * @return hora int
    */  
   public int getHora()
    {
        return hora;
    }
   
   /**
    * Devuelve Minutos
    * @return Minutos int
    */ 
   public int getMinutos()
    {
        return minutos;
    }
    
    /**
     * Devuelve la ip
     * @return la ip cadena
     */
    public String getIp()
   {
        return ip;
   }

    /**
     * Devuelve la url
     * @return la url cadena
     */
    public String getUrl()
   {
        return url;
    }

    /**
     * Devuelve el codigo
     * @return el codigo int
     */
   public int getCode()
    {
        return code;
    }
}