package dingyue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class querystudent2 extends JFrame implements ActionListener{
    JLabel label4 = new JLabel(" �������ѯ��Ϣ:");
    String list2[] = new String[100];
    String[] arrSortStr;
    JLabel labName;
    JLabel labNo;
    JLabel label3;
    JTextField jtextName;
    JTextField jtextNo;
    JTextArea jtextarea2;
    JButton jbt3;
    JButton jbt4;
    public querystudent2() {
        labName = new JLabel("������ѧ������");
        labNo = new JLabel("������ѧ��ѧ��");
        label3 = new JLabel(" ");

        jtextName = new JTextField("");
        jtextNo = new JTextField("");

        jtextarea2 = new JTextArea("6");

        jbt3 = new JButton(" �˳� ");
        jbt3.addActionListener(this);

        jbt4 = new JButton(" ��ѯ ");
        jbt4.addActionListener(this);

        this.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\tupian.jpg");
        JLabel labimg1 = new JLabel(img);

        labimg1.setBounds(0, 0, 500, 80);

        add(labimg1);


        add(label4);

        add(labName);
        add(jtextName);
        add(labNo);
        add(jtextNo);

        add(jbt4);
        add(jbt3);

        label4.setBounds(100, 100, 100, 25);
        labName.setBounds(100, 100 + 30, 100, 25);
        jtextName.setBounds(100 + 100, 100 + 30, 100, 25);

        labNo.setBounds(100, 100 + 60, 100, 25);
        jtextNo.setBounds(100 + 100, 100 + 60, 100, 25);

        jbt4.setBounds(100, 100 + 90, 100, 25);
        jbt3.setBounds(100 + 100, 100 + 90, 100, 25);


    }

    public String[] SortGrade(String SName, String SNo) {

//			switch (Radiovalue) {
//			case 1:// ����
        //
//				break;
//			case 2:// ��ѧ
//				break;
//			case 3:// Ӣ��
//				break;
        //
//			default:
//				// ����
//				;
//			}

        // sort
        // 1,���ļ���������

        saveandread sr = new saveandread();
        sr.read();

        sscStuInfo[] array = saveandread.arrStuInfo2;

        // 2�����ݰ���Ҫ�����


        String[] out_sort = shuru(array, SName, SNo);


        return out_sort;

    }


    public String[] shuru(sscStuInfo[] arrStuInfo, String Name, String No) {

        int i = 0;

        //sscStuInfo2 _info = new sscStuInfo2();
        int g = 0;
        for (g = 0; g < arrStuInfo.length; g++) {

            if (arrStuInfo[g] == null) continue;

            //double no  = Double.parseDouble(_info.no );
            if (Name.equals(arrStuInfo[g].name) && No.equals(arrStuInfo[g].no)) {


                String name2 = saveandread.arrStuInfo2[g].name;
                String no2 = saveandread.arrStuInfo2[g].no;
                String course = saveandread.arrStuInfo2[g].course;
                String gradeY = saveandread.arrStuInfo2[g].gradeY;
                String gradeM = saveandread.arrStuInfo2[g].gradeM;
                String gradeE = saveandread.arrStuInfo2[g].gradeE;
                String grade1 = saveandread.arrStuInfo2[g].grade1;
                String grade2 = saveandread.arrStuInfo2[g].grade2;
                String grade3 = saveandread.arrStuInfo2[g].grade3;
                String cbcoursename1 = saveandread.arrStuInfo2[g].cbcoursename1;
                String cbcoursename2 = saveandread.arrStuInfo2[g].cbcoursename2;
                String cbcoursename3 = saveandread.arrStuInfo2[g].cbcoursename3;

                this.list2[i] = "ѧ������" + "   " + name2 + "\n  ";
                this.list2[i + 1] = "ѧ��ѧ��" + "   " + no2 + "\n  ";
                this.list2[i + 2] = "ѡ������" + "   " + course + "\n  ";
                this.list2[i + 3] = "���ĳɼ�" + "   " + gradeY + "\n  ";
                this.list2[i + 4] = "���ĳɼ�" + "   " + gradeY + "\n  ";
                this.list2[i + 5] = "��ѧ�ɼ�" + "   " + gradeM + "\n  ";
                this.list2[i + 6] = "Ӣ��ɼ�" + "   " + gradeE + "\n  ";
                this.list2[i + 7] = "ѡ�޿�һ" + "   " + cbcoursename1 + "\n  ";
                this.list2[i + 8] = "�ɼ�һ" + "   " + grade1 + "\n  ";
                this.list2[i + 9] = "ѡ�޿ζ�" + "   " + cbcoursename2 + "\n  ";
                this.list2[i + 10] = "�ɼ�һ" + "   " + grade2 + "\n  ";
                this.list2[i + 11] = "ѡ�޿���" + "   " + cbcoursename3 + "\n  ";
                this.list2[i + 12] = "�ɼ���" + "   " + grade3 + "\n  ";

                i++;
                return list2;
            }

        }
        return null;
    }
    public void actionPerformed(ActionEvent ev) {
        // TODO Auto-generated method stub
        if(ev.getSource() == jbt3) {

            gmod.dlg2.setVisible(false);
        }
        if(ev.getSource()==jbt4){

            String name = jtextName.getText();
            String no = jtextNo.getText();
            arrSortStr = SortGrade(name, no);
            if (arrSortStr == null) {

                JOptionPane.showMessageDialog(null, "ѧ����ϢΪ��");
                return;
            }

            JFrame frame = new viewinformation(arrSortStr);
            frame.setSize(500, 300);
            frame.setVisible(true);
        }


    }
}


		 
