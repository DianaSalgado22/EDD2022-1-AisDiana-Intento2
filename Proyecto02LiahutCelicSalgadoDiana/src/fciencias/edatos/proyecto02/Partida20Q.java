package fciencias.edatos.proyecto02;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que implementa el juego de las 20 preguntas.
 * @version 1. Diciembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class Partida20Q{

  // COLORES                                                               
  String green = "\033[32m";
  String white = "\u001B[0m";
  String purple = "\033[35m";
  String blue = "\033[34m";
  String yellow= "\033[33m";
  String red =  "\u001B[31m";  
  String black = "\033[30m";

  // Atributo que dice si una partida ya termino
  boolean terminada=false;

  /** Metodo para volver a guardar el arbol.
   *  @param arbol que se guardara
   */
  public void actualizarArchivo(BinaryTree arbol)throws FileNotFoundException,IOException{
    try{
      FileOutputStream fs = new FileOutputStream("ArbolCantantes.ser");//Creamos el archivo
      ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
      os.writeObject(arbol);//El método writeObject() serializa el objeto y lo escribe en el archivo
      os.close();//Hay que cerrar siempre el archivo
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  /** Metodo para usar al metodo recorrido 
   *  el archivo ArbolCantantes
   */
  public void ejecutarPreguntas()throws FileNotFoundException,IOException,ClassNotFoundException{
    try{
      // Creamos a un objeto que tenga al aarchivo de nuestr arbol
      FileInputStream fileIn=new FileInputStream("ArbolCantantes.ser");
      // Este es el que procesa los datos
      ObjectInputStream entrada=new ObjectInputStream(fileIn);
      // Guardamos al arbol 
      BinaryTree a1=(BinaryTree)entrada.readObject();
      // Empezamos a hacer las preguntas al usuario con el metodo recorrido
      this.recorrido(a1);
      // Volvemos a escribir el archivo 
      this.actualizarArchivo(a1);
      // Cerramos 
      entrada.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }

  /** Metodo para usar al metodo de orden alfabetico
   *  en el archivo ArbolCantantes
   */
  public void PreguntasOrdenAlfabetico()throws FileNotFoundException,IOException,ClassNotFoundException{
    try{
      // Creamos a un objeto que tenga al aarchivo de nuestr arbol
      FileInputStream fileIn=new FileInputStream("ArbolCantantes.ser");
      // Este es el que procesa los datos
      ObjectInputStream entrada=new ObjectInputStream(fileIn);
      // Guardamos al arbol 
      BinaryTree a1=(BinaryTree)entrada.readObject();
      // Usamos el metodo para regresar el orden alfabetico
      a1.AlphabetizeTheQuestions();
      // Cerramos 
      entrada.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }


  /** Metodo para usar al metodo de orden en que llegaron
   *  en el archivo ArbolCantantes
   */
  public void PreguntasOrdenAgregadas()throws FileNotFoundException,IOException,ClassNotFoundException{
    try{
      // Creamos a un objeto que tenga al aarchivo de nuestr arbol
      FileInputStream fileIn=new FileInputStream("ArbolCantantes.ser");
      // Este es el que procesa los datos
      ObjectInputStream entrada=new ObjectInputStream(fileIn);
      // Guardamos al arbol 
      BinaryTree a1=(BinaryTree)entrada.readObject();
      // Usamos el metodo para regresar el orden alfabetico
      a1.imprimirEnOrdenEnQueLlegaronSinHojas();
      // Cerramos 
      entrada.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }

  /** Metodo para usar al metodo de orden alfabetico
   *  en el archivo ArbolCantantes
   */
  public void RespuestasOrdenAlfabetico()throws FileNotFoundException,IOException,ClassNotFoundException{
    try{
      // Creamos a un objeto que tenga al aarchivo de nuestr arbol
      FileInputStream fileIn=new FileInputStream("ArbolCantantes.ser");
      // Este es el que procesa los datos
      ObjectInputStream entrada=new ObjectInputStream(fileIn);
      // Guardamos al arbol 
      BinaryTree a1=(BinaryTree)entrada.readObject();
      // Usamos el metodo para regresar el orden alfabetico
      a1.AlphabetizeTheAnswers();
      // Cerramos 
      entrada.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }


  /** Metodo para usar al metodo de orden en que llegaron
   *  en el archivo ArbolCantantes
   */
  public void RespuestasOrdenAgregadas()throws FileNotFoundException,IOException,ClassNotFoundException{
    try{
      // Creamos a un objeto que tenga al aarchivo de nuestr arbol
      FileInputStream fileIn=new FileInputStream("ArbolCantantes.ser");
      // Este es el que procesa los datos
      ObjectInputStream entrada=new ObjectInputStream(fileIn);
      // Guardamos al arbol 
      BinaryTree a1=(BinaryTree)entrada.readObject();
      // Usamos el metodo para regresar el orden alfabetico
      a1.imprimirHojasEnOrdenEnQueLlegaron();
      // Cerramos 
      entrada.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }
  }


  /** Metodo que hace el camino en un arbol (La partida basicamente)
	 *  @param 
	 *  @return ultNode el nodo donde termino el camino
	 */
	public Node recorrido(BinaryTree arbol){
		Node actual= arbol.root;
		String eleccion=""; 
		Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner
		int contador=1; // Cuenta cuantas preguntas se han hecho
		// Mientras actual no sea una hoja
		while(!actual.isLeaf()){
      // Si ya llegamos a las 20 preguntas rompemos el ciclo y avisamos al jugador.
      if(contador==20){
        System.out.println(yellow+"No puede ser 😭, lo siento pero no pude adivinar en menos de 20 preguntas"+
        ",Me declaro como perdedor 👉👈" +white+ "\n");
        this.terminada=true; // La partida ya termino pues no se logro adivinar
        return actual;
      }
			// Le preguntamos al usuario
			System.out.println(white+actual.element+blue);
			// Obtenemos la respuesta del usuario (con scanner)
				eleccion = sc.nextLine();
			  System.out.println(white);
			  // si el usuario respondio true
			  if(eleccion.equals("true")){
				// Pasamos al actual del lado izq
				actual=actual.left;
        // Aumentamos el contador pues nos movimos de nodo
        contador++;
				continue;
			  }
			  // si el usuario respondio false
			  if(eleccion.equals("false")){
				// Pasamos al actual del lado derecho
				actual=actual.rigth;
        // Aumentamos el contador pues nos movimos de nodo
        contador++;
				continue;
			  }
			  // Para cuando el usuario no responde true o false
			  else{
					//avisar al usuario que no contesto como esperaba entonces 
					System.out.println(red+"Recuerda solo responder true o false, para poder avanzar a la siguiente pregunta ;)"+white);
			  }
		}
		// Cuando ya llegamos a una hoja preguntamos si adivinamos
    boolean aux=true;
    while(aux){
      System.out.println(white+actual.element+blue);
      try {
        eleccion = sc.nextLine();
       } catch (Exception e) {
         System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
         System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
       }
       System.out.println(white);
       // si el usuario respondio true
       if(eleccion.equals("true")){
        // Ya se adivino en quien piensa y celebramos 
        System.out.println(green+"Yeii Adivinator adivino en quien estabas pensando, lo siento pero perdisteee"+purple+"🔮"+white +"\n\n");
        return actual;
        }
        // si el usuario respondio false, no se pudo adivinar quien es entonces hay que agregar un nuevo nodo
        if(eleccion.equals("false")){
          //La pregunta nueva
          String pregunta;
          // cantante
          String cantante;
          // siOno
          boolean siOno;
          
          // preguntamos al usuario la info 
          System.out.println(yellow+"oh oh creo que no sé en quien piensas 😥" +white+"\n\t"+purple+" Ayudame a mejorar 🙏"+white);
          // Obtenemos en quien pensaba
          System.out.println("¿En quién estabas pensando?"+blue);
          cantante= sc.nextLine();
          // Pedimos la pregunta
          System.out.println(white+"Ingresa una pregunta que pueda identificar a "+green+cantante+white+
           " y que se pueda responder con true o false: "+blue);
          pregunta=sc.nextLine();
          System.out.println(white+"Ahora ayudame respondiendo la siguiente pregunta con true o false:\n"+green+cantante+
          white+" cumple que "+purple+pregunta+blue);
          siOno=Boolean.parseBoolean(sc.nextLine());
          // Ahora insertamos la nueva pregunta
          arbol.insert(actual,pregunta,cantante,siOno);
        }

        // Para cuando el usuario no responde true o false
        else{
          //avisar al usuario que no contesto como esperaba entonces 
          System.out.println("Recuerda solo responder true o false, para poder avanzar");
          continue;
        }
        aux=false;
    }

      return actual;
	}
    
    public static void main(String[] args){
        // creamos una partida
        Partida20Q partida=new Partida20Q();
        // COLORES
        String green = "\033[32m";
        String white = "\u001B[0m";
        String purple = "\033[35m";
        String blue = "\033[34m";
        String yellow = "\033[33m";
        String red = "\u001B[31m";
        // Empieza el menú
        Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner

        
        // INICIO DEL MENU
        System.out.println(yellow + "Bienvenido a Adivinator" + purple+"🔮" + white + "\n");
        int eleccion = 0;
        int aux = 0;
        String aux2 = "";
        do {
          System.out.println(
            blue + "Elige algunas de las siguientes opciones:" + white
          );
        
          System.out.print( 
            green +"[1]" +white +"Jugar\n" +
            green +"[2]" +white +"Preguntas en orden alfabético\n" +
            green +"[3]" +white +"Preguntas en el orden en que fueron agregadas\n" +
            green +"[4]" +white +"Entes en orden alfabético\n" +
            green +"[5]" +white +"Entes en el orden en que fueron agregados\n" +
            green +"[6]" +white +"Salir\n" );
          try {
            eleccion = sc.nextInt();
          } catch (InputMismatchException ime) {
            System.out.println(red + "\tNo ingresaste un entero" + white);
            System.out.print(green + "\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          } catch (Exception e) {
            System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
            System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
            sc.nextLine();
            continue;
          }
          sc.nextLine();
          System.out.println();
        
          switch (eleccion) {
            case 1:  // Jugar
            String listo="";
            System.out.println(yellow+"Holaa yo soy adivinator, piensa en un cantante y yo adivinare "+purple+"🔮"+white);
            System.out.println(purple+"Contesta las  preguntas siguiendo estas pequeñas reglas:"+white);
            System.out.print( 
            green +"-" + white +"La persona en la que piensas tiene que ser un cantante 🎤\n" +
            green +"-" +white +"Responder true si la respuesta es sí ✅ ,false si la respuesta es no ❎ \n" );
            // loop para hacer robusto al listo para empezar
            while(!(listo.equals("true"))){
              System.out.println(purple+"\t ¿Listo para empezar?"+white);
              try{
                listo=sc.nextLine();
                listo=listo.toLowerCase();

              } catch (Exception e) {
                System.out.print(red + "\n\tLo siento,ocurrio un error inesperado");
                System.out.print(green + "\n\tIntenta de nuevo:)" + white + "\n\n");
                sc.nextLine();
                continue;
              }
            }
            // Abrimos/Cargamos el archivo del arbol 
            try{

              partida.ejecutarPreguntas();

            }catch(FileNotFoundException e){
              e.printStackTrace();
            }catch(IOException e){
              e.printStackTrace();
            }catch(ClassNotFoundException e){
              e.printStackTrace();
            }
            break;
            case 2: // Preguntas en orden alfabético
              try{

                partida.PreguntasOrdenAlfabetico();

              }catch(FileNotFoundException e){
                e.printStackTrace();
              }catch(IOException e){
                e.printStackTrace();
              }catch(ClassNotFoundException e){
                e.printStackTrace();
              }
              break;
            
            case 3: // Preguntas en el orden en que fueron agregadas
              try{

                partida.PreguntasOrdenAgregadas();

              }catch(FileNotFoundException e){
                e.printStackTrace();
              }catch(IOException e){
                e.printStackTrace();
              }catch(ClassNotFoundException e){
                e.printStackTrace();
              }  
            
              break;

            case 4: // Entes en orden alfabético
            try{

              partida.RespuestasOrdenAlfabetico();

            }catch(FileNotFoundException e){
              e.printStackTrace();
            }catch(IOException e){
              e.printStackTrace();
            }catch(ClassNotFoundException e){
              e.printStackTrace();
            }  
            break;

            case 5: // Entes en el orden en que fueron agregadas
            try{

              partida.RespuestasOrdenAgregadas();

            }catch(FileNotFoundException e){
              e.printStackTrace();
            }catch(IOException e){
              e.printStackTrace();
            }catch(ClassNotFoundException e){
              e.printStackTrace();
            }    
            
            break;
          } // final switch principal

        } while (eleccion != 6); //final do .. while principal
        System.out.print(
          white +
          "\n 🌈 " +
          purple +
          " Gracias por jugar Adivinator" +
          white +
          "🌈\n" +
          white
        );
  }
  
     // AUN NO BORRARE ESTO POR SI OCUPAMOS VOLVER A HACER EL ARBOL ANTES DE SUBIRLO 


      // esto es como para escribir en el doc y lo que use para crearlos
        /* 
        // Creamos al nuevo arbol
        BinaryTree a1= new BinaryTree();
        // Insertamos 
        a1.insertFirst("¿La persona en la que estas pensando forma parte de un grupo o banda?","Tyler Joseph","Ariana Grande");
        a1.insert(a1.root.rigth,"¿Canta pop?","Bad bunny   ",false);
        a1.insert(a1.root.left,"¿Es mujer?","Lisa (Blackpink)",true);
        a1.insert(a1.root.rigth.left,"¿Tiene más de 21 años?","Olivia Rodrigo",false);
        a1.insert(a1.root.left.left,"¿Canta en español?","Melissa Robles",true);
        // System.out.println("La raiz es  "+a1.root.element);
        // System.out.println("El hijo derecho de la raiz  "+a1.root.rigth.element);
        // System.out.println("El hijo derecho de   "+a1.root.rigth.element+" es"+a1.root.rigth.rigth.element);
        // System.out.println("El hijo izq de   "+a1.root.rigth.element+" es"+a1.root.rigth.left.element);
        //a1.preorden();
        a1.AlphabetizeTheAnswers();
       // a1.postorden();
        try{
            FileOutputStream fs = new FileOutputStream("ArbolCantantes.ser");//Creamos el archivo
            ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
            os.writeObject(a1);//El método writeObject() serializa el objeto y lo escribe en el archivo
            os.close();//Hay que cerrar siempre el archivo
          }catch(FileNotFoundException e){
            e.printStackTrace();
          }catch(IOException e){
            e.printStackTrace();
          }
       

      
       try{
        // Creamos a un objeto que tenga al aarchivo de nuestr arbol
        FileInputStream fileIn=new FileInputStream("ArbolCantantes.ser");
        // Este es el que procesa los datos
        ObjectInputStream entrada=new ObjectInputStream(fileIn);
        // Guardamos al arbol 
        BinaryTree a1=(BinaryTree)entrada.readObject();
        // Usamos el metodo para regresar el orden alfabetico
        a1.insert(a1.root.rigth.left,"¿Tiene más de 21 años?","Olivia Rodrigo",false);
        a1.insert(a1.root.left.left,"¿Canta en español?","Melissa Robles",true);
        a1.imprimirHojasEnOrdenEnQueLlegaron();
        partida.actualizarArchivo(a1);
        // Cerramos 
        entrada.close();
      }catch(FileNotFoundException e){
        e.printStackTrace();
      }catch(IOException e){
        e.printStackTrace();
      }catch(ClassNotFoundException e){
        e.printStackTrace();
      }
      
       
    }*/
  }
