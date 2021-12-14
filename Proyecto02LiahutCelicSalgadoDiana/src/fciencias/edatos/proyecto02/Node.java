package fciencias.edatos.proyecto02;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.Serializable;
import java.util.Scanner;

/** Nodo para un árbol binario.
 * @version 1. Diciembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
	public class Node implements Serializable{

		/** Elemento. */
		public String element;

		/** Padre del nodo. */
		public Node parent;

		/** Hijo izquierdo. */
		public Node left;

		/** Hijo derecho. */
		public Node rigth;

		/** Hora y fecha de creación del nodo */
		public String horaFecha;

		/**
		 * Crea un nuevo nodo.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 */
		public Node(String element, Node parent){
			this.element = element;
			this.parent = parent;
			this.horaFecha=getHoraFecha();
		}

		/** Metodo para intercambiar el elemento de un nodo.
		 *  @param e elemento por el que se cambiara.
		 */
		public void setElement(String e){
			this.element=e;
		}

		/** Metodo que intercambia los elementos de dos nodos
		 *  @param a nodo a intercambiar con this.
		 */
		public void swap(Node a){
			// Variable auxiliar que guarda al elemento del nodo a.
			String elemA= a.element;
			// Se cambia el elemento  del nodo a por el elemento del nodo con el que se llama.
			a.setElement(this.element);
			// Se cambia el elemento del nodo con el que se llama por el elemento del nodo a.
			this.setElement(elemA);
		}

		/** MEtodo que obtien la fecha y la hora actual
		 *  @return horaFecha */
		public String getHoraFecha(){
			return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		}


		/** Metodo para saber si un nodo es una hoja o no
		 *  @return un booleano true si es hoja, false en otro caso
		 */
		public boolean isLeaf(){
			return this.left==null && this.rigth==null;
		}
	}

	