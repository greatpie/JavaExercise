package dingyue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class listviewsort extends  JFrame {
//	private String[] studentinfor = {"学生姓名","学生学号","选修门数",
//			"语文成绩","数学成绩","英语成绩",
//			"选修课一","选修课二","选修课三",
//			"成绩一","成绩二","成绩三"
//	};
   private JList jlist = null;
   
	public listviewsort(String[] studentinfor){
	 
		JList jlist = new JList(studentinfor);
		   
		JLabel label1=new JLabel ("本课程排名为:");
		
	//	JList ls = new JList();
	//	ls.add("arg1");
		
		add(label1,BorderLayout.NORTH);
		
		add(new JScrollPane(jlist));
}
}
