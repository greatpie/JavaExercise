package dingyue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class listviewsort extends  JFrame {
//	private String[] studentinfor = {"ѧ������","ѧ��ѧ��","ѡ������",
//			"���ĳɼ�","��ѧ�ɼ�","Ӣ��ɼ�",
//			"ѡ�޿�һ","ѡ�޿ζ�","ѡ�޿���",
//			"�ɼ�һ","�ɼ���","�ɼ���"
//	};
   private JList jlist = null;
   
	public listviewsort(String[] studentinfor){
	 
		JList jlist = new JList(studentinfor);
		   
		JLabel label1=new JLabel ("���γ�����Ϊ:");
		
	//	JList ls = new JList();
	//	ls.add("arg1");
		
		add(label1,BorderLayout.NORTH);
		
		add(new JScrollPane(jlist));
}
}
