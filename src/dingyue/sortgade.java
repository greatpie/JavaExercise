package dingyue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class sortgade extends JFrame implements ActionListener{

    int Radiovalue = 1;
    JRadioButton jrb1;
    JRadioButton jrb2;
    JRadioButton jrb3;
    JRadioButton jrb4;

    public sortgade() {

        JLabel label1 = new JLabel("请选择课程名:");
        jrb1 = new JRadioButton("语文", true);
        jrb2 = new JRadioButton("数学", true);
        jrb3 = new JRadioButton("英语", true);
        jrb4 = new JRadioButton("退出", true);

        jrb1.addActionListener(this);
        jrb2.addActionListener(this);
        jrb3.addActionListener(this);
        jrb4.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(jrb1);
        group.add(jrb2);
        group.add(jrb3);
        group.add(jrb4);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3, 1));
        jp.add(jrb1);
        jp.add(jrb2);
        jp.add(jrb3);
        jp.add(jrb4);

        // this.setLayout( new GridLayout(4,2));

        // add(label1);
        // add( jtextfield1);

        JButton jbt = new JButton("CLick it ");
        jbt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

                String[] arrSortStr = SortGrade(Radiovalue);

                switch (Radiovalue) {
                    case 1:

                        JFrame frame = new listviewsort(arrSortStr);
                        frame.setSize(500, 300);
                        // frame.pack();
                        frame.setVisible(true);

                        break;
                    case 2:
                        JFrame frame2 = new listviewsort(arrSortStr);
                        frame2.setSize(500, 300);
                        // frame.pack();
                        frame2.setVisible(true);

                        break;
                    case 3:
                        JFrame frame3 = new listviewsort(arrSortStr);
                        frame3.setSize(500, 300);
                        // frame.pack();
                        frame3.setVisible(true);

                        break;
                    case 4:
                        gmod.dlg3.setVisible(false);
                        break;
                }

            }
        });

        add(label1, BorderLayout.NORTH);
        add(jp);
        add(jbt, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==jrb1){
            Radiovalue = 1;
        }
        if(e.getSource()==jrb2){
            Radiovalue = 2;
        }
        if(e.getSource()==jrb3){
            Radiovalue = 3;
        }
        if(e.getSource()==jrb4){
            Radiovalue = 4;
        }
    }

    public String[] SortGrade(int Radiovalue) {

//		switch (Radiovalue) {
//		case 1:// 语文
//
//			break;
//		case 2:// 数学
//			break;
//		case 3:// 英语
//			break;
//
//		default:
//			// 意外
//			;
//		}

        // sort
        // 1,从文件读出数据

        saveandread sr = new saveandread();
        sr.read();

        sscStuInfo[] array = saveandread.arrStuInfo2;

        // 2，数据按照要求排序
        int n;
        n = Radiovalue;

        String[] out_sort = __sort(array, 200, n);

        String[] out_sort2 = new String[out_sort.length + 1];

        for (int i = 0; i < out_sort.length; i++) {
            out_sort2[i + 1] = out_sort[i];

        }

        out_sort2[0] = "排名  姓名  学号  成绩";

        return out_sort2;

    }

    String[] __sort(sscStuInfo[] arrStuInfo, int arrNum, int cousreNo) {

        // 1 sscStuInfo[] -> ArrayList
        ArrayList<sscStuInfo> arrLsInfo = new ArrayList<sscStuInfo>();

        for (int i = 0; i < arrNum; i++) {
            sscStuInfo arg0 = arrStuInfo[i];
            arrLsInfo.add(arg0);
        }

        // 2 sort
        String list1[] = new String[100];

        if (cousreNo == 1) {
            Collections.sort(arrLsInfo, compChinese);

            int j = 0;
            for (j = 0; j < arrLsInfo.size(); j++) {

                if (arrLsInfo.get(j) != null)

                    list1[j] = j + 1 + "         " + arrLsInfo.get(j).name + "         "
                            + arrLsInfo.get(j).no + "         " + arrLsInfo.get(j).gradeY;
            }
        } else if (cousreNo == 2) {
            Collections.sort(arrLsInfo, compMath);
            int j = 0;
            for (j = 0; j < arrLsInfo.size(); j++) {

                if (arrLsInfo.get(j) != null)

                    list1[j] = j + 1 + "         " + arrLsInfo.get(j).name + "         "
                            + arrLsInfo.get(j).no + "         " + arrLsInfo.get(j).gradeM;
            }
        } else if (cousreNo == 3) {
            Collections.sort(arrLsInfo, compEnglish);
            int j = 0;
            for (j = 0; j < arrLsInfo.size(); j++) {

                if (arrLsInfo.get(j) != null)

                    list1[j] = j + 1 + "         " + arrLsInfo.get(j).name + "         "
                            + arrLsInfo.get(j).no + "         " + arrLsInfo.get(j).gradeE;
            }
        }
        // arrls -> string[]
        // string[]4列，名次，姓名，學號，成績

        return list1;

    }

    Comparator<sscStuInfo> compChinese = new Comparator<sscStuInfo>() {
        public int compare(sscStuInfo in1, sscStuInfo in2) {

            if (in1 == null || in2 == null)
                return 1;

            double gradeY1 = Double.parseDouble(in1.gradeY);
            double gradeY2 = Double.parseDouble(in2.gradeY);
            if (gradeY1 < gradeY2)
                return 1;
            else
                return -1;
        }

    };

    Comparator<sscStuInfo> compMath = new Comparator<sscStuInfo>() {
        public int compare(sscStuInfo in1, sscStuInfo in2) {
            if (in1 == null || in2 == null)
                return 1;
            double gradeM1 = Double.parseDouble(in1.gradeM);
            double gradeM2 = Double.parseDouble(in2.gradeM);
            if (gradeM1 < gradeM2)
                return 1;
            else
                return -1;
        }
    };

    Comparator<sscStuInfo> compEnglish = new Comparator<sscStuInfo>() {
        public int compare(sscStuInfo in1, sscStuInfo in2) {
            if (in1 == null || in2 == null)
                return 1;
            double gradeE1 = Double.parseDouble(in1.gradeE);
            double gradeE2 = Double.parseDouble(in2.gradeE);
            if (gradeE1 < gradeE2)
                return 1;
            else
                return -1;
        }
    };
}
