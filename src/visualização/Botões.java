package visualização;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Botões extends JButton {
	public Botões(String texto, Color cor) {
		setBackground(cor);
		setOpaque(true);
		setText(texto);
		setFont(new Font("arial", Font.BOLD, 50));
	}
}
