package com.claytonpereira.View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;

import com.claytonpereira.util.FileHash;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JLabel;

/**
 * Classe JanelaPrincipal, responsável pela criação da GUI com o usuário, nela
 * também está a parte de gravação e salvamento do arquivo .TXT contendo o HASH
 * .
 * 
 * @author Clayton Pereira
 * 
 * */

public class JanelaPrincipal {

	public JFrame frame;
	JTextArea textArea = new JTextArea(15,30);

	/**
	 * Metodo que grava o arquivo já com o HASH gerado no disco.
	 * 
	 * @param String
	 *            texto Texto a ser inserido no arquivo .TXT
	 * @param String
	 *            path Caminho onde será salvo o arquivo .TXT
	 * **/
	public void Gravar(String texto, String path) {
		String conteudo = texto;
		String local = path;
		try {
			// o true significa q o arquivo será constante
			FileWriter x = new FileWriter(local + "\\HASH_ARQUIVOS_XMLS.TXT");

			// criando nova linha e recuo no arquivo
			if (!conteudo.trim().equals(" ")) {
				x.write(conteudo); // armazena o texto no objeto x, que aponta
									// para o arquivo
				x.close(); // cria o arquivo
				JOptionPane.showMessageDialog(null,
						"Hash dos arquivos gerados com sucesso ", "Concluído",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		// em caso de erro apreenta mensagem abaixo
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// JanelaPrincipal window = new JanelaPrincipal();
					//
					//
					// window.frame.setVisible(true);
					// window.frame.setTitle("Gerador de Hash");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a aplicação.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public JanelaPrincipal() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		initialize();
	}

	/**
	 * Inicializa os componentes do Frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager
				.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int Altura = screenSize.height - 200;
		int Largura = screenSize.width - 500;
		frame.setSize(Largura, Altura);
		frame.setLocationRelativeTo(null);

		// frame.setBounds(0, 0, 600, 800);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JtreeModificado classeTree = new JtreeModificado();
		final JTree tree = classeTree.ajustaTree();
		frame.getContentPane()
				.setLayout(
						new FormLayout(new ColumnSpec[] {
								ColumnSpec.decode("395px"),
								FormFactory.RELATED_GAP_COLSPEC,
								FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("max(247dlu;default):grow"),
								FormFactory.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("max(118dlu;default)"), },
								new RowSpec[] {
										FormFactory.RELATED_GAP_ROWSPEC,
										FormFactory.DEFAULT_ROWSPEC,
										FormFactory.LINE_GAP_ROWSPEC,
										FormFactory.DEFAULT_ROWSPEC,
										FormFactory.RELATED_GAP_ROWSPEC,
										FormFactory.DEFAULT_ROWSPEC,
										FormFactory.RELATED_GAP_ROWSPEC,
										RowSpec.decode("370px:grow"),
										RowSpec.decode("46px"),
										RowSpec.decode("55px"), }));

		JLabel lblNewLabel = new JLabel("Hash a ser Gerado ");
		frame.getContentPane().add(lblNewLabel, "5, 2, center, default");

		JScrollPane scroll = new JScrollPane(tree);
		JScrollPane scroll2 = new JScrollPane(textArea);
		frame.getContentPane().add(scroll, "1, 8, left, top");
		tree.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				// TODO Auto-generated method stub
				int quantidade = tree.getModel().getChildCount(
						tree.getLastSelectedPathComponent());
				File[] URL2 = new File[quantidade];
				String[] arquivos = new String[quantidade];

				int contArquivos = 0;
				int contDiretorios = 0;
				for (int i = 0; i < quantidade; i++) {

					URL2[i] = (File) tree.getModel().getChild(
							tree.getLastSelectedPathComponent(), i);

					if (URL2[i].isFile()) {
						contArquivos = contArquivos + 1;
						arquivos[contArquivos - 1] = URL2[i].getPath();
						// JOptionPane.showMessageDialog(null,
						// arquivos[contArquivos-1]);

					}
					if (URL2[i].isDirectory()) {
						contDiretorios = contDiretorios + 1;

					}

				}

				for (int a = 0; a < arquivos.length; a++) {
					FileHash hash = new FileHash();
					if (arquivos[a] != null) {
						String extensao = arquivos[a].substring(arquivos[a]
								.lastIndexOf('.') + 1);
						if (extensao.equals("XML") ){
							arquivos[a].replace("/", "\\");
							try {
								textArea.append(arquivos[a]
										.substring(arquivos[a]
												.lastIndexOf('\\') + 1)
										+ ";"
										+ hash.fileToHash(arquivos[a])
										+ "\n");
								// System.out.println(hash.fileToHash(arquivos[a])
								// );
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();

							}
						}
						if(extensao.equals("xml")){
							arquivos[a].replace("/", "\\");
							try {
								textArea.append(arquivos[a]
										.substring(arquivos[a]
												.lastIndexOf('\\') + 1)
										+ ";"
										+ hash.fileToHash(arquivos[a])
										+ "\n");
								// System.out.println(hash.fileToHash(arquivos[a])
								// );
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();

							}
							
							
							
							
							
						}
						
					}

				}

				// JOptionPane.showMessageDialog(null, "nesta pasta existem " +
				// contDiretorios + " Diretorio(s)" + " e " + contArquivos +
				// " arquivo(s)");

				// String URL ;
				// FileHash hash = new FileHash();
				// URL = tree.getLastSelectedPathComponent().toString();
				// URL.replace("/","\\" );
				//
				// try {
				// hash.fileToHash(URL);
				// } catch (Exception e1) {
				// // TODO Auto-generated catch block
				// e1.printStackTrace();
				// }
				// // JOptionPane.showMessageDialog(null, URL);
				//
				// }
			}
		});

		frame.getContentPane().add(scroll2, "5, 8, fill, fill");
		textArea.setEditable(false);
		textArea.setSize(80, 100);
		textArea.setRows(27);
		textArea.setColumns(28);
		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator, "7, 8, 1, 3");

		JButton btnNewButton = new JButton("Gerar Hash");
		btnNewButton.setSize(50, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Gravar(textArea.getText(), tree.getLastSelectedPathComponent()
						.toString());
			}
		});

		frame.getContentPane().add(btnNewButton, "1, 9, fill, fill");

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		JMenuItem mniSair = new JMenuItem("Sair");
		mnArquivo.add(mniSair);
		mniSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});

		menuBar.add(mnArquivo);

		JMenu mnSobre = new JMenu("Sobre");
		JMenuItem mniSobre = new JMenuItem("Sobre");

		mnSobre.add(mniSobre);

		mniSobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);

			}
		});

		menuBar.add(mnSobre);

	}

}
