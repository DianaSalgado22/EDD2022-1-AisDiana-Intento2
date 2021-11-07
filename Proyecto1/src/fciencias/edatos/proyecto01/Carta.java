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
    // Representacio de la carta por delante, esta nunca cambi
    String repFija="";
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
                    this.repFija=black+"🂡 "+white;
                    break;
                case 2:
                    this.rep= black+"🂢 "+white;
                    this.repFija=black+"🂢 "+white;
                    break;
                case 3:
                    this.rep= black+"🂣 "+white;
                    this.repFija=this.rep;
                    break;
                case 4:
                    this.rep= black+"🂤 "+white;
                    this.repFija=this.rep;
                    break;
                case 5:
                    this.rep= black+"🂥 "+white;
                    this.repFija=this.rep;
                    break;
                case 6:
                    this.rep= black+"🂦 "+white;
                    this.repFija=this.rep;
                    break;
                case 7:
                    this.rep= black+"🂧 "+white;
                    this.repFija=this.rep;
                    break;
                case 8:
                    this.rep= black+"🂨 "+white;
                    this.repFija=this.rep;
                    break;
                case 9:
                    this.rep= black+"🂩 "+white;
                    this.repFija=this.rep;
                    break;
                case 10:
                    this.rep= black+"🂪 "+white;
                    this.repFija=this.rep;
                    break;
                case 11:
                    this.rep= black+"🂫 "+white;
                    this.repFija=this.rep;
                    break;
                case 12:
                    this.rep= black+"🂭 "+white;
                    this.repFija=this.rep;
                    break;
                case 13:
                    this.rep= black+"🂮 "+white;
                    this.repFija=this.rep;
                    break;
            }
        }
        if(palo.equals("Treboles")){
            switch (valor) {
                case 1:
                    this.rep= black+"🃑 "+white;
                    this.repFija=this.rep;
                    break;
                case 2:
                    this.rep= black+"🃒 "+white;
                    this.repFija=this.rep;
                    break;
                case 3:
                    this.rep= black+"🃓 "+white;
                    this.repFija=this.rep;
                    break;
                case 4:
                    this.rep= black+"🃔 "+white;
                    this.repFija=this.rep;
                    break;
                case 5:
                    this.rep= black+"🃕 "+white;
                    this.repFija=this.rep;
                    break;
                case 6:
                    this.rep= black+"🃖 "+white;
                    this.repFija=this.rep;
                    break;
                case 7:
                    this.rep= black+"🃗 "+white;
                    this.repFija=this.rep;
                    break;
                case 8:
                    this.rep= black+"🃘 "+white;
                    this.repFija=this.rep;
                    break;
                case 9:
                    this.rep= black+"🃙 "+white;
                    this.repFija=this.rep;
                    break;
                case 10:
                    this.rep= black+"🃚 "+white;
                    this.repFija=this.rep;
                    break;
                case 11:
                    this.rep= black+"🃛 "+white;
                    this.repFija=this.rep;
                    break;
                case 12:
                    this.rep= black+"🃝 "+white;
                    this.repFija=this.rep;
                    break;
                case 13:
                    this.rep= black+"🃞 "+white;
                    this.repFija=this.rep;
                    break;
            }
        }
        if(palo.equals("Corazones")){
            switch (valor) {
                case 1:
                    this.rep= red+"🂱 "+white;
                    this.repFija=this.rep;
                    break;
                case 2:
                    this.rep= red+"🂲 "+white;
                    this.repFija=this.rep;
                    break;
                case 3:
                    this.rep= red+"🂳 "+white;
                    this.repFija=this.rep;
                    break;
                case 4:
                    this.rep= red+"🂴 "+white;
                    this.repFija=this.rep;
                    break;
                case 5:
                    this.rep= red+"🂵 "+white;
                    this.repFija=this.rep;
                    break;
                case 6:
                    this.rep= red+"🂶 "+white;
                    this.repFija=this.rep;
                    break;
                case 7:
                    this.rep= red+"🂷 "+white;
                    this.repFija=this.rep;
                    break;
                case 8:
                    this.rep= red+"🂸 "+white;
                    this.repFija=this.rep;
                    break;
                case 9:
                    this.rep= red+"🂹 "+white;
                    this.repFija=this.rep;
                    break;
                case 10:
                    this.rep= red+"🂺 "+white;
                    this.repFija=this.rep;
                    break;
                case 11:
                    this.rep= red+"🂻 "+white;
                    this.repFija=this.rep;
                    break;
                case 12:
                    this.rep= red+"🂽 "+white;
                    this.repFija=this.rep;
                    break;
                case 13:
                    this.rep= red+"🂾 "+white;
                    this.repFija=this.rep;
                    break;
            }
        }
        if(palo.equals("Diamantes")){
            switch (valor) {
                case 1:
                    this.rep= red+"🃁 "+white;
                    this.repFija=this.rep;
                    break;
                case 2:
                    this.rep= red+"🃂 "+white;
                    this.repFija=this.rep;
                    break;
                case 3:
                    this.rep= red+"🃃 "+white;
                    this.repFija=this.rep;
                    break;
                case 4:
                    this.rep= red+"🃄 "+white;
                    this.repFija=this.rep;
                    break;
                case 5:
                    this.rep= red+"🃅 "+white;
                    this.repFija=this.rep;
                    break;
                case 6:
                    this.rep= red+"🃆 "+white;
                    this.repFija=this.rep;
                    break;
                case 7:
                    this.rep= red+"🃇 "+white;
                    this.repFija=this.rep;
                    break;
                case 8:
                    this.rep= red+"🃈 "+white;
                    this.repFija=this.rep;
                    break;
                case 9:
                    this.rep= red+"🃉 "+white;
                    this.repFija=this.rep;
                    break;
                case 10:
                    this.rep= red+"🃊 "+white;
                    this.repFija=this.rep;
                    break;
                case 11:
                    this.rep= red+"🃋 "+white;
                    this.repFija=this.rep;
                    break;
                case 12:
                    this.rep= red+"🃍 "+white;
                    this.repFija=this.rep;
                    break;
                case 13:
                    this.rep= red+"🃎 "+white;
                    this.repFija=this.rep;
                    break;
            }
        }
    }

    /** Metodo para cambiar la representación 
     *  de una carta.
     *  @param nueva representacion de la carta
     */
    public void setRep(String nueva){
        this.rep=nueva;
    }
    
    /** Metodo para saber si una carta esta volteada 
     *  @return true si esta volteado false si no.
     */
    public boolean isFlip(){
        return rep.equals("🂠");
    }

    /** Método para voltear una carta  
     */
    public void volter(){
        // Si esta volteado quiere decir que tiene rep=🂠
        if(this.isFlip()){
            // Para cambiar a la representacion de frente
            this.setRep(repFija);
        }else{
            // Si la representación no es rep=🂠
        this.setRep(green+"🂠");  // La volteamos
        }
    }
 
    /** Metodo para imprimir una carta
     *  @return el atributo rep de la carta.
     */
    public String toString(){
        return rep;
    }



}
