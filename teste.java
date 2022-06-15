import java.util.*;
/**
 * Escreva uma descrição da classe teste aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class teste{
    public static void main(String[] args){
        Utils u = new Utils();
        
        int[] a = new int[] {1,2,3,4,5,34};
        int[] b = new int[] {1,5,2,3,7,4,9};
        
        System.out.println(u.estaEm(a, b));
        
        System.out.println(Arrays.toString(Arrays.copyOfRange(b, 0, 4)));
    }
}
