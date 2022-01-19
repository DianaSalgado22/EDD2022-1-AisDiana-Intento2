package fciencias.edatos.practica07;
// Clase de un elemento quimico
    public class Elemento{
        // Nombre del elemento
        String nombre;
        // Simbolo
        String simbolo;
        // Peso atomico
        double peso;
        
        public Elemento(String nombre,String simbolo,double peso){
            this.nombre=nombre;
            this.simbolo=simbolo;
            this.peso=peso;
        } 
        /** Metodo que obtiene el nombre de un elemento
         * @return el nombre
         */ 
        public String getNombre(){
            return this.nombre;
        } 
        /** Metodo que obtiene al peso de un elemento
         * @return el peso
         */
        public double getPeso(){
            return this.peso;
        }        
        /** Metodo que obtiene el simbolo de un elemento
         * @return el simbolo
         */ 
        public String getSimbolo(){
            return this.simbolo;
        } 

        
    }
