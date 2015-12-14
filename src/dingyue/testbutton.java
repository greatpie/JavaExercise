package dingyue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.tree.ExpandVetoException;

public class testbutton extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new testbutton();
        frame.setSize(500, 300);
        //frame.pack();
        frame.setVisible(true);

    }

    public testbutton() {

        //////////////////////////////////////////////////////////////////////////////

        JLabel label1 = new JLabel("学生姓名");
        JLabel label2 = new JLabel("学生学号");
        JLabel label13 = new JLabel("选修门数");
        JLabel label3 = new JLabel("语文成绩");
        JLabel label4 = new JLabel("数学成绩");
        JLabel label5 = new JLabel("英语成绩");
        JLabel label6 = new JLabel("输入本科成绩");
        JLabel label7 = new JLabel("输入本科成绩");
        JLabel label8 = new JLabel("输入本科成绩");
        JLabel label9 = new JLabel("      ");
        JLabel label10 = new JLabel(" 选修课一     ");
        JLabel label11 = new JLabel(" 选修课二     ");
        JLabel label12 = new JLabel(" 选修课三     ");

        JTextField jtextfield1 = new JTextField("");
        JTextField jtextfield2 = new JTextField("");
        JTextField jtextfield3 = new JTextField("0");
        JTextField jtextfield4 = new JTextField("0");
        JTextField jtextfield5 = new JTextField("0");
        JTextField jtextfield6 = new JTextField("0");
        JTextField jtextfield7 = new JTextField("0");
        JTextField jtextfield8 = new JTextField("0");
        JTextField jtextfield9 = new JTextField("0");

        JComboBox jcb1 = new JComboBox(new Object[]
                {"无", "物理", "化学", "生物"});
        JComboBox jcb2 = new JComboBox(new Object[]
                {"无", "历史", "政治", "地理"});
        JComboBox jcb3 = new JComboBox(new Object[]
                {"无", "美术", "音乐", "计算机"});

        JCheckBox jchk = new JCheckBox("选修课 ", true);
        JCheckBox jchk1 = new JCheckBox("选修课一 ", true);
        JCheckBox jchk2 = new JCheckBox("选修课二 ", true);
        JCheckBox jchk3 = new JCheckBox("选修课三 ", true);
        saveandread.i = 0;

        JTextArea jtextarea2 = new JTextArea("6");

        JButton jbt3 = new JButton("renew it ");
        jbt3.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                jtextfield1.setText("");
                jtextfield2.setText("");
                jtextfield3.setText("0");
                jtextfield4.setText("0");
                jtextfield5.setText("0");
                jtextfield6.setText("0");
                jtextfield7.setText("0");
                jtextfield8.setText("0");
                jtextfield9.setText("0");
                jcb1.setSelectedIndex(0);
                jcb2.setSelectedIndex(0);
                jcb3.setSelectedIndex(0);
                jchk.setSelected(true);
                jchk1.setSelected(true);
                jchk2.setSelected(true);
                jchk3.setSelected(true);
            }
        });


        JButton jbt4 = new JButton(" ESC ");
        jbt4.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                gmod.dlg1.setVisible(false);

            }
        });


        JTextArea jtextarea1 = new JTextArea("6");

        JButton jbt = new JButton("save it ");
        jbt.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

                String cbcoursename1 = jcb1.getSelectedItem().toString();
                String cbcoursename2 = jcb2.getSelectedItem().toString();
                String cbcoursename3 = jcb3.getSelectedItem().toString();

                sscStuInfo sinfo = new sscStuInfo();
                sinfo.name = jtextfield1.getText();
                sinfo.no = jtextfield2.getText();
                sinfo.course = jtextfield9.getText();
                sinfo.gradeY = jtextfield3.getText();
                sinfo.gradeM = jtextfield4.getText();
                sinfo.gradeE = jtextfield5.getText();
                sinfo.grade1 = jtextfield6.getText();
                sinfo.grade2 = jtextfield7.getText();
                sinfo.grade3 = jtextfield8.getText();
                sinfo.cbcoursename1 = cbcoursename1;
                sinfo.cbcoursename2 = cbcoursename2;
                sinfo.cbcoursename3 = cbcoursename3;

                saveandread.StuInfortoArray2(sinfo);


            }
        });

        JButton jbt2 = new JButton("save all ");
        jbt2.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                saveandread o = new saveandread();
                try {
                    o.WriteArraytoFile("testfile1.txt");
                }catch (FileNotFoundException ec){
                    ec.printStackTrace();
                }

            }
        });

        //setLayout(new GridLayout(7,2));
        setLayout(new BorderLayout());


        //JCheckBox jchk = new JCheckBox("选修课 ",true);

        jchk.addItemListener(new ItemListener() {


            @Override
            public void itemStateChanged(ItemEvent arg0) {
                // TODO Auto-generated method stub
                boolean b = jchk.isSelected();
                jcb1.setEnabled(b);
                jtextfield6.setEnabled(b);
                jcb2.setEnabled(b);
                jtextfield7.setEnabled(b);
                jcb3.setEnabled(b);
                jtextfield8.setEnabled(b);

                jchk1.setEnabled(b);
                jchk2.setEnabled(b);
                jchk3.setEnabled(b);

                //jchk.isSelected();
            }


        });


        jchk1.addActionListener(new ActionListener() {


//				if( jchk.isSelected() == true){
//					jcb1.setEnabled(true);
//					jtextfield6.setEnabled(true);
//					
//					
//				}
//				else if  ( jchk.isSelected() == false){
//					jcb1.setEnabled(false);
//					jtextfield6.setEnabled(false);
//				
//				}

            ///////////////


            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean b = jchk1.isSelected();

                jcb1.setEnabled(b);
                jtextfield6.setEnabled(b);

                // TODO Auto-generated method stub

            }


        });


        jchk2.addItemListener(new ItemListener() {


            @Override
            public void itemStateChanged(ItemEvent arg0) {

                boolean b = jchk2.isSelected();

                jcb2.setEnabled(b);
                jtextfield7.setEnabled(b);
                // TODO Auto-generated method stub
                //jchk2.isSelected();
            }


        });


        jchk3.addItemListener(new ItemListener() {


            @Override
            public void itemStateChanged(ItemEvent arg0) {
                // TODO Auto-generated method stub
                boolean b = jchk3.isSelected();

                jcb3.setEnabled(b);
                jtextfield8.setEnabled(b);
                //jchk3.isSelected();
            }


        });


//		getContentPane().add(label1);
//		getContentPane().add(jtextfield1 );
//		getContentPane().add(label2);
//		getContentPane().add(jtextfield2);
//		
//		getContentPane().add(label3);
//		getContentPane().add(jtextfield3 );
//		getContentPane().add(label4);
//		getContentPane().add(jtextfield4 );
//		//getContentPane().add(jbt );
        //getContentPane().add(jbt );
        //getContentPane().add(jbt );
        //getContentPane().add(jbt );
        //getContentPane().add(jbt );


//		JPanel jp1 = new JPanel();
//		JPanel jp1_1 = new JPanel();
//		jp1_1.setLayout(new GridLayout(4,1));
//		jp1_1.add(label1);
//		jp1_1.add(label2);
//		jp1_1.add(label3);
//		jp1_1.add(label4);
//		JPanel jp1_2 = new JPanel();
//		jp1_2.setLayout(new GridLayout(4,1));
//		jp1_2.add(jtextfield1);
//		jp1_2.add(jtextfield2);
//		jp1_2.add(jtextfield3);
//		jp1_2.add(jtextfield4);


//		jp1.setLayout(new BorderLayout());
//		//jp1.add(jp1_1);
//		jp1.add(jp1_2);
        setLocationRelativeTo(null);
//		
//		
//		JPanel jp2_2 = new JPanel();
//		jp2_2.add(jbt);
//		jp2_2.add(jbt2);


        /////////////////////////////////////////////////////////////


        //jp1.setSize(300, 200);

        //this.add(jp1);
        //add(label1);
        //add(label2);
        //add(label3);
        //add(label4);
        //add(jtextfield1);
        //add(jtextarea1);

        //add(jp2_2,BorderLayout.SOUTH);

        this.setLayout(new GridLayout(15, 2));

        add(label1);
        add(jtextfield1);
        add(label2);
        add(jtextfield2);
        add(label3);
        add(jtextfield3);
        add(label4);
        add(jtextfield4);
        add(label5);
        add(jtextfield5);
        add(label13);
        add(jtextfield9);
        add(jchk);
        add(label9);
        add(jchk1);
        //add(label10);
        add(jcb1);
        add(label6);
        add(jtextfield6);
        add(jchk2);
        //add(label11);
        add(jcb2);
        add(label7);
        add(jtextfield7);
        add(jchk3);
        //add(label12);
        add(jcb3);
        add(label8);
        add(jtextfield8);
        add(jbt, BorderLayout.SOUTH);
        add(jbt2, BorderLayout.SOUTH);
        add(jbt3, BorderLayout.SOUTH);
        add(jbt4, BorderLayout.SOUTH);


    }

}
