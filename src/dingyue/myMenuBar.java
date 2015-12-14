package dingyue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class myMenuBar extends JMenuBar {

	String[] fileitems = new String[]{"输入","查询","排名"};
	//String[] edititems = new String[]{"aaa","bbb","456"};
	
	public myMenuBar()
	{
		
		JMenu menu1 = new JMenu("功能");
		JMenu menu2 = new JMenu("退出");
		
		ActionListener lser = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				JFrame frame = new testbutton();
				frame.setSize(500, 300);
				//frame.pack();
				frame.setVisible(true);
				gmod.dlg1 = frame;
		
			}
			
			
		};

		ActionListener lser1 = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				JFrame frame2 = new  querystudent2();
				frame2.setSize(500, 300);
				//frame.pack();
				frame2.setVisible(true);

				gmod.dlg2 = frame2;

				
			}
			
			
		};

		ActionListener lser2 = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame frame3 = new   sortgade();
				frame3.setSize(500, 300);
				//frame.pack();
				frame3.setVisible(true);

				gmod.dlg3 = frame3;

			}
			
			
		};


		ActionListener lser_exit = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			
		};

		
		
		for(int i=0; i<3; i++)
		{
			JMenuItem m1_1 = new JMenuItem( fileitems[i] );
		
			if(i==0)
				m1_1.addActionListener(lser);
			else if(i==1)
				m1_1.addActionListener(lser1);
			else
				m1_1.addActionListener(lser2);
			
			menu1.add(m1_1);
		}
		
		
		JMenuItem item_exit = new JMenuItem("退出");
		item_exit.addActionListener(lser_exit);
		menu2.add(item_exit);
		
		add(menu1);
		add(menu2);
		
		
	}
}
