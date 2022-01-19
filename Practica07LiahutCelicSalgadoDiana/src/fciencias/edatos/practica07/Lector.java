package fciencias.edatos.practica07;
import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;



/**
 * Practica 07. Lector del archivo
 * @version 1.Enero 2022.
 * @author Salgado Tirado Diana Laura
 * @since Estructuras de Datos 2022-1
 */

public class Lector {

    //Colores
    static String verde = "\033[32m";
    static String blanco = "\u001B[0m";
    static String morado = "\033[35m";
    static String azul = "\033[34m";
    static String yellow= "\033[33m";
	static String rojo =  "\u001B[31m";


    public AbstractHashMap convierteAmapa(){
        String cadena = "";
        String resultado = "";
        // Creamos una tabla de dispersión de elementos
        AbstractHashMap<String,DoubleLinkedList<Elemento>> mapaTP = new AbstractHashMap<>(127);
        
        try{
            Reader reader1 = new FileReader("tabla-periodica.txt");
            BufferedReader lector1 = new BufferedReader(reader1);
            String linea = lector1.readLine();
            do{
                //Contador de comas
                int cc=0;
                //
                String nombre="";
                String simbolo="";
                String pesoCad="";
                double peso=0.0;
                //Empezamos a recorrerla para obtener la info.
                for(int i=0;i<linea.length();i++){
                    char caracter=linea.charAt(i);
                    // Si es una coma quiere decir que tenemos que pasar al siguiente cacho de info
                    if(caracter==','){
                        cc++; // se llego a una coma y por eso se suma
                        continue;
                    }
                    //
                    switch(cc){
                        case 0: 
                            nombre+=caracter+"";
                            break;
                        case 1:
                            simbolo+=caracter+"";
                            break;
                        case 2:
                            pesoCad+=caracter+"";
                            break;
                    }
                }
                peso=Double.parseDouble(pesoCad); //convertimos la cadea on el peso en un double
                // Ya que terminamos de procesar una linea
                Elemento elem= new Elemento(nombre,simbolo,peso); //creamos al elemento
                // vemos si la posicion donde se pretende guardar esta libre o no
                if(mapaTP.isEmpty(simbolo)){
                    // si esta libre creamos una lista
                    DoubleLinkedList<Elemento> lista=new DoubleLinkedList<>();
                    // introducimos esta lista en el mapa 
                    mapaTP.put(simbolo,lista);
                    // Agregamos al elemento a la lista
                    lista.add(0,elem);
                }else{
                    // si la posicion no esta libre 
                    //accedemos a la lista en ella 
                    DoubleLinkedList<Elemento> lista = mapaTP.get(simbolo);
                    // Agregamos al nuevo elemento
                    lista.add(0,elem);
                }
                //this.toString(mapaTP.get(simbolo));
        }
            while((linea=lector1.readLine())!=null);
        }catch(FileNotFoundException fnfe){
            System.out.println(rojo+"\tNo se encontró el archivo");
        } catch(Exception e){
            System.out.println(rojo+"\tOcurrió un error en la lectura"+blanco);
        }
        //toString(mapaTP);
        return mapaTP;
        }

        public void toString(DoubleLinkedList<Elemento> lista){
            DoubleLinkedList<Elemento>.IteradorLista it=lista.listIterador();
            while(it.hasNext()){
                Elemento elem=it.next();
                if(elem.getSimbolo().equals("H")){
                    System.out.print(verde+elem.getPeso()+"  ");
                }
                System.out.print(elem.getNombre()+"   "+elem.getSimbolo()+", ");
                
            }
            System.out.println();
        }

        
        
        public static void main(String[] args) {
            Lector p1=new Lector();
            p1.convierteAmapa();
        }
    
}
