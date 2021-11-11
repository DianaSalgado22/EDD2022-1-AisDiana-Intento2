package fciencias.edatos.proyecto01;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 * Clase que simula la partida del juego Solterona
 */
public class Partida{

    // COLORES                                                               
    String green = "\033[32m";
    String white = "\u001B[0m";
    String purple = "\033[35m";
    String blue = "\033[34m";
    String yellow= "\033[33m";
    String red =  "\u001B[31m";  
    String black = "\033[30m";

    // Cantidad de jugadores 
    int cantPlayers;
    // Lista con los jugadores
    TDAList<Player> listaPlayers= new DoubleLinkedList<>();
		//Lista con los turnos
		TDAList<Player> turnos=new DoubleLinkedList<>();
    // Solterona elegida
    Carta solterona;
    //ganador de la partida
    Player winner;
    //Mazo con el que se va a jugar
    Mazo mazoDelJuego;
    //Player real
    Player usuario;

    /** Método para construir una partida
     *  @param mazoDelJuego mazo con el que se jugara
     *  @param cantPlayers la cantidad de jugadores que habra en la partida
     *  @param usuario el usuario del programa, pero ya como un player.
     */
    public Partida(Mazo mazoDelJuego,int cantPlayers,Player usuario){
	      this.mazoDelJuego=mazoDelJuego;
        this.cantPlayers= cantPlayers;
        this.usuario= usuario;
    }

    /** Metodo que barajea el mazo, retira una carta 
     *  y escoge a la solterona, reparte las cartas a los jugadores
		 *  y además elimina todos los primeros pares.
     */
    public void preGame(){
	  // El mazo del juego ahora esta barajeado, al hacer la igualdad
	  mazoDelJuego.cartasMazo = mazoDelJuego.mazoCompletoBarajeado();
    //mazoDelJuego.cartasBarajeado=mazoDelJuego.mazoCompletoBarajeado();

	  // Se guarda a la solterona y se elimina una carta del mazo
	  this.solterona = mazoDelJuego.eliminarUnaCarta();

	  // Se genera a los jugadores artificiales.
	  generaJugadores();

	  // Al ultimo nos agregamos a nosotras las usuarias
	  listaPlayers.add(0,usuario);
		turnos.add(0,usuario);
      
	  // Para acceder al lugar del player 
	  int aux=0;
       
	  //mientra el mazo del juego no este vacio se repartiran las cartas
	  while(!mazoDelJuego.cartasMazo.isEmpty()){

	    //la carta a agregar en el mazo de algun jugador sera la que se elimine del mazo de la partida
      Carta cartaAagregar = mazoDelJuego.cartasMazo.remove(0);

      // Se checa si la carta a agregar puede ser par con alguna de las cartas del jugador
      TDAList<Carta> cartasPlayer= listaPlayers.get(aux).cartsOfThePlayer;
      listaPlayers.get(aux).cartsOfThePlayerInTheBeginning.add(0,cartaAagregar);

      // si el jugador no tiene ninguna carta se agrega sin necesidad de comparar.
      if(cartasPlayer.size()==0){
        cartasPlayer.add(0,cartaAagregar);
      }else{
      for(int c=0;c<cartasPlayer.size();c++){
        int valorPorComparar= cartasPlayer.get(c).valor; // Se obtiene el valor de la carta en la posición c
        // si tienen el valor igual, son par.
        if(cartaAagregar.valor==valorPorComparar){
          break; // se rompe porque ya encontramos un par
        }
        // si no tienen el valor igual, no pueden ser par. Asi que continuamos

        /* si llegamos hasta este if quiere decir que
         * ninguna de las cartas del jugador es par con la nueva por lo tanto se agrega.*/
          if(c==cartasPlayer.size()-1){
          //se agrega la carta,que se elimino del mazo, en la posición 0 de las cartas del jugador 
          cartasPlayer.add(0,cartaAagregar); 
          break;
        }
      }
    }
      //listaPlayer.get(aux).historial =""+ System.out    
      // Se suma para para pasar al siguiente jugador
      aux++;
      //esto es para que se vuelva a regresar a repartir desde el jugador 0
      if(aux == listaPlayers.size())
        aux=0; 
    } 
    
  }

    /** Metodo que crea los demas jugadores no reales,es decir artificiales.
     */
    public void generaJugadores(){

	  // Se le resta uno pq no contamos al jugador real
	  int jugadoresPorGenerar= cantPlayers-1;
          
	  // k es el int que dice el numero de jugador 
	  int k = jugadoresPorGenerar-1; // empieza en -1 porque siempre habra un jugador llamado Diana
	  String aux="";
	  //
	  for(int i= 0;i<jugadoresPorGenerar;i++){
	    //para que siempre haya una jugadora llamada LULA en la segunda posicion 
	    if(i== jugadoresPorGenerar-1){
		    //se crea al jugador y se agrega a la lista
		    Player player =new Player(" LULA🐙  ");
		    listaPlayers.add(0,player);
				turnos.add(0,player);
		    continue;
	    }
	    aux="Jugador"+k; //k es el numero del jugador 
	    //se crea al jugador y se agrega a la lista y a la de turnos
	    Player player = new Player(aux);
	    listaPlayers.add(0,player);
			turnos.add(0,player);
	    k--; 
	}
}
		/** Metodo que voltea todas las cartas de un jugador al reves
 		 *  @param jugador al que se le pondran sus cartas 
		 */
		public void volteaTodasReves(Player jugador){
				// Las cartas del jugador 
				TDAList<Carta> mazoJugador=jugador.cartsOfThePlayer;
				// Recorremos las cartas del jugador
				for(int j=0;j<mazoJugador.size();j++){
						Carta carta =mazoJugador.get(j); // La carta en la posición j
						// Si la carta ya esta al reves continuamos con la siguiente 
						if(carta.isFlip()){
							continue;
						}
						// si no
						carta.voltear(); // volteamos la carta
				}
		}


    public void volteaTodasRev(){
      // Recorremos las cartas del jugador
      for(int j=0;j<mazoDelJuego.cartasMazo.size();j++){
          Carta carta =mazoDelJuego.cartasMazo.get(j); // La carta en la posición j
          // Si la carta ya esta al reves continuamos con la siguiente 
          if(carta.isFlip()){
            continue;
          }
          // si no
          carta.voltear(); // volteamos la carta
      }
  }
 

		/** Metodo que voltea todas las cartas de un jugador al frente
 		 *  @param jugador al que se le pondran sus cartas de frente
		 */
		public void volteaTodasFrente(Player jugador){
			// Las cartas del jugador 
	    TDAList<Carta> mazoJugador=jugador.cartsOfThePlayer;
			// Recorremos las cartas del jugador
			for(int j=0;j<mazoJugador.size();j++){
					Carta carta =mazoJugador.get(j); // La carta en la posición j
					// Si la carta no esta al reves continuamos con la siguiente 
					if(!carta.isFlip()){
						continue;
           
					}
          carta.voltear();
					
			}
	}



		/** Metodo que muestra las cartas disponibles a robar
		 *  @param jugadorActual es decir el jugador que esta de turno 
		 *  que no puede robarse a si mismo.
		 */
		// para enseñarle al usuario cuantas cartas tienen los otros jugadores y poder elegir a quien robar.
		public void muestraRobables(Player jugadorActual){
				for(int j=0;j<turnos.size();j++){
					// si es el jugador que esta en turno, se ignora
					if(jugadorActual==turnos.get(j)){
						continue;
					}
					// Si no pone al reves todas las carta del jugador en la posción j 
					volteaTodasReves(turnos.get(j));
					// Imprime las cartas del jugador en la posición j
					turnos.get(j).toString();
				}
				
		}

		/** Metodo que muestra todos las cartas de todos los jugadores
		 *  que siguen en la partida (Los que estan en Turnos)
		 */
		// este metodo es solo para hacer pruebas, creo que no se ocupara ya al jugar
		public void muestraCartas(){
			for(int j=0;j<turnos.size();j++){
				System.out.println(turnos.get(j).toString());
			}
			
	}

		/** Metodo que muestra las cartas de un jugador numeradas 
		 *  para que el usuario pueda elegir una para robar 
		 *  @param jugador al que se le checaran sus cartas
		 */
		// este metodo se usara para mostrarle al usuario las cartas y pueda elegir por numero
		public void muestraCartasNumeradas(Player jugador){
				int contador=1;
				// las cartas del jugador
				TDAList<Carta> mazoJugador=jugador.cartsOfThePlayer;
				// 
				for(;contador<mazoJugador.size()+1;contador++){
					System.out.print(blue+"["+contador+"] ");
					System.out.print(mazoJugador.get(contador-1)+"   "+white);
					
				}
				System.out.println();
		}
		/** Metodo para robar una carta
		 *  @param p1 jugador que recibe la carta
		 *  @param p2 jugador al que le quitan la carta
		 *  @param num numero de la carta que se quiere robar 
		 */
		public void robar(Player p1,Player p2, int num){
				// Posición de la carta que se regresara
				int pos=num-1 ;// se le resta 1 pq al usuario se le muestra numerado del 1-n 
				// Primero removemos a la carta robada
				Carta cartaRobada= p2.cartsOfThePlayer.remove(pos);
				// volteamos al frente l carta robada
				//cartaRobada.voltear();
				// Agregamos la carta robada en la poscición 0 de la lista de cartas del p1.
				p1.cartsOfThePlayer.add(0,cartaRobada);
		}

    /** Metodo para cambiar la posicion de las cartas
     * de un jugador.
     * @param x la posición donde esta la carta que se cambiara.
     * @param y la posicion donde esta la otra carta que se cambiara
     * @param p1 el jugador al que se le cambiara sus cartas de posicion.
    */
     public void reacomodarCartas(int x, int y,Player p1){
        p1.cartsOfThePlayer.swap(x,y);
    } 

    /** Metodo para simular el turno de un jugador
     *  @param playerAct jugador en el turno actual.
     *  @param num el turno que tiene el jugador actual (la posicion en la cola turnos)
     */
    public void turno(Player playerAct,int num){
      //playerAct.historialDeCartas.add(0,playerAct.cartsOfThePlayer);
        playerAct.historial+= "\n𝕮𝖆𝖗𝖙𝖆𝖘 𝖈𝖔𝖓 𝖑𝖆𝖘 𝖖𝖚𝖊 𝖎𝖓𝖎𝖈𝖎𝖔 𝖊𝖘𝖙𝖊 𝖙𝖚𝖗𝖓𝖔:"+playerAct.cartsOfThePlayer.toString()+"\n";
        // Primero se avisa que es su turno
        System.out.println(blue+playerAct.name+ white + " es tu turno 🔮 "+"\n");
        // Despues se muestra las cartas del jugador a la derecha numeradas
        Player jD=turnos.get(num+1);  // obtenemos al jugador de la derecha
        this.volteaTodasReves(jD); // volteamos las cartas del jugador a la derecha 
        //
        System.out.println(white+"Puedes robarle una carta a "+yellow+jD.name+ white+"\n");
        // Si el del turno es el usuario
        if(playerAct==usuario){
          muestraCartasNumeradas(jD); // le mostramos al jugador las opciones
          // Creamos el scanner y el boolean aux
          Scanner sc = new Scanner(System.in);
          boolean aux=true;
          int eleccion=0;
          // Se hace la elección de la carta a robar
          try{
            while(aux){
              System.out.println("\n"+purple+"¿Qué carta quieres robar? "+white+"\n");
              eleccion = sc.nextInt();
              if(1>eleccion || eleccion> jD.cartsOfThePlayer.size()){
                  System.out.println(red+ "No elegiste una carta valida, intenta de nuevo"+white);
                  continue;
                }
                aux=false;
            }
          }catch (InputMismatchException ime) {
            System.out.println(red+ "\tNo ingresaste un entero" + white);
            System.out.print(green+"\tIntenta de nuevo:)"+white+"\n\n");
            sc.nextLine();
          }catch(Exception e){
            System.out.print(red+"\n\tLo siento,ocurrio un error inesperado");
            System.out.print(green+"\n\tIntenta de nuevo:)"+white+"\n\n");
            sc.nextLine();
            }
          sc.nextLine();
          System.out.println();
          // Se regresan al estado incial las cartas del jugador a la derecha
          this.volteaTodasFrente(jD);
          // Se hace el robo 
          this.robar(playerAct, jD, eleccion);
          // AQUI IRIA UNA GUARDADA EN EL HISTORIAL

          playerAct.historial +="𝖑𝖆 𝖈𝖆𝖗𝖙𝖆 𝖖𝖚𝖊 𝖗𝖔𝖇ó 𝖊𝖓 𝖊𝖘𝖙𝖊 𝖙𝖚𝖗𝖓𝖔 𝖊𝖘:"+jD.cartsOfThePlayer.get(eleccion-1).toString();

          // Se le muestran sus cartas al jugador
          
          System.out.println(playerAct.toString());
          // Si se hace un par se descarta y se le avisa al usuario.
            if(playerAct.descartarPar()){
<<<<<<< HEAD
              System.out.println(green+ "Yeii , hiciste un par 💯 "+white);
              playerAct.historial+="\n𝕰𝖓 𝖊𝖘𝖙𝖆 𝖕𝖆𝖗𝖙𝖎𝖉𝖆 𝖑𝖔𝖌𝖗ó 𝖍𝖆𝖈𝖊𝖗 𝖚𝖓 𝖕𝖆𝖗 𝖉𝖊 𝖈𝖆𝖗𝖙𝖆𝖘 🥳S\n"; 
=======
              System.out.println(green+ "Yeii , hiciste un par 💯 "+white+"\n");
              System.out.println( "Ahora tus cartas son estas: "+white+"\n");
              System.out.println(playerAct.toString());
>>>>>>> dac5f90bf31d21161546e29c42f4a2bf44d7bc87
              // AQUI IRIA UNA GUARDADA EN EL HISTORIAL
            }else{
              playerAct.historial+= "\n𝕰𝖓 𝖊𝖘𝖙𝖆 𝖕𝖆𝖗𝖙𝖎𝖉𝖆 𝖓𝖔 𝖑𝖔𝖌𝖗ó 𝖍𝖆𝖈𝖊𝖗 𝖚𝖓 𝖕𝖆𝖗 𝖉𝖊 𝖈𝖆𝖗𝖙𝖆𝖘 🥺\n";
            }

<<<<<<< HEAD
           /*  if(!(playerAct.descartarPar())){
            playerAct.historial+= "\n𝕰𝖓 𝖊𝖘𝖙𝖆 𝖕𝖆𝖗𝖙𝖎𝖉𝖆 𝖓𝖔 𝖑𝖔𝖌𝖗ó 𝖍𝖆𝖈𝖊𝖗 𝖚𝖓 𝖕𝖆𝖗 𝖉𝖊 𝖈𝖆𝖗𝖙𝖆𝖘 🥺\n";
            } */
=======
>>>>>>> dac5f90bf31d21161546e29c42f4a2bf44d7bc87
          // Se checa si el jugador actual ya gano 
          if(playerAct.cartsOfThePlayer.isEmpty()){
              System.out.println("El jugador "+blue+playerAct.name+white + "sale del juego"+ "\n"+ purple+"🐙 : EALEEEE LA MÁS GANADORA"+white);
              // se elimina de la lista turnos
              turnos.remove(num);
              playerAct.historial+= "𝕰𝖓 𝖊𝖘𝖙𝖊 𝖙𝖚𝖗𝖓𝖔 𝖊𝖑 𝖏𝖚𝖌𝖆𝖉𝖔𝖗 𝖘𝖊 𝖖𝖚𝖊𝖉ó 𝖘𝖎𝖓 𝖈𝖆𝖗𝖙𝖆𝖘 ⭐\n";
              // AQUI IRIA UNA GUARDADA EN EL HISTORIAL
              //Si el jugador ya gano pues ya acaba su turno 
              return;
          }else{
            playerAct.historial+= "𝕰𝖓 𝖊𝖘𝖙𝖊 𝖙𝖚𝖗𝖓𝖔 𝖊𝖑 𝖏𝖚𝖌𝖆𝖉𝖔𝖗 𝖘𝖎𝖌𝖚𝖊 𝖈𝖔𝖓 𝖈𝖆𝖗𝖙𝖆𝖘\n";
          }
          // Se le pregunta al usuario si quiere mover sus cartas
          String respuesta;
          boolean aux2=true;
          int c1;
          int c2;
          aux=true;
          while(aux2){
          try{
          
            System.out.println("Antes de que acabe tu turno ¿quieres hacer algún cambio en tus cartas?"+white+"\n");
            respuesta=sc.nextLine();
            respuesta=respuesta.toUpperCase(); // Pasa la respuesta a mayusculas
            if(respuesta.contains("SI")|| respuesta.contains("SÍ")){
              while(aux){
                // Se le muestra al usuario sus cartas numeradas
                muestraCartasNumeradas(playerAct);
                System.out.println("\n"+"Escribe el número de la primera carta "); 
                c1 = sc.nextInt();
                sc.nextLine();
                System.out.println("Escribe el número de la segunda carta "); 
                c2 = sc.nextInt();
                sc.nextLine();
                if(1>c1|| 1>c2 || c1> playerAct.cartsOfThePlayer.size()|| c2> playerAct.cartsOfThePlayer.size()){
                    System.out.println(red+ "No elegiste cartas validas, intenta de nuevo"+white+"\n");
                    continue;
                  }
                //Se hace el cambio
                this.reacomodarCartas(c1-1,c2-1,playerAct);
                System.out.println( "Ahora tus cartas se ven asi: "+white+"\n");
                System.out.println(playerAct.toString());
                //
                System.out.println("¿Quieres hacer otro cambio?");
                respuesta=sc.nextLine();
                respuesta=respuesta.toUpperCase(); // Pasa la respuesta a mayusculas
                if(respuesta.contains("SI")|| respuesta.contains("SÍ")){
                  continue;
                }
                else{
                  aux2=false;
                  return;
                }
              }
            }
            if(respuesta.contains("NO")){

              return; //SE ACABA EL TURNO
            }
            System.out.println(red+"No entiendo a que te refieres, trata responder sí o no "+white);
          }
          catch (InputMismatchException ime) {
            System.out.println(red+ "\tNo ingresaste un entero" + white);
            System.out.print(green+"\tIntenta de nuevo:)"+white+"\n\n");
            sc.nextLine();
            continue;  
          }catch(Exception e){
            System.out.print(red+"\n\tLo siento,ocurrio un error inesperado");
            System.out.print(green+"\n\tIntenta de nuevo:)"+white+"\n\n");
            sc.nextLine();
            continue;  
            }
          sc.nextLine();
          System.out.println();
          //aux2=false;
        }
      }
        // Si el del turno es un jugador artificial.
        else{ 
          // Se hace la eleccion de carta a robar de manera random
            Random random=new Random();
            int pos=random.nextInt(jD.cartsOfThePlayer.size());
          // Se hace el robo 
            this.robar(playerAct, jD, pos+1);
            // AQUI IRIA UNA GUARDADA EN EL HISTORIAL
          // Si se hace un par se descarta y se guarda en el historial
            if(playerAct.descartarPar()){
              // AQUI IRIA UNA GUARDADA EN EL HISTORIAL
            }
          // Se checa si el jugador actual ya gano 
            if(playerAct.cartsOfThePlayer.isEmpty()){
              System.out.println("El jugador "+blue+playerAct.name+white + "sale del juego"+ "\n"+ purple+"🐙 : EALEEEE LA MÁS GANADORA"+white);
              // se elimina de la lista turnos
              turnos.remove(num);
              // AQUI TAMBIEN FALTA GUARDAR EN EL HISTORIAL
            }
        }
        
        // Se agrega al historial la info del turno
        playerAct.historial += "\n";

    }

   /*  public void historial(){
      for(i int=0;i< listaPlayers.size();i++){
          System.out.println(listaPlayers.get(aux),cartsOfThePlayerInTheBeginning);
      }
    } */

    

    public static void main(String[] args){
      
      // COLORES                                                               
        String green = "\033[32m";
        String white = "\u001B[0m";
        String purple = "\033[35m";
        String blue = "\033[34m";
        String yellow= "\033[33m";
        String red =  "\u001B[31m";  
        String black = "\033[30m";
<<<<<<< HEAD
        Mazo m=new Mazo();
        Player player1 = new Player("Aislinn ");   
        Partida p =new Partida(m,4,player1);
        p.preGame();
        System.out.println(p.turnos.get(0)+"\n");
	      System.out.println(p.turnos.get(1)+"\n");
	      System.out.println(p.turnos.get(2)+"\n");
	      System.out.println(p.turnos.get(3)+"\n");
        p.turno(player1,0); 
        p.turno(player1,0); 
        System.out.println(player1.historial);
       // System.out.println("F"+player1.historialDeCartas.get(0));
         //System.out.println(p1.listaPlayers.get(0)+"\n");
	      //System.out.println(p1.listaPlayers.get(1)+"\n");
	      //System.out.println(p1.listaPlayers.get(2)+"\n");
	      //System.out.println(p1.listaPlayers.get(3)+"\n");
      //  p.preGame();
			//	p.muestraCartas();
      //  p.reacomodarCartas(4,5,player1);
			//	p.muestraRobables(player1);
			//	p.muestraCartas();
			//	Player player2= p.listaPlayers.get(2);
			//	p.muestraCartasNumeradas(player2);
			//	System.out.println("Se hace un robo de la carta [2] \n");
			//	p.robar(player1,player2,2); 
			//	System.out.println(player1);
			//	System.out.println("Se elimina si hubo par \n");
			//	player1.descartarPar();
			//	System.out.println(player1);
	    //  // System.out.println(p1.listaPlayers.get(0)+"\n");
	    //  // System.out.println(p1.listaPlayers.get(1)+"\n");
	    //  // System.out.println(p1.listaPlayers.get(2)+"\n");
	    //  // System.out.println(p1.listaPlayers.get(3)+"\n");
      //  TDAList<String> historial= new DoubleLinkedList<>();
//
=======
      
>>>>>>> dac5f90bf31d21161546e29c42f4a2bf44d7bc87
				
        // INICIO DEL MENU
        Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner

        
        System.out.println(blue+"🃏 Bienvenido al juego Solterona 🃏"+white+"\n");
        int eleccion= 0;
        do{
            System.out.println(yellow+"Elige algunas de las siguientes opciones:"+white);
    
            System.out.print(green+ "[1]"+white+" Empezar una partida 🎴 \n" +
                            green+ "[2]"+white+" Conocer las Reglas del juego 👀\n" +
                             green + "[3]"+white+" Cerrar 😞\n");
            try {
                eleccion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println(red+ "\tNo ingresaste un entero" + white);
                System.out.print(green+"\tIntenta de nuevo:)"+white+"\n\n");
                sc.nextLine();
                continue;
              }catch(Exception e){
                System.out.print(red+"\n\tLo siento,ocurrio un error inesperado");
                System.out.print(green+"\n\tIntenta de nuevo:)"+white+"\n\n");
                sc.nextLine();
                continue;
                }
            sc.nextLine();
            System.out.println();
    
            switch(eleccion){
            // opcion 1 (empezar partida)
            case 1:
              boolean aux=true;
              String nombre="";
              System.out.print(purple+"🐙 : Hola soy LULA y soy tu ayudante en el juego"+
                ",antes de empezar,");
              while(aux){
                System.out.println(purple+"¿Cuál es tu nombre? "+white+"\n");
                nombre=sc.nextLine();
                System.out.println(purple+ "🐙 : Entonces tu nombre es "+green+nombre+purple+" ¿cierto?"+white+"\n");
                System.out.println(white+"Responde"+ green+ " SI" +white
                +" para continuar o"+red+" NO"+white+" para cambiar tu nombre."+white+"\n");
                String confirmacion=sc.nextLine();
                if(confirmacion.equals("SI")){
                  System.out.println(purple+"🐙 : Wow que lindo nombre, un placer conocerte "+green+
                  nombre+white+"\n");
                  aux=false; 
                  continue; //salimos del ciclo.
                }
                if(confirmacion.equals("NO")){
                  System.out.print(purple+"🐙 : Lo siento, quiza entendí mal, ");
                  continue; //continuamos en el ciclo.
                }
                System.out.println(purple+"🐙 :" +red+" AL PARECER NO SABES LEER INSTRUCCIONES"+
                " ASI QUE TE DARE UNA OPORTUNIDAD MÁS 😡"+white);
              }
              System.out.println(purple+"🐙 : Ahora dime ¿cuántos jugadores quieres que haya en el juego?,por cierto recuerda que solo puedes elegir entre 2 a 10 jugadores"+white+"\n");

              int cantJugadores= 0;
							aux=true;
              while(aux){
								//System.out.println(purple+"🐙 : Ahora dime ¿cuántos jugadores quieres que haya en el juego?,por cierto recuerda que solo puedes elegir entre 2 a 10 jugadores"+white+"\n");
            try {
              	cantJugadores = sc.nextInt();
								// Por si no se ingresa un valor valido
								if(cantJugadores<2 || cantJugadores>10){
									System.out.println(purple+"🐙:" +red+" AL PARECER NO SABES LEER INSTRUCCIONES"+
                " ASI QUE TE DARE UNA OPORTUNIDAD MÁS 😡");
                	sc.nextLine();
                	continue;
								}
            } catch (InputMismatchException ime) {
                System.out.println(red+ "\tNo ingresaste un entero" + white);
                System.out.print(green+"\tIntenta de nuevo:)"+white+"\n\n");
                sc.nextLine();
                continue;
              }catch(Exception e){
                System.out.print(red+"\n\tLo siento,ocurrio un error inesperado");
                System.out.print(green+"\n\tIntenta de nuevo:)"+white+"\n\n");
                sc.nextLine();
                continue;
                }
								aux=false; //Para salir del ciclo si ya se ingreso un valor valido
            		sc.nextLine();
            		System.out.println();
							}
								
						
                // Creamos al jugador
                Player playerReal=new Player(nombre);
                // Creamos al Mazo
                Mazo m1=new Mazo();
                // Creamos la partida
                Partida p1 =new Partida(m1,cantJugadores,playerReal); 
								System.out.println(purple+"🐙 : Estamos listos y listas para inciar 🎉 🎉 "+white+"\n");
                System.out.println("jugaremos con baraja inglesa 🙊 🙉\n");
                try{
                Thread.sleep(1000);
                }catch(Exception e){
                  System.out.println(e);
                }
                System.out.println("\nAhora vamos a barajear las cartas\n");
                try{
                  Thread.sleep(1000);
                  }catch(Exception e){
                    System.out.println(e);
                  }
                System.out.println("\n"+green+"Barajeando..."+white+"\n");

                try{
                  Thread.sleep(2000);
                  }catch(Exception e){
                    System.out.println(e);
                  }
                p1.volteaTodasRev();
                // 
                 System.out.println(p1.mazoDelJuego.cartasMazo);
<<<<<<< HEAD
//<<<<<<< HEAD
                
                  System.out.println("\nA continuación se retirara una carta y se repartiran las cartas entre todos los jugadores y se descartaran todas sus cartas pares\n");
//=======
  //                System.out.println(white+"\nA continuación se retirara una carta y se repartiran las cartas entre todos los jugadores y se descartaran todas sus cartas pares\n");
//>>>>>>> b03875727fccc8ba8039797bd92800cffa8b11b8
=======
                  System.out.println(white+"\nA continuación se retirara una carta y se repartiran las cartas entre todos los jugadores \n además se descartaran todas sus cartas pares\n");
>>>>>>> dac5f90bf31d21161546e29c42f4a2bf44d7bc87
                 try{
                  Thread.sleep(100);
                  }catch(Exception e){
                    System.out.println(e);
                  }

                p1.preGame();
							
                System.out.println(purple+"\n🐙 :"+white+" La solterona en esta partida es "+p1.solterona.toString()+white+"\n");
                

                  System.out.println("Primero te toca a ti 🙉. Roba una carta a tu contrincante del lado derecho:D\n Escoge el indice de la carta que quieres robar\n");

                  p1.muestraCartasNumeradas(p1.turnos.get(1));



                break;

            //opcion 2 (REGLAS)
            case 2:
                 System.out.println("𝕽𝖊𝖌𝖑𝖆𝖘 𝖉𝖊𝖑 𝖏𝖚𝖊𝖌𝖔 " );
                  System.out.println(red+"1."+white+"Solo pueden haber de 2 a 10 jugadores, no más ni menos\n"
                  +red+"2."+white+"El mazo debe barajearse antes de repartirse entre los jugadores\n"+red+
                  "3."+white+"Se retirara una carta sin enseñarsela a los jugadores\n"
                  +red+"4."+white+"Se reparte de manera uniforma las cartas, puede ocurrir que algunos jugadores comiencen con mas cartas que otros\n"
                  +red+"5."+white+"Cuando le sean repartidas la cartas se descartaran automaticamente todos los pares que tenga.\n"+
                   "Se descartan solo los pares, no las tercias, esto es, si tiene tres cartas de igual denominación,se descartan solo dos de ellas.\n"
                   +red+"6."+white+"tu querido usuaro seras el primero en empezar.\n"
                   +red+"7."+white+"En su turno, cada jugador le debe robar una carta al jugador que tenga a laderecha. Si logra formar un par, puede descartarlo. Si se queda sin cartas,"+
                   "abandona la partida.\n"
                   +red+"8."+white+"No se debe la mano del jugador a su derecha. La carta que escoja debe estar boca abajo.\n"
                   +red+"9."+white+"Cuando quede solo un jugador en la partida termina el juego. Ese jugador es el perdedor.");
            break;
            
            // opcion 3 (salir)
            case 3:
            System.out.println(white+"\n 🌈 " + red+" Gracias por usar el programa "+ white+ "🌈\n"+white);
            break;
    
            } // final switch principal 
           
            System.out.println();
            
        } //final do .. while principal
        while(eleccion!=3); 



      }
}
