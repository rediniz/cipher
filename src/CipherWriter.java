
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RenatoD
 */
public class CipherWriter extends Writer {

    OutputStreamWriter out;

    public CipherWriter(OutputStreamWriter out) {
        this.out = out;
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        out.write(cifra(cbuf));
        System.out.println(cbuf);
    }


    public char[] cifra(char[] cadeia) {

        String vogais = "aeiou"; //String utilizada para fazer checagem de vogais
        String consoantes = "bcdfghjklmnpqrstvwxyz"; //String utilizada para fazer checagem de consoantes

        for (int i = 0; i < cadeia.length; i++) {
            //Se for vogal, faz as substituição das vogais
            if (vogais.indexOf(Character.toLowerCase(cadeia[i])) >= 0) {
                
                switch (cadeia[i]) {
                    case 'a':
                        cadeia[i] = 'e';
                        break;
                    case 'A':
                        cadeia[i] = 'E';
                        break;
                    case 'e':
                        cadeia[i] = 'i';
                        break;
                    case 'E':
                        cadeia[i] = 'I';
                        break;
                    case 'i':
                        cadeia[i] = 'o';
                        break;
                    case 'I':
                        cadeia[i] = 'O';
                        break;
                    case 'o':
                        cadeia[i] = 'u';
                        break;
                    case 'O':
                        cadeia[i] = 'U';
                        break;
                    case 'u':
                        cadeia[i] = 'a';
                        break;
                    case 'U':
                        cadeia[i] = 'A';
                        break;
                }
                //Se for consoante, faz a substituição das consoantes
            } else if (consoantes.indexOf(Character.toLowerCase(cadeia[i])) >= 0) {
                //Se a consoante for 'z' ou 'Z', pula para 'a' ou 'A', para fazer a lista
                //do alfabeto ser circular

                if (cadeia[i] == 'z') { 
                    
                    cadeia[i] = 'a';  
                    
                } else if (cadeia[i] == 'Z') {
                    
                    cadeia[i] = 'A';
                    
                } else {
                    /*Se for qualquer outra consoante, pula para a próxima ( É possível somar 
                     +1 a um char para fazer isso, porque char é um inteiro. No caso das letras 'z'
                     ou 'Z', o próximo valor é um caractere especial, por isso o código acima
                     faz essa checagem pra letra z) */

                    cadeia[i]++;

                    //Se a próxima letra for uma vogal, pula novamente para pegar a próxima consoante
                    if (vogais.indexOf(Character.toLowerCase(cadeia[i])) >= 0) {
                        
                       cadeia[i]++;
                       
                    }
                }
            }
        }
        return cadeia;
    }

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
