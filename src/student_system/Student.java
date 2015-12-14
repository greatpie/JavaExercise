package student_system;


public class Student {
    String ID;
    String name;
    String age;
    String college;
    String schoolclass;
    String sex;
    String math;
    String english;
    String javasubject;
    String pe;
    String total;
    String average;

    public void setID(String ID) {
        this.ID = ID;
    }//��������ѧ�ŵķ���

    public void setName(String Name) {
        this.name = Name;
    }//�������������ķ���

    public void setAge(String Age) {
        this.age = Age;
    }//������������ķ���

    public void setCollege(String College) {
        this.college = College;
    }//��������ѧԺ�ķ���

    public void setSchoolclass(String Class1) {
        this.schoolclass = Class1;
    }//�������ð༶�ķ���

    public void setsex(String sex) {
        this.sex = sex;
    }//���������Ա�ķ���

    public void setMath(String Math) {
        this.math = Math;
    }//�������ø����ķ���

    public void setEnglish(String English) {
        this.english = English;
    }//��������Ӣ��ķ���

    public void setJava(String Java) {
        this.javasubject = Java;
    }//��������Java�ķ���

    public void setPe(String Pe) {
        this.pe = Pe;
    }//�������������ķ���

    public void setTotal(String Total) {
        this.total = Total;
    }//���������ֵܷķ���

    public void setAverage(String Average) {
        this.average = Average;
    }//�������þ��ֵķ���


    public String getID() {
        return this.ID;
    }//����ȡ��ѧ�ŵķ���

    public String getName() {
        return this.name;
    }//����ȡ�����ֵķ���

    public String getAge() {
        return this.age;
    }//����ȡ������ķ���

    public String getCollege() {
        return this.college;
    }//����ȡ��ѧԺ�ķ���

    public String getSchoolclass() {
        return this.schoolclass;
    }//����ȡ�ð༶�ķ���

    public String getsex() {
        return this.sex;
    }//����ȡ���Ա�ķ���

    public String getMath() {
        return this.math;
    }//����ȡ�ø����ķ���

    public String getEnglish() {
        return this.english;
    }//����ȡ��Ӣ��ķ���

    public String getJava() {
        return this.javasubject;
    }//����ȡ��Java�ķ���

    public String getPe() {
        return this.pe;
    }//����ȡ�������ķ���

    //����ȡ���ֵܷķ���
    public String getTotal() {
        return String.valueOf(Double.parseDouble(this.math) + Double.parseDouble(this.english) + Double.parseDouble(this.javasubject) + Double.parseDouble(this.pe));
    }

    //����ȡ�þ��ֵķ���
    public String getAverage() {
        return String.valueOf(Double.parseDouble(this.math) + Double.parseDouble(this.english) + Double.parseDouble(this.javasubject) + Double.parseDouble(this.pe) / 4);
    }
    //���幹�췽��
    public Student(String ID, String name, String age, String college, String schoolclass, String sex, String math, String english, String javasubject, String pe, String total, String average) {

        this.setID(ID);
        this.setName(name);
        this.setAge(age);
        this.setCollege(college);
        this.setSchoolclass(schoolclass);
        this.setsex(sex);
        this.setMath(math);
        this.setEnglish(english);
        this.setJava(javasubject);
        this.setPe(pe);
        this.setTotal(total);
        this.setAverage(average);
    }
    //������ַ�������ʵ�����Ĺ��췽��
    public Student(String[] studentStr){
        this.ID = studentStr[0];
        this.name = studentStr[1];
        this.sex = studentStr[2];
        this.age = studentStr[3];
        this.college = studentStr[4];
        this.schoolclass = studentStr[5];
        this.math = studentStr[6];
        this.english = studentStr[7];
        this.javasubject = studentStr[8];
        this.pe = studentStr[9];
        this.total = studentStr[10];
        this.average = studentStr[11];
    }
    //����ѧ����Ϣ�ַ���
    public String toString(){
        String str = "ID:"+ID;
        str += "name:"+name;
        //ʣ�µ�ûд��
        return str;
    }
    //�����ַ�������
    public String[] toStringArray(){
        String[] strArr= new String[12];
        strArr[0] = ID;
        strArr[1] = name;
        strArr[2] = sex;
        strArr[3] = age;
        strArr[4] = college;
        strArr[5] = schoolclass;
        strArr[6] = math;
        strArr[7] = english;
        strArr[8] = javasubject;
        strArr[9] = pe;
        strArr[10] = total;
        strArr[11] = average;
        return strArr;
    }
    //�����±����
    public String getByNum(int num){
        String str="";
        switch (num){
            case 0:str = ID;break;
            case 1:str = name;break;
            case 2:str = sex;break;
            case 3:str = age;break;
            case 4:str = college;break;
            case 5:str = schoolclass;break;
            case 6:str = math;break;
            case 7:str = english;break;
            case 8:str = javasubject;break;
            case 9:str = pe;break;
            case 10:str = total;break;
            case 11:str = average;break;
            default:str = ID;
        }
        return str;
    }
    public void setByNum(int num,String value){
        switch (num){
            case 0:ID = value;break;
            case 1:name = value;break;
            case 2:sex = value;break;
            case 3:age = value;break;
            case 4:college=value;break;
            case 5:schoolclass=value;break;
            case 6:math=value;break;
            case 7:english=value;break;
            case 8:javasubject=value;break;
            case 9:pe=value;break;
            case 10:total=value;break;
            case 11:average=value;break;
            default:name=value;
        }
    }

}

