package dingyue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class querystudent extends JFrame{
//	public querystudent(){
//		JLabel label1=new JLabel ("1");
//		JLabel label2=new JLabel ("2");
//		JLabel label3=new JLabel ("3");
//		JLabel label4=new JLabel ("4");
//		JTextField jtextfield1 = new JTextField("5");
//		JTextField jtextfield2 = new JTextField("6");
//		JTextField jtextfield3 = new JTextField("7");
//		JTextField jtextfield4 = new JTextField("8");
//		
//		this.setLayout( new GridLayout(4,2));
//
//		add(label1);
//		add( jtextfield1);
//		add(label2);
//		add( jtextfield2);
//		add(label3);
//		add( jtextfield3);
//		add(label4);
//		add( jtextfield4);
//		
//		
//}
public static void main(String[] args){
	JFrame frame = new testbutton();
	frame.setSize(500, 300);
	//frame.pack();
	frame.setVisible(true);
	
}
public  querystudent(){
	
	//////////////////////////////////////////////////////////////////////////////
	
	JLabel label1=new JLabel ("ѧ������");
	JLabel label2=new JLabel ("ѧ��ѧ��");
	JLabel label3=new JLabel ("���ĳɼ�");
	JLabel label4=new JLabel ("��ѧ�ɼ�");
	JLabel label5=new JLabel ("Ӣ��ɼ�");
	JLabel label6=new JLabel ("ѡ�޿�һ");
	JLabel label7=new JLabel ("ѡ�޿ζ�");
	JLabel label8=new JLabel ("ѡ�޿���");
	JLabel label9=new JLabel ("ѡ������ ");
	JLabel label10=new JLabel("�ɼ�һ     ");
	JLabel label11=new JLabel("�ɼ���     ");
	JLabel label12=new JLabel("�ɼ���     ");
	JLabel label13=new JLabel("    ");
	
	JTextField jtextfield1 = new JTextField();
	
	JTextField jtextfield2 = new JTextField("");
	JTextField jtextfield3 = new JTextField("");
	JTextField jtextfield4 = new JTextField("");
	JTextField jtextfield5 = new JTextField("");
	JTextField jtextfield6 = new JTextField("");
	JTextField jtextfield7 = new JTextField("");
	JTextField jtextfield8 = new JTextField("");
	JTextField jtextfield9 = new JTextField("");
	JTextField jtextfield10 = new JTextField("");
	JTextField jtextfield11 = new JTextField("");
	JTextField jtextfield12 = new JTextField("");
	
	JTextArea jtextarea = new JTextArea("6");
	
	JButton jbt3 =new JButton("�˳� ");
	jbt3.addActionListener(new ActionListener(){
		 
		 

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
			 
		}
	});
	
	 
	
	
	
	this.setLayout( new GridLayout(14,2));
	

	add(label1);
	add( jtextfield1);
	add(label2);
	add( jtextfield2);
	add(label3);
	add( jtextfield3);
	add(label4);
	add( jtextfield4);
	add(label5);
	add( jtextfield5);
	 
	add(label9);
	add( jtextfield9);
	 
	//add(label10);
	 
	add(label6);
	add( jtextfield6);
	
	add(label10);
	add( jtextfield10);
	 
	 
	//add(label11);
	 
	add(label7);
	add( jtextfield7);
	
	add(label11);
	add( jtextfield11);
	 
	//add(label12);
	 
	add(label8);
	add( jtextfield8);
	
	add(label12);
	add( jtextfield12);
	 
	add(jbt3,BorderLayout.NORTH);
	
	 
	
	
	
	
	 
	 
		

}


	
}



