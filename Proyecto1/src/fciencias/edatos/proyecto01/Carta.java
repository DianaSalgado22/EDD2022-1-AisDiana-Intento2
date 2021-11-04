package fciencias.edatos.proyecto01;
import java.io.IOException;
import java.util.Arrays;
/**
 * @version 1.0 Noviembre 2021.
 * @author Salgado Tirado Diana Laura
 * @author Celic Aislinn Liahut Ley
 * @since Estructuras de Datos 2022-1
 */

public class Carta{
    // COLORES                                                               
    String green = "\033[32m";
    String white = "\u001B[0m";
    String purple = "\033[35m";
    String blue = "\033[34m";
    String yellow= "\033[33m";
    String red =  "\u001B[31m";  
    String black = "\033[30m";



    // Palo --> es la figura de la carta
    String palo="";
    // Valor --> El número de la carta
    int valor=0; 
    // Representación de la carta en consola
    String rep="";


// POSIBLEMENTE HACER ESTAS UN METODO
    // Posible valores del palo
    String posiblesPalos="Picas,Corazones,Diamantes,Treboles";
    // Posible valores de valor
    String posiblesValor="1,2,3,4,5,6,7,8,9,10,11,12,13";

    /** Metodo para crear una nueva carta.
     *  @param palo la figura de la carta.
     *  @param valor el número de la carta.
     *  @return La carta
     */
    public Carta(String palo,int valor){
        this.palo=palo;
        this.valor=valor;
        if(palo.equals("Picas")){
            switch (valor){
                case 1:
                    this.rep= black+"🂡 "+white;
                    
                case 2:
                    this.rep= black+"🂢 "+white;
                    
                case 3:
                    this.rep= black+"🂣 "+white;
                    
                case 4:
                    this.rep= black+"🂤 "+white;
                    
                case 5:
                    this.rep= black+"🂥 "+white;
                    
                case 6:
                    this.rep= black+"🂦 "+white;
                    
                case 7:
                    this.rep= black+"🂧 "+white;
                    
                case 8:
                    this.rep= black+"🂨 "+white;
                    
                case 9:
                    this.rep= black+"🂩 "+white;
                    
                case 10:
                    this.rep= black+"🂪 "+white;
                    
                case 11:
                    this.rep= black+"🂫 "+white;
                    
                case 12:
                    this.rep= black+"🂭 "+white;
                    
                case 13:
                    this.rep= black+"🂮 "+white;
                    
            }
        }
        if(palo.equals("Treboles")){
            switch (valor) {
                case 1:
                    this.rep= black+"🃑 "+white;
                    
                case 2:
                    this.rep= black+"🃒 "+white;
                    
                case 3:
                    this.rep= black+"🃓 "+white;
                    
                case 4:
                    this.rep= black+"🃔 "+white;
                    
                case 5:
                    this.rep= black+"🃕 "+white;
                    
                case 6:
                    this.rep= black+"🃖 "+white;
                    
                case 7:
                    this.rep= black+"🃗 "+white;
                    
                case 8:
                    this.rep= black+"🃘 "+white;
                    
                case 9:
                    this.rep= black+"🃙 "+white;
                    
                case 10:
                    this.rep= black+"🃚 "+white;
                    
                case 11:
                    this.rep= black+"🃛 "+white;
                    
                case 12:
                    this.rep= black+"🃝 "+white;
                    
                case 13:
                    this.rep= black+"🃞 "+white;
                    
            }
        }
        if(palo.equals("Corazones")){
            switch (valor) {
                case 1:
                    this.rep= red+"🂱 "+white;
                    
                case 2:
                    this.rep= red+"🂲 "+white;
                    
                case 3:
                    this.rep= red+"🂳 "+white;
                    
                case 4:
                    this.rep= red+"🂴 "+white;
                    
                case 5:
                    this.rep= red+"🂵 "+white;
                    
                case 6:
                    this.rep= red+"🂶 "+white;
                    
                case 7:
                    this.rep= red+"🂷 "+white;
                    
                case 8:
                    this.rep= red+"🂸 "+white;
                    
                case 9:
                    this.rep= red+"🂹 "+white;
                    
                case 10:
                    this.rep= red+"🂺 "+white;
                    
                case 11:
                    this.rep= red+"🂻 "+white;
                    
                case 12:
                    this.rep= red+"🂽 "+white;
                    
                case 13:
                    this.rep= red+"🂾 "+white;
                    
            }
        }
        if(palo.equals("Diamantes")){
            switch (valor) {
                case 1:
                    this.rep= red+"🃁 "+white;
                    
                case 2:
                    this.rep= red+"🃂 "+white;
                    
                case 3:
                    this.rep= red+"🃃 "+white;
                    
                case 4:
                    this.rep= red+"🃄 "+white;
                    
                case 5:
                    this.rep= red+"🃅 "+white;
                    
                case 6:
                    this.rep= red+"🃆 "+white;
                    
                case 7:
                    this.rep= red+"🃇 "+white;
                    
                case 8:
                    this.rep= red+"🃈 "+white;
                    
                case 9:
                    this.rep= red+"🃉 "+white;
                    
                case 10:
                    this.rep= red+"🃊 "+white;
                    
                case 11:
                    this.rep= red+"🃋 "+white;
                    
                case 12:
                    this.rep= red+"🃍 "+white;
                    
                case 13:
                    this.rep= red+"🃎 "+white;
                    
            }
        }
    }
    

    public String toString(){
        if(palo.equals("Picas")){
            switch (valor){
                case 1:
                    return black+"🂡 "+white;
                    
                case 2:
                    return black+"🂢 "+white;
                    
                case 3:
                    return black+"🂣 "+white;
                    
                case 4:
                    return black+"🂤 "+white;
                    
                case 5:
                    return black+"🂥 "+white;
                    
                case 6:
                    return black+"🂦 "+white;
                    
                case 7:
                    return black+"🂧 "+white;
                    
                case 8:
                    return black+"🂨 "+white;
                    
                case 9:
                    return black+"🂩 "+white;
                    
                case 10:
                    return black+"🂪 "+white;
                    
                case 11:
                    return black+"🂫 "+white;
                    
                case 12:
                    return black+"🂭 "+white;
                    
                case 13:
                    return black+"🂮 "+white;
                    
            }
        }
        if(palo.equals("Treboles")){
            switch (valor) {
                case 1:
                    return black+"🃑 "+white;
                    
                case 2:
                    return black+"🃒 "+white;
                    
                case 3:
                    return black+"🃓 "+white;
                    
                case 4:
                    return black+"🃔 "+white;
                    
                case 5:
                    return black+"🃕 "+white;
                    
                case 6:
                    return black+"🃖 "+white;
                    
                case 7:
                    return black+"🃗 "+white;
                    
                case 8:
                    return black+"🃘 "+white;
                    
                case 9:
                    return black+"🃙 "+white;
                    
                case 10:
                    return black+"🃚 "+white;
                    
                case 11:
                    return black+"🃛 "+white;
                    
                case 12:
                    return black+"🃝 "+white;
                    
                case 13:
                    return black+"🃞 "+white;
                    
            }
        }
        if(palo.equals("Corazones")){
            switch (valor) {
                case 1:
                    return red+"🂱 "+white;
                    
                case 2:
                    return red+"🂲 "+white;
                    
                case 3:
                    return red+"🂳 "+white;
                    
                case 4:
                    return red+"🂴 "+white;
                    
                case 5:
                    return red+"🂵 "+white;
                    
                case 6:
                    return red+"🂶 "+white;
                    
                case 7:
                    return red+"🂷 "+white;
                    
                case 8:
                    return red+"🂸 "+white;
                    
                case 9:
                    return red+"🂹 "+white;
                    
                case 10:
                    return red+"🂺 "+white;
                    
                case 11:
                    return red+"🂻 "+white;
                    
                case 12:
                    return red+"🂽 "+white;
                    
                case 13:
                    return red+"🂾 "+white;
                    
            }
        }
        if(palo.equals("Diamantes")){
            switch (valor) {
                case 1:
                    return red+"🃁 "+white;
                    
                case 2:
                    return red+"🃂 "+white;
                    
                case 3:
                    return red+"🃃 "+white;
                    
                case 4:
                    return red+"🃄 "+white;
                    
                case 5:
                    return red+"🃅 "+white;
                    
                case 6:
                    return red+"🃆 "+white;
                    
                case 7:
                    return red+"🃇 "+white;
                    
                case 8:
                    return red+"🃈 "+white;
                    
                case 9:
                    return red+"🃉 "+white;
                    
                case 10:
                    return red+"🃊 "+white;
                    
                case 11:
                    return red+"🃋 "+white;
                    
                case 12:
                    return red+"🃍 "+white;
                    
                case 13:
                    return red+"🃎 "+white;
                    
            }
        }
        return "";
    }



}
