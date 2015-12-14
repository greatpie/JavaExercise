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
    }//定义设置学号的方法

    public void setName(String Name) {
        this.Name = Name;
    }//定义设置姓名的方法

    public void setAge(String Age) {
        this.Age = Age;
    }//定义设置年龄的方法

    public void setCollege(String College) {
        this.College = College;
    }//定义设置学院的方法

    public void setClass1(String Class1) {
        this.Class1 = Class1;
    }//定义设置班级的方法

    public void setsex(String sex) {
        this.sex = sex;
    }//定义设置性别的方法

    public void setMath(String Math) {
        this.Math = Math;
    }//定义设置高数的方法

    public void setEnglish(String English) {
        this.English = English;
    }//定义设置英语的方法

    public void setJava(String Java) {
        this.Java = Java;
    }//定义设置Java的方法

    public void setPe(String Pe) {
        this.Pe = Pe;
    }//定义设置体育的方法

    public void setTotal(String Total) {
        this.Total = Total;
    }//定义设置总分的方法

    public void setAverage(String Average) {
        this.Average = Average;
    }//定义设置均分的方法


    public String getID() {
        return this.ID;
    }//定义取得学号的方法

    public String getName() {
        return this.Name;
    }//定义取得名字的方法

    public String getAge() {
        return this.Age;
    }//定义取得年龄的方法

    public String getCollege() {
        return this.College;
    }//定义取得学院的方法

    public String getClass1() {
        return this.Class1;
    }//定义取得班级的方法

    public String getsex() {
        return this.sex;
    }//定义取得性别的方法

    public String getMath() {
        return this.Math;
    }//定义取得高数的方法

    public String getEnglish() {
        return this.English;
    }//定义取得英语的方法

    public String getJava() {
        return this.Java;
    }//定义取得Java的方法

    public String getPe() {
        return this.Pe;
    }//定义取得体育的方法

    public String getTotal() {
        return String.valueOf(Double.parseDouble(this.Math) + Double.parseDouble(this.English) + Double.parseDouble(this.Java) + Double.parseDouble(this.Pe));
    }//定义取得总分的方法

    public String getAverage() {
        return String.valueOf(Double.parseDouble(this.Math) + Double.parseDouble(this.English) + Double.parseDouble(this.Java) + Double.parseDouble(this.Pe) / 4);
    }//定义取得均分的方法

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
    }//定义构造方法

}

