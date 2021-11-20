/**
 * Clase que implementa las operaciones sobre un arbol
 * binario de busqueda.
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class BinarySearchTree<K extends Comparable<K>, T> implements TDABinarySearchTree<K, T>{
	
	/**
	 * Nodo para un árbol binario de búsqueda.
	 */
	public class BinaryNode{

		/** Clave. */
		public K key;

		/** Elemento. */
		public T element;

		/** Padre del nodo. */
		public BinaryNode parent;

		/** Hijo izquierdo. */
		public BinaryNode left;

		/** Hijo derecho. */
		public BinaryNode rigth;

		/**
		 * Crea un nuevo nodo.
		 * @param key la clave.
		 * @param element el elemento a almacenar.
		 * @param parent el padre del nodo.
		 */
		public BinaryNode(K key, T element, BinaryNode parent){
			this.key = key;
			this.element = element;
			this.parent = parent;
		}
	}

	/** Root */
	private BinaryNode root;

	@Override
	public T retrieve(K k){
		BinaryNode node = retrieve(root, k);
		if(node == null)
			return null;
		return node.element;
	}

    /** Metodo auxiliar del metodo retrieve.
     *  @param actual el nodo donde se empieza a buscar 
     *  (Al usarse como auxiliar representa hasta donde se ha buscado).
     *  @param k la llave del nodo que se busca dentro del arbol.
     */
	private BinaryNode retrieve(BinaryNode actual, K k){
		// No se encuentra el elemento
		if(actual == null)
			return null;

		// Si encontramos el elemento
		if(actual.key.compareTo(k) == 0)
			return actual;

		// Comparamos los elementos
		if(k.compareTo(actual.key) < 0){ // Verificamos en la izquierda
			return retrieve(actual.left, k);
		} else { // Verificar en la derecha
			return retrieve(actual.rigth, k);
		}
	}

	@Override
	public void insert(T e, K k){
		// Si es vacío 
        if(this.isEmpty()){
            // Se crea el nodo binario y se asigna a la raiz del arbol.
            this.root= new BinaryNode(k,e,null); 
            return; // se termina el metodo pues ya se inserto el elemento.
        }
        // Si no es vacio
		// Crear un nodo iterador que comience en la raíz
        BinaryNode iterador= this.root;
		// Invocar el método insert de tres parámetros
        insert(iterador,e,k);
	}
	
    /** Metodo auxiliar del metodo insert.
     *  @param actual el nodo hasta donde se esta buscando la posición en que se insertara el nodo.
     *  @param e el elemento del nodo que se insertara.
     *  @param k la llave del nodo que se insertara.
     */
	private void insert(BinaryNode actual, T e, K k){
		// Comparamos las claves: la clave de actual con k. Con compareTo
        int i = actual.key.compareTo(k);
		// Si la clave es menor compareTo regresa un número negativo.
        if(i<0){
            // Verificamos si el hijo izquierdo es null
            if(actual.left==null){
                // Si sí insertamos el nuevo elemento como hijo izquierdo del actual.
                actual.left = new BinaryNode(k,e,actual);
                return; // se termina el metodo pues ya se inserto el elemento.
            }
            // Si no es null continuamos con la recursión sobre el hijo izquierdo
            insert(actual.left,e,k);
        }
		// Si la clave es mayor o igual compareTo regresa un numero positivo o cero
        if(i>=0){
            // Verificamos si el hijo derecho es null
            if(actual.rigth==null){
                // Si sí insertamos el nuevo elemento como hijo derecho del actual.
                actual.rigth = new BinaryNode(k,e,actual);
                return; // se termina el metodo pues ya se inserto el elemento.
            }
            // Si no es null continuamos con la recursión sobre el hijo derecho
            insert(actual.rigth,e,k);
        }	
	}

	@Override
	public T delete(K k){
		// Se busca al nodo en el arbol con el metodo retireve.
		BinaryNode nodoPorBorrar=retrieve(root,k); // regresa el nodo con la clave k o null.
		if(nodoPorBorrar==null){
			/* Si el resultado de retrieve es null el elemento que 
			 * se quiere robar no se encuentrar en el arbol asi que 
			 * se regresa null. */
			return null;
		}
		// Variable que almacena al elemento con la clave k
		T elemento= nodoPorBorrar.element;
		
		// Casos que puede tener el nodo por borrar:
		
		//Cuando tiene dos hijos (Ninguno de sus hijos es null).
		if(nodoPorBorrar.left!=null && nodoPorBorrar.rigth!=null){
			// Buscamos al maximo de los mínimos
			// hacemos un swap actual con el maximo de los mínimos
			// eliminar el nodo con el que se hizo swap
		}

		// Cuando no tiene hijos (Ambos hijos son null).
		if(nodoPorBorrar.left==null && nodoPorBorrar.rigth==null){
			// Verificar si es hijo izquierdo o es hijo derecho
			// Si es hijo izquiero hacer null el izquierdo del padre
			// Si es hijo derecho hacer null el derecho del padre
		}
		
		// Cuando solo tiene un hijo (Si uno de los dos no es null)
		if(nodoPorBorrar.left!=null || nodoPorBorrar.rigth!=null){
			// Swap con el hijo, ya sea derecho o izquierdo
			// Borramos al hijo con el que se hizo swap. Podemos hacer null a ambos hijos
		}
		return null;
	}

	@Override
	public T findMin(){
		// Verificar que no sea vacío -> return null
		// Mientras sí tenga hijo izquierdo -> Que actual se mueva al izquierdo
		// Ya encontramos al nodo con clave menor
		return null;
	}

	@Override
	public T findMax(){
		return null;
	}

	@Override
	public void preorden(){
		// Primero verifica la raiz
		// Aplica preorden al izquierdo
		// Aplica preorden al derecho
	}

	@Override
	public void inorden(){}

	@Override
	public void postorden(){}

	@Override 
    public boolean isEmpty(){
        return this.root==null // si root es igual a null esto es true y es true que es vacio.
    }

	public static void main(String[] args) {

	}
}