package fciencias.edatos.proyecto03;
import java.io.Serializable;
/**
 * Clase que implementa las operaciones sobre un arbol
 * binario de busqueda.
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */
public class BinarySearchTree<K extends Comparable<K>, T> 
  implements Serializable,TDABinarySearchTree<K, T>{
  
  static final long serialVersionUID = 2L;
  /**
   * Nodo para un árbol binario de búsqueda.
   */
  public class BinaryNode implements Serializable {
    static final long serialVersionUID = 4L;
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
    public BinaryNode(K key, T element, BinaryNode parent) {
      this.key = key;
      this.element = element;
      this.parent = parent;
    }

    /** Metodo para intercambiar el elemento de un nodo.
     *  @param e elemento por el que se cambiara.
     */
    public void setElement(T e) {
      this.element = e;
    }

    /** Metodo que intercambia los elementos de dos nodos
     *  @param a nodo a intercambiar con this.
     */
    public void swap(BinaryNode a) {
      // Variable auxiliar que guarda al elemento del nodo a.
      T elemA = a.element;
      // Se cambia el elemento del nodo a por el elemento del nodo con el que se llama.
      a.setElement(this.element);
      // Se cambia el elemento del nodo con el que se llama por el elemento del nodo a.
      this.setElement(elemA);
    }
  }

  /** Root */
  public BinaryNode root;

  public T getRootElement() {
    return root.element;
  }

  public BinaryNode getRoot() {
    return root;
  }

  //retrieve es como get
  @Override
  public T retrieve(K k) {
    BinaryNode node = retrieve(root, k);
    if (node == null) return null;
    return node.element;
  }

  public boolean contains(K k) {
    BinaryNode node = retrieve(root, k);
    if (node == null) return false;
    return true;
  }

  /** Metodo retrieve que se usara en delete
   *  @param k la clave que se quiere buscar
   *  @return el nodo con la clave deseada
   */
  public BinaryNode retrieveR(K k) {
    BinaryNode node = retrieve(root, k);
    if (node == null) return null;
    return node;
  }

  /** Metodo auxiliar del metodo retrieve.
   *  @param actual el nodo donde se empieza a buscar
   *  (Al usarse como auxiliar representa hasta donde se ha buscado).
   *  @param k la llave del nodo que se busca dentro del arbol.
   */
  private BinaryNode retrieve(BinaryNode actual, K k) {
    // No se encuentra el elemento
    if (actual == null) return null;

    // Si encontramos el elemento
    if (actual.key.compareTo(k) == 0) return actual;

    // Comparamos los elementos
    if (k.compareTo(actual.key) < 0) { // Verificamos en la izquierda
      return retrieve(actual.left, k);
    } else { // Verificar en la derecha
      return retrieve(actual.rigth, k);
    }
  }

  @Override
  public void insert(T e, K k) {
    // Si es vacío
    if (this.isEmpty()) {
      // Se crea el nodo binario y se asigna a la raiz del arbol.
      this.root = new BinaryNode(k, e, null);
      return; // se termina el metodo pues ya se inserto el elemento.
    }
    // Si no es vacio
    // Crear un nodo iterador que comience en la raíz
    BinaryNode iterador = this.root;
    // Invocar el método insert de tres parámetros
    insert(iterador, e, k);
  }

  /** Metodo auxiliar del metodo insert.
   *  @param actual el nodo hasta donde se esta buscando la posición en que se insertara el nodo.
   *  @param e el elemento del nodo que se insertara.
   *  @param k la llave del nodo que se insertara.
   */
  private void insert(BinaryNode actual, T e, K k) {
    // Comparamos las claves: la clave de actual con k. Con compareTo
    int i = actual.key.compareTo(k);
    // Si actualK >= k compareTo regresa un numero positivo o cero. SI K ES menor O = SE AGREGA A LA IZQ.
    if (i >= 0) {
      // Verificamos si el hijo izquierdo es null
      if (actual.left == null) {
        // Si sí insertamos el nuevo elemento como hijo izquierdo del actual.
        actual.left = new BinaryNode(k, e, actual);
        return; // se termina el metodo pues ya se inserto el elemento.
      }
      // Si no es null continuamos con la recursión sobre el hijo izquierdo
      insert(actual.left, e, k);
    }
    // Si actualK < k compareTo regresa un número negativo. SI K ES MAYOR SE AGREGA A LA DERECHA
    if (i < 0) {
      // Verificamos si el hijo derecho es null
      if (actual.rigth == null) {
        // Si sí insertamos el nuevo elemento como hijo derecho del actual.
        actual.rigth = new BinaryNode(k, e, actual);
        return; // se termina el metodo pues ya se inserto el elemento.
      }
      // Si no es null continuamos con la recursión sobre el hijo derecho
      insert(actual.rigth, e, k);
    }
  }

  @Override
  public T delete(K k) {
    // Se busca al nodo en el arbol con el metodo retireve.
    BinaryNode nodoPorBorrar = retrieveR(k); // regresa el nodo con la clave k o null.
    if (nodoPorBorrar == null) {
      /* Si el resultado de retrieve es null el elemento que
       * se quiere robar no se encuentrar en el arbol asi que
       * se regresa null. */
      return null;
    }
    // Variable que almacena al elemento con la clave k
    T elemento = nodoPorBorrar.element;

    // Casos que puede tener el nodo por borrar:

    //Cuando tiene dos hijos (Ninguno de sus hijos es null).
    if (nodoPorBorrar.left != null && nodoPorBorrar.rigth != null) {
      // Buscamos al maximo de los mínimos
      BinaryNode maxDmin = findMaxAux(nodoPorBorrar.left);
      // Eliminamos al max de los min pq si no hay conflictos con el retrieve
      delete(maxDmin.key);
      // hacemos un swap nodoPorBorrar con el maximo de los mínimos
      nodoPorBorrar.swap(maxDmin);
      // eliminar el nodo con el que se hizo swap
      return elemento;
    }

    // Cuando no tiene hijos (Ambos hijos son null). FUNCIONA
    if (nodoPorBorrar.left == null && nodoPorBorrar.rigth == null) {
      /* Si el nodo que se quiere borrar
       * es el unico nodo en el arbol,
       * entonces al borrarlo quedara un arbol vacio.
       */
      if (nodoPorBorrar.parent == null) {
        this.root = null; // En este caso root==nodoPorBorrar.
        return elemento;
      }

      // Verificar si es hijo izquierdo o es hijo derecho
      BinaryNode padre = nodoPorBorrar.parent; // Primero obtenemos al padre

      // Si es hijo izquierdo:
      if (padre.left == nodoPorBorrar) padre.left = null; // hacer null el izquierdo del padre
      // Si es hijo derecho
      if (padre.rigth == nodoPorBorrar) padre.rigth = null; // hacer null el derecho del padre
    }

    // Cuando solo tiene un hijo (Si uno de los dos no es null) FUNCIONA
    if (nodoPorBorrar.left != null || nodoPorBorrar.rigth != null) {
      // Checamos si tiene hijo izq o derecho:
      // Si el hijo izquierdo es null entonces tiene hijo derecho
      if (nodoPorBorrar.left == null) {
        //
        BinaryNode hijoD = nodoPorBorrar.rigth;
        // Si el nodo por borrar es la raiz
        if (nodoPorBorrar.parent == null) {
          this.root = hijoD; // al hijo lo convertimos en la raiz y terminamos
          return elemento;
        }
        // Si no es la raiz, tenemos que cambiar las referencias
        BinaryNode padreNb = nodoPorBorrar.parent;
        // El padre del nodo por borrar sera el nuevo padre del hijo
        hijoD.parent = padreNb;
        // Ahora tenemos que hacer que este se haga hijo del padre
        if (nodoPorBorrar.parent.left == nodoPorBorrar) {
          // el nodo por borrar es hijo izq
          padreNb.left = hijoD; // se hace el cambio y el nodo por borrar queda sin acceso
        } else {
          // el nodo por borrar es hijo derecho
          padreNb.rigth = hijoD; // se hace el cambio y el nodo por borrar queda sin acceso
        }
      } else { // Si el hijo izquierdo no es null entonces tiene hijo izq.
        //
        BinaryNode hijoI = nodoPorBorrar.left;
        // Si el nodo por borrar es la raiz
        if (nodoPorBorrar.parent == null) {
          this.root = hijoI; // al hijo lo convertimos en la raiz y terminamos
          root.parent = null;
          return elemento;
        }
        // Si no es la raiz, tenemos que cambiar las referencias
        BinaryNode padreNb = nodoPorBorrar.parent;
        // El padre del nodo por borrar sera el nuevo padre del hijo
        hijoI.parent = padreNb;
        // Ahora tenemos que hacer que este se haga hijo del padre
        if (nodoPorBorrar.parent.left == nodoPorBorrar) {
          // el nodo por borrar es hijo izq
          padreNb.left = hijoI; // se hace el cambio y el nodo por borrar queda sin acceso
        } else {
          // el nodo por borrar es hijo derecho
          padreNb.rigth = hijoI; // se hace el cambio y el nodo por borrar queda sin acceso
        }
      }
    }
    return elemento;
  }

  @Override
  public T findMin() {
    BinaryNode actual = root;
    //System.out.println("p"+actual.element);
    // Verificar que no sea vacío -> return null
    if (this.root == null) {
      return null;
    }
    return findMinAux(actual).element;
  }

  public BinaryNode findMinAux(BinaryNode actual) {
    // Mientras sí tenga hijo izquierdo -> Que actual se mueva al izquierdo
    if (!(actual.left == null)) {
      //System.out.println("p"+actual.element);
      //System.out.println("p");
      actual = actual.left;
      //System.out.println(actual.element);
      return findMinAux(actual);
    }
    // Ya encontramos al nodo con clave menor, asi que se regresa
    return actual;
  }

  @Override
  public T findMax() {
    BinaryNode actual = root;

    // Verificar que no sea vacío -> return null
    if (this.root == null) {
      return null;
    }
    return findMaxAux(actual).element;
  }

  public BinaryNode findMaxAux(BinaryNode actual) {
    // if(actual.left == null){
    // 	return actual.element;
    // }
    // Mientras sí tenga hijo derecho -> Que actual se mueva al derechoo
    if (!(actual.rigth == null)) {
      //System.out.println("p"+actual.element);
      //System.out.println("p");
      actual = actual.rigth;
      //System.out.println(actual.element);
      return findMaxAux(actual);
    }
    // Ya encontramos al nodo con clave menor
    return actual;
  }

  @Override
  public void preorden() {
    // Aplica preorden al derecho
    preOrdenAux(this.root);
  }

  public void preOrdenAux(BinaryNode actual) {
    //mientras el nodo actual no sea null
    if (actual != null) {
      // Primero verifica la raiz
      System.out.print(actual.element + " ");
      // Aplica preorden al izquierdo
      preOrdenAux(actual.left);
      // Aplica preorden al derecho
      preOrdenAux(actual.rigth);
    }
  }

  @Override
  public void inorden() {
    //Aplica inorden al izquierdo
    //verifica la raiz
    //Aplica inorden al derecho
    inordenAux(this.root);
  }

  public void inordenAux(BinaryNode actual) {
    //mientras el nodo actual no sea null
    if (actual != null) {
      // aplica inorden al  hijo izquierdo
      inordenAux(actual.left);
      //verifica la raiz
      System.out.print(actual.element + " ");
      // Aplica inorden al hijo derecho
      inordenAux(actual.rigth);
    }
  }

  @Override
  public void postorden() {
    postOrdenAux(this.root);
  }

  public void postOrdenAux(BinaryNode actual) {
    //mientras el nodo actual no sea null
    if (actual != null) {
      // aplica ipostordenal  hijo izquierdo
      postOrdenAux(actual.left);
      // Aplica postorden al hijo derecho
      postOrdenAux(actual.rigth);
      //verifica la raiz
      System.out.print(actual.element + " ");
    }
  }

  @Override
  public boolean isEmpty() {
    return this.root == null;
    // si root es igual a null esto es true y es true que es vacio.
  }
}

