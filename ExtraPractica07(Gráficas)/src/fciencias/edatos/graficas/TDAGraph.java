package fciencias.edatos.graficas;
import java.util.ArrayList;
/**
* Se definen las operaciones que se pueden hacer sobre graficas.
* @author Liahut Ley Celic Aislinn.
* @author Salgado Tirado Diana Laura.
* @version 19.0 Enero 2021.
* @since Estructuras de Datos 2021-1.
*/
public interface TDAGraph<V, E>{

    /**
	* Representación de una arista.
	*/
	public class Arista<V, E>{

		/** Identificador de la arista. */
		private E id;

		/** Primer vertice partida o inicio de la arista. */
		private V startVertex;

		/** Segundo vertice  llegado o vertice final de la arista. */
		private V endVertex;

		/**
		* Crea una nueva arista.
		* @param name el nombre de la arista.
		* @param startVertex el primer vertice de adyacencia.
		* @param endVertex el segundo vertice de adyacencia.
		*/
		public Arista(E name, V startVertex, V endVertex){
			this.id = name;
			this.startVertex = startVertex;
			this.endVertex = endVertex;
		}

		/**
		* Crea una nueva arista.
		* @param startVertex el primer vertice de adyacencia.
		* @param endVertex el segundo vertice de adyacencia.
		*/
		public Arista(V startVertex, V endVertex){
			this.startVertex = startVertex;
			this.endVertex = endVertex;
		}

		/**
		* Regresa el identificador de la arista.
		* @return el id de la arista.
		*/
		public E getId(){
			return id;
		}

		/**
		* Regresa el primer vertice de la arista.
		* @return el primer vertice.
		*/
		public V getStartVertex(){
			return startVertex;
		}

		/**
		* Regresa el segundo vertice de la arista.
		* @return el segundo vertice.
		*/
		public V getEndVertex(){
			return endVertex;
		}

		/**
		* Verifica si dos vertices conforman la arista.
		* @param startVertex el primer vertice a verificacion.
		* @param endVertex el segundo vertice a verificacion.
		* @return true si ambos vertices conforman la arista, false en otro caso.
		*/
		public boolean isContained(V startVertex, V endVertex){
			return (this.startVertex.equals(startVertex) || this.endVertex.equals(startVertex) ) && 
				(this.startVertex.equals(endVertex) || this.endVertex.equals(endVertex));
		}

		public boolean isEdge(V startVertex, V endVertex){
			return startVertex.equals(this.startVertex) && endVertex.equals(this.endVertex);
		}

		public boolean isContained(V v){
			return v.equals(startVertex) || v.equals(endVertex);
		}

		public boolean isSame(E e){
			return e.equals(id);
		}

        
	}

 
    /**Agrega una arista entre el vertice startVertex y endVertex
     * @param startVertex vertice de inicio de la arista
     * @param endVertex vértice de llegada de la arista
     */
    public void addEdge(V startVertex, V endVertex);

    /**
	* Elimina un vertice de la grafica.
	* @param e la arista a  eliminar de la grafica.
	* @return el valor almacenado en el vertice o null si no existe.
	*/
	public Arista<V,E> removeEdge(V v1, V v2);


   
    /** Obtiene la lista de adyacencias de un vertice
    */
    public ArrayList<V> getListOfAdjacencies(V v);

    /**
     * Imprime la mátriz de adyacencia asociada a la gráfica 
     */
    public void printGraph();

    /**Recorre los elementos de la gráfica con BFS */
    public void BFSpath();
    
}