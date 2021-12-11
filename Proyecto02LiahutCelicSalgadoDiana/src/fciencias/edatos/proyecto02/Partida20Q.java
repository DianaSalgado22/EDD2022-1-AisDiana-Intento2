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
import java.io.IOException;

/**
 * Clase que implementa el juego de las 20 preguntas.
 * @version 1. Diciembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class Partida20Q{
    
    public static void main(String[] args){
        
      // esto es como para escribir en el doc y lo que use para crearlos
      /* 
        // Creamos al nuevo arbol
        BinaryTree a1= new BinaryTree();
        // Insertamos 
        a1.insertFirst("¿La persona en la que estas pensando forma parte de un grupo o banda?","Tyler Joseph","Ariana Grande");


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
         */
      
      // aqui es ya donde se pueden hacer cosas
        try{
            // Creamos a un objeto que tenga al aarchivo de nuestr arbol
            FileInputStream fileIn=new FileInputStream("ArbolCantantes.ser");
            // Este es el que procesa los datos
            ObjectInputStream entrada=new ObjectInputStream(fileIn);
            // Guardamos al arbol 
            BinaryTree a1=(BinaryTree)entrada.readObject();
            // Hacemos las operaciones que queremos
            a1.preorden();
            
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
}