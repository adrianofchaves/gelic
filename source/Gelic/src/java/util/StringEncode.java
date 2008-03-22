/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author Adriano
 */
public class StringEncode {

    public String toUTF8(String isoString) {
        String utf8String = null;
        if (null != isoString && !isoString.equals("")) {
            try {
                byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");
                utf8String = new String(stringBytesISO, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // Mostra exceção mas devolve a mesma String   
                System.out.println("UnsupportedEncodingException: " + e.getMessage());
                utf8String = isoString;
            }
        } else {
            utf8String = isoString;
        }
        return utf8String;
    }
}
