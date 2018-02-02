import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MyClass extends JFrame{
   JTextField tf;
   JPasswordField pw;
   JButton bt;
   JLabel lb1,lb2,lb3;
  
	
	MyClass(){
		//Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//double width = screensize.getWidth();
		//double height = screensize.getHeight();
		
		tf=new JTextField(20);
		pw=new JPasswordField(20);
		bt=new JButton("Submit");
		lb1=new JLabel("Username");
		lb2=new JLabel("Password");
		lb3 = new JLabel("Welcome");
		
		//setSize((int)width,(int)height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		//lb3.setBounds((int)width/2,(int)height/2,300,300);
		lb3.setFont(new Font("Serif",Font.BOLD,50));
		
		
		lb1.setBounds(100,10,100,50);
		tf.setBounds(170,20,150,30);
		
		lb2.setBounds(10, 60, 100, 50);
		pw.setBounds(80, 70, 150, 30);
		
		bt.setBounds(60, 120, 100, 30);
	    
		add(lb3);
		add(lb1);
		add(tf);
		add(lb2);
		add(pw);
		add(bt);
		
	}
	public static void main(String[] args) {
		new MyClass();
	}
}
