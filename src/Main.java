
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RenatoD
 */
public class Main {
    
    public static void main(String args[]) throws IOException{
        CipherWriter writer = new CipherWriter(new OutputStreamWriter(System.out));
               
        String teste = "Testando A Entrada!? 123"; //String para teste
        char[] testeChar = teste.toCharArray(); //Converte em um array de chars que será passado para o writer
        writer.write(teste);
    }
    
}
