package sjx;


public class Student {
    String ID;
    String Name;
    String Age;
    String College;
    String Class1;
    String sex;
    String Math;
    String English;
    String Java;
    String Pe;
    String Total;
    String Average;

    public void setID(String ID) {
        this.ID = ID;
    }//��������ѧ�ŵķ���

    public void setName(String Name) {
        this.Name = Name;
    }//�������������ķ���

    public void setAge(String Age) {
        this.Age = Age;
    }//������������ķ���

    public void setCollege(String College) {
        this.College = College;
    }//��������ѧԺ�ķ���

    public void setClass1(String Class1) {
        this.Class1 = Class1;
    }//�������ð༶�ķ���

    public void setsex(String sex) {
        this.sex = sex;
    }//���������Ա�ķ���

    public void setMath(String Math) {
        this.Math = Math;
    }//�������ø����ķ���

    public void setEnglish(String English) {
        this.English = English;
    }//��������Ӣ��ķ���

    public void setJava(String Java) {
        this.Java = Java;
    }//��������Java�ķ���

    public void setPe(String Pe) {
        this.Pe = Pe;
    }//�������������ķ���

    public void setTotal(String Total) {
        this.Total = Total;
    }//���������ֵܷķ���

    public void setAverage(String Average) {
        this.Average = Average;
    }//�������þ��ֵķ���


    public String getID() {
        return this.ID;
    }//����ȡ��ѧ�ŵķ���

    public String getName() {
        return this.Name;
    }//����ȡ�����ֵķ���

    public String getAge() {
        return this.Age;
    }//����ȡ������ķ���

    public String getCollege() {
        return this.College;
    }//����ȡ��ѧԺ�ķ���

    public String getClass1() {
        return this.Class1;
    }//����ȡ�ð༶�ķ���

    public String getsex() {
        return this.sex;
    }//����ȡ���Ա�ķ���

    public String getMath() {
        return this.Math;
    }//����ȡ�ø����ķ���

    public String getEnglish() {
        return this.English;
    }//����ȡ��Ӣ��ķ���

    public String getJava() {
        return this.Java;
    }//����ȡ��Java�ķ���

    public String getPe() {
        return this.Pe;
    }//����ȡ�������ķ���

    public String getTotal() {
        return String.valueOf(Double.parseDouble(this.Math) + Double.parseDouble(this.English) + Double.parseDouble(this.Java) + Double.parseDouble(this.Pe));
    }//����ȡ���ֵܷķ���

    public String getAverage() {
        return String.valueOf(Double.parseDouble(this.Math) + Double.parseDouble(this.English) + Double.parseDouble(this.Java) + Double.parseDouble(this.Pe) / 4);
    }//����ȡ�þ��ֵķ���

    public Student(String ID, String Name, String Age, String College, String Class1, String sex, String Math, String English, String Java, String Pe, String Total, String Average) {

        this.setID(ID);
        this.setName(Name);
        this.setAge(Age);
        this.setCollege(College);
        this.setClass1(Class1);
        this.setsex(sex);
        this.setMath(Math);
        this.setEnglish(English);
        this.setJava(Java);
        this.setPe(Pe);
        this.setTotal(Total);
        this.setAverage(Average);
    }//���幹�췽��

}

