package fciencias.edatos.practica03;

import java.util.Iterator;

/**
 * @version 1.0 Octubre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class DoubleLinkedList<T> implements TDAList<T> {

  // COLORES:
  String blue = "\033[34m";
  String green = "\033[32m";
  String yellow = "\033[33m";
  String red = "\033[31m";
  String cyan = "\033[36m";
  String white = "\u001B[0m";

  /**
   * Clase del Nodo de una lista.
   */
  private class Node {

    /** El elemento del nodo. */
    private T element;

    /** El nodo siguiente. */
    private Node next;

    /** El nodo anterior */
    private Node prev;

    /**
     * Crea un nuevo nodo.
     * @param element el elemento que almacena el nodo.
     */
    public Node(T element) {
      this.element = element;
    }

    /**
     * Permite cambiar el nodo siguiente.
     * @param newNode el nuevo nodo siguiente.
     */
    public void setNext(Node newNode) {
      this.next = newNode;
    }

    /**
     * Permite cambiar el nodo anterior.
     * @param newNode el nuevo nodo anterior.
     */
    public void setPrev(Node newNode) {
      this.prev = newNode;
    }

    /**
     * Accede a la información del nodo.
     * @return element.
     */
    public T getElement() {
      return element;
    }

    /**
     * Accede al nodo siguiente
     * @return next.
     */
    public Node getNext() {
      return next;
    }

    /**
     * Accede al nodo anterior
     * @return prev.
     */
    public Node getPrev() {
      return prev;
    }
  }

  

  /**
   * Clase que implementa iterator en una lista
   * doblemente ligada.
   */
  private class IteradorLista implements Iterator<T> {

    /**Punto de inicio del recorrido */
    private Node iteradorLista;

    /**
     * Crea un nuevo iterador.
     * @param cabeza de la lista para obtener todos los elementos
     */

    public IteradorLista(Node cabeza) {
      iteradorLista = new Node(null);
      iteradorLista.next = cabeza;
    }

    @Override
    public boolean hasNext() {
      return iteradorLista.next != null;
    }

    @Override
    public T next() {
      iteradorLista = iteradorLista.next;
      return iteradorLista.element;
    }
  }

  // Continua la clase sobre Listas doblemente ligadas:
  /** Cabeza de la lista. */
  private Node head;

  /*  Ultimo nodo de la lista */
  private Node tail;

  /** Longitud de la lista . */
  private int size;

  @Override
  public void add(int i, T e) throws IndexOutOfBoundsException {
    // Cuando i no está en los rangos definidos
    if (i > size || i < 0){
      System.out.println(yellow+"No se agrego porque el indice es invalido"+white);
       throw new IndexOutOfBoundsException();
    }

    Node nuevo = new Node(e);

    // Es vacía
    if (head == null) {
      head = nuevo;
      tail = nuevo;
      size++;
      return;
    }

    // Cuando se agrega al inicio
    if (i == 0) {
      nuevo.setNext(head);
      head.setPrev(nuevo);
      head = nuevo;
      size++;
      return;
    }
    // Cuando se agrega al final
    if (i == size) {
      nuevo.setPrev(tail);
      tail.setNext(nuevo);
      tail = nuevo;
      size++;
      return;
    }
    // Cuando se agrega en cualquier otra posición

    // Caso donde i esta mas cerca de head o en el medio.
    if (i <= size / 2) {
      Node iterador = head;
      /* Empezamos a recorrer desde head
       * hasta un nodo antes de la posición
       * deseada */
      for (int c = 0; c < i - 1; c++) iterador = iterador.getNext();
      // Acomodamos las referencias (flechas)
      nuevo.setNext(iterador.getNext());
      nuevo.setPrev(iterador);
      iterador.getNext().setPrev(nuevo);
      iterador.setNext(nuevo);
      // Aumentamos el tamaño y terminamos
      size++;
      return;
    }
    // Caso donde i esta mas cerca de tail (i>n/2).
    else {
      Node iterador = tail;
      /* Empezamos a recorrer desde tail
       * hasta el nodo de la posición deseada */
      for (int c = size - 1; c > i; c--) iterador = iterador.getPrev();
      // Acomodamos las referencias (flechas)
      nuevo.setNext(iterador);
      nuevo.setPrev(iterador.getPrev());
      iterador.getPrev().setNext(nuevo);
      iterador.setPrev(nuevo);
      // Aumentamos el tamaño y terminamos
      size++;
      return;
    }
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public boolean contains(T e) {
    int contador = 0;
    Node iterador1 = head; // Iterador #1 que inicia en cabeza.
    Node iterador2 = tail; // Iterador #2 que inicia en la cola.
    while (size / 2 > contador) {
      // Primera comparacion
      if (e.equals(iterador1.getElement())) return true;
      // Segunda comparacion
      if (e.equals(iterador2.getElement())) return true;
      // Si no se encuentra un match movemos los iteradores
      iterador1 = iterador1.getNext();
      iterador2 = iterador2.getPrev();
      // Aumentamos el contador de repeticiones
      contador++;
    }
    // Si no se encuentra
    return false;
  }

  @Override
  public T get(int i) throws IndexOutOfBoundsException {
    // Cuando i no está en los rangos definidos
    if (i >=size || i < 0) {
      System.out.println(yellow+"No se puede obtener el elemento porque el indice es invalido"+white);
      throw new IndexOutOfBoundsException();
    }
    // Caso donde i esta mas cerca de head o en el medio.
    if (i <= size / 2) {
      Node iterador = head;
      /* Empezamos a recorrer desde head
       * hasta el nodo de la posición deseada */
      for (int c = 0; c < i; c++) iterador = iterador.getNext();
      // Regresamos el elemento donde esta el iterador
      return iterador.getElement();
    }
    // Caso donde i esta mas cerca de tail (i>n/2).
    else {
      Node iterador = tail;
      /* Empezamos a recorrer desde tail
       * hasta el nodo de la posición deseada */
      for (int c = size - 1; c > i; c--) iterador = iterador.getPrev();
      return iterador.getElement();
    }
  }

  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public T remove(int i) throws IndexOutOfBoundsException {
    // Cuando i no está en los rangos definidos
    // o si la lista ya esta vacia.
    if (i >= size || i < 0 || head == null){
        System.out.println(yellow+"No se puede eliminar el elemento porque el indice es invalido"+white);
        throw new IndexOutOfBoundsException();
      } 

    if(size == 1){
      T retorno = head.getElement();
      this.clear();
      return retorno;
    }
    // Para eliminar la cabeza
    if (i == 0) {
      T aux = head.getElement(); //primero guardamos el elemento
      head = head.getNext();
      head.setPrev(null);
      size--; // Se actualiza el tamaño
      return aux;
    }
    // Para eliminar el ultimo elemento
    if (i == size - 1) {
      T aux = tail.getElement();
      tail = tail.getPrev();
      tail.setNext(null);
      size--; // Se actualiza el tamaño
      return aux; // Se regresa el elemento eliminado
    }

    // Cualquier otra posicion
    // Caso donde i esta mas cerca de head o en el medio.
    if (i <= size / 2) {
      Node iterador = head;
      /* Empezamos a recorrer desde head
       * hasta el nodo de la posición deseada */
      for (int c = 0; c < i; c++) iterador = iterador.getNext();
      // Guardamos el elemento que se eliminara
      T aux = iterador.getElement();
      // Acomodamos las referencias (flechas)
      iterador.getPrev().setNext(iterador.getNext());
      iterador.getNext().setPrev(iterador.getPrev());
      // Disminuimos el tamaño y regresamos el elemento eliminado
      size--;
      return aux;
    }
    // Caso donde i esta mas cerca de tail (i>n/2).
    else {
      Node iterador = tail;
      /* Empezamos a recorrer desde tail
       * hasta el nodo de la posición deseada */
      for (int c = size - 1; c > i; c--) iterador = iterador.getPrev();
      // Guardamos el elemento que se eliminara
      T aux = iterador.getElement();
      // Acomodamos las referencias (flechas)
      iterador.getPrev().setNext(iterador.getNext());
      iterador.getNext().setPrev(iterador.getPrev());
      // Disminuimos el tamaño y regresamos el elemento eliminado
      size--;
      return aux;
    }
  }

  public int size() {
    return size;
  }

  public void revert() {
    if (size == 0 || size == 1) return;

    Node iterador1 = head;
    Node iterador2 = tail;
    T leftAux = iterador1.element;
    iterador1.element = iterador2.element;
    iterador2.element = leftAux;

    //  System.out.println(size()/2);

    for (int i = 1; i < (size / 2); i++) {
      // System.out.println(i);
      iterador1 = iterador1.next;
      iterador2 = iterador2.prev;
      leftAux = iterador1.element;
      iterador1.element = iterador2.element;
      iterador2.element = leftAux;
    }
  } //tiempo n/2

  public TDAList cut(boolean side) {
    DoubleLinkedList<T> listaAux = new DoubleLinkedList<>();
    //derecha

    if (side) {
      Node iterador = tail;
      //int i;
      int aux = 0;
      int k = (size % 2 == aux) ? (size / 2) - 1 : (size / 2);
      // System.out.println(i);

      for (int i = k; i >= 0; i--) {
        // System.out.println(blue+iterador.elemento+white);
        listaAux.add(0, iterador.element);
        iterador = iterador.prev;
      }
      /* 

            System.out.println(blue+"show");
            lista.show();
            System.out.print(white+""); */
      return listaAux;
    }

    Node iterador = head;
    for (int i = 0; i < size() / 2; i++) {
      listaAux.add(i, iterador.element);
      iterador = iterador.next;
    }
    return listaAux;
  }

  public String toString() {
    Node iterador = head;
    String cadena = "";
    for (int i = 0; i < size; i++) {
      cadena = cadena + iterador.element + " ";
      iterador = iterador.next;
    }
    return cadena;
  }

  public Iterator listIterador() {
    return new IteradorLista(this.head);
  }
}