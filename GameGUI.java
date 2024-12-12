import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener {
	public JFrame DisplayGUI;
	public JTextArea displayArea;
	public JButton confirm;
	public JLabel displayQuestion;
	public JTextField playerInput;
	public JPanel bottomRow;
	
	
	public static void main(String[] args) {
		new GameGUI();
	}
	
	public GameGUI() {
		buildWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		String s = playerInput.getText();
		Game.processCommand(s);
		
	
	}
	
	public void buildWindow() {
		DisplayGUI = new JFrame("Game GUI");
		displayArea = new JTextArea("");
		confirm = new JButton(" Execute ");
		displayQuestion = new JLabel("What Would You Like To Do?");
		playerInput = new JTextField("");
		bottomRow = new JPanel();
		DisplayGUI.setLayout(new BorderLayout());
		DisplayGUI.add(displayArea, BorderLayout.CENTER);
		DisplayGUI.add(bottomRow, BorderLayout.SOUTH);
		Font currentFont = displayArea.getFont();
		Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() - 3);
		displayArea.setFont(newFont);
		bottomRow.setLayout(new GridLayout(3,1));
		bottomRow.add(displayQuestion);
		bottomRow.add(playerInput);
		bottomRow.add(confirm);
		confirm.addActionListener(this);
		
		
		DisplayGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //tells the operation what to do if the user clicks the X
		DisplayGUI.setLocationRelativeTo(null); // Center Window
		DisplayGUI.setSize(500, 500);
		DisplayGUI.setVisible(true); //Make Window appear
	}
}
