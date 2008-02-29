/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta classe fornece métodos para gerar uma criptografia usando MD5.
 * 
 * Agradecimentos: 
 *  www.guj.com.br
 *  Daniel Malaquias Freitas
 * 
 * @author adriano
 */
public class CriptMD5 {

    private static final String hexDigits = "0123456789abcdef";

    /**
     * Realiza um digest em um array de bytes através do algoritmo especificado
     * @param input - O array de bytes a ser criptografado
     * @param algoritmo - O algoritmo a ser utilizado
     * @return byte[] - O resultado da criptografia
     * @throws NoSuchAlgorithmException - Caso o algoritmo fornecido não seja
     * válido
     */
    public static byte[] digest(byte[] input)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.reset();
        return md.digest(input);
    }

    /**
     * Retorna a string passada usando MD5.
     * @param input 
     * @return String com o MD5 de input
     */
    public static String digest(String input)
            throws NoSuchAlgorithmException {
        byte[] b = digest(input.getBytes());

        return byteArrayToHexString(b);
    }

    /**
     * Converte o array de bytes em uma representação hexadecimal.
     * @param input - O array de bytes a ser convertido.
     * @return Uma String com a representação hexa do array
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer buf = new StringBuffer();
        int j;
        for (int i = 0; i < b.length; i++) {
            j = ((int) b[i]) & 0xFF;
            buf.append(hexDigits.charAt(j / 16));
            buf.append(hexDigits.charAt(j % 16));
        }

        return buf.toString();
    }

    /**
     * Converte uma String hexa no array de bytes correspondente.
     * @param hexa - A String hexa
     * @return O vetor de bytes
     * @throws IllegalArgumentException - Caso a String não seja uma
     * representação haxadecimal válida
     */
    public static byte[] hexStringToByteArray(String hexa)
            throws IllegalArgumentException {

        //verifica se a String possui uma quantidade par de elementos
        if (hexa.length() % 2 != 0) {
            throw new IllegalArgumentException("String hexa inválida");
        }

        byte[] b = new byte[hexa.length() / 2];

        for (int i = 0; i < hexa.length(); i += 2) {
            b[i / 2] = (byte) ((hexDigits.indexOf(hexa.charAt(i)) << 4) |
                    (hexDigits.indexOf(hexa.charAt(i + 1))));
        }
        return b;
    }
    public static void main(String [] args){
        try {
            

            System.out.println(digest("Adriano"));
            System.out.println(digest("Adriano Fernandes Chaves"));
            
            String buffer = digest( "Adriano");
            System.out.println(buffer);
            System.out.println(buffer.length());
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CriptMD5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
