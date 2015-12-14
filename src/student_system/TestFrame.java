package student_system;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class TestFrame extends JFrame implements ActionListener, MouseListener
{
    private static final long serialVersionUID = 1L;
    String FileName = "information.txt";
    private JMenuBar typeMenu;  //创建菜单条
    private JMenu file, display, edit, help, sort,delete,alter,add,subject,search,avg;  //创建菜单
    private JMenuItem seeItem,addStudent,pageone,exit,alterName,alterID,
            deleteID,deleteName,deleteClass,deleteSex,deleteAge,deleteCollage,
            searchID,searchName,searchClass,searchSex,searchAge,searchCollage,
            ID, age, English,math, Pe, java,  //创建菜单项变量

    totalGrade,helpItem,avgMath,avgJava,avgPe,avgEnglish;
    private CardLayout cardl;  //创建一个具有指定水平间距和垂直间距的新卡片布局
    private TableColumn col1,col2,col3,col4,col5,col6,col7,col8,col9,col10;
    private JPanel card,jpSee,jpAddStudent,jpAlterByID,jpAlterByName, jpMain,jpSearch,jphelp;
    private JTable jtable;
    private JLabel jl,jlAdd1, jlAdd2, jlAdd3, jlAdd4, jlAdd5, jlAdd6, jlAdd7, jlAdd8, jlAdd9, jlAdd10, jlAdd11, jlAdd12,jlAdd13,
            jlMain1, jlMain2,
            jlAlter1,jlAlter2,jlAlter3,jlAlter4,jlAlter5,jlAlter6,jlAlter7;
    private JTextField jtAddClass, jtAddID, jtAddName, jtAddAge,jtAddCollage, jtAddEnglish, jtAddMath, jtAddPe, jtAddJava,
            jtAlterID,jtAlterName,jtAlterAge,jtAlterClass,jtAlterCollage,jtAlterMath,jtAlterEnglish,jtAlterJava,jtAlterPe,
            jtAlterID2,jtAlterName2,jtAlterAge2,jtAlterClass2,jtAlterCollage2,jtAlterMath2,jtAlterEnglish2,jtAlterJava2,jtAlterPe2;
    private JRadioButton jr_man, jr_woman,jr_man2, jr_woman2;
    private ButtonGroup sexgroup,sexgroup2;
    private JButton jbAddSure,jbAlterSure,jbAlterSure2;
    private int row;
    private JScrollPane js;
    private String[][] student = new String [100][25];
    Student[] stus=new Student[100];
    public TestFrame()
    {
        Container c = getContentPane();
        c.setLayout(null);
        typeMenu = new JMenuBar();// 应用程序菜单的容器
        setJMenuBar(typeMenu);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // 菜单File
        file = new JMenu("系统");
        file.setFont(new Font("宋体", Font.PLAIN, 14));
        typeMenu.add(file);
        // 菜单Display
        display = new JMenu("查看");
        display.setFont(new Font("宋体", Font.PLAIN, 14));
        typeMenu.add(display);
        // 菜单Edit
        edit = new JMenu("编辑信息");
        edit.setFont(new Font("宋体", Font.PLAIN, 14));
        typeMenu.add(edit);
        // 菜单Sort
        sort = new JMenu("排序");
        sort.setFont(new Font("宋体", Font.PLAIN, 14));
        typeMenu.add(sort);
        //菜单Avg
        avg = new JMenu("平均分");
        avg.setFont(new Font("宋体", Font.PLAIN, 14));
        typeMenu.add(avg);
        // 菜单Help
        help = new JMenu("Help");
        help.setFont(new Font("宋体", Font.PLAIN, 14));
        typeMenu.add(help);
        //Help
        helpItem = new JMenuItem("Help");
        helpItem.setFont(new Font("宋体", Font.PLAIN, 14));
        help.add(helpItem);
        helpItem.addActionListener(this);
        helpItem.setActionCommand("帮助");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //首页
        pageone = new JMenuItem("首页");
        pageone.setFont(new Font("宋体", Font.PLAIN, 14));
        file.add(pageone);
        pageone.addActionListener(this);
        pageone.setActionCommand("首页");
        file.addSeparator();
        //退出
        exit = new JMenuItem("退出");
        exit.setFont(new Font("宋体", Font.PLAIN, 14));
        file.add(exit);
        exit.addActionListener(this);
        exit.setActionCommand("退出");
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //查看
        seeItem  = new JMenuItem("查看");
        seeItem.setFont(new Font("宋体", Font.PLAIN, 14));
        display.add(seeItem);
        seeItem.addActionListener(this);
        seeItem.setActionCommand("查看");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //删除
        delete = new JMenu("删除");
        delete.setMnemonic(KeyEvent.VK_D);  //将delete邦定Alt+D键
        delete.setFont(new Font("宋体", Font.PLAIN, 14));
        edit.add(delete);
        delete.addActionListener(this);
        delete.setActionCommand("删除"); //设置此组件激发的操作事件的命令名称
        edit.addSeparator();
        //按学号删除
        deleteID = new JMenuItem("按学号删除");
        deleteID.setFont(new Font("宋体", Font.PLAIN, 13));
        delete.add(deleteID);
        deleteID.addActionListener(this);
        deleteID.setActionCommand("按学号删除");
        delete.addSeparator();
        //按姓名删除
        deleteName = new JMenuItem("按姓名删除");
        deleteName.setFont(new Font("宋体", Font.PLAIN, 13));
        delete.add(deleteName);
        deleteName.addActionListener(this);
        deleteName.setActionCommand("按姓名删除");
        delete.addSeparator();
        //按学院删除
        deleteCollage = new JMenuItem("按学院删除");
        deleteCollage.setFont(new Font("宋体", Font.PLAIN, 13));
        delete.add(deleteCollage);
        deleteCollage.addActionListener(this);
        deleteCollage.setActionCommand("按学院删除");
        delete.addSeparator();
        //按班级删除
        deleteClass = new JMenuItem("按班级删除");
        deleteClass.setFont(new Font("宋体", Font.PLAIN, 13));
        delete.add(deleteClass);
        deleteClass.addActionListener(this);
        deleteClass.setActionCommand("按班级删除");
        delete.addSeparator();
        //按性别删除
        deleteSex = new JMenuItem("按性别删除");
        deleteSex.setFont(new Font("宋体", Font.PLAIN, 13));
        delete.add(deleteSex);
        deleteSex.addActionListener(this);
        deleteSex.setActionCommand("按性别删除");
        delete.addSeparator();
        //按年龄删除
        deleteAge = new JMenuItem("按年龄删除");
        deleteAge.setFont(new Font("宋体", Font.PLAIN, 13));
        delete.add(deleteAge);
        deleteAge.addActionListener(this);
        deleteAge.setActionCommand("按年龄删除");
        //添加
        add = new JMenu("添加");
        add.setMnemonic(KeyEvent.VK_A);
        add.setFont(new Font("宋体", Font.PLAIN, 14));
        edit.add(add);
        edit.addSeparator();
        add.addActionListener(this);
        add.setActionCommand("添加");
        //添加学生
        addStudent = new JMenuItem("添加学生");
        addStudent.setFont(new Font("宋体", Font.PLAIN, 13));
        add.add(addStudent);
        addStudent.addActionListener(this);
        addStudent.setActionCommand("添加学生");
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //修改
        alter = new JMenu("修改");
        alter.setMnemonic(KeyEvent.VK_A);
        alter.setFont(new Font("宋体", Font.PLAIN, 14));
        edit.add(alter);
        alter.addActionListener(this);
        alter.setActionCommand("修改");
        edit.addSeparator();
        //按学号修改
        alterID = new JMenuItem("按学号修改");
        alterID.setFont(new Font("宋体", Font.PLAIN, 13));
        alter.add(alterID);
        alterID.addActionListener(this);
        alterID.setActionCommand("按学号修改");
        alter.addSeparator();
        //按姓名修改
        alterName = new JMenuItem("按姓名修改");
        alterName.setFont(new Font("宋体", Font.PLAIN, 13));
        alter.add(alterName);
        alterName.addActionListener(this);
        alterName.setActionCommand("按姓名修改");
        //查询
        search = new JMenu("查询");
        search.setFont(new Font("宋体", Font.PLAIN, 14));
        edit.add(search);
        search.addActionListener(this);
        search.setActionCommand("查询");
        //按学号查询
        searchID = new JMenuItem("按学号查询");
        searchID.setFont(new Font("宋体", Font.PLAIN, 13));
        search.add(searchID);
        searchID.addActionListener(this);
        searchID.setActionCommand("按学号查询");
        search.addSeparator();
        //姓名查询
        searchName = new JMenuItem("按姓名查询");
        searchName.setFont(new Font("宋体", Font.PLAIN, 13));
        search.add(searchName);
        searchName.addActionListener(this);
        searchName.setActionCommand("按姓名查询");
        search.addSeparator();
        //按学院查询
        searchCollage = new JMenuItem("按学院查询");
        searchCollage.setFont(new Font("宋体", Font.PLAIN, 13));
        search.add(searchCollage);
        searchCollage.addActionListener(this);
        searchCollage.setActionCommand("按学院查询");
        search.addSeparator();
        //按班级查询
        searchClass = new JMenuItem("按班级查询");
        searchClass.setFont(new Font("宋体", Font.PLAIN, 13));
        search.add(searchClass);
        searchClass.addActionListener(this);
        searchClass.setActionCommand("按班级查询");
        search.addSeparator();
        //按性别查询
        searchSex = new JMenuItem("按性别查询");
        searchSex.setFont(new Font("宋体", Font.PLAIN, 13));
        search.add(searchSex);
        searchSex.addActionListener(this);
        searchSex.setActionCommand("按性别查询");
        search.addSeparator();
        //按年龄查询
        searchAge = new JMenuItem("按年龄查询");
        searchAge.setFont(new Font("宋体", Font.PLAIN, 13));
        search.add(searchAge);
        searchAge.addActionListener(this);
        searchAge.setActionCommand("按年龄查询");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //排序
        //按学号排序
        ID = new JMenuItem("按学号排序");
        ID.setFont(new Font("宋体", Font.PLAIN, 14));
        sort.add(ID);
        sort.addSeparator();
        ID.addActionListener(this);
        ID.setActionCommand("按学号排序");
        //按年龄排序
        age = new JMenuItem("按年龄排序");
        age.setFont(new Font("宋体", Font.PLAIN, 14));
        sort.add(age);
        sort.addSeparator();
        age.addActionListener(this);
        age.setActionCommand("按年龄排序");
        //按总成绩排序
        totalGrade  = new JMenuItem("按总成绩排序");
        totalGrade.setFont(new Font("宋体", Font.PLAIN, 14));
        sort.add(totalGrade);
        sort.addSeparator();
        totalGrade.addActionListener(this);
        totalGrade.setActionCommand("按总成绩排序");
        //按单科成绩排序
        subject = new JMenu("按单科成绩排序");
        subject.setFont(new Font("宋体", Font.PLAIN, 14));
        sort.add(subject);
        //按高数排序
        math = new JMenuItem("按高数排序");
        math.setFont(new Font("宋体", Font.PLAIN, 14));
        subject.add(math);
        math.addActionListener(this);
        math.setActionCommand("按高数排序");
        subject.addSeparator();
        //按Java排序
        java = new JMenuItem("按Java排序");
        java.setFont(new Font("宋体", Font.PLAIN, 14));
        subject.add(java);
        java.addActionListener(this);
        java.setActionCommand("按Java排序");
        subject.addSeparator();
        //按英语排序
        English = new JMenuItem("按英语排序");
        English.setFont(new Font("宋体", Font.PLAIN, 14));
        subject.add( English);
        English.addActionListener(this);
        English.setActionCommand("按英语排序");
        subject.addSeparator();
        //按体育排序
        Pe = new JMenuItem("按体育排序");
        Pe.setFont(new Font("宋体", Font.PLAIN, 14));
        subject.add(Pe);
        Pe.addActionListener(this);
        Pe.setActionCommand("按体育排序");
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //课程平均分
        //求高数平均分
        avgMath = new JMenuItem("求高数平均分");
        avgMath.setFont(new Font("宋体", Font.PLAIN, 14));
        avg.add(avgMath);
        avgMath.addActionListener(this);
        avgMath.setActionCommand("求高数平均分");
        avg.addSeparator();
        //求Java平均分
        avgJava = new JMenuItem("求Java平均分");
        avgJava.setFont(new Font("宋体", Font.PLAIN, 14));
        avg.add(avgJava);
        avgJava.addActionListener(this);
        avgJava.setActionCommand("求Java平均分");
        avg.addSeparator();
        //求英语平均分
        avgEnglish = new JMenuItem("求英语平均分");
        avgEnglish.setFont(new Font("宋体", Font.PLAIN, 14));
        avg.add(avgEnglish);
        avgEnglish.addActionListener(this);
        avgEnglish.setActionCommand("求英语平均分");
        avg.addSeparator();
        //求体育平均分
        avgPe = new JMenuItem("求体育平均分");
        avgPe.setFont(new Font("宋体", Font.PLAIN, 14));
        avg.add(avgPe);
        avgPe.addActionListener(this);
        avgPe.setActionCommand("求体育平均分");
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  //
        cardl = new CardLayout();  //创建一个具有指定水平间距和垂直间距的新卡片布局对象
        card = new JPanel();
        card.setBounds(0, 0, 650, 400);  //左上角为起点，650长，400宽
        card.setOpaque(false);  //设置控件透明
        card.setLayout(cardl);
        jpSearch = new JPanel();
        jpMain = new JPanel();
        jpAddStudent = new JPanel();
        jpAlterByID = new JPanel();
        jpAlterByName = new JPanel();
        jpSee = new JPanel();
        jphelp = new JPanel();


        card.add("首页", jpMain);
        card.add("按班级查询",jpSearch);
        card.add("添加学生", jpAddStudent);
        card.add("按姓名修改", jpAlterByName);
        card.add("按学号修改", jpAlterByID);
        card.add("查看", jpSee);
        card.add("帮助", jphelp);
        c.add(card);
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //首页
        jpMain.setLayout(null);
        jlMain1 = new JLabel();
        jlMain1.setText("欢迎来到学生成绩管理系统");
        jlMain1.setBounds(150, 100, 300, 40);
        jlMain1.setFont(new Font("宋体", Font.PLAIN, 25));
        jlMain1.setForeground(Color.black);
        jpMain.add(jlMain1);
        jlMain2 = new JLabel();
        jlMain2.setText("管理员：sjx");
        jlMain2.setBounds(230, 150, 300, 40);
        jlMain2.setFont(new Font("宋体", Font.PLAIN, 20));
        jlMain2.setForeground(Color.black);
        jpMain.add(jlMain2);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //帮助
        jphelp.setLayout(null);
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        jpAlterByID.setLayout(null);
        //按学号修改
        jlAlter1 = new JLabel();
        jlAlter1.setText("按学号修改");
        jlAlter1.setBounds(200, 20, 170, 20);
        jlAlter1.setFont(new Font("宋体", Font.PLAIN, 20));
        jpAlterByID.add(jlAlter1);
        jlAlter2 = new JLabel();
        jlAlter2.setBounds(20, 70, 200, 20);
        jlAlter2.setText("*请输入要修改学生的学号：");
        jlAlter2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter2);
        //要修改学生的学号
        jtAlterID = new JTextField();
        jtAlterID.setBounds(220, 70, 150, 20);
        jtAlterID.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterID);
        //修改基本信息
        jlAlter2 = new JLabel();
        jlAlter2.setBounds(20, 100, 170, 20);
        jlAlter2.setText("*修改基本信息*");
        jlAlter2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter2);
        // 修改姓名
        jlAlter3 = new JLabel();
        jlAlter3.setBounds(80, 140, 50, 20);
        jlAlter3.setText("姓名：");
        jlAlter3.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter3);

        jtAlterName = new JTextField();
        jtAlterName.setBounds(130, 140, 150, 20);
        jtAlterName.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterName);
        // 修改年龄
        jlAlter4 = new JLabel();
        jlAlter4.setBounds(320, 140, 50, 20);
        jlAlter4.setText("年龄：");
        jlAlter4.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter4);

        jtAlterAge = new JTextField();
        jtAlterAge.setBounds(370, 140, 150, 20);
        jtAlterAge.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterAge);

        // 修改学院
        jlAlter6 = new JLabel();
        jlAlter6.setBounds(80, 170, 50, 20);
        jlAlter6.setText("学院:");
        jlAlter6.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter6);

        jtAlterCollage = new JTextField();
        jtAlterCollage.setBounds(130, 170, 150, 20);
        jtAlterCollage.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterCollage);
        //修改班级
        jlAlter7 = new JLabel();
        jlAlter7.setBounds(320, 170, 50, 20);
        jlAlter7.setText("班级:");
        jlAlter7.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter7);
        jtAlterClass = new JTextField();
        jtAlterClass.setBounds(370, 170, 150, 20);
        jtAlterClass.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterClass);
        // 修改性别
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 210, 50, 20);
        jlAlter5.setText("性别：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);

        jr_man = new JRadioButton();
        jr_man.setText("男");
        jr_man.setFont(new Font("宋体", Font.PLAIN, 16));
        jr_man.setSelected(true);
        jr_man.setBounds(130, 210, 50, 20);
        jr_woman = new JRadioButton();
        jr_woman.setText("女");
        jr_woman.setFont(new Font("宋体", Font.PLAIN, 16));
        jr_woman.setBounds(180, 210, 50, 20);
        sexgroup = new ButtonGroup();
        sexgroup.add(jr_man);
        sexgroup.add(jr_woman);
        jpAlterByID.add(jr_man);
        jpAlterByID.add(jr_woman);
        // 修改成绩
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(20, 240, 200, 20);
        jlAlter5.setText("*修改单科成绩*");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);
        // 修改高数
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 270, 50, 20);
        jlAlter5.setText("高数：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);

        jtAlterMath = new JTextField();
        jtAlterMath.setBounds(130, 270, 150, 20);
        jtAlterMath.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterMath);
        //修改英语
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(320, 270, 80, 20);
        jlAlter5.setText("英语：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);

        jtAlterEnglish = new JTextField();
        jtAlterEnglish.setBounds(400, 270, 150, 20);
        jtAlterEnglish.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterEnglish);
        // 修改Java
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 300, 50, 20);
        jlAlter5.setText("Java：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);

        jtAlterJava = new JTextField();
        jtAlterJava.setBounds(130, 300, 150, 20);
        jtAlterJava.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterJava);
        // 修改体育
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(320, 300, 80, 20);
        jlAlter5.setText("体育：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);
        jtAlterPe = new JTextField();
        jtAlterPe.setBounds(400, 300, 150, 20);
        jtAlterPe.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterPe);

        jbAlterSure = new JButton();
        jbAlterSure.setBounds(500, 325, 50, 20);
        jbAlterSure.addActionListener(this);
        jbAlterSure.setActionCommand("按学号修改提交");
        jpAlterByID.add(jbAlterSure);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        jpAlterByName.setLayout(null);
        //按姓名修改
        jlAlter1 = new JLabel();
        jlAlter1.setText("按姓名修改");
        jlAlter1.setBounds(230, 20, 170, 20);
        jlAlter1.setFont(new Font("宋体", Font.PLAIN, 20));
        jpAlterByName.add(jlAlter1);
        jlAlter2 = new JLabel();
        jlAlter2.setBounds(20, 70, 200, 20);
        jlAlter2.setText("*请输入要修改学生的姓名：");
        jlAlter2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter2);
        //要修改学生的姓名
        jtAlterName2 = new JTextField();
        jtAlterName2.setBounds(220, 70, 150, 20);
        jtAlterName2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterName2);
        //修改基本信息
        jlAlter2 = new JLabel();
        jlAlter2.setBounds(20, 100, 170, 20);
        jlAlter2.setText("*修改基本信息*");
        jlAlter2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter2);
        // 修改学号
        jlAlter3 = new JLabel();
        jlAlter3.setBounds(80, 140, 50, 20);
        jlAlter3.setText("学号：");
        jlAlter3.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter3);

        jtAlterID2 = new JTextField();
        jtAlterID2.setBounds(130, 140, 150, 20);
        jtAlterID2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterID2);
        // 修改年龄
        jlAlter4 = new JLabel();
        jlAlter4.setBounds(320, 140, 50, 20);
        jlAlter4.setText("年龄：");
        jlAlter4.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter4);

        jtAlterAge2 = new JTextField();
        jtAlterAge2.setBounds(370, 140, 150, 20);
        jtAlterAge2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterAge2);

        // 修改学院
        jlAlter6 = new JLabel();
        jlAlter6.setBounds(80, 170, 50, 20);
        jlAlter6.setText("学院:");
        jlAlter6.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter6);

        jtAlterCollage2 = new JTextField();
        jtAlterCollage2.setBounds(130, 170, 150, 20);
        jtAlterCollage2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterCollage2);
        //修改班级
        jlAlter7 = new JLabel();
        jlAlter7.setBounds(320, 170, 50, 20);
        jlAlter7.setText("班级:");
        jlAlter7.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter7);
        jtAlterClass2 = new JTextField();
        jtAlterClass2.setBounds(370, 170, 150, 20);
        jtAlterClass2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterClass2);
        // 修改性别
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 210, 50, 20);
        jlAlter5.setText("性别：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);

        jr_man2 = new JRadioButton();
        jr_man2.setText("男");
        jr_man2.setFont(new Font("宋体", Font.PLAIN, 16));
        jr_man2.setSelected(true);
        jr_man2.setBounds(130, 210, 50, 20);
        jr_woman2 = new JRadioButton();
        jr_woman2.setText("女");
        jr_woman2.setFont(new Font("宋体", Font.PLAIN, 16));
        jr_woman2.setBounds(180, 210, 50, 20);
        sexgroup2 = new ButtonGroup();
        sexgroup2.add(jr_man2);
        sexgroup2.add(jr_woman2);
        jpAlterByName.add(jr_man2);
        jpAlterByName.add(jr_woman2);
        // 修改成绩
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(20, 240, 200, 20);
        jlAlter5.setText("*修改单科成绩*");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);
        // 修改高数
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 270, 50, 20);
        jlAlter5.setText("高数：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);

        jtAlterMath2 = new JTextField();
        jtAlterMath2.setBounds(130, 270, 150, 20);
        jtAlterMath2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterMath2);
        //修改英语
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(320, 270, 80, 20);
        jlAlter5.setText("英语：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);

        jtAlterEnglish2 = new JTextField();
        jtAlterEnglish2.setBounds(400, 270, 150, 20);
        jtAlterEnglish2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterEnglish2);
        // 修改Java
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 300, 50, 20);
        jlAlter5.setText("Java：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);

        jtAlterJava2 = new JTextField();
        jtAlterJava2.setBounds(130, 300, 150, 20);
        jtAlterJava2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterJava2);
        // 修改体育
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(320, 300, 80, 20);
        jlAlter5.setText("体育：");
        jlAlter5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);
        jtAlterPe2 = new JTextField();
        jtAlterPe2.setBounds(400, 300, 150, 20);
        jtAlterPe2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterPe2);

        jbAlterSure2 = new JButton();
        jbAlterSure2.setBounds(500, 325, 50, 20);
        jbAlterSure2.addActionListener(this);
        jbAlterSure2.setActionCommand("按姓名修改提交");
        jpAlterByName.add(jbAlterSure2);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //添加
        jpAddStudent.setLayout(null);
        jlAdd1 = new JLabel();
        jlAdd1.setBounds(200, 20, 200, 20);
        jlAdd1.setText("添加学生基本信息");
        jlAdd1.setFont(new Font("宋体", Font.PLAIN, 20));
        jpAddStudent.add(jlAdd1);
        // 添加基本信息
        jlAdd2 = new JLabel();
        jlAdd2.setBounds(20, 60, 100, 20);
        jlAdd2.setText("*基本信息：");
        jlAdd2.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd2);
        //添加学号
        jlAdd3 = new JLabel();
        jlAdd3.setBounds(80, 90, 50, 20);
        jlAdd3.setText("学号：");
        jlAdd3.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd3);
        jtAddID = new JTextField();
        jtAddID.setBounds(130, 90, 150, 20);
        jtAddID.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddID);
        // 添加姓名
        jlAdd4 = new JLabel();
        jlAdd4.setBounds(320, 90, 50, 20);
        jlAdd4.setText("姓名：");
        jlAdd4.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd4);
        jtAddName = new JTextField();
        jtAddName.setBounds(370, 90, 150, 20);
        jtAddName.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddName);
        // 添加年龄
        jlAdd5 = new JLabel();
        jlAdd5.setBounds(80, 130, 50, 20);
        jlAdd5.setText("年龄：");
        jlAdd5.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd5);
        jtAddAge = new JTextField();
        jtAddAge.setBounds(130, 130, 150, 20);
        jtAddAge.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddAge);
        // 添加学院
        jlAdd12 = new JLabel();
        jlAdd12.setBounds(320, 130, 50, 20);
        jlAdd12.setText("学院:");
        jlAdd12.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd12);
        jtAddCollage = new JTextField();
        jtAddCollage.setBounds(370, 130, 150, 20);
        jtAddCollage.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddCollage);
        // 添加性别
        jlAdd6 = new JLabel();
        jlAdd6.setBounds(80, 170, 50, 20);
        jlAdd6.setText("性别：");
        jlAdd6.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd6);
        jr_man = new JRadioButton();
        jr_man.setText("男");
        jr_man.setFont(new Font("宋体", Font.PLAIN, 16));
        jr_man.setSelected(true);
        jr_man.setBounds(130, 170, 50, 20);
        jr_woman = new JRadioButton();
        jr_woman.setText("女");
        jr_woman.setFont(new Font("宋体", Font.PLAIN, 16));
        jr_woman.setBounds(180, 170, 50, 20);
        sexgroup = new ButtonGroup();
        sexgroup.add(jr_man);
        sexgroup.add(jr_woman);
        jpAddStudent.add(jr_man);
        jpAddStudent.add(jr_woman);
        //添加班级
        jlAdd13 = new JLabel();
        jlAdd13.setBounds(320, 170, 50, 20);
        jlAdd13.setText("班级:");
        jlAdd13.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd13);
        jtAddClass = new JTextField();
        jtAddClass.setBounds(370, 170, 150, 20);
        jtAddClass.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddClass);
        // 添加成绩
        jlAdd7 = new JLabel();
        jlAdd7.setBounds(20, 210, 100, 20);
        jlAdd7.setText("*单科成绩：");
        jlAdd7.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd7);
        // 添加高数
        jlAdd8 = new JLabel();
        jlAdd8.setBounds(80, 240, 50, 20);
        jlAdd8.setText("高数：");
        jlAdd8.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd8);
        jtAddMath = new JTextField();
        jtAddMath.setBounds(130, 240, 150, 20);
        jtAddMath.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddMath);
        // 添加英语
        jlAdd9 = new JLabel();
        jlAdd9.setBounds(320, 240, 80, 20);
        jlAdd9.setText("英语：");
        jlAdd9.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd9);
        jtAddEnglish = new JTextField();
        jtAddEnglish.setBounds(400, 240, 150, 20);
        jtAddEnglish.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddEnglish);
        // 添加Java
        jlAdd10 = new JLabel();
        jlAdd10.setBounds(80, 280, 50, 20);
        jlAdd10.setText("Java：");
        jlAdd10.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd10);
        jtAddJava = new JTextField();
        jtAddJava.setBounds(130, 280, 150, 20);
        jtAddJava.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddJava);
        // 添加体育
        jlAdd11 = new JLabel();
        jlAdd11.setBounds(320, 280, 80, 20);
        jlAdd11.setText("体育：");
        jlAdd11.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd11);
        jtAddPe = new JTextField();
        jtAddPe.setBounds(400, 280, 150, 20);
        jtAddPe.setFont(new Font("宋体", Font.PLAIN, 16));
        jpAddStudent.add(jtAddPe);
        jbAddSure = new JButton();
        jbAddSure.setBounds(500, 320, 50, 20);
        jbAddSure.setIcon(new ImageIcon("pic//tijiao.gif"));
        jbAddSure.addActionListener(this);
        jbAddSure.setActionCommand("添加提交");
        jpAddStudent.add(jbAddSure);
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //查看
        jl = new JLabel();
        jl.setBounds(110, 0, 300, 20);
        jl.setText("信息表");
        jl.setForeground(Color.gray);
        jl.setFont(new Font("宋体", Font.PLAIN, 16));
        jpSee.add(jl);

        MyTableModel Mytable = new MyTableModel();
        jtable = new JTable(Mytable);
        jtable.setShowGrid(true);
        //设置列宽
        col1 = jtable.getColumnModel().getColumn(0);
        col1.setPreferredWidth(145);
        col2 = jtable.getColumnModel().getColumn(1);
        col2.setPreferredWidth(80);
        col3 = jtable.getColumnModel().getColumn(2);
        col3.setPreferredWidth(50);
        col4 = jtable.getColumnModel().getColumn(3);
        col4.setPreferredWidth(50);
        col5 = jtable.getColumnModel().getColumn(4);
        col5.setPreferredWidth(100);
        col6 = jtable.getColumnModel().getColumn(5);
        col6.setPreferredWidth(130);
        col7 = jtable.getColumnModel().getColumn(6);
        col7.setPreferredWidth(80);
        col8 = jtable.getColumnModel().getColumn(7);
        col8.setPreferredWidth(80);
        col9 = jtable.getColumnModel().getColumn(8);
        col9.setPreferredWidth(80);
        col10 = jtable.getColumnModel().getColumn(9);
        col10.setPreferredWidth(80);
        jtable.setPreferredScrollableViewportSize(new Dimension(610, 300));
        js = new JScrollPane(jtable);
        js.setBounds(30, 20, 590, 350);
        jpSee.add(js);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        setLocation(400, 150);
        setResizable(false);
        setSize(650, 400);
        setVisible(true);
        setTitle("学生成绩管理系统");
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //判断学生是否存在
    public Boolean isEixt(String ID, String fileName)
    {
        String str = null;
        String[][] student = new String[100][];
        FileReader fr;
        BufferedReader br;
        try
        {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            try
            {
                for (int i = 0; (str = br.readLine()) != null; i++)
                {
                    Student stutemp= new Student(str.split(" "));


                    if (stutemp.ID.equals(ID))
                    {
                        return true;
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //添加基本信息
    public void add(String information, String FileName)
    {
        File file = new File(FileName);
        try
        {
            BufferedWriter bw;
            FileWriter fw;
            // 如果文件（班级）不存在则创建
            if (!file.exists())
            {
                // 创建文件（班级）
                file.createNewFile();
            }
            try
            {
                fw = new FileWriter(FileName, true);
                bw = new BufferedWriter(fw);
                bw.write(information);
                bw.newLine();
                bw.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //查看
    public void SeeAll(String FileName)
    {
        String str = null;
        for(int i =0;i<100;i++)
        {
            for(int j=0;j<12;j++)
            {
                student[i][j] = " ";
            }
        }
        try
        {
            FileReader fr = new FileReader(FileName);
            BufferedReader br = new BufferedReader(fr);
            for(int i =0;(str = br.readLine())!=null;i++)
            {
                student[i] = str.split(" ");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //查询
    public int Search(String FileName,int num,String information)
    {
        String str = null;
        String temp [][] = new String[100][12];
        int count = 0;
        int flag = 0;
        for(int i =0;i<100;i++)
        {
            for(int j=0;j<12;j++)
            {
                student[i][j] = "";
            }
        }
        try
        {
            FileReader fr = new FileReader(FileName);
            BufferedReader br = new BufferedReader(fr);
            for(int i =0;(str = br.readLine())!=null;i++)
            {
                temp[i] = str.split(" ");
                if(temp[i][num].equals(information))
                {
                    student[count] = temp[i];
                    count ++;
                    flag = 1;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return flag;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //删除
    public int delete(String FileName,int num,String information)
    {
        FileReader fr;
        BufferedReader br;
        BufferedWriter bw;
        FileWriter fw;
        String str = null;
        int count = 0;
        int k = 0;
        int flag = 0;//判断该学生是否存在 0 没有 1 有
        String temp [][] = new String[100][12];
        for(int i =0;i<100;i++)
        {
            for(int j=0;j<12;j++)
            {
                student[i][j] = "";
            }
        }
        try
        {
            fr = new FileReader(FileName);
            br = new BufferedReader(fr);
            for(int i =0;(str = br.readLine())!=null;i++)
            {
                temp[i] = str.split(" ");
                if(temp[i][num].equals(information))
                {
                    flag = 1;
                    continue;
                }
                student[count++]=temp[i];
                if(k == 0)
                {
                    fw = new FileWriter(FileName);
                    k++;
                }
                else
                {
                    fw = new FileWriter(FileName,true);
                }
                bw = new BufferedWriter(fw);
                bw.write(str);
                bw.newLine();
                bw.close();
            }
            br.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return flag;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //修改
    public int alter(int num,String information[])
    {
        FileReader fr;
        BufferedReader br;
        BufferedWriter bw;
        FileWriter fw;
        String str = null;
        String tempStr = null;
        int k =0;
        int flag = 0;//判断该学生是否存在 0 没有 1 有
        double total = 0;
        String temp [][] = new String[100][12];
        for(int i =0;i<100;i++)
        {
            for(int j=0;j<12;j++)
            {
                student[i][j] = " ";
            }
        }
        try
        {
            fr = new FileReader(FileName);
            br = new BufferedReader(fr);
            for(int i =0;(str = br.readLine())!=null;i++)
            {
                temp[i] = str.split(" ");
                if(temp[i][num].equals(information[num]))
                {System.out.print("gggggggggf");
                    tempStr = null;
                    flag = 1;
                    for(int j =0;j<= 9;j++)
                    {
                        if(information[j].equals(""))
                        {
                            if(j>=6)//修改单科成绩也要修改总成绩 和平均分
                            {
                                total += Double.parseDouble(temp[i][j]);
                            }
                            if(j == 0)
                                tempStr = temp[i][j];
                            else
                                tempStr=tempStr+" "+temp[i][j];
                            continue;
                        }
                        if(j>=6)
                        {
                            total += Double.parseDouble(information[j]);
                        }
                        temp[i][j] = information[j];
                        if(j == 0)
                            tempStr=temp[i][j];
                        else
                            tempStr=tempStr+" "+temp[i][j];
                    }
                    str = tempStr+" "+String.valueOf(total)+" "+String.valueOf((int)(total/4));
                    temp[i][10] = String.valueOf(total);temp[i][11] = String.valueOf((int)(total/4));
                }
                student[i]=temp[i];
                if(k == 0)
                {
                    fw = new FileWriter(FileName);
                    k++;
                }
                else
                {
                    fw = new FileWriter(FileName,true);
                }
                bw = new BufferedWriter(fw);
                bw.write(str);
                bw.newLine();
                bw.close();
            }
            br.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return flag;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //排序
    public void Sort(int num)
    {
        String str = null;
        double d1,d2;
        int count = 0;
        for(int i =0;i<100;i++)
        {
            for(int j=0;j<12;j++)
            {
                student[i][j] = null;
            }
        }
        try
        {
            FileReader fr = new FileReader(FileName);
            BufferedReader br = new BufferedReader(fr);
            for(int i =0;(str = br.readLine())!=null;i++)
            {
                student[i] = str.split(" ");
                count++;
            }
            for (int j = 0;j < count;j++)
            {
                for (int i = 0;i < count-1;i++)
                {
                    String[] temp;
                    d1 = Double.parseDouble(student[i][num]);
                    d2 = Double.parseDouble(student[i+1][num]);
                    if(num == 3 ||num == 6||num == 7||num == 8|| num == 9||num == 10)
                    {
                        if (d1<d2)
                        {
                            temp = student[i];
                            student[i] = student[i + 1];
                            student[i + 1] = temp;
                        }
                    }
                    else
                    {
                        if (d1>d2)
                        {
                            temp = student[i];
                            student[i] = student[i + 1];
                            student[i + 1] = temp;
                        }
                    }

                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //查询平均成绩
    public double SearchAvg(int num)
    {
        String str = null;
        String temp [][] = new String[100][10];
        double total = 0;
        int count = 0;
        for(int i =0;i<100;i++)
        {
            for(int j=0;j<12;j++)
            {
                student[i][j] = "";
            }
        }
        try
        {
            FileReader fr = new FileReader(FileName);
            BufferedReader br = new BufferedReader(fr);
            for(int i =0;(str = br.readLine())!=null;i++)
            {
                count ++;
                temp[i] = str.split(" ");
                total +=Double.parseDouble(temp[i][num]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return total/count;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean Check(String str)
    {
        int len = str.length();
        for(int i =0;i<len;i++)
        {
            if(str.charAt(i)<'0'||str.charAt(i)>'9')
            {
                return false;
            }
        }
        return true;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void mouseReleased(MouseEvent e)
    {}

    public void mousePressed(MouseEvent e)
    {}

    public void mouseEntered(MouseEvent e)
    {}

    public void mouseExited(MouseEvent e)
    {}

    public void mouseClicked(MouseEvent e)
    {
        Point p = e.getPoint();
        row = jtable.rowAtPoint(p);
        if (e.getClickCount() == 2)
        {}
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("首页"))
        {
            cardl.show(card, "首页");
        }
        else if (e.getActionCommand().equals("退出"))
        {
            dispose();
        }
        else if (e.getActionCommand().equals("帮助"))
        {
            cardl.show(card, "帮助");
        }
        else if (e.getActionCommand().equals("查看"))
        {
            jtable.updateUI();
            SeeAll(FileName);
            cardl.show(card, "查看");
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //按学号删除
        else if (e.getActionCommand().equals("按学号删除"))
        {
            String ID=JOptionPane.showInputDialog(null,"请输入学号");
            if(ID!=null)
            {
                if(!ID.equals(""))
                {
                    jtable.updateUI();
                    if(delete(FileName,0,ID) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该学生", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入学号！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //按姓名删除
        else if (e.getActionCommand().equals("按姓名删除"))
        {
            String Name=JOptionPane.showInputDialog(null,"请输入姓名");
            if(Name!=null)
            {
                if(!Name.equals(""))
                {
                    jtable.updateUI();
                    if(delete(FileName,1,Name) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，该学生不在成绩管理系统中！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入姓名！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //按性别删除
        else if (e.getActionCommand().equals("按性别删除"))
        {
            Object[] Sex = {"男","女"};
            String s = (String) JOptionPane.showInputDialog(this,"请选择性别\n","按性别删除", JOptionPane.QUESTION_MESSAGE, null,Sex, "男");
            if(!s.equals(""))
            {
                jtable.updateUI();
                if(delete(FileName,2,s) == 0)
                {
                    JOptionPane.showMessageDialog(null, "对不起，在成绩管理系统中没有查找到！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                cardl.show(card, "查看");
            }

        }
        //按年龄删除
        else if (e.getActionCommand().equals("按年龄删除"))
        {
            String Age=JOptionPane.showInputDialog(null,"请输入年龄");
            if(Age!=null)
            {
                if(!Age.equals(""))
                {
                    jtable.updateUI();  //刷新面板
                    if(delete(FileName,3,Age) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该年龄的学生", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入年龄！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //按学院删除
        else if (e.getActionCommand().equals("按学院删除"))
        {
            String Collage=JOptionPane.showInputDialog(null,"请输入学院");
            if(Collage!=null)
            {
                if(!Collage.equals(""))
                {
                    jtable.updateUI();
                    if(delete(FileName,4,Collage)  == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该学院的学生", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入学院！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //按班级删除
        else if (e.getActionCommand().equals("按班级删除"))
        {
            String Class=JOptionPane.showInputDialog(null,"请输入班级");
            if(Class!=null)
            {
                if(!Class.equals(""))
                {
                    jtable.updateUI();
                    if(delete(FileName,5,Class) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该班级的学生", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入班级！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("添加学生"))
        {
            cardl.show(card, "添加学生");
        }
        else if (e.getActionCommand().equals("添加班级"))
        {
            cardl.show(card, "添加学生");
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("按学号修改"))
        {
            cardl.show(card, "按学号修改");
        }
        else if (e.getActionCommand().equals("按姓名修改"))
        {
            cardl.show(card, "按姓名修改");
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //按学号查询
        else if (e.getActionCommand().equals("按学号查询"))
        {
            String ID=JOptionPane.showInputDialog(null,"请输入学号");
            if(ID!=null)
            {
                if(!ID.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,0,ID) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，该学生不在成绩管理系统中！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入学号！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //按姓名查询
        else if (e.getActionCommand().equals("按姓名查询"))
        {
            String Name=JOptionPane.showInputDialog(null,"请输入姓名");
            if(Name!=null)
            {
                if(!Name.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,1,Name) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，该学生不在成绩管理系统中！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入姓名！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //按性别查询
        else if (e.getActionCommand().equals("按性别查询"))
        {
            Object[] Sex = {"男","女"};
            String s = (String) JOptionPane.showInputDialog(this,"请选择性别\n","按性别查询", JOptionPane.QUESTION_MESSAGE, null,Sex, "男");
            if(s!=null)
            {
                jtable.updateUI();
                if(Search(FileName,2,s) == 0)
                {
                    JOptionPane.showMessageDialog(null, "对不起，在成绩管理系统中没有查找到该性别的学生！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                cardl.show(card, "查看");
            }
        }
        //按年龄查询
        else if (e.getActionCommand().equals("按年龄查询"))
        {
            String Age=JOptionPane.showInputDialog(null,"请输入年龄");
            if(Age!=null)
            {
                if(!Age.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,3,Age) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该年龄的学生！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入年龄！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //按学院查询
        else if (e.getActionCommand().equals("按学院查询"))
        {
            String Collage=JOptionPane.showInputDialog(null,"请输入学院");
            if(Collage!=null)
            {
                if(!Collage.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,4,Collage) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该学院的学生！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入学院！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //按班级查询
        else if (e.getActionCommand().equals("按班级查询"))
        {
            String Class =JOptionPane.showInputDialog(null,"请输入班级");
            if(Class!=null)
            {
                if(!Class.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,5,Class) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该班级的学生！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "查看");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "对不起，请确保输入班级！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("按学号排序"))
        {
            jtable.updateUI();
            Sort(0);
            cardl.show(card, "查看");
        }
        else if (e.getActionCommand().equals("按年龄排序"))
        {
            jtable.updateUI();
            Sort(3);
            cardl.show(card, "查看");
        }
        else if (e.getActionCommand().equals("按总成绩排序"))
        {
            jtable.updateUI();
            Sort(10);
            cardl.show(card, "查看");
        }
        else if (e.getActionCommand().equals("按Java排序"))
        {
            jtable.updateUI();
            Sort(8);
            cardl.show(card, "查看");
        }
        else if (e.getActionCommand().equals("按高数排序"))
        {
            jtable.updateUI();
            Sort(6);
            cardl.show(card, "查看");
        }
        else if (e.getActionCommand().equals("按英语排序"))
        {
            jtable.updateUI();
            Sort(7);
            cardl.show(card, "查看");
        }
        else if (e.getActionCommand().equals("按体育排序"))
        {
            jtable.updateUI();
            Sort(9);
            cardl.show(card, "查看");
        }
        else if (e.getActionCommand().equals("按总成绩排序"))
        {
            String Age=JOptionPane.showInputDialog(null,"请输入年龄");
            jtable.updateUI();
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("求高数平均分"))
        {
            cardl.show(card, "首页");
            JOptionPane.showMessageDialog(null, "高数平均分:"+String.valueOf(SearchAvg(6)), "提示", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getActionCommand().equals("求Java平均分"))
        {
            cardl.show(card, "首页");
            JOptionPane.showMessageDialog(null, "Java平均分:"+String.valueOf(SearchAvg(8)), "提示", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getActionCommand().equals("求英语平均分"))
        {
            cardl.show(card, "首页");
            JOptionPane.showMessageDialog(null, "英语平均分:"+String.valueOf(SearchAvg(7)), "提示", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getActionCommand().equals("求体育平均分"))
        {
            cardl.show(card, "首页");
            JOptionPane.showMessageDialog(null, "体育平均分:"+String.valueOf(SearchAvg(9)), "提示", JOptionPane.INFORMATION_MESSAGE);
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("按学号修改提交"))
        {
            String[] information = new String[10];
            String sex = null;
            if(jtAlterID.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "对不起，请填写要修改学生的学号！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(!Check(jtAlterPe.getText())||!Check(jtAlterID.getText())||!Check(jtAlterEnglish.getText())||!Check(jtAlterJava.getText())||!Check(jtAlterMath.getText())||!Check(jtAlterAge.getText()))
            {
                JOptionPane.showMessageDialog(null, "对不起，请确保信息格式正确！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                information[0] = jtAlterID.getText();
                information[1] = jtAlterName.getText();
                if (jr_man.isSelected())
                {sex = "男";}
                else
                {sex = "女";}
                information[2] = sex;
                information[3] = jtAlterAge.getText();
                information[4] = jtAlterCollage.getText();
                information[5] = jtAlterClass.getText();
                information[6] = jtAlterMath.getText();
                information[7] = jtAlterEnglish.getText();
                information[8] = jtAlterJava.getText();
                information[9] = jtAlterPe.getText();
                if(alter(0,information) == 0)
                {
                    JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该学生！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    jtAlterID.setText("");jtAlterAge.setText("");jtAlterCollage.setText("");jtAlterClass.setText("");jtAlterMath.setText("");jtAlterEnglish.setText("");
                    jtAlterJava.setText("");jtAlterPe.setText("");jtAlterName.setText("");
                    JOptionPane.showMessageDialog(null, "修改信息成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else if (e.getActionCommand().equals("按姓名修改提交"))
        {
            String[] information = new String[10];
            String sex = null;
            if(jtAlterName2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "对不起，请填写要修改学生的姓名！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(!Check(jtAlterPe2.getText())||!Check(jtAlterID2.getText())||!Check(jtAlterEnglish2.getText())||!Check(jtAlterJava2.getText())||!Check(jtAlterMath2.getText())||!Check(jtAlterAge2.getText()))
            {
                JOptionPane.showMessageDialog(null, "对不起，请确保信息格式正确！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                information[0] = jtAlterID2.getText();
                information[1] = jtAlterName2.getText();
                if (jr_man2.isSelected())
                {sex = "男";}
                else
                {sex = "女";}
                information[2] = sex;
                information[3] = jtAlterAge2.getText();
                information[4] = jtAlterCollage2.getText();
                information[5] = jtAlterClass2.getText();
                information[6] = jtAlterMath2.getText();
                information[7] = jtAlterEnglish2.getText();
                information[8] = jtAlterJava2.getText();
                information[9] = jtAlterPe2.getText();
                if(alter(1,information) == 0)
                {
                    JOptionPane.showMessageDialog(null, "对不起，成绩管理系统中没有该学生！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    jtAlterID2.setText("");jtAlterAge2.setText("");jtAlterCollage2.setText("");jtAlterClass2.setText("");jtAlterMath2.setText("");jtAlterEnglish2.setText("");
                    jtAlterJava2.setText("");jtAlterPe2.setText("");jtAlterName2.setText("");
                    JOptionPane.showMessageDialog(null, "修改信息成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else if (e.getActionCommand().equals("添加提交"))
        {
            String information = null;
            String sex = null;
            double math,pe,java,english;
            // 请确保信息填完成
            if (jtAddCollage.getText().equals("") || jtAddPe.getText().equals("") || jtAddID.getText().equals("") || jtAddName.getText().equals("") || jtAddAge.getText().equals("") || jtAddClass.getText().equals("")
                    || jtAddMath.getText().equals("") || jtAddJava.getText().equals("") || jtAddEnglish.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "对不起，请确保信息填完成！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(!Check(jtAddPe.getText())||!Check(jtAddID.getText())||!Check(jtAddEnglish.getText())||!Check(jtAddJava.getText())||!Check(jtAddMath.getText())||!Check(jtAddAge.getText()))
            {
                JOptionPane.showMessageDialog(null, "对不起，请确保信息格式正确！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                math = Double.parseDouble(jtAddMath.getText());
                pe = Double.parseDouble(jtAddPe.getText());
                java = Double.parseDouble(jtAddJava.getText());
                english = Double.parseDouble(jtAddEnglish.getText());
                if (jr_man.isSelected())
                {
                    sex = "男";
                }
                else
                {
                    sex = "女";
                }
                information = jtAddID.getText() + " " + jtAddName.getText() + " " + sex + " " + jtAddAge.getText()+" " +jtAddCollage.getText() +" " + jtAddClass.getText() + " " + jtAddMath.getText() + " "
                        + jtAddEnglish.getText() + " " + jtAddJava.getText() + " " + jtAddPe.getText()+" "+String.valueOf(math+pe+java+english)+" "+String.valueOf((math+pe+java+english)/4);
                if (isEixt(jtAddID.getText(), FileName))
                {
                    JOptionPane.showMessageDialog(null, "对不起，该信息已经填写！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    add(information, FileName);
                    jtAddID.setText("");
                    jtAddName.setText("");
                    jtAddCollage.setText("");
                    jtAddClass.setText("");
                    jtAddAge.setText("");
                    jtAddMath.setText("");
                    jtAddPe.setText("");
                    jtAddEnglish.setText("");
                    jtAddJava.setText("");
                    JOptionPane.showMessageDialog(null,"成功","提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    class MyTableModel extends AbstractTableModel
    {
        private String[] columnNames = {"学号","姓名","性别","年龄","学院","班级","高数","英语","Java","体育","总成绩","平均分"};
        private String[][] data = student;
        public int getColumnCount()
        {
            return columnNames.length;
        }

        public int getRowCount()
        {
            if(data == null)
            {
                return 0;
            }
            else
            {
                return data.length;
            }
        }
        public void addRow(String ID,String Name,String Age,String Class,String sex,String Math,String English,String Java,String Pe)
        {
            int n;
            if(data == null)
            {
                n = 0;
            }
            else
            {
                n = data.length;
            }
            data[n] = new String[9];
            data[n][0] = ID;

        }
        public String getColumnName(int col)
        {
            return columnNames[col];
        }

        public String getValueAt(int row, int col)
        {
            return data[row][col];
        }

        public Class getColumnClass(int c)
        {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col)
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        TestFrame m = new TestFrame();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}