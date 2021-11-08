package fciencias.edatos.proyecto01;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
/**
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 * Clase que simula la partida del juego Solterona
 */
public class Partida{

    // Cantidad de jugadores 
    int cantPlayers;
    // Cola con los jugadores
    //TDAQueue<Player> colaPlayers= new Queue<>(); 
    TDAList<Player> listaPlayers= new DoubleLinkedList<>();
    // Solterona elegida
    Carta solterona;
    //ganador de la partida
    Player winner;
    //Mazo con el que se va a jugar
    Mazo mazoDelJuego;
    //Player real
    Player usuario;

   // int numeroDeJugadores;


    /** Método para construir una partida
     * 
     */

    public Partida(Mazo mazoDelJuego,int cantPlayers,Player usuario){
       // this.mazoDelJuego.cartasMazo = mazoDelJuego.mazoCompleto();
       // this.mazoDelJuego.tipoDeMazo=mazoDelJuego.tipoDeMazo;
       this.mazoDelJuego=mazoDelJuego;
        this.cantPlayers= cantPlayers;
        this.usuario= usuario;

    }
    // este aún no sé muy bien si se ocupa

     /** Metodo para crear a los jugadores de la partida
      *  @param cantPlayers la cantidad de jugadores que tendra la partida
      *  @return arrPlayers un arreglo con los jugadores. 
      */
    
    /** Metodo para preparar todo antes de una partida
     *  @param colaPlayers la lista con los jugadores de la partida.
     */
    // public void preGame(TDAQueue<Players> colaPlayers){
    //     // Se crea el mazo y se barajea
    //     Mazo mazo=new Mazo(); 
    //     mazo=mazo.mazoCompleto().mazoCompletoBarajeado(); 
    //     // Elegimos a la Solterona 
    //     this.solterona=mazo.eliminarUnaCarta();    
    //     // Repartimos el resto
    //     while(!mazo.cartasMazo.isEmpty()){ //Mientras que el mazo no este vacio
    //         // Obtenemos el mazo del jugador en la primera posicion de la cola    
    //         Mazo mazoAux=colaPlayers.first().getMazoPlayer(); 
    //         /* Cambiamos el mazo del jugador:
    //          * le agregamos al mazo del jugador la primera carta del mazo total
    //          * y la eliminamos del mazo total.*/
    //         mazoAux.setMazoPlayer(mazoAux.add(mazo.eliminarUnaCarta()));
    //         // Agrega al jugador actual al final de la cola y lo elimina del principio.
    //         colaPlayers.enqueue(colaPlayers.dequeue());    
    //     } 
    //     // Al terminar el while el mazo ya esta repartido entre los jugadores.
    // }

     public void imprimrLista(){
            for(int i = 0;i< listaPlayers.size();i++){
         System.out.println(listaPlayers);
            }
     }
     /**
      * metodo que barajea el mazo, retira una carta y escoge a la solterona y ademas reparte las cartas a los jugadores
      */
     public void preGame(){
       // mazoDelJuego=mazoDelJuego.mazoCompletoBarajeado();
       mazoDelJuego.cartasMazo = mazoDelJuego.mazoCompletoBarajeado();
       System.out.println(mazoDelJuego.cartasMazo);
       this.solterona = mazoDelJuego.eliminarUnaCarta();
       generaJugadores();
      listaPlayers.add(0,usuario);
       System.out.println(listaPlayers.size());
       System.out.println(listaPlayers);
       
       //imprimrLista();
       //System.out.println(listaPlayers.name);
       int aux=0;
       System.out.println(mazoDelJuego.cartasMazo.size());
         while(!mazoDelJuego.cartasMazo.isEmpty()){
           //listaPlayers.get(aux).cartsOfThePlayer = mazoDelJuego.cartasMazo.remove(0);

            Carta cartaAagregar = mazoDelJuego.cartasMazo.remove(0);
            listaPlayers.get(aux).cartsOfThePlayer.add(0,cartaAagregar); 
            
            aux++;
            if(aux == listaPlayers.size()){
                aux=0;
            }

          //  System.out.println(mazoDelJuego.cartasMazo);
        } 
      }
      /**
       * metodo que crea los demas jugadores no reales,es decir artificiales.
       */
      public void generaJugadores(){
          int jugadoresPorGenerar= cantPlayers-1;
          //String aux="jugador"
          //k es el string que dice el numero de jugador y va arriba hacia abajo por como se agregan
          int k = jugadoresPorGenerar-1;
          String aux="";
          for(int i= 0;i<jugadoresPorGenerar;i++){
                if(i== jugadoresPorGenerar-1){
                    Player player =new Player("Diana   ");
                    listaPlayers.add(0,player);
                    //k++;
                    continue;
                    
                }
                aux="Jugador"+k;
                Player player = new Player(aux);
                listaPlayers.add(0,player);
                k--;


          }
      }

    public static void main(String[] args){
        Mazo m1=new Mazo("inglesa");

        //System.out.println(p1.mazoCompleto()+ "\n");  
        //System.out.println(p1.cartasMazo+ "\n");   
        //System.out.println(p1.mazoCompletoBarajeado()); 
        Player player1 = new Player("Aislinn ");   
        Partida p1 =new Partida(m1,4,player1); 
        System.out.println(p1.mazoDelJuego.cartasMazo+ "\n"); 
        p1.preGame();
      //  System.out.println("\n"+p1.mazoDelJuego.cartasMazo);
        
      System.out.println(p1.listaPlayers.get(0));
        // p1.listaPlayers.get(0).descartaPares();
        // System.out.println(p1.listaPlayers.get(0));
        // Carta cartan = new Carta("Picas",4);
        // p1.listaPlayers.get(0).cartsOfThePlayer.add(0,cartan);
        // System.out.println(p1.listaPlayers.get(0));
        // p1.listaPlayers.get(0).descartarPar();
        // System.out.println(p1.listaPlayers.get(0));
      System.out.println(p1.listaPlayers.get(1));
      System.out.println(p1.listaPlayers.get(2));
      System.out.println(p1.listaPlayers.get(3));
     // System.out.println(p1.listaPlayers.get(4));
      System.out.println(p1.mazoDelJuego.cartasMazo.size());

      System.out.println(p1.listaPlayers.get(0));
        p1.listaPlayers.get(0).descartaPares();
        System.out.println("\ndescartando todas las cartas pares\n"+p1.listaPlayers.get(0));
        //creamos una carta solo para probar supongamos q esta se va a robar
        Carta cartan = new Carta("Picas",4);
        //la añadimos pos se la robo
        p1.listaPlayers.get(0).cartsOfThePlayer.add(0,cartan);
        //la imprimirmos
        System.out.println("\nañadiendo una carta\n"+p1.listaPlayers.get(0));
        //ve si con la carta que añadio hay un par , si lo hay lo elimina
        p1.listaPlayers.get(0).descartarPar();
        //imprimir como queda
        System.out.println("\nEliminandos dos cartas si se encuentra un par\n"+p1.listaPlayers.get(0));
    }
}
