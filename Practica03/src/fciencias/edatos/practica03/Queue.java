package fciencias.edatos.practica03;

import java.util.LinkedList;

/**
 * Implementación de una colas basada en una lista oblemente ligada.
 *  Implementa las operaciones del TDAQueue.
 * @author Emmanuel Cruz Hernández.
 * @version 1.0 Octubre 2021.
 * @since Estructuras de datos 2021-2.
 */
public class Queue<T> implements TDAQueue<T>{

    /** Lista */
    private DoubleLinkedList<T> list = new DoubleLinkedList<T>();

    @Override
    public void clear(){
        list.clear();
    }

    @Override
    public T dequeue(){
        if(list.isEmpty())
            return null;
        return list.remove(0);
    }

    @Override
    public void enqueue(T e){
        list.add(list.size(), e);
    }

    @Override
    public T first(){
        if(list.isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

}