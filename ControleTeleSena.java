import java.util.Arrays;
/**
 * Escreva uma descrição da classe ControleTeleSena aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ControleTeleSena{
    static final int numPessoas = 20; //default: 20
    static final int numConjuntos = 2; //default: 2
    static final int tamanhoTele = 25; //default: 25
    static final int maxNumTele = 60; //default: 60
    Utils u = new Utils();
    
    public ControleTeleSena(){
        int numTeles;
        int totalNumTeles = 0;
        int rodadas = 0;
        int[] numsSorteados = u.sortear(maxNumTele, maxNumTele);//começa em 60 numeros
        
        System.out.println("1: "+Arrays.toString(numsSorteados));
        
        
        Pessoa[] pessoas = new Pessoa[numPessoas];
        
        String[] nomes = randomNome(numPessoas);
        
        //Criar pessoas
        for(int p=0; p<numPessoas; p++){
            numTeles = (int) (Math.random() * 15) + 1; // 1 -> 15
            totalNumTeles += numTeles;
            
            pessoas[p] = new Pessoa(nomes[p], numTeles, totalNumTeles * 10);
        }
        
        for (int i = 25; i< numsSorteados.length; i++){
            int posGanhador = verificarGanhador(pessoas, Arrays.copyOfRange(numsSorteados,0, i));
            if(posGanhador > -1){
                break;
            }
            System.out.println("rodadas: "+rodadas);
            rodadas ++;
        }
        
        System.out.println(pessoas[verificarGanhador(pessoas, numsSorteados)].getNome());
        System.out.println(rodadas);
    }
    
    private String[] randomNome(int numPessoas){
        
        String[] nomes = {"Joao","Carlos","Alice","Jurema","Matheus","Julia",
                          "Gabriela","Robson","Pedro","Karen","Fofao","Fabio",
                          "Lorenzo","Caroline","Leticia","Junior","Ronaldo",
                          "Richard","Helen","Katia","Roberta","Cleiton","Ana"};
                          
        int[] randIndex = u.sortear(numPessoas, nomes.length);
        String[] randNomes = new String[numPessoas];
        
        for(int i=0; i<numPessoas; i++)
            randNomes[i] = nomes[randIndex[i] -1];
            
        return randNomes;
    }
    
    public int verificarGanhador(Pessoa[] pessoas, int[] numsSorteados){
        int pessoaIndex = 0;
        for(Pessoa p: pessoas)//para cada pessoa em array de pessoas
            for(int[][] teles: p.getTeles())//para cada telesena de cada pessoa
                for(int[] conj: teles)//para cada conjunto em cada telesena(2 conjuntos para cada)
                    if (u.estaEm(conj, numsSorteados))
                        return pessoaIndex;
            pessoaIndex += 1;
        return -1;//Sem vencedores
    }
    
    public static void main(String[] args){
        ControleTeleSena cts = new ControleTeleSena();
        
        
    }
    public int getNumConjuntos(){
        return numConjuntos;
    }
    public int getTamanhoTele(){
        return tamanhoTele;
    }
    public int getMaxNumTele(){
        return maxNumTele;
    }

}