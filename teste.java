import java.util.*;
/**
 * Escreva uma descrição da classe teste aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class teste{
    public static void main(String[] args){
        int rand = -1;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        
        System.out.println("\n\n\n");
        
        for(int i =0; i<1000; i++){
            rand = (int) (Math.random()*4);
            if(rand == 0)
                a += 1;
            else if(rand == 1)
                b += 1;
            else if(rand == 2)
                c += 1;
            else if(rand == 3)
                d += 1;
            else
                System.out.println("ERROOOOO, deu "+rand);
            }
                
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("c: "+c);
        System.out.println("d: "+d);
    }           
}
