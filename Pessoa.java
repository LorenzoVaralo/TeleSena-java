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
    boolean ganhador;
    int[][][] teles;
    
    int numConjuntos = ControleTeleSena.numConjuntos;
    int tamanhoTele = ControleTeleSena.tamanhoTele;
    int maxNumTele = ControleTeleSena.maxNumTele;
    
    public Pessoa(String nome, int numTeles, int valPrem){
        this.nome = nome;
        this.numTeles = numTeles;
        this.valPrem = valPrem;
        this.ganhador = false;
        
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
    
    public boolean getGanhador(){
        return this.ganhador;
    }
    
    public void setGanhador(boolean ganhador){
        this.ganhador = ganhador;
    }
    ///public static void main(String[] args){
    ///    Pessoa josee = new Pessoa("jose", 7, 89769);
    ///}    
}
