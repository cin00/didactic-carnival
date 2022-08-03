package kul;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
	
	//Weight stuff
	private JButton lbsButton, kgButton; //Weight Buttons
	private JPanel weightButtonPanel;  //Panels for weight buttons
	private JLabel weightLabel, weightResultLabel; //Labels for info above weight buttons and result text
	private JPanel weightTextPanel, weightResultPanel; //Panels for text above weight buttons and result text
	private JTextField weightTextInput; //Textfield for weight input
	private JPanel weightInputPanel; //Panel for textfield
	private double weight_input; //Weight input variable
	private double weight_result; //Weight result variable
	private static final double KGtoLBS = 2.20462262; //1 KG in LBS constant
	
	//Distance stuff
	private JButton mileButton, kmButton; //Distance Buttons
	private JPanel distButtonPanel; //Panel for distance buttons
	private JLabel distLabel, distResultLabel; //Labels for info above distance buttons and result text
	private JPanel distTextPanel, distResultPanel; //Panels for text above distance buttons and result text
	private JTextField distTextInput; //Textfield for distance input
	private JPanel distInputPanel; //Panel for textfield
	private double dist_input; //Distance input variable
	private double dist_result; //Distance result variable
	private static final double KMtoMILES = 0.621371192; //1 KM to Miles constant
	
	
	
	public GUI() {
		
		
		//Info above weight buttons
		weightLabel = new JLabel("Input weight in pounds (lbs) or kilograms (kg)");
		weightLabel.setForeground(Color.orange);
		
		//Panel for info above weight buttons
		weightTextPanel = new JPanel();
		weightTextPanel.add(weightLabel);
		weightTextPanel.setAlignmentY(CENTER_ALIGNMENT);
		weightTextPanel.setBackground(new Color(125,50,250));
		
		
		//Weight textfield
		weightTextInput = new JTextField();
		weightTextInput.setPreferredSize(new Dimension(150,50));
		weightTextInput.setFont(new Font("Italic", 1, 30));
		weightTextInput.setBackground(Color.black);
		weightTextInput.setForeground(Color.orange);
		weightTextInput.setCaretColor(Color.white);
		
		//Weight textfield panel
		weightInputPanel = new JPanel();
		weightInputPanel.add(weightTextInput);
		weightInputPanel.setAlignmentY(CENTER_ALIGNMENT);
		weightInputPanel.setBackground(new Color(135,50,250));
		
		//Weight buttons
		lbsButton = new JButton("To lbs");
		lbsButton.addActionListener(this);
		lbsButton.setFocusable(false);
		lbsButton.setBackground(new Color(255,204,51));
		kgButton = new JButton("To kg");
		kgButton.setFocusable(false);
		kgButton.setBackground(new Color(255,204,51));
		kgButton.addActionListener(this);
		
		//Weight buttons panel
		weightButtonPanel = new JPanel();
		weightButtonPanel.add(lbsButton);
		weightButtonPanel.add(kgButton);
		weightButtonPanel.setAlignmentY(CENTER_ALIGNMENT);
		weightButtonPanel.setBackground(new Color(145,50,250));
		
		//Weight result text
		weightResultLabel = new JLabel();
		weightResultLabel.setFont(new Font("Italic", 1, 20));
		weightResultLabel.setForeground(Color.orange);
		
		//Weight result text panel
		weightResultPanel = new JPanel();
		weightResultPanel.add(weightResultLabel);
		weightResultPanel.setAlignmentY(CENTER_ALIGNMENT);
		weightResultPanel.setBackground(new Color(155,50,250));
		
		
		//Info above distance buttons
		distLabel = new JLabel("Input distance in miles or kilometers (km)");
		distLabel.setForeground(Color.orange);
		
		//Panel for info above distance buttons
		distTextPanel = new JPanel();
		distTextPanel.add(distLabel);
		distTextPanel.setAlignmentY(CENTER_ALIGNMENT);
		distTextPanel.setBackground(new Color(165,50,250));
		
		//Distance textfield
		distTextInput = new JTextField();
		distTextInput.setPreferredSize(new Dimension(150,50));
		distTextInput.setFont(new Font("Italic", 1, 30));
		distTextInput.setBackground(Color.black);
		distTextInput.setForeground(Color.orange);
		distTextInput.setCaretColor(Color.white);
		
		//Distance textfield panel
		distInputPanel = new JPanel();
		distInputPanel.add(distTextInput);
		distInputPanel.setAlignmentY(CENTER_ALIGNMENT);
		distInputPanel.setBackground(new Color(175,50,250));
		
		//Distance buttons
		mileButton = new JButton("Till miles");
		mileButton.setBackground(new Color(255,204,51));
		mileButton.setFocusable(false);
		mileButton.addActionListener(this);
		kmButton = new JButton("Till km");
		kmButton.setFocusable(false);
		kmButton.setBackground(new Color(255,204,51));
		kmButton.addActionListener(this);
		
		//Distance buttons panel
		distButtonPanel = new JPanel();
		distButtonPanel.add(mileButton);
		distButtonPanel.add(kmButton);
		distButtonPanel.setAlignmentY(CENTER_ALIGNMENT);
		distButtonPanel.setBackground(new Color(185,50,250));
		
		//Distance result text
		distResultLabel = new JLabel();
		distResultLabel.setFont(new Font("Italic", 1, 20));
		distResultLabel.setForeground(Color.orange);
		
		//Distance result panel
		distResultPanel = new JPanel();
		distResultPanel.add(distResultLabel);
		distResultPanel.setAlignmentY(CENTER_ALIGNMENT);
		distResultPanel.setBackground(new Color(190,50,250));
		
		
		//JFrame settings
		this.setSize(600,600);
		this.setTitle("Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.add(weightTextPanel);
		this.add(weightInputPanel);
		this.add(weightButtonPanel);
		this.add(weightResultPanel);
		this.add(distTextPanel);
		this.add(distInputPanel);
		this.add(distButtonPanel);
		this.add(distResultPanel);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == lbsButton) {
			try {
				weight_input = Double.parseDouble(weightTextInput.getText());
				weight_result = weight_input * KGtoLBS;
				weightResultLabel.setText(weight_input + " kg is equal to " + String.valueOf(weight_result) + " lbs");
			} catch(Exception e1) {
				weightResultLabel.setText("Invalid input!");
			}
			
				
		}
		if(e.getSource() == kgButton) {
			try {
				
				weight_input = Double.parseDouble(weightTextInput.getText());
				weight_result = weight_input / KGtoLBS;
				weightResultLabel.setText(weight_input + " lbs is equal to " + String.valueOf(weight_result) + " kg");
			} catch(Exception e1) {
				weightResultLabel.setText("Invalid input!");
			}
		}
		if(e.getSource() == mileButton) {
			try {
				
				dist_input = Double.parseDouble(distTextInput.getText());
				dist_result = dist_input * KMtoMILES;
				distResultLabel.setText(dist_input + " km is equal to " + String.valueOf(dist_result) + " miles");
			} catch(Exception e1) {
				distResultLabel.setText("Invalid input!");
			}
			
		}
		if(e.getSource() == kmButton) {
			try {
				
				dist_input = Double.parseDouble(distTextInput.getText());
				dist_result = dist_input / KMtoMILES;
				distResultLabel.setText(dist_input + " miles is equal to " + String.valueOf(dist_result) + " km");
			} catch(Exception e1) {
				distResultLabel.setText("Invalid input!");
			}
		}
	}

}
