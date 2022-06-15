import java.util.*;

public class Utils{
    public boolean check(int[] array, int compare){
        //retorna true se o valor "compare" esta presente no array "array"
        // se nao retorna false
        for(int valor:array){
            if (valor == compare){
                return true;
            }
        }
        return false;
    }
    
    public int[] sortear(int tamanho, int maxNum){
        int[] arr = new int[tamanho];
        int j;
        
        for (int i=0; i<tamanho; i++){
            j = -1;
            while(j == -1 || check(arr, j)){
                //enquanto j for -1 ou j estar em <arr>, mudar j
                j = (int) (Math.random()*maxNum + 1); //1 => maxNum
            }
            arr[i] = j;
        }
        return arr;
    }
    
    public boolean estaEm(int[] inner, int[] outer){
        for(int i=0; i<inner.length; i++){
            if(!check(outer, inner[i])){
                return false;
            }
        }
        return true;
    }
}
