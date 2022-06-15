import java.util.Arrays;
/**
 * Escreva uma descrição da classe Pessoa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Pessoa{
    String nome;
    int numTeles;
    int valPrem;
    int[][][] teles;
    
    int numConjuntos = ControleTeleSena.numConjuntos;
    int tamanhoTele = ControleTeleSena.tamanhoTele;
    int maxNumTele = ControleTeleSena.maxNumTele;
    
    public Pessoa(String nome, int numTeles, int valPrem){
        this.nome = nome;
        this.numTeles = numTeles;
        this.valPrem = valPrem;
        
        teles = new int[numTeles][numConjuntos][tamanhoTele];
        
        for (int i=0; i<numTeles; i++){
            teles[i] = TeleSena.criarTele(numConjuntos, tamanhoTele, maxNumTele);
        }
    }
    
    public int[][][] getTeles(){
        return teles;
    }
    
    public String getNome(){
        return this.nome;
    }
    ///public static void main(String[] args){
    ///    Pessoa josee = new Pessoa("jose", 7, 89769);
    ///}    
}
