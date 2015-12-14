package dingyue;



import java.awt.BorderLayout;
import java.awt.Font;
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


public class windows1 extends JFrame {
	
	public static void main(String[] args){
		JFrame startFrame = new  windows1();
		startFrame.setSize(500, 300);
		startFrame.setLocation(300,300);
		//frame.pack();
		startFrame.setVisible(true);
		
	}

	
	public windows1()
	{
		
		
		JButton jbt =new JButton("进入");
		jbt.addActionListener(new ActionListener(){
			 
			 

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			  
					JFrame frame = new LoginUI();
					frame.setSize(500, 300);
					
//					frame.setJMenuBar(new myMenuBar());
					//frame.pack();
					frame.setVisible(true);
					dispose();
					//gmod.dlg1 = frame;
					
					 
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
		
		ImageIcon img = new ImageIcon("C:\\tupian.jpg");
		JLabel labimg1 = new JLabel(img);
		
		JLabel lab1 = new JLabel("欢迎进入教务系统");
		add(lab1);
		add(labimg1);
		
		add(jbt);

		jbt.setBounds( 150, 200, 200, 50);
		
		lab1.setBounds(50 + 70, 100, 400, 30);
		lab1.setFont(new Font("宋体", Font.ITALIC, 28));
		labimg1.setBounds(0, 0, 500, 80);
		
		
	}

}
