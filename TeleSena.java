import java.util.Arrays;

public class TeleSena{
    public TeleSena(){
        final double valVenda = 10.0;
        
    }
    
    private static boolean check(int[] array, int compare){
        //retorna true se o valor "compare" esta presente no array "array"
        // se nao retorna false
        for(int valor:array){
            if (valor == compare){
                return true;
            }
        }
        return false;
    }
    public static int[] sortear(int tamanho, int maxNum){
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
    
    public static int[][] criarTele(int numConjuntos, int tamanho, int maxNum){
        Utils u = new Utils();
        
        int[][] tele = new int[numConjuntos][tamanho];
        
        for (int i=0; i<numConjuntos; i++){
            tele[i] = u.sortear(tamanho, maxNum);
            Arrays.sort(tele[i]);
        }

        return tele;
    }
    
    public static void main(String[] args){
        System.out.println(Arrays.toString(criarTele(1, 25, 60)[0]));
        System.out.println(Arrays.toString(criarTele(1, 25, 60)[0]));
        System.out.println(Arrays.toString(criarTele(1, 25, 60)[0]));
    }
}