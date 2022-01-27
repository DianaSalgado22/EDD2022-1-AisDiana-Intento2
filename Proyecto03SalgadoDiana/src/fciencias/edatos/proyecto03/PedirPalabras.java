package fciencias.edatos.proyecto03;
import java.io.Serializable;
import java.util.Scanner;
/**
 * Ejemplo de programa con threads.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Eneror 2022.
 * @since Estructuras de datos 2022-1.
 */
public class PedirPalabras extends Thread implements Serializable{
    // COLORES:
    String blue = "\033[34m";
    String green = "\033[32m";
    String yellow = "\033[33m";
    String red = "\033[31m";
    String purple = "\033[35m";
    String cyan = "\033[36m";
    String white = "\u001B[0m";

    //
    public Scanner sc = new Scanner(System.in);
    public Cronometro cr=new Cronometro();
    public String secuencia="";
    public DoubleLinkedList<String> listaTodas=new DoubleLinkedList();
    public SecuenciaLetras sl=new SecuenciaLetras();

	    @Override
		public void run(){
            cr.start();
            delay4Segundos();
            System.out.print("\n");
            while(cr.cronometroActivo){
                System.out.print(purple+"🅂 🄴 🄲 🅄 🄴 🄽 🄲 🄸 🄰  : " +white);
                sl.toString(this.secuencia);
                String palabra=sc.nextLine();
                //Se agrega a la lista 
                listaTodas.add(0,palabra);
            }
            System.out.println("\n"+blue+ "𝗣 𝗮 𝗿 𝘁 𝗶 𝗱 𝗮    𝘁 𝗲 𝗿 𝗺  𝗶 𝗻 𝗮 𝗱 𝗮"+ white+"\n");
        }

        public void delay4Segundos(){
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                
            }
        }
}
