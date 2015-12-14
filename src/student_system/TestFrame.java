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
    private JMenuBar typeMenu;  //�����˵���
    private JMenu file, display, edit, help, sort,delete,alter,add,subject,search,avg;  //�����˵�
    private JMenuItem seeItem,addStudent,pageone,exit,alterName,alterID,
            deleteID,deleteName,deleteClass,deleteSex,deleteAge,deleteCollage,
            searchID,searchName,searchClass,searchSex,searchAge,searchCollage,
            ID, age, English,math, Pe, java,  //�����˵������

    totalGrade,helpItem,avgMath,avgJava,avgPe,avgEnglish;
    private CardLayout cardl;  //����һ������ָ��ˮƽ���ʹ�ֱ�����¿�Ƭ����
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
        typeMenu = new JMenuBar();// Ӧ�ó���˵�������
        setJMenuBar(typeMenu);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // �˵�File
        file = new JMenu("ϵͳ");
        file.setFont(new Font("����", Font.PLAIN, 14));
        typeMenu.add(file);
        // �˵�Display
        display = new JMenu("�鿴");
        display.setFont(new Font("����", Font.PLAIN, 14));
        typeMenu.add(display);
        // �˵�Edit
        edit = new JMenu("�༭��Ϣ");
        edit.setFont(new Font("����", Font.PLAIN, 14));
        typeMenu.add(edit);
        // �˵�Sort
        sort = new JMenu("����");
        sort.setFont(new Font("����", Font.PLAIN, 14));
        typeMenu.add(sort);
        //�˵�Avg
        avg = new JMenu("ƽ����");
        avg.setFont(new Font("����", Font.PLAIN, 14));
        typeMenu.add(avg);
        // �˵�Help
        help = new JMenu("Help");
        help.setFont(new Font("����", Font.PLAIN, 14));
        typeMenu.add(help);
        //Help
        helpItem = new JMenuItem("Help");
        helpItem.setFont(new Font("����", Font.PLAIN, 14));
        help.add(helpItem);
        helpItem.addActionListener(this);
        helpItem.setActionCommand("����");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //��ҳ
        pageone = new JMenuItem("��ҳ");
        pageone.setFont(new Font("����", Font.PLAIN, 14));
        file.add(pageone);
        pageone.addActionListener(this);
        pageone.setActionCommand("��ҳ");
        file.addSeparator();
        //�˳�
        exit = new JMenuItem("�˳�");
        exit.setFont(new Font("����", Font.PLAIN, 14));
        file.add(exit);
        exit.addActionListener(this);
        exit.setActionCommand("�˳�");
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //�鿴
        seeItem  = new JMenuItem("�鿴");
        seeItem.setFont(new Font("����", Font.PLAIN, 14));
        display.add(seeItem);
        seeItem.addActionListener(this);
        seeItem.setActionCommand("�鿴");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //ɾ��
        delete = new JMenu("ɾ��");
        delete.setMnemonic(KeyEvent.VK_D);  //��delete�Alt+D��
        delete.setFont(new Font("����", Font.PLAIN, 14));
        edit.add(delete);
        delete.addActionListener(this);
        delete.setActionCommand("ɾ��"); //���ô���������Ĳ����¼�����������
        edit.addSeparator();
        //��ѧ��ɾ��
        deleteID = new JMenuItem("��ѧ��ɾ��");
        deleteID.setFont(new Font("����", Font.PLAIN, 13));
        delete.add(deleteID);
        deleteID.addActionListener(this);
        deleteID.setActionCommand("��ѧ��ɾ��");
        delete.addSeparator();
        //������ɾ��
        deleteName = new JMenuItem("������ɾ��");
        deleteName.setFont(new Font("����", Font.PLAIN, 13));
        delete.add(deleteName);
        deleteName.addActionListener(this);
        deleteName.setActionCommand("������ɾ��");
        delete.addSeparator();
        //��ѧԺɾ��
        deleteCollage = new JMenuItem("��ѧԺɾ��");
        deleteCollage.setFont(new Font("����", Font.PLAIN, 13));
        delete.add(deleteCollage);
        deleteCollage.addActionListener(this);
        deleteCollage.setActionCommand("��ѧԺɾ��");
        delete.addSeparator();
        //���༶ɾ��
        deleteClass = new JMenuItem("���༶ɾ��");
        deleteClass.setFont(new Font("����", Font.PLAIN, 13));
        delete.add(deleteClass);
        deleteClass.addActionListener(this);
        deleteClass.setActionCommand("���༶ɾ��");
        delete.addSeparator();
        //���Ա�ɾ��
        deleteSex = new JMenuItem("���Ա�ɾ��");
        deleteSex.setFont(new Font("����", Font.PLAIN, 13));
        delete.add(deleteSex);
        deleteSex.addActionListener(this);
        deleteSex.setActionCommand("���Ա�ɾ��");
        delete.addSeparator();
        //������ɾ��
        deleteAge = new JMenuItem("������ɾ��");
        deleteAge.setFont(new Font("����", Font.PLAIN, 13));
        delete.add(deleteAge);
        deleteAge.addActionListener(this);
        deleteAge.setActionCommand("������ɾ��");
        //���
        add = new JMenu("���");
        add.setMnemonic(KeyEvent.VK_A);
        add.setFont(new Font("����", Font.PLAIN, 14));
        edit.add(add);
        edit.addSeparator();
        add.addActionListener(this);
        add.setActionCommand("���");
        //���ѧ��
        addStudent = new JMenuItem("���ѧ��");
        addStudent.setFont(new Font("����", Font.PLAIN, 13));
        add.add(addStudent);
        addStudent.addActionListener(this);
        addStudent.setActionCommand("���ѧ��");
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //�޸�
        alter = new JMenu("�޸�");
        alter.setMnemonic(KeyEvent.VK_A);
        alter.setFont(new Font("����", Font.PLAIN, 14));
        edit.add(alter);
        alter.addActionListener(this);
        alter.setActionCommand("�޸�");
        edit.addSeparator();
        //��ѧ���޸�
        alterID = new JMenuItem("��ѧ���޸�");
        alterID.setFont(new Font("����", Font.PLAIN, 13));
        alter.add(alterID);
        alterID.addActionListener(this);
        alterID.setActionCommand("��ѧ���޸�");
        alter.addSeparator();
        //�������޸�
        alterName = new JMenuItem("�������޸�");
        alterName.setFont(new Font("����", Font.PLAIN, 13));
        alter.add(alterName);
        alterName.addActionListener(this);
        alterName.setActionCommand("�������޸�");
        //��ѯ
        search = new JMenu("��ѯ");
        search.setFont(new Font("����", Font.PLAIN, 14));
        edit.add(search);
        search.addActionListener(this);
        search.setActionCommand("��ѯ");
        //��ѧ�Ų�ѯ
        searchID = new JMenuItem("��ѧ�Ų�ѯ");
        searchID.setFont(new Font("����", Font.PLAIN, 13));
        search.add(searchID);
        searchID.addActionListener(this);
        searchID.setActionCommand("��ѧ�Ų�ѯ");
        search.addSeparator();
        //������ѯ
        searchName = new JMenuItem("��������ѯ");
        searchName.setFont(new Font("����", Font.PLAIN, 13));
        search.add(searchName);
        searchName.addActionListener(this);
        searchName.setActionCommand("��������ѯ");
        search.addSeparator();
        //��ѧԺ��ѯ
        searchCollage = new JMenuItem("��ѧԺ��ѯ");
        searchCollage.setFont(new Font("����", Font.PLAIN, 13));
        search.add(searchCollage);
        searchCollage.addActionListener(this);
        searchCollage.setActionCommand("��ѧԺ��ѯ");
        search.addSeparator();
        //���༶��ѯ
        searchClass = new JMenuItem("���༶��ѯ");
        searchClass.setFont(new Font("����", Font.PLAIN, 13));
        search.add(searchClass);
        searchClass.addActionListener(this);
        searchClass.setActionCommand("���༶��ѯ");
        search.addSeparator();
        //���Ա��ѯ
        searchSex = new JMenuItem("���Ա��ѯ");
        searchSex.setFont(new Font("����", Font.PLAIN, 13));
        search.add(searchSex);
        searchSex.addActionListener(this);
        searchSex.setActionCommand("���Ա��ѯ");
        search.addSeparator();
        //�������ѯ
        searchAge = new JMenuItem("�������ѯ");
        searchAge.setFont(new Font("����", Font.PLAIN, 13));
        search.add(searchAge);
        searchAge.addActionListener(this);
        searchAge.setActionCommand("�������ѯ");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //����
        //��ѧ������
        ID = new JMenuItem("��ѧ������");
        ID.setFont(new Font("����", Font.PLAIN, 14));
        sort.add(ID);
        sort.addSeparator();
        ID.addActionListener(this);
        ID.setActionCommand("��ѧ������");
        //����������
        age = new JMenuItem("����������");
        age.setFont(new Font("����", Font.PLAIN, 14));
        sort.add(age);
        sort.addSeparator();
        age.addActionListener(this);
        age.setActionCommand("����������");
        //���ܳɼ�����
        totalGrade  = new JMenuItem("���ܳɼ�����");
        totalGrade.setFont(new Font("����", Font.PLAIN, 14));
        sort.add(totalGrade);
        sort.addSeparator();
        totalGrade.addActionListener(this);
        totalGrade.setActionCommand("���ܳɼ�����");
        //�����Ƴɼ�����
        subject = new JMenu("�����Ƴɼ�����");
        subject.setFont(new Font("����", Font.PLAIN, 14));
        sort.add(subject);
        //����������
        math = new JMenuItem("����������");
        math.setFont(new Font("����", Font.PLAIN, 14));
        subject.add(math);
        math.addActionListener(this);
        math.setActionCommand("����������");
        subject.addSeparator();
        //��Java����
        java = new JMenuItem("��Java����");
        java.setFont(new Font("����", Font.PLAIN, 14));
        subject.add(java);
        java.addActionListener(this);
        java.setActionCommand("��Java����");
        subject.addSeparator();
        //��Ӣ������
        English = new JMenuItem("��Ӣ������");
        English.setFont(new Font("����", Font.PLAIN, 14));
        subject.add( English);
        English.addActionListener(this);
        English.setActionCommand("��Ӣ������");
        subject.addSeparator();
        //����������
        Pe = new JMenuItem("����������");
        Pe.setFont(new Font("����", Font.PLAIN, 14));
        subject.add(Pe);
        Pe.addActionListener(this);
        Pe.setActionCommand("����������");
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //�γ�ƽ����
        //�����ƽ����
        avgMath = new JMenuItem("�����ƽ����");
        avgMath.setFont(new Font("����", Font.PLAIN, 14));
        avg.add(avgMath);
        avgMath.addActionListener(this);
        avgMath.setActionCommand("�����ƽ����");
        avg.addSeparator();
        //��Javaƽ����
        avgJava = new JMenuItem("��Javaƽ����");
        avgJava.setFont(new Font("����", Font.PLAIN, 14));
        avg.add(avgJava);
        avgJava.addActionListener(this);
        avgJava.setActionCommand("��Javaƽ����");
        avg.addSeparator();
        //��Ӣ��ƽ����
        avgEnglish = new JMenuItem("��Ӣ��ƽ����");
        avgEnglish.setFont(new Font("����", Font.PLAIN, 14));
        avg.add(avgEnglish);
        avgEnglish.addActionListener(this);
        avgEnglish.setActionCommand("��Ӣ��ƽ����");
        avg.addSeparator();
        //������ƽ����
        avgPe = new JMenuItem("������ƽ����");
        avgPe.setFont(new Font("����", Font.PLAIN, 14));
        avg.add(avgPe);
        avgPe.addActionListener(this);
        avgPe.setActionCommand("������ƽ����");
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  //
        cardl = new CardLayout();  //����һ������ָ��ˮƽ���ʹ�ֱ�����¿�Ƭ���ֶ���
        card = new JPanel();
        card.setBounds(0, 0, 650, 400);  //���Ͻ�Ϊ��㣬650����400��
        card.setOpaque(false);  //���ÿؼ�͸��
        card.setLayout(cardl);
        jpSearch = new JPanel();
        jpMain = new JPanel();
        jpAddStudent = new JPanel();
        jpAlterByID = new JPanel();
        jpAlterByName = new JPanel();
        jpSee = new JPanel();
        jphelp = new JPanel();


        card.add("��ҳ", jpMain);
        card.add("���༶��ѯ",jpSearch);
        card.add("���ѧ��", jpAddStudent);
        card.add("�������޸�", jpAlterByName);
        card.add("��ѧ���޸�", jpAlterByID);
        card.add("�鿴", jpSee);
        card.add("����", jphelp);
        c.add(card);
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //��ҳ
        jpMain.setLayout(null);
        jlMain1 = new JLabel();
        jlMain1.setText("��ӭ����ѧ���ɼ�����ϵͳ");
        jlMain1.setBounds(150, 100, 300, 40);
        jlMain1.setFont(new Font("����", Font.PLAIN, 25));
        jlMain1.setForeground(Color.black);
        jpMain.add(jlMain1);
        jlMain2 = new JLabel();
        jlMain2.setText("����Ա��sjx");
        jlMain2.setBounds(230, 150, 300, 40);
        jlMain2.setFont(new Font("����", Font.PLAIN, 20));
        jlMain2.setForeground(Color.black);
        jpMain.add(jlMain2);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //����
        jphelp.setLayout(null);
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        jpAlterByID.setLayout(null);
        //��ѧ���޸�
        jlAlter1 = new JLabel();
        jlAlter1.setText("��ѧ���޸�");
        jlAlter1.setBounds(200, 20, 170, 20);
        jlAlter1.setFont(new Font("����", Font.PLAIN, 20));
        jpAlterByID.add(jlAlter1);
        jlAlter2 = new JLabel();
        jlAlter2.setBounds(20, 70, 200, 20);
        jlAlter2.setText("*������Ҫ�޸�ѧ����ѧ�ţ�");
        jlAlter2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter2);
        //Ҫ�޸�ѧ����ѧ��
        jtAlterID = new JTextField();
        jtAlterID.setBounds(220, 70, 150, 20);
        jtAlterID.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterID);
        //�޸Ļ�����Ϣ
        jlAlter2 = new JLabel();
        jlAlter2.setBounds(20, 100, 170, 20);
        jlAlter2.setText("*�޸Ļ�����Ϣ*");
        jlAlter2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter2);
        // �޸�����
        jlAlter3 = new JLabel();
        jlAlter3.setBounds(80, 140, 50, 20);
        jlAlter3.setText("������");
        jlAlter3.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter3);

        jtAlterName = new JTextField();
        jtAlterName.setBounds(130, 140, 150, 20);
        jtAlterName.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterName);
        // �޸�����
        jlAlter4 = new JLabel();
        jlAlter4.setBounds(320, 140, 50, 20);
        jlAlter4.setText("���䣺");
        jlAlter4.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter4);

        jtAlterAge = new JTextField();
        jtAlterAge.setBounds(370, 140, 150, 20);
        jtAlterAge.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterAge);

        // �޸�ѧԺ
        jlAlter6 = new JLabel();
        jlAlter6.setBounds(80, 170, 50, 20);
        jlAlter6.setText("ѧԺ:");
        jlAlter6.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter6);

        jtAlterCollage = new JTextField();
        jtAlterCollage.setBounds(130, 170, 150, 20);
        jtAlterCollage.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterCollage);
        //�޸İ༶
        jlAlter7 = new JLabel();
        jlAlter7.setBounds(320, 170, 50, 20);
        jlAlter7.setText("�༶:");
        jlAlter7.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter7);
        jtAlterClass = new JTextField();
        jtAlterClass.setBounds(370, 170, 150, 20);
        jtAlterClass.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterClass);
        // �޸��Ա�
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 210, 50, 20);
        jlAlter5.setText("�Ա�");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);

        jr_man = new JRadioButton();
        jr_man.setText("��");
        jr_man.setFont(new Font("����", Font.PLAIN, 16));
        jr_man.setSelected(true);
        jr_man.setBounds(130, 210, 50, 20);
        jr_woman = new JRadioButton();
        jr_woman.setText("Ů");
        jr_woman.setFont(new Font("����", Font.PLAIN, 16));
        jr_woman.setBounds(180, 210, 50, 20);
        sexgroup = new ButtonGroup();
        sexgroup.add(jr_man);
        sexgroup.add(jr_woman);
        jpAlterByID.add(jr_man);
        jpAlterByID.add(jr_woman);
        // �޸ĳɼ�
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(20, 240, 200, 20);
        jlAlter5.setText("*�޸ĵ��Ƴɼ�*");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);
        // �޸ĸ���
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 270, 50, 20);
        jlAlter5.setText("������");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);

        jtAlterMath = new JTextField();
        jtAlterMath.setBounds(130, 270, 150, 20);
        jtAlterMath.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterMath);
        //�޸�Ӣ��
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(320, 270, 80, 20);
        jlAlter5.setText("Ӣ�");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);

        jtAlterEnglish = new JTextField();
        jtAlterEnglish.setBounds(400, 270, 150, 20);
        jtAlterEnglish.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterEnglish);
        // �޸�Java
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 300, 50, 20);
        jlAlter5.setText("Java��");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);

        jtAlterJava = new JTextField();
        jtAlterJava.setBounds(130, 300, 150, 20);
        jtAlterJava.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterJava);
        // �޸�����
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(320, 300, 80, 20);
        jlAlter5.setText("������");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jlAlter5);
        jtAlterPe = new JTextField();
        jtAlterPe.setBounds(400, 300, 150, 20);
        jtAlterPe.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByID.add(jtAlterPe);

        jbAlterSure = new JButton();
        jbAlterSure.setBounds(500, 325, 50, 20);
        jbAlterSure.addActionListener(this);
        jbAlterSure.setActionCommand("��ѧ���޸��ύ");
        jpAlterByID.add(jbAlterSure);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        jpAlterByName.setLayout(null);
        //�������޸�
        jlAlter1 = new JLabel();
        jlAlter1.setText("�������޸�");
        jlAlter1.setBounds(230, 20, 170, 20);
        jlAlter1.setFont(new Font("����", Font.PLAIN, 20));
        jpAlterByName.add(jlAlter1);
        jlAlter2 = new JLabel();
        jlAlter2.setBounds(20, 70, 200, 20);
        jlAlter2.setText("*������Ҫ�޸�ѧ����������");
        jlAlter2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter2);
        //Ҫ�޸�ѧ��������
        jtAlterName2 = new JTextField();
        jtAlterName2.setBounds(220, 70, 150, 20);
        jtAlterName2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterName2);
        //�޸Ļ�����Ϣ
        jlAlter2 = new JLabel();
        jlAlter2.setBounds(20, 100, 170, 20);
        jlAlter2.setText("*�޸Ļ�����Ϣ*");
        jlAlter2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter2);
        // �޸�ѧ��
        jlAlter3 = new JLabel();
        jlAlter3.setBounds(80, 140, 50, 20);
        jlAlter3.setText("ѧ�ţ�");
        jlAlter3.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter3);

        jtAlterID2 = new JTextField();
        jtAlterID2.setBounds(130, 140, 150, 20);
        jtAlterID2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterID2);
        // �޸�����
        jlAlter4 = new JLabel();
        jlAlter4.setBounds(320, 140, 50, 20);
        jlAlter4.setText("���䣺");
        jlAlter4.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter4);

        jtAlterAge2 = new JTextField();
        jtAlterAge2.setBounds(370, 140, 150, 20);
        jtAlterAge2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterAge2);

        // �޸�ѧԺ
        jlAlter6 = new JLabel();
        jlAlter6.setBounds(80, 170, 50, 20);
        jlAlter6.setText("ѧԺ:");
        jlAlter6.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter6);

        jtAlterCollage2 = new JTextField();
        jtAlterCollage2.setBounds(130, 170, 150, 20);
        jtAlterCollage2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterCollage2);
        //�޸İ༶
        jlAlter7 = new JLabel();
        jlAlter7.setBounds(320, 170, 50, 20);
        jlAlter7.setText("�༶:");
        jlAlter7.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter7);
        jtAlterClass2 = new JTextField();
        jtAlterClass2.setBounds(370, 170, 150, 20);
        jtAlterClass2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterClass2);
        // �޸��Ա�
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 210, 50, 20);
        jlAlter5.setText("�Ա�");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);

        jr_man2 = new JRadioButton();
        jr_man2.setText("��");
        jr_man2.setFont(new Font("����", Font.PLAIN, 16));
        jr_man2.setSelected(true);
        jr_man2.setBounds(130, 210, 50, 20);
        jr_woman2 = new JRadioButton();
        jr_woman2.setText("Ů");
        jr_woman2.setFont(new Font("����", Font.PLAIN, 16));
        jr_woman2.setBounds(180, 210, 50, 20);
        sexgroup2 = new ButtonGroup();
        sexgroup2.add(jr_man2);
        sexgroup2.add(jr_woman2);
        jpAlterByName.add(jr_man2);
        jpAlterByName.add(jr_woman2);
        // �޸ĳɼ�
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(20, 240, 200, 20);
        jlAlter5.setText("*�޸ĵ��Ƴɼ�*");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);
        // �޸ĸ���
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 270, 50, 20);
        jlAlter5.setText("������");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);

        jtAlterMath2 = new JTextField();
        jtAlterMath2.setBounds(130, 270, 150, 20);
        jtAlterMath2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterMath2);
        //�޸�Ӣ��
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(320, 270, 80, 20);
        jlAlter5.setText("Ӣ�");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);

        jtAlterEnglish2 = new JTextField();
        jtAlterEnglish2.setBounds(400, 270, 150, 20);
        jtAlterEnglish2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterEnglish2);
        // �޸�Java
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(80, 300, 50, 20);
        jlAlter5.setText("Java��");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);

        jtAlterJava2 = new JTextField();
        jtAlterJava2.setBounds(130, 300, 150, 20);
        jtAlterJava2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterJava2);
        // �޸�����
        jlAlter5 = new JLabel();
        jlAlter5.setBounds(320, 300, 80, 20);
        jlAlter5.setText("������");
        jlAlter5.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jlAlter5);
        jtAlterPe2 = new JTextField();
        jtAlterPe2.setBounds(400, 300, 150, 20);
        jtAlterPe2.setFont(new Font("����", Font.PLAIN, 16));
        jpAlterByName.add(jtAlterPe2);

        jbAlterSure2 = new JButton();
        jbAlterSure2.setBounds(500, 325, 50, 20);
        jbAlterSure2.addActionListener(this);
        jbAlterSure2.setActionCommand("�������޸��ύ");
        jpAlterByName.add(jbAlterSure2);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //���
        jpAddStudent.setLayout(null);
        jlAdd1 = new JLabel();
        jlAdd1.setBounds(200, 20, 200, 20);
        jlAdd1.setText("���ѧ��������Ϣ");
        jlAdd1.setFont(new Font("����", Font.PLAIN, 20));
        jpAddStudent.add(jlAdd1);
        // ��ӻ�����Ϣ
        jlAdd2 = new JLabel();
        jlAdd2.setBounds(20, 60, 100, 20);
        jlAdd2.setText("*������Ϣ��");
        jlAdd2.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd2);
        //���ѧ��
        jlAdd3 = new JLabel();
        jlAdd3.setBounds(80, 90, 50, 20);
        jlAdd3.setText("ѧ�ţ�");
        jlAdd3.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd3);
        jtAddID = new JTextField();
        jtAddID.setBounds(130, 90, 150, 20);
        jtAddID.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddID);
        // �������
        jlAdd4 = new JLabel();
        jlAdd4.setBounds(320, 90, 50, 20);
        jlAdd4.setText("������");
        jlAdd4.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd4);
        jtAddName = new JTextField();
        jtAddName.setBounds(370, 90, 150, 20);
        jtAddName.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddName);
        // �������
        jlAdd5 = new JLabel();
        jlAdd5.setBounds(80, 130, 50, 20);
        jlAdd5.setText("���䣺");
        jlAdd5.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd5);
        jtAddAge = new JTextField();
        jtAddAge.setBounds(130, 130, 150, 20);
        jtAddAge.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddAge);
        // ���ѧԺ
        jlAdd12 = new JLabel();
        jlAdd12.setBounds(320, 130, 50, 20);
        jlAdd12.setText("ѧԺ:");
        jlAdd12.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd12);
        jtAddCollage = new JTextField();
        jtAddCollage.setBounds(370, 130, 150, 20);
        jtAddCollage.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddCollage);
        // ����Ա�
        jlAdd6 = new JLabel();
        jlAdd6.setBounds(80, 170, 50, 20);
        jlAdd6.setText("�Ա�");
        jlAdd6.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd6);
        jr_man = new JRadioButton();
        jr_man.setText("��");
        jr_man.setFont(new Font("����", Font.PLAIN, 16));
        jr_man.setSelected(true);
        jr_man.setBounds(130, 170, 50, 20);
        jr_woman = new JRadioButton();
        jr_woman.setText("Ů");
        jr_woman.setFont(new Font("����", Font.PLAIN, 16));
        jr_woman.setBounds(180, 170, 50, 20);
        sexgroup = new ButtonGroup();
        sexgroup.add(jr_man);
        sexgroup.add(jr_woman);
        jpAddStudent.add(jr_man);
        jpAddStudent.add(jr_woman);
        //��Ӱ༶
        jlAdd13 = new JLabel();
        jlAdd13.setBounds(320, 170, 50, 20);
        jlAdd13.setText("�༶:");
        jlAdd13.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd13);
        jtAddClass = new JTextField();
        jtAddClass.setBounds(370, 170, 150, 20);
        jtAddClass.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddClass);
        // ��ӳɼ�
        jlAdd7 = new JLabel();
        jlAdd7.setBounds(20, 210, 100, 20);
        jlAdd7.setText("*���Ƴɼ���");
        jlAdd7.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd7);
        // ��Ӹ���
        jlAdd8 = new JLabel();
        jlAdd8.setBounds(80, 240, 50, 20);
        jlAdd8.setText("������");
        jlAdd8.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd8);
        jtAddMath = new JTextField();
        jtAddMath.setBounds(130, 240, 150, 20);
        jtAddMath.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddMath);
        // ���Ӣ��
        jlAdd9 = new JLabel();
        jlAdd9.setBounds(320, 240, 80, 20);
        jlAdd9.setText("Ӣ�");
        jlAdd9.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd9);
        jtAddEnglish = new JTextField();
        jtAddEnglish.setBounds(400, 240, 150, 20);
        jtAddEnglish.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddEnglish);
        // ���Java
        jlAdd10 = new JLabel();
        jlAdd10.setBounds(80, 280, 50, 20);
        jlAdd10.setText("Java��");
        jlAdd10.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd10);
        jtAddJava = new JTextField();
        jtAddJava.setBounds(130, 280, 150, 20);
        jtAddJava.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddJava);
        // �������
        jlAdd11 = new JLabel();
        jlAdd11.setBounds(320, 280, 80, 20);
        jlAdd11.setText("������");
        jlAdd11.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jlAdd11);
        jtAddPe = new JTextField();
        jtAddPe.setBounds(400, 280, 150, 20);
        jtAddPe.setFont(new Font("����", Font.PLAIN, 16));
        jpAddStudent.add(jtAddPe);
        jbAddSure = new JButton();
        jbAddSure.setBounds(500, 320, 50, 20);
        jbAddSure.setIcon(new ImageIcon("pic//tijiao.gif"));
        jbAddSure.addActionListener(this);
        jbAddSure.setActionCommand("����ύ");
        jpAddStudent.add(jbAddSure);
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //�鿴
        jl = new JLabel();
        jl.setBounds(110, 0, 300, 20);
        jl.setText("��Ϣ��");
        jl.setForeground(Color.gray);
        jl.setFont(new Font("����", Font.PLAIN, 16));
        jpSee.add(jl);

        MyTableModel Mytable = new MyTableModel();
        jtable = new JTable(Mytable);
        jtable.setShowGrid(true);
        //�����п�
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
        setTitle("ѧ���ɼ�����ϵͳ");
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //�ж�ѧ���Ƿ����
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
    //��ӻ�����Ϣ
    public void add(String information, String FileName)
    {
        File file = new File(FileName);
        try
        {
            BufferedWriter bw;
            FileWriter fw;
            // ����ļ����༶���������򴴽�
            if (!file.exists())
            {
                // �����ļ����༶��
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
    //�鿴
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
    //��ѯ
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
    //ɾ��
    public int delete(String FileName,int num,String information)
    {
        FileReader fr;
        BufferedReader br;
        BufferedWriter bw;
        FileWriter fw;
        String str = null;
        int count = 0;
        int k = 0;
        int flag = 0;//�жϸ�ѧ���Ƿ���� 0 û�� 1 ��
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
    //�޸�
    public int alter(int num,String information[])
    {
        FileReader fr;
        BufferedReader br;
        BufferedWriter bw;
        FileWriter fw;
        String str = null;
        String tempStr = null;
        int k =0;
        int flag = 0;//�жϸ�ѧ���Ƿ���� 0 û�� 1 ��
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
                            if(j>=6)//�޸ĵ��Ƴɼ�ҲҪ�޸��ܳɼ� ��ƽ����
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
    //����
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
    //��ѯƽ���ɼ�
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
        if (e.getActionCommand().equals("��ҳ"))
        {
            cardl.show(card, "��ҳ");
        }
        else if (e.getActionCommand().equals("�˳�"))
        {
            dispose();
        }
        else if (e.getActionCommand().equals("����"))
        {
            cardl.show(card, "����");
        }
        else if (e.getActionCommand().equals("�鿴"))
        {
            jtable.updateUI();
            SeeAll(FileName);
            cardl.show(card, "�鿴");
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //��ѧ��ɾ��
        else if (e.getActionCommand().equals("��ѧ��ɾ��"))
        {
            String ID=JOptionPane.showInputDialog(null,"������ѧ��");
            if(ID!=null)
            {
                if(!ID.equals(""))
                {
                    jtable.updateUI();
                    if(delete(FileName,0,ID) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�и�ѧ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ������ѧ�ţ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //������ɾ��
        else if (e.getActionCommand().equals("������ɾ��"))
        {
            String Name=JOptionPane.showInputDialog(null,"����������");
            if(Name!=null)
            {
                if(!Name.equals(""))
                {
                    jtable.updateUI();
                    if(delete(FileName,1,Name) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬸�ѧ�����ڳɼ�����ϵͳ�У�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ������������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //���Ա�ɾ��
        else if (e.getActionCommand().equals("���Ա�ɾ��"))
        {
            Object[] Sex = {"��","Ů"};
            String s = (String) JOptionPane.showInputDialog(this,"��ѡ���Ա�\n","���Ա�ɾ��", JOptionPane.QUESTION_MESSAGE, null,Sex, "��");
            if(!s.equals(""))
            {
                jtable.updateUI();
                if(delete(FileName,2,s) == 0)
                {
                    JOptionPane.showMessageDialog(null, "�Բ����ڳɼ�����ϵͳ��û�в��ҵ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
                cardl.show(card, "�鿴");
            }

        }
        //������ɾ��
        else if (e.getActionCommand().equals("������ɾ��"))
        {
            String Age=JOptionPane.showInputDialog(null,"����������");
            if(Age!=null)
            {
                if(!Age.equals(""))
                {
                    jtable.updateUI();  //ˢ�����
                    if(delete(FileName,3,Age) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�и������ѧ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ���������䣡", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //��ѧԺɾ��
        else if (e.getActionCommand().equals("��ѧԺɾ��"))
        {
            String Collage=JOptionPane.showInputDialog(null,"������ѧԺ");
            if(Collage!=null)
            {
                if(!Collage.equals(""))
                {
                    jtable.updateUI();
                    if(delete(FileName,4,Collage)  == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�и�ѧԺ��ѧ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ������ѧԺ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //���༶ɾ��
        else if (e.getActionCommand().equals("���༶ɾ��"))
        {
            String Class=JOptionPane.showInputDialog(null,"������༶");
            if(Class!=null)
            {
                if(!Class.equals(""))
                {
                    jtable.updateUI();
                    if(delete(FileName,5,Class) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�иð༶��ѧ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ������༶��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("���ѧ��"))
        {
            cardl.show(card, "���ѧ��");
        }
        else if (e.getActionCommand().equals("��Ӱ༶"))
        {
            cardl.show(card, "���ѧ��");
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("��ѧ���޸�"))
        {
            cardl.show(card, "��ѧ���޸�");
        }
        else if (e.getActionCommand().equals("�������޸�"))
        {
            cardl.show(card, "�������޸�");
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //��ѧ�Ų�ѯ
        else if (e.getActionCommand().equals("��ѧ�Ų�ѯ"))
        {
            String ID=JOptionPane.showInputDialog(null,"������ѧ��");
            if(ID!=null)
            {
                if(!ID.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,0,ID) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬸�ѧ�����ڳɼ�����ϵͳ�У�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ������ѧ�ţ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //��������ѯ
        else if (e.getActionCommand().equals("��������ѯ"))
        {
            String Name=JOptionPane.showInputDialog(null,"����������");
            if(Name!=null)
            {
                if(!Name.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,1,Name) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬸�ѧ�����ڳɼ�����ϵͳ�У�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ������������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //���Ա��ѯ
        else if (e.getActionCommand().equals("���Ա��ѯ"))
        {
            Object[] Sex = {"��","Ů"};
            String s = (String) JOptionPane.showInputDialog(this,"��ѡ���Ա�\n","���Ա��ѯ", JOptionPane.QUESTION_MESSAGE, null,Sex, "��");
            if(s!=null)
            {
                jtable.updateUI();
                if(Search(FileName,2,s) == 0)
                {
                    JOptionPane.showMessageDialog(null, "�Բ����ڳɼ�����ϵͳ��û�в��ҵ����Ա��ѧ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
                cardl.show(card, "�鿴");
            }
        }
        //�������ѯ
        else if (e.getActionCommand().equals("�������ѯ"))
        {
            String Age=JOptionPane.showInputDialog(null,"����������");
            if(Age!=null)
            {
                if(!Age.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,3,Age) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�и������ѧ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ���������䣡", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //��ѧԺ��ѯ
        else if (e.getActionCommand().equals("��ѧԺ��ѯ"))
        {
            String Collage=JOptionPane.showInputDialog(null,"������ѧԺ");
            if(Collage!=null)
            {
                if(!Collage.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,4,Collage) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�и�ѧԺ��ѧ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ������ѧԺ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //���༶��ѯ
        else if (e.getActionCommand().equals("���༶��ѯ"))
        {
            String Class =JOptionPane.showInputDialog(null,"������༶");
            if(Class!=null)
            {
                if(!Class.equals(""))
                {
                    jtable.updateUI();
                    if(Search(FileName,5,Class) == 0)
                    {
                        JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�иð༶��ѧ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    cardl.show(card, "�鿴");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "�Բ�����ȷ������༶��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("��ѧ������"))
        {
            jtable.updateUI();
            Sort(0);
            cardl.show(card, "�鿴");
        }
        else if (e.getActionCommand().equals("����������"))
        {
            jtable.updateUI();
            Sort(3);
            cardl.show(card, "�鿴");
        }
        else if (e.getActionCommand().equals("���ܳɼ�����"))
        {
            jtable.updateUI();
            Sort(10);
            cardl.show(card, "�鿴");
        }
        else if (e.getActionCommand().equals("��Java����"))
        {
            jtable.updateUI();
            Sort(8);
            cardl.show(card, "�鿴");
        }
        else if (e.getActionCommand().equals("����������"))
        {
            jtable.updateUI();
            Sort(6);
            cardl.show(card, "�鿴");
        }
        else if (e.getActionCommand().equals("��Ӣ������"))
        {
            jtable.updateUI();
            Sort(7);
            cardl.show(card, "�鿴");
        }
        else if (e.getActionCommand().equals("����������"))
        {
            jtable.updateUI();
            Sort(9);
            cardl.show(card, "�鿴");
        }
        else if (e.getActionCommand().equals("���ܳɼ�����"))
        {
            String Age=JOptionPane.showInputDialog(null,"����������");
            jtable.updateUI();
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("�����ƽ����"))
        {
            cardl.show(card, "��ҳ");
            JOptionPane.showMessageDialog(null, "����ƽ����:"+String.valueOf(SearchAvg(6)), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getActionCommand().equals("��Javaƽ����"))
        {
            cardl.show(card, "��ҳ");
            JOptionPane.showMessageDialog(null, "Javaƽ����:"+String.valueOf(SearchAvg(8)), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getActionCommand().equals("��Ӣ��ƽ����"))
        {
            cardl.show(card, "��ҳ");
            JOptionPane.showMessageDialog(null, "Ӣ��ƽ����:"+String.valueOf(SearchAvg(7)), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getActionCommand().equals("������ƽ����"))
        {
            cardl.show(card, "��ҳ");
            JOptionPane.showMessageDialog(null, "����ƽ����:"+String.valueOf(SearchAvg(9)), "��ʾ", JOptionPane.INFORMATION_MESSAGE);
        }
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        else if (e.getActionCommand().equals("��ѧ���޸��ύ"))
        {
            String[] information = new String[10];
            String sex = null;
            if(jtAlterID.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "�Բ�������дҪ�޸�ѧ����ѧ�ţ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(!Check(jtAlterPe.getText())||!Check(jtAlterID.getText())||!Check(jtAlterEnglish.getText())||!Check(jtAlterJava.getText())||!Check(jtAlterMath.getText())||!Check(jtAlterAge.getText()))
            {
                JOptionPane.showMessageDialog(null, "�Բ�����ȷ����Ϣ��ʽ��ȷ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                information[0] = jtAlterID.getText();
                information[1] = jtAlterName.getText();
                if (jr_man.isSelected())
                {sex = "��";}
                else
                {sex = "Ů";}
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
                    JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�и�ѧ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    jtAlterID.setText("");jtAlterAge.setText("");jtAlterCollage.setText("");jtAlterClass.setText("");jtAlterMath.setText("");jtAlterEnglish.setText("");
                    jtAlterJava.setText("");jtAlterPe.setText("");jtAlterName.setText("");
                    JOptionPane.showMessageDialog(null, "�޸���Ϣ�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else if (e.getActionCommand().equals("�������޸��ύ"))
        {
            String[] information = new String[10];
            String sex = null;
            if(jtAlterName2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "�Բ�������дҪ�޸�ѧ����������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(!Check(jtAlterPe2.getText())||!Check(jtAlterID2.getText())||!Check(jtAlterEnglish2.getText())||!Check(jtAlterJava2.getText())||!Check(jtAlterMath2.getText())||!Check(jtAlterAge2.getText()))
            {
                JOptionPane.showMessageDialog(null, "�Բ�����ȷ����Ϣ��ʽ��ȷ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                information[0] = jtAlterID2.getText();
                information[1] = jtAlterName2.getText();
                if (jr_man2.isSelected())
                {sex = "��";}
                else
                {sex = "Ů";}
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
                    JOptionPane.showMessageDialog(null, "�Բ��𣬳ɼ�����ϵͳ��û�и�ѧ����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    jtAlterID2.setText("");jtAlterAge2.setText("");jtAlterCollage2.setText("");jtAlterClass2.setText("");jtAlterMath2.setText("");jtAlterEnglish2.setText("");
                    jtAlterJava2.setText("");jtAlterPe2.setText("");jtAlterName2.setText("");
                    JOptionPane.showMessageDialog(null, "�޸���Ϣ�ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else if (e.getActionCommand().equals("����ύ"))
        {
            String information = null;
            String sex = null;
            double math,pe,java,english;
            // ��ȷ����Ϣ�����
            if (jtAddCollage.getText().equals("") || jtAddPe.getText().equals("") || jtAddID.getText().equals("") || jtAddName.getText().equals("") || jtAddAge.getText().equals("") || jtAddClass.getText().equals("")
                    || jtAddMath.getText().equals("") || jtAddJava.getText().equals("") || jtAddEnglish.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "�Բ�����ȷ����Ϣ����ɣ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(!Check(jtAddPe.getText())||!Check(jtAddID.getText())||!Check(jtAddEnglish.getText())||!Check(jtAddJava.getText())||!Check(jtAddMath.getText())||!Check(jtAddAge.getText()))
            {
                JOptionPane.showMessageDialog(null, "�Բ�����ȷ����Ϣ��ʽ��ȷ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                math = Double.parseDouble(jtAddMath.getText());
                pe = Double.parseDouble(jtAddPe.getText());
                java = Double.parseDouble(jtAddJava.getText());
                english = Double.parseDouble(jtAddEnglish.getText());
                if (jr_man.isSelected())
                {
                    sex = "��";
                }
                else
                {
                    sex = "Ů";
                }
                information = jtAddID.getText() + " " + jtAddName.getText() + " " + sex + " " + jtAddAge.getText()+" " +jtAddCollage.getText() +" " + jtAddClass.getText() + " " + jtAddMath.getText() + " "
                        + jtAddEnglish.getText() + " " + jtAddJava.getText() + " " + jtAddPe.getText()+" "+String.valueOf(math+pe+java+english)+" "+String.valueOf((math+pe+java+english)/4);
                if (isEixt(jtAddID.getText(), FileName))
                {
                    JOptionPane.showMessageDialog(null, "�Բ��𣬸���Ϣ�Ѿ���д��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(null,"�ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    class MyTableModel extends AbstractTableModel
    {
        private String[] columnNames = {"ѧ��","����","�Ա�","����","ѧԺ","�༶","����","Ӣ��","Java","����","�ܳɼ�","ƽ����"};
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