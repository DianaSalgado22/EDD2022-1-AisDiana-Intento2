package fciencias.edatos.practica03;

import java.util.EmptyStackException;

/**
 * @version 1.0 Octubre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class Stack<T> implements TDAStack<T> {

    /** Lista base */
    public DoubleLinkedList<T> list= new DoubleLinkedList<>();

    @Override
    public void clear(){
        list.clear();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public T pop() throws EmptyStackException{
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.remove(0);
    }

    @Override
    public void push(T e){
        list.add(0,e);
    }

    @Override
    public T top() throws EmptyStackException{
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.get(0);
    }

    /**
     * Muestra la representación de una pila
     */
    public String toString(){
        return list.toString();
    } 

    /**  Pruebitas de clase Stack
    public static void main(String[] args){
        TDAStack<String> pila1=new Stack<>();
        pila1.push("Entrada 1");
        System.out.println(pila1.toString()+" \n");
        pila1.push("Entrada 2");
        pila1.push("Entrada 3");
        pila1.push("Entrada 4");
        pila1.push("Entrada 5");
        System.out.println(pila1.toString()+"\n");
        System.out.println(pila1.top()+" Deberia ser un E5\n "); 
        System.out.println(pila1.isEmpty()+" Deberia ser false\n ");
        pila1.pop(); 
        System.out.println(pila1.toString()+"\n");
    }
    */
    
}