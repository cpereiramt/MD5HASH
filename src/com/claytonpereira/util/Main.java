package com.claytonpereira.util;

import com.claytonpereira.View.JanelaPrincipal;

public class Main {

	/**
	 * Inicio da aplicação .
	 */
	public static void main(String args[]) throws Exception {

		// FileHash file = new FileHash();
		//
		// file.fileToHash();
		JanelaPrincipal window = new JanelaPrincipal();
		window.frame.setVisible(true);
		window.frame.setTitle("Gerador de Hash");

	}

}
