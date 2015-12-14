package liuyixiao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by pie on 2015-6-18.
 */

public class GetArea extends JFrame implements ActionListener{
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JButton submit;
    private JLabel lb4;
    private JLabel resLb;
    private JComboBox type;
    public GetArea(){
        lb1 = new JLabel("半径，长，上底：");
        lb2 = new JLabel("宽，下底");
        lb3 = new JLabel("高");
        tf1 = new JTextField("");
        tf2 = new JTextField("");
        tf3 = new JTextField("");
        submit = new JButton("计算");
        submit.addActionListener(this);
        lb4 = new JLabel("结果为：");
        resLb = new JLabel("");
        type = new JComboBox();
        type.addItem("圆");
        type.addItem("矩形");
        type.addItem("梯形");
        setBounds(200,200,100,200);
        setLayout(new GridLayout(5,2));
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);
        add(type);
        add(submit);
        add(lb4);
        add(resLb);
        setTitle("面积计算");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(submit)){
            int k = type.getSelectedIndex();

            double a=0,b=0,c=0;
            double m=0;
        try {
            a = Double.parseDouble(tf1.getText());
            b = Double.parseDouble(tf2.getText());
            c = Double.parseDouble(tf2.getText());
        }catch (Exception ec){
            ec.printStackTrace();
        }

        switch (k){
            case 0:m = caculatePlus(a);break;
            case 1:m = caculatePlus(a,b);
            case 2:m = caculatePlus(a,b,c);
        }
            String resultStr = String.valueOf(m);
            resLb.setText(resultStr);
        }
    }

//    public double caculate(int k){
//        double m = 0;
//        double a=0,b=0,c=0;
//        try {
//            a = Double.parseDouble(tf1.getText());
//            b = Double.parseDouble(tf2.getText());
//            c = Double.parseDouble(tf2.getText());
//        }catch (Exception ec){
//            ec.printStackTrace();
//        }
//
//        switch (k){
//            case 0:m = Math.PI*a*a;break;
//            case 1:m = a*b;break;
//            case 2:m = (a+b)*c/2;
//        }
//        return m;
//    }

    //多态形式
    public double caculatePlus(double a){
        return Math.PI*a*a;
    }
    public double caculatePlus(double a,double b){
        return a*b;
    }

    public double caculatePlus(double a,double b,double c){
        return  (a+b)*c/2;
    }



    public static void main(String[] args){
        new GetArea();
    }

}

