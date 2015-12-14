package dingyue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class viewinformation extends JFrame{
	 private JList jlist = null;
	   
		public  viewinformation(String[] studentinfor){
		 
			JList jlist = new JList(studentinfor);
			   
			JLabel label1=new JLabel ("学生信息为:");
			
		//	JList ls = new JList();
		//	ls.add("arg1");
			
			add(label1,BorderLayout.NORTH);
			
			add(new JScrollPane(jlist));
	}
}
