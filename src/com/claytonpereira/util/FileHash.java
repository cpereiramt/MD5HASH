package com.claytonpereira.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Classe FileHash responsável pela criação do Hash de um determinado arquivo
 * que foi passado anteriormente .
 * 
 * @author Clayton Pereira
 * 
 * */
public class FileHash {
	/**
	 * 
	 * Metodo fileToHash, que gera a sequencia de 32 caracteres em MD5
	 * 
	 * @param String
	 *            URL O caminho do arquivo que terá o HASH gerado
	 * @return String O retorno de uma String contendo o HASH .
	 * @throws Exception
	 * 
	 * */
	public String fileToHash(String URL) throws Exception {

		MessageDigest md = MessageDigest.getInstance("MD5");
		FileInputStream fis = new FileInputStream(URL);
		byte[] dataBytes = new byte[1024];

		int nread = 0;
		while ((nread = fis.read(dataBytes)) != -1) {
			md.update(dataBytes, 0, nread);
		}
		;
		byte[] mdbytes = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++) {
			sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		// System.out.println("Digest(in hex format):: " + sb.toString());

		fis.close();
		return sb.toString().toUpperCase();

	}
}
