package fciencias.edatos.practica03;
import java.util.Scanner;
import java.util.Iterator;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * @version 1.0 Octubre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class Maze{

    // COLORES                                                               
    String verde = "\033[32m";
    String blanco = "\u001B[0m";
    String morado = "\033[35m";
    String azul = "\033[34m";
    String yellow= "\033[33m";
    String rojo =  "\u001B[31m";   

    /** Un arreglo de casillas 
     *  que es la representación del 
     *  tablero del laberinto */
    Box[][] tablero;  

    /** Representa la casilla de inicio del
     *  recorrido del laberinto.
     *  Esta casilla no puede ser una pared*/
    Box inicio;

    /** Representa la casilla de fin del
     *  recorrido del laberinto.*/
    Box fin;

    /** Representa la casilla actual del
     *  recorrido del laberinto.
     *  Esta casilla no puede ser una pared*/
    Box actual;

    public Maze(){

    }

    public Maze(Box[][] tablero,Box inicio,Box fin, Box actual){
        this.tablero = tablero;
        this.inicio = inicio;
        this.fin = fin;
        this.actual = actual;
    }

    public Maze(Box[][] tablero){

        this.tablero = tablero;

    }
     

    /** Metodo para saber si el laberinto esta resuelto
     *  @return true si ya esta resuleto,false si no.
     */
      public boolean isSolution(){
        // Si son iguales significa que encontramos un camino
        if(actual==fin)
           return isExtensible();
        // De otra manera aún no se encuentra una solución
        return false;
    }  

//<<<<<<< HEAD

    public boolean isExtensible(){
        return  !((actual.getNeighbors().size()) == 0);
    }

    public String toString(){
        int contadorC=1; //contador columnas
        int contadorF=0; //contador filas
        String representación = "";
        String representaciónC ="     "+yellow+"0";
        for(int i = 0; i < tablero.length; i++){
            // Para escribir las filas
            if(contadorF<=9){
                representación += verde+" "+contadorF+blanco+" |";
                contadorF++;
            }
            else{
                representación += verde+contadorF+blanco+" |";
                contadorF++;
            }
            // Para escribir las columnas

            // Para eliminar la etiqueta extra
            if(contadorC==tablero.length){} 
            // Para que los numeros con dos cifras no arruinen la simetria
            if(contadorC<=9){
                representaciónC+= "  "+yellow+contadorC+blanco;
            }
            if(contadorC>9 && contadorC!=tablero.length){
                representaciónC+= " "+yellow+contadorC+blanco;
            }
            //
            for(int j = 0; j < tablero[i].length; j++){
                 if(i  == inicio.fila && j == inicio.columna){
                    representación += morado+"👻 "+blanco;
                    continue;
                } 

                if(i  == fin.fila && j == fin.columna){
                    representación += yellow+" 🎃"+blanco;
                    continue;
                } 

                 if(i  == actual.fila && j == actual.columna){
                    representación += yellow+" ✨ "+blanco;
                    continue;
                }              
 
                representación += tablero[i][j] == null ? "@@@" : "   ";
            }

          //  tablero[inicio.fila][inicio.columna] = "👻 ";
            representación += "|\n";
            contadorC++;
        }
        return representaciónC+"\n"+representación;
    }

    //🎃👻✨
    /** Metodo para imprimir un laberinto cuando aún no tiene 
     *  casilla de inicio o de fin
     */
    public String toStringVacio(){
        int contadorC=1; //contador columnas
        int contadorF=0; //contador filas
        String representación = "";
        String representaciónC ="     "+yellow+"0";
        for(int i = 0; i < tablero.length; i++){
            // Para escribir las filas
            if(contadorF<=9){
                representación += verde+" "+contadorF+blanco+" |";
                contadorF++;
            }
            else{
                representación += verde+contadorF+blanco+" |";
                contadorF++;
            }
            // Para escribir las columnas

            // Para eliminar la etiqueta extra
            if(contadorC==tablero.length){} 
            // Para que los numeros con dos cifras no arruinen la simetria
            if(contadorC<=9){
                representaciónC+= "  "+yellow+contadorC+blanco;
            }
            if(contadorC>9 && contadorC!=tablero.length){
                representaciónC+= " "+yellow+contadorC+blanco;
            }
            //
            for(int j = 0; j < tablero[i].length; j++){             
                representación += tablero[i][j] == null ? "@@@" : "   ";
            }
            representación += "|\n";
            contadorC++;
        }
        return representaciónC+"\n"+representación;
    }

    public String toStringSolución(TDAStack<Box> coordenadas ){
        int contadorC=1; //contador columnas
        int contadorF=0; //contador filas
        String representación = "";
        String representaciónC ="     "+yellow+"0";
        for(int i = 0; i < tablero.length; i++){
            // Para escribir las filas
            if(contadorF<=9){
                representación += verde+" "+contadorF+blanco+" |";
                contadorF++;
            }
            else{
                representación += verde+contadorF+blanco+" |";
                contadorF++;
            }
            // Para escribir las columnas

            // Para eliminar la etiqueta extra
            if(contadorC==tablero.length){} 
            // Para que los numeros con dos cifras no arruinen la simetria
            if(contadorC<=9){
                representaciónC+= "  "+yellow+contadorC+blanco;
            }
            if(contadorC>9 && contadorC!=tablero.length){
                representaciónC+= " "+yellow+contadorC+blanco;
            }
            //
            for(int j = 0; j < tablero[i].length; j++){
                 if(i  == inicio.fila && j == inicio.columna){
                    representación += morado+"👻 "+blanco;
                    continue;
                } 

                if(i  == fin.fila && j == fin.columna){
                    representación += yellow+" 🎃"+blanco;
                    continue;
                } 


                 if(i  == coordenadas.pop().fila && j == coordenadas.pop().columna){
                    representación += yellow+" ✨ "+blanco;
                    continue;
                }              
 
                representación += tablero[i][j] == null ? "@@@" : "   ";
            }

          //  tablero[inicio.fila][inicio.columna] = "👻 ";
            representación += "|\n";
            contadorC++;
        }
        return representaciónC+"\n"+representación;
    }


    public void extend(){


        //int auxf=actual.fila;
        //int auxc=actual.columna;
        for(int i=0; i<4;i++){
        int dirección= actual.neighbors.first();
        switch(dirección){
            case 0:
                // if(actual.fila== 0)
                //     break;
                //actual.fila += 1;
                int auxf= actual.fila;
                if (actual.fila != 0 && (tablero[actual.fila+1][actual.columna].wall == false) && (tablero[actual.fila+1][actual.columna].visited == false)){
                    
                   // actual.fila += 1;
                //    auxf += 1;
                    actual = tablero[actual.fila+1][actual.columna];
                //    actual.fila = auxf;
                   /*  tablero[actual.fila+1][actual.columna].fila = actual.fila;
                    tablero[actual.fila+1][actual.columna].columna = actual.columna; */
                    return;
                } 
                break;   
            case 1:
                if(tablero[actual.fila].length-1 == actual.columna){
                    break;
                }
                if(tablero[actual.fila][actual.columna + 1].wall== false && tablero[actual.fila][actual.columna + 1].visited == false ){
                    actual = tablero[actual.fila][actual.columna+1];
                  //  actual.columna += 1;
                    return;

                }    

                break;
            case 2:
               /*  if(tablero.length-1 == actual.fila){
                    break;
                } */
                if(tablero.length-1 == actual.fila && tablero[actual.fila-1][actual.columna].wall== false && tablero[actual.fila-1][actual.columna].visited == false ){
                actual = tablero[actual.fila-1][actual.columna];
              //  actual.fila = actual.fila -1 ;
                return;
                }     
                break;
            case 3:
                // if(actual.columna==0){
                //     break;
                // }
                if(actual.columna != 0  && tablero[actual.fila][actual.columna-1].wall== false && tablero[actual.fila-1][actual.columna].visited == false ){
              //  actual = tablero[actual.fila-1][actual.columna];
               // actual.
                return;

                }    
            actual.neighbors.dequeue();    
        }


        }

        //if(getNeighbors().first())


    }
    
        /* public TDAStack<Box> solve(Maze laberinto){
        TDAStack<Box> camino = new Stack<>();
        //actual.visited= true;
        camino.push(actual);
      
        //actual.visited = true;
        while(!laberinto.isSolution()){
            if(laberinto.isExtensible()){
                
                laberinto.extend();
                actual.visited = true;
                camino.push(actual);
            
            }

            if(!laberinto.isExtensible()){
                actual= camino.pop();

            }

        }

        return camino;
    } */
 
    public TDAStack<Box> solve(Maze laberinto){
        TDAStack<Box> camino = new Stack<>();
        actual = laberinto.inicio;
        camino.push(actual);
          /* if(actual==null){
            System.out.println("aaaa");
            return camino;
        }   */

        actual.visit();

        while(!laberinto.isSolution()){
            if(laberinto.isExtensible()){
                
                laberinto.extend();
                actual.visit();
                camino.push(actual);
            
            }

            if(!laberinto.isExtensible()){
                actual= camino.pop();

            }

        }

        return camino;
    }

 // /*
    public static void main(String[] args){
        
        // COLORES                                                               
        String verde = "\033[32m";
        String blanco = "\u001B[0m";
        String morado = "\033[35m";
        String azul = "\033[34m";
        String yellow= "\033[33m";
        String rojo =  "\u001B[31m"; 

//<<<<<<< HEAD
/*
   
*/
        Box[][] p1 = ArrayReader.readMatrix("Laberintos/LaberintoA.txt");

        Box startp = new Box(false,true,9,0);
        Box endp = new Box(false,false,9,20);
        Box actualp = startp;
        System.out.println(actualp.getNeighbors());
        System.out.println(actualp.getNeighbors().size());

        
		Maze laberinto = new Maze(p1,startp,endp,actualp); 
        Maze aux = new Maze();


        System.out.println(laberinto);  
        aux.solve(laberinto);
       
//=======
       /*  Box start = new Box(false,true,9,0);
        Box end = new Box(false,false,9,20);
        Box actual = start;
		Maze laberinto = new Maze(p1,start,end,actual); 
 */



       // laberinto.extend();
        //Maze laberinto = new Maze(p1);
       // System.out.println(laberinto);  
//=======
        //Box[][] p1 = ArrayReader.readMatrix("Laberintos/LaberintoA.txt");

		//Maze laberinto = new Maze(p1);
//>>>>>>> ba9fadf080bf5c6633eac86e23f18457f52c5a01
    
//>>>>>>> 2331652aeb0da0723d8d9ea338a09e9ad8fc2ce9
/*
        Scanner sc = new Scanner(System.in); //Objeto para usar la clase Scanner
        ArrayReader arre= new ArrayReader(); //Objeto para usar la clase ArrayReader
    
        //	Maze laberinto = new Maze();
        
        // INSTRUCCIONES PARA EL USUARIO
        System.out.println(verde+"Antes de comenzar:" +blanco+"\n"+azul+
          " Este es un programa que utiliza archivos,"
          +" asi que tenemos algunas recomendaciones para ti"+rojo+" 🚩" +blanco+"\n"+
          "\n"+azul+"\t-- "+blanco+"Si los archivos que quieres leer"+
          " se encuentran en la misma carpeta que este programa," + blanco+"\n"+
          "\tsolo ingresa su nombre"+morado+ " (Recuerda incluir el .txt)"+blanco+"\n\n"
          +azul+"\t-- "+blanco+"Si tu caso no es el anterior"+ 
          " tendras que incluir la ruta completa \n\tdonde se encuentra" +
          " el archivo "+morado+"Por ejemplo:" + 
          "/Documentos/ICC/carpetita/Archivo.txt"+blanco+"\n\n");
          
        // INICIO DEL MENU
        System.out.println(yellow+"Bienvenido al buscador de soluciones de laberintos ツ"+blanco+"\n");
        int eleccion= 0;
        do{
            System.out.println(azul+"Elige algunas de las siguientes opciones:"+blanco);
    
            System.out.print(verde+ "[1]"+blanco+" Resolver laberinto 🌟\n" +
                            verde+ "[2]"+blanco+" Probar ejemplos 👀\n" +
                             verde + "[3]"+blanco+" Cerrar el programa 😞\n");
            try {
                eleccion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println(rojo+ "\tNo ingresaste un entero" + blanco);
                System.out.print(verde+"\tIntenta de nuevo:)"+blanco+"\n\n");
                sc.nextLine();
                continue;
              }catch(Exception e){
                System.out.print(rojo+"\n\tLo siento,ocurrio un error inesperado");
                System.out.print(verde+"\n\tIntenta de nuevo:)"+blanco+"\n\n");
                sc.nextLine();
                continue;
                }
            sc.nextLine();
            System.out.println();
    
            switch(eleccion){
            // opcion 1 (resolver Laberinto)
            case 1:
            System.out.println(morado+"Ingresa el nombre del archivo donde esta la representación del laberinto"+blanco+"\n");
            String archivo=sc.nextLine();
            // mostrar laberinto
            Box[][] tablero1= arre.readMatrix(archivo);
            try{
            Maze lab1=new Maze(tablero1);
            lab1.toStringVacio();
            System.out.println("\n"+morado+"El laberinto del ejemplo se ve de la siguiente manera:"+blanco);
            System.out.println(lab.toStringVacio());
            }catch(NullPointerException npe){
                System.out.println("");
                continue;
            }
            try{
            // casilla inicio
            System.out.println(morado+"Ahora seleccionaremos coordenadas de la casilla de inicio:"+blanco);
            System.out.println(yellow+"Ingresa el número de columna: "+blanco);
            int cInicio1=sc.nextInt(); // número de la columna de inicio
            sc.nextLine();
            System.out.println(verde+"Ingresa el número de fila: "+blanco);
            int fInicio1=sc.nextInt(); // número de la fila de inicio
            sc.nextLine();
            Box inicio1 = tablero2[fInicio1][cInicio1];
            // casilla fin
            System.out.println(morado+"Ahora seleccionaremos coordenadas de la casilla de fin:"+blanco);
            System.out.println(yellow+"Ingresa el número de columna: "+blanco);
            int cFin1=sc.nextInt(); // número de la columna de inicio
            sc.nextLine();
            System.out.println(verde+"Ingresa el número de fila: "+blanco);
            int fFin1=sc.nextInt(); // número de la fila de inicio
            sc.nextLine();
            Box fin1 = tablero2[fFin1][cFin1];
            //
            Box start = new Box(inicio1.isWall(),inicio2.isVisited(),fInicio1,cInicio1);
            Box end = new Box(fin1.isWall(),fin2.isVisited(),fFin1,cFin1);
            Box actual = start;
		    Maze solucion1 = new Maze(tablero1,start,end,actual);
            solucion1.solve(solucion1);
            }catch (InputMismatchException ime) {
                System.out.println(rojo+ "\tNo ingresaste un entero" + blanco);
                System.out.print(verde+"\tIntenta de nuevo:)"+blanco+"\n\n");
                continue;
              }catch(IndexOutOfBoundsException ibe){
                System.out.println(rojo+ "\tIngresaste un número fuera de los rangos validos" + blanco);
                System.out.print(verde+"\tIntenta de nuevo:)"+blanco+"\n\n");
                continue;
              }
              catch(Exception e){
                System.out.print(rojo+"\n\tLo siento,ocurrio un error inesperado");
                System.out.print(verde+"\n\tIntenta de nuevo:)"+blanco+"\n\n");
                continue;
            }
            break;

            //opcion 2 (Para no tener que escribir la ruta completa al probar ejemplos)
            case 2:
            System.out.println(morado+"Ingresa solo la letra del laberinto de ejemplo (A o B)"+blanco+"\n");
            String archivoInc=sc.nextLine(); // La letra que el usuario ingrese
            String archivoCom="Laberintos/Laberinto"+archivoInc+".txt"; //La ruta de acuerdo a como esta implementada la gráfica
            // mostrar laberinto
            Box[][] tablero2= arre.readMatrix(archivoCom);
            try{
            Maze lab2=new Maze(tablero2);
            lab2.toStringVacio();
            System.out.println("\n"+morado+"El laberinto del ejemplo "+ archivoInc+" se ve de la siguiente manera:"+blanco);
            System.out.println(lab2.toStringVacio());
            }catch(NullPointerException npe){
                System.out.println("");
                continue;
            }
            try{
            // casilla inicio
            System.out.println(morado+"Ahora seleccionaremos coordenadas de la casilla de inicio:"+blanco);
            System.out.println(yellow+"Ingresa el número de columna: "+blanco);
            int cInicio1=sc.nextInt(); // número de la columna de inicio
            sc.nextLine();
            System.out.println(verde+"Ingresa el número de fila: "+blanco);
            int fInicio2=sc.nextInt(); // número de la fila de inicio
            sc.nextLine();
            Box inicio2 = tablero2[fInicio2][cInicio1];
            // casilla fin
            System.out.println(morado+"Ahora seleccionaremos coordenadas de la casilla de fin:"+blanco);
            System.out.println(yellow+"Ingresa el número de columna: "+blanco);
            int cFin2=sc.nextInt(); // número de la columna de inicio
            sc.nextLine();
            System.out.println(verde+"Ingresa el número de fila: "+blanco);
            int fFin2=sc.nextInt(); // número de la fila de inicio
            sc.nextLine();
            Box fin2 = tablero2[fFin2][cFin2];
            //
            Box start = new Box(inicio2.isWall(),inicio2.isVisited(),fInicio2,cInicio1);
            Box end = new Box(fin2.isWall(),fin2.isVisited(),fFin2,cFin2);
            Box actual = start;
		    Maze solucion2 = new Maze(tablero2,start,end,actual);
            //System.out.println(solucion2);
            solucion2.solve(solucion2);
            }catch (InputMismatchException ime) {
                System.out.println(rojo+ "\tNo ingresaste un entero" + blanco);
                System.out.print(verde+"\tIntenta de nuevo:)"+blanco+"\n\n");
                continue;
              }catch(IndexOutOfBoundsException ibe){
                System.out.println(rojo+ "\tIngresaste un número fuera de los rangos validos" + blanco);
                System.out.print(verde+"\tIntenta de nuevo:)"+blanco+"\n\n");
                continue;
              }
              catch(Exception e){
                System.out.print(rojo+"\n\tLo siento,ocurrio un error inesperado");
                System.out.print(verde+"\n\tIntenta de nuevo:)"+blanco+"\n\n");
                continue;
            }
            break;
            
            // opcion 3 (salir)
            case 3:
            System.out.println(blanco+"\n 🌈 " + rojo+" Gracias por usar el programa "+ blanco+ "🌈\n"+blanco);
            break;
    
            } // final switch principal 
           
            System.out.println();
            
        } //final do .. while principal
        while(eleccion!=3);
        */
      }
    
     
//>>>>>>> 23d007fbb8856333b94742be0e6902244f37e3a0


}