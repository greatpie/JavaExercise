//刘以潇 2014302480056
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
public class Task2 extends JFrame {
	public void init(){
		JTextField tfNum1= new JTextField(10);
		JTextField tfNum2 = new JTextField(10);
		JLabel lbNum1 = new JLabel("操作数1");
		JLabel lbNum2 = new JLabel("操作数2");
		JLabel lbCalType = new JLabel("计算类型");
		JComboBox cbCatalogs = new JComboBox();
		cbCatalogs.addItem("+");
		cbCatalogs.addItem("-");
		cbCatalogs.addItem("*");
		cbCatalogs.addItem("/");
		JButton btncalculate = new JButton("计算");
		btncalculate.addActionListener( (ActionListener) this);
		JPanel p1 =  new JPanel();
		p1.add(btncalculate);
		setLayout(new GridLayout(8,2));
		add(lbNum1);
		add(tfNum1);
		add(lbNum2);
		add(tfNum2);
		add(lbCalType);
		add(cbCatalogs);
		add(p1);
		setVisible(true);
		setSize(450,300);
		setTitle("爸爸做的计算器");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Task2().init();
	}

}
