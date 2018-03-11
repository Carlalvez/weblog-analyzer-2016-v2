public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    
   public Acceso(String fecha)
    {
        String[] arrayLogs = fecha.split(" ");

       ano = Integer.parseInt(arrayLogs[0]);
       mes = Integer.parseInt(arrayLogs[1]);
       dia = Integer.parseInt(arrayLogs[2]);
       hora = Integer.parseInt(arrayLogs[3]);
       minutos = Integer.parseInt(arrayLogs[4]);
    }
   /**
    * Devuelve año
    * @return año
    */ 
   public int getAno() 
    {
        return ano;
    }
    
    /**
    * Devuelve mes
    * @return mes
    */ 
   public int getMes()
    {
        return mes;
    }
    
   /**
    * Devuelve dia
    * @return dia
    */ 
   public int getDia()
    {
        return dia;
    }
   
   /**
    * Devuelve hora
    * @return hora
    */  
   public int getHora()
    {
        return hora;
    }
   
   /**
    * Devuelve Minutos
    * @return Minutos
    */ 
   public int getMinutos()
    {
        return minutos;
    }
}