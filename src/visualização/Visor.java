package visualização;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Visor extends JPanel{
	private JLabel label;
	
	public Visor(){
		label = new JLabel();
		label.setBackground(new Color(15,15,15));
		label.setFont(new Font("Arial",Font.BOLD,50));
		label.setOpaque(false);
		add(label);
		label.setHorizontalTextPosition(JLabel.RIGHT);
		label.setVerticalTextPosition(JLabel.CENTER);
	}
	
	public void setLabel(String texto){
		label.setText(texto);
	}
}
