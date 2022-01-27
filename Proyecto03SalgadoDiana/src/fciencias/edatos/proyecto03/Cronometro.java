package fciencias.edatos.proyecto03;
 
public class Cronometro extends Thread{ 
    
    static String green = "\033[32m";
    static String white = "\u001B[0m";
    static String purple = "\033[35m";
    static String blue = "\033[34m";
    static String yellow= "\033[33m";
	static String red =  "\u001B[31m";

    Thread hilo;
    public boolean cronometroActivo;

    public void run(){
        Integer milesimas=0,segundos = 0;
        
        try
        {
            System.out.println(yellow+"\t Preparado"+white);
            delaySegundo();
            System.out.println(yellow+"\t Listo"+white);
            delaySegundo();
            System.out.println(green+"\t ¡¡¡YAAAAA!!!"+white);
            //Mientras cronometroActivo sea verdadero entonces seguira
            //aumentando el tiempo
            
            while( cronometroActivo ){
                Thread.sleep( 4 );
                //Incrementamos 4 milesimas de segundo
                milesimas += 4;
                 
                //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                //y las milesimas de segundo de nuevo a 0
                if( milesimas == 1000){
                    milesimas = 0;
                    segundos += 1;
                    //Si los segundos llegan a 60 entonces se acabo el tiempo
                    if( segundos == 60 )
                    {
                       cronometroActivo=false;  
                    }
                }               
            }
            System.out.println("\n"+red+"\t ¡¡ 𝘛 𝘐 𝘌 𝘔 𝘗 𝘖 !!"+white+"\n"); 
            System.out.println("\n"+green+"Da un ultimo click en enter para continuar"+white+"\n"); 
        }catch(Exception e){}
    }
    
  
    //Iniciar el cronometro poniendo cronometroActivo 
    //en verdadero para que entre en el while
    public void start() {
        cronometroActivo = true;
        hilo = new Thread( this );
        hilo.start();
    }

    public void delaySegundo(){
        try {
            hilo.sleep(1000);
        } catch (Exception e) {
            
        }
    }

  
    public static void main(String[] args) {
        Cronometro c=new Cronometro();
        c.start();
    }
  
    

}