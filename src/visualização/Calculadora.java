package visualização;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import Interna.Memory;

public class Calculadora extends JFrame{
	private Memory memoria = new Memory();
	
	ImageIcon icon = new ImageIcon("C:/Temp/eclipse/Minha nova calc/src/visualização/icon.png");
	
	public Calculadora() {
		organizador();
		setSize(400,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setIconImage(icon.getImage());
		setTitle("Calculadora");
	}
	
	public void organizador() {
	    Visor display = new Visor();
	    memoria = new Memory(); 
	    Teclado teclado = new Teclado(memoria, display);

	    setLayout(new BorderLayout());
	    display.setPreferredSize(new Dimension(400, 300));
	    teclado.setPreferredSize(new Dimension(400, 400));

	    add(teclado, BorderLayout.SOUTH);
	    add(display, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		new Calculadora();
	}

}
