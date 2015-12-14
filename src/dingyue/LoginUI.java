package dingyue;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginUI extends JFrame {
	
	public static void main(String[] args){
		JFrame loginFrame = new  LoginUI();
		loginFrame.setSize(500, 300);
		loginFrame.setLocation(300,300);
		//frame.pack();
		loginFrame.setVisible(true);
		
	}
	public LoginUI()
	{
		

		JLabel label1=new JLabel ("µÇÂ½:");
		JLabel label2=new JLabel ("ÓÃ»§Ãû:");
		JLabel label3=new JLabel ("ÃÜÂë:");
		
		JTextField jtextfield1 = new JTextField("");
		JTextField jtextfield2 = new JPasswordField("");
		JTextField jtextfield3 = new JTextField("");
		JTextField jtextfield4 = new JTextField("");
		
		JButton jbt =new JButton("µÇÂ½");
		jbt.addActionListener(new ActionListener(){
			 
			 

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			  
					JFrame frame = new mainUI();
					frame.setSize(500, 300);
					frame.setLocation(300,300);
					frame.setJMenuBar(new myMenuBar());
					//frame.pack();
					frame.setVisible(true);
					//gmod.dlg1 = frame;
					dispose();
					
					 
			}
		});

		this.setLayout(null);
		
		JPanel jp = new JPanel();
		
//		jp.setLayout(new GridLayout(4,4));
//		jp.setLayout(null);
//		jp.add(label2);
//		jp.add(jtextfield1);
//		jp.add(label3);
//		jp.add(jtextfield2);
		jp.setLocation(300,300);
		label2.setBounds(100, 100, 50, 20);//setSize(20, 20);
		jtextfield1.setBounds(100+100, 100, 100, 25);
		
		label3.setBounds(100 , 100 + 30, 50, 20);//setSize(20, 20);
		jtextfield2.setBounds(100+100, 100 + 30, 100, 25);
		
		ImageIcon img = new ImageIcon("C:\\tupian.jpg");
		JLabel labimg1 = new JLabel(img);
		
		add(labimg1);
		add(label2);
		add(jtextfield1);
		add(label3);
		add(jtextfield2);

		add(jbt);

		jbt.setBounds( 150, 200, 200, 50);
		
		labimg1.setBounds(0, 0, 500, 80);
		
	}

}
