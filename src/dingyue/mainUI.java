package dingyue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class mainUI extends JFrame {
	  
		int Radiovalue = 1;
		
		public static void main(String[] args){
			JFrame mainFrame = new  mainUI();
			mainFrame.setSize(500, 300);
			mainFrame.setLocation(300,300);
			//frame.pack();
			mainFrame.setVisible(true);
			
		}
		public mainUI(){
			
			saveandread.i = 0;
			
			JLabel label1=new JLabel ("1900");
			JLabel label2=new JLabel ("2");
			JLabel label3=new JLabel ("3");
			JLabel label4=new JLabel ("4");
			JTextField jtextfield1 = new JTextField("5000");
			JTextField jtextfield2 = new JTextField("6");
			JTextField jtextfield3 = new JTextField("7");
			JTextField jtextfield4 = new JTextField("8");
			
			JRadioButton jrb1 = new JRadioButton("录入学生信息",true);
			JRadioButton jrb2 = new JRadioButton("查询学生信息",true);
			JRadioButton jrb3 = new JRadioButton("显示各科排名",true);
			JRadioButton jrb4 = new JRadioButton("退出",true);
			
			
			
			
			
			jrb1.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent e){
				  Radiovalue = 1;
				}
				
			});
			
			jrb2.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent e){
				  Radiovalue = 2;
				}
				
			});
			
			jrb3.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent e){
				  Radiovalue = 3;
				}
				
			});
			
			jrb4.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent e){
					  Radiovalue = 4;
				}
				
			});
			
			ButtonGroup group = new ButtonGroup();
			group.add(jrb1);
			group.add(jrb2);
			group.add(jrb3);
			group.add(jrb4);
			
			JPanel jp = new JPanel();
			jp.setLayout(new GridLayout(3,1));
			jp.add(jrb1);
			jp.add(jrb2);
			jp.add(jrb3);
			jp.add(jrb4);
			
			
			
			
			JTextArea jtextarea1 = new JTextArea("6");
			
			JButton jbt =new JButton("CLick it ");
			jbt.addActionListener(new ActionListener(){
				 
				 

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				  
					switch(Radiovalue){
					case 1:
						JFrame frame = new testbutton();
						frame.setSize(500, 300);
						//frame.pack();
						frame.setVisible(true);
						gmod.dlg1 = frame;
						
						break;
					case 2:
						JFrame frame2 = new  querystudent2();
					frame2.setSize(500, 300);
					//frame.pack();
					frame2.setVisible(true);

					gmod.dlg2 = frame2;
					
						break;
					case 3:
						JFrame frame3 = new   sortgade();
						frame3.setSize(500, 300);
						//frame.pack();
						frame3.setVisible(true);

						gmod.dlg3 = frame3;
						break;
					case 4:
						System.exit(0);
						break;
					}
				 
				}
			});
			
			
			
			
			add(jp);
			add(jbt,BorderLayout.SOUTH);
	}

}
