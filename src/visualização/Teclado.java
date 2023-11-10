package visualização;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import Interna.Memory;

public class Teclado extends JPanel implements ActionListener{
	private Visor display;
	private Memory memoria;
	
	public Teclado(Memory memoria, Visor display) {
		this.display = display;
		this.memoria = memoria;
		
		setLayout(new GridLayout(4,4));
		
		add(criarBotao("1", Color.magenta));
		add(criarBotao("2", Color.magenta));
		add(criarBotao("3", Color.magenta));
		add(criarBotao("C", Color.gray));
		
		add(criarBotao("4", Color.magenta));
		add(criarBotao("5", Color.magenta));
		add(criarBotao("6", Color.magenta));
		add(criarBotao("+", Color.gray));
		
		add(criarBotao("7", Color.magenta));
		add(criarBotao("8", Color.magenta));
		add(criarBotao("9", Color.magenta));
		add(criarBotao("-", Color.gray));
		
		add(criarBotao("0", Color.magenta));
		add(criarBotao("=", Color.gray));
		add(criarBotao("x", Color.gray));
		add(criarBotao("/", Color.gray));
	}
	
	public Botões criarBotao(String texto, Color cor) {
		Botões b = new Botões(texto, cor);
		b.addActionListener(this);
		return b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    JButton b = (JButton) e.getSource();
	    String texto = b.getText();

	    if (texto.equals("C")) {
	        memoria.clearNumeros();
	        display.setLabel("");
	    } 
	    else if (texto.equals("=")) {
	        String expressao = String.join(" ", memoria.getNumeros()); 

	        try {
	            double resultado = memoria.operations(expressao);
	            display.setLabel(Double.toString(resultado));
	            memoria.clearNumeros();
	            memoria.setNumeros(Double.toString(resultado));
	        } 
	        catch (ArithmeticException ex) {
	            display.setLabel("Erro");
	            memoria.clearNumeros();
	        }
	    }
	    else {
	       
	        if (!texto.equals("+") && !texto.equals("-") && !texto.equals("x") && !texto.equals("/")) {
	            memoria.setNumeros(texto);
	        }
	        else {
	            memoria.setNumeros(" " + texto + " ");
	        }
	        display.setLabel(memoria.getNumeros());
	    }
	}


}
