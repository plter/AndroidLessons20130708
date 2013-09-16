import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main extends JFrame implements ActionListener{

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
	
	
	public Main() {
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		btn = new JButton("Click me");
		btn.setSize(100, 30);
		btn.addActionListener(this);
		add(btn);
	}
	
	private JButton btn;

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Button Clicked");
	}
	
}
