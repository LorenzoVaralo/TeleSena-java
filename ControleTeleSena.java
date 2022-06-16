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
    Pessoa[] ganhadores;
    Utils u = new Utils();
    
    public ControleTeleSena(){
        int numTeles;
        int totalNumTeles = 0;
        int rodadas = 0;
        int n_ganhadores = 0;
        int[] numsSorteados = u.sortear(maxNumTele, maxNumTele);//começa em 60 numeros
        Pessoa[] pessoas = new Pessoa[numPessoas];
        String[] nomes = randomNome(numPessoas);
        
        // vvvvvvvvvvvvv Interface Inicial    
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n"
        +"Seja bem vindo á TELE SENA DO MIL E POUCO!\n"
        +"Onde todos concorrem á um premio de ATÉ R$2400,00!!!\n\n"
        +"Iremos dar inicio á Tele Sena sorteando os primeiros 25 numeros, \n"
        +"os numeros sorteados são:\n");
        u.sleep(2000);
        System.out.println(Arrays.toString(Arrays.copyOfRange(numsSorteados, 0, tamanhoTele)));
        u.sleep(1000);
        System.out.println("\nNeste sorteio participará "+numPessoas+" pessoas!");
        
        // ^^^^^^^^^^^^^
        
        
        //Criar pessoas
        for(int p=0; p<numPessoas; p++){
            numTeles = (int) (Math.random() * 15) + 1; // 1 -> 15
            totalNumTeles += numTeles;
            
            pessoas[p] = new Pessoa(nomes[p], numTeles, totalNumTeles * 10);
        }
        
        for (int i = tamanhoTele; i< numsSorteados.length; i++){
            System.out.println("\nRodada Número "+(rodadas+1)+":");
            //começa nos 25 primeiros numeros e um numero novo e sorteado por loop
            // Garantido que tera ganhadores antes do termino deste for loop.
            n_ganhadores = verificarGanhador(pessoas, Arrays.copyOfRange(numsSorteados,0, i));
            if(n_ganhadores > 0){
                // se houver um ou mais ganhadores
                ganhadores = pessoasGanhadoras(pessoas, n_ganhadores);
                break;
            }
            System.out.print("Ainda nenhum ganhador! Sorteando um novo número... ");
            u.sleep(1000);
            System.out.println(numsSorteados[i]+"!");
            u.sleep(500);
            rodadas ++;
        }
        
        double valorFatura = faturamento(totalNumTeles);
        
        if (n_ganhadores == 1){
            System.out.println("\n\nTemos um ganhador!\n"
                              +"O vencedor desta TeleSena é...");
                              
            u.sleep(3000);
            
            printNomesGanhadores(ganhadores);
            //System.out.println(ganhadores[0].getNome()+"!!");
            
            u.sleep(3000);
            
            System.out.println("Este individuo sortudo foi o unico vencedor do premio de R$"
                              +(valorFatura * 0.8)+"!!!\n"
                              +"Parabens "+ganhadores[0].getNome()+"!");
            
            
        } else {
            System.out.println("\n\nTemos "+(n_ganhadores)+" ganhadores!\n"
                              +"Os vencedores desta TeleSena sao...");
            printNomesGanhadores(ganhadores);
            u.sleep(3000);
            System.out.println("Os "+(n_ganhadores)+" ganhadores desta TeleSena dividirao o premio "
                              +"igualmente, ou seja, cada sortudo recebera R$"
                              +(valorFatura * 0.8 / n_ganhadores)+"!!!\n"
                              +"Parabens ganhadores!");
        }
        
        System.out.println("\nNumeros Sorteados: \n"
        +Arrays.toString(Arrays.copyOfRange(numsSorteados, 0, tamanhoTele+rodadas)));
        System.out.println("Quantidade de Tele Senas vendidas: "+totalNumTeles);
        System.out.println("Quantidade de ganhadores: "+n_ganhadores);
        System.out.print("Nome de cada um dos ganhadores: ");
        printNomesGanhadores(ganhadores);
        System.out.println("Valor do premio para cada ganhador: R$"+(valorFatura * 0.8/n_ganhadores));
        System.out.println("Valor total das Tele Senas vendidas: R$"+valorFatura);
        System.out.println("Lucro obtido pelo Sílvio Santos com a Tele Sena : R$"+(valorFatura*0.2));
    }
    
    private String[] randomNome(int numPessoas){
        
        String[] nomes = {"Joao","Carlos","Alice","Jurema","Matheus","Julia",
                          "Gabriela","Robson","Pedro","Karen","Fofao","Fabio",
                          "Lorenzo","Caroline","Leticia","Junior","Ronaldo","Lala",
                          "Richard","Helen","Katia","Roberta","Cleiton","Ana",
                          "Juju","Jubileu","Gleison","Vasconcelos","Eloi","Jose"};
                          
        if(numPessoas > nomes.length){
            //Se existem mais pessoas do que nomes, a diferença tera nome null,
            //porque os nomes devem ser unicos.
            System.out.println("Erro! Pessoas demais! Insira mais "
            +(numPessoas - nomes.length)+" nomes, ou utilize menos pessoas.");
            
            return null;
        }
        
        int[] randIndex = u.sortear(numPessoas, nomes.length);
        String[] randNomes = new String[numPessoas];
        
        System.out.println(Arrays.toString(randIndex));
        for(int i=0; i<numPessoas; i++)
            randNomes[i] = nomes[randIndex[i] -1];
            
        return randNomes;
    }
    
    public int verificarGanhador(Pessoa[] pessoas, int[] numsSorteados){
        int n_ganhadores = 0;
        for(Pessoa p: pessoas)//para cada pessoa em array de pessoas
            for(int[][] teles: p.getTeles())//para cada telesena de cada pessoa
                for(int[] conj: teles)//para cada conjunto em cada telesena(2 conjuntos para cada)
                    if (u.estaEm(conj, numsSorteados)){
                        p.setGanhador(true);
                        n_ganhadores += 1;
                    }
        return n_ganhadores;
    }
    
    public Pessoa[] pessoasGanhadoras(Pessoa[] pessoas, int n_ganhadores){
        Pessoa[] ganhadores = new Pessoa[n_ganhadores];
        for(Pessoa p: pessoas){
            if(p.getGanhador()){ //Se pessoa e ganhadora:
                for(int ind = 0; ind < n_ganhadores; ind++){
                    //na primeira posiçao null do array ganhadores, 
                    //inserir pessoa ganhadora
                    if(ganhadores[ind] == null){
                        ganhadores[ind] = p;
                        break; // sair do primeiro loop
                    }
                }
            }
            if(ganhadores[n_ganhadores-1] != null){
                //Se ultima posiçao esta ocupada por uma pessoa, 
                //parar de procurar ganhadores
                break;
            }
        }
        return ganhadores;
    }
    
    public double faturamento(int numTeleVendidas){
        TeleSena ts = new TeleSena();
        double valVenda = ts.getValVenda();
        
        return numTeleVendidas * valVenda;
    }
    
    public void printNomesGanhadores(Pessoa[] ganhadores){
        for(int p = 0; p < ganhadores.length; p++){
            //nome1, nome2, nome3 e nome4!!!
            String sep = ", ";
            if (p == (ganhadores.length-2))
                sep = " e ";
            else if(p == (ganhadores.length-1))
                sep = "!!\n";
            u.sleep(3000);
            System.out.print(ganhadores[p].getNome() + sep);
        }        
        
    }
    
    public static void main(String[] args){
        ControleTeleSena cts;
        //for(int i =0; i<5;i++)
        cts = new ControleTeleSena();
        
        
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
