import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Avaliacao {
    public static void main(String[] args) {

        String valor = "NaoOrdenada.txt";
        int cont = 0;

        try {
            //Leitura do arquivo de entrada
            FileReader Entrada = new FileReader(valor);
            BufferedReader leitor = new BufferedReader(Entrada);

            String linha = "";

            do {
                linha = leitor.readLine();
                if (linha != null) {
                    cont++; //contador de linhas do arquivo
                }
            } while (linha != null);

            leitor.close();
            Entrada.close();

            //Criando array
            String[] listaDesordenada = new String[cont];
            int [] Conversao = new int[cont];
        

            FileReader novaLeitura = new FileReader(valor);
            BufferedReader novoLeitor = new BufferedReader(novaLeitura);

            for (int i = 0; i < cont; i++) {
                listaDesordenada[i] = novoLeitor.readLine(); //guarda as linhas do arquivo no array
            }

            novoLeitor.close();
            novaLeitura.close();


            //Ordenação da Array
            for (int i = 0; i < cont; i++) {
                Conversao[i] = Integer.parseInt(listaDesordenada[i]); //Converte o array de String para Int
            }

            //Insertion Sort
            for (int l = 0; l < cont; l++) {  
                int value = Conversao[l];  
                int i = l - 1;

                while((i > -1) && (Conversao[i] > value)){  
                    Conversao [i+1] = Conversao [i];  
                    i--; 
                }  

                Conversao[i+1] = value; 
            }

            //Ordenação da Collection
            List <Integer> colecaoOrdenada = new ArrayList<Integer>();

            for (int i = 0; i < cont; i++){
                colecaoOrdenada.add(Conversao[i]);
            }

            System.out.println("\nArray ordenada: " + Arrays.toString(Conversao));
            System.out.println("\nCollection ordenado: " + colecaoOrdenada);

            //Salvar em arquivo
            FileWriter arquivoSaida = new FileWriter("Saida.txt");
            PrintWriter gravaArquivo = new PrintWriter("Saida.txt");

            gravaArquivo.println("\nArray ordenada: " + Arrays.toString(Conversao));
            gravaArquivo.println("\nCollection ordenado: " + colecaoOrdenada);

            gravaArquivo.close();
            arquivoSaida.close();

        }catch (IOException e){
            System.out.println("Não é possivel criar o arquivo!");
        }
    }
}