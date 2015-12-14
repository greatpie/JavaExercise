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
    }//定义设置学号的方法

    public void setName(String Name) {
        this.name = Name;
    }//定义设置姓名的方法

    public void setAge(String Age) {
        this.age = Age;
    }//定义设置年龄的方法

    public void setCollege(String College) {
        this.college = College;
    }//定义设置学院的方法

    public void setSchoolclass(String Class1) {
        this.schoolclass = Class1;
    }//定义设置班级的方法

    public void setsex(String sex) {
        this.sex = sex;
    }//定义设置性别的方法

    public void setMath(String Math) {
        this.math = Math;
    }//定义设置高数的方法

    public void setEnglish(String English) {
        this.english = English;
    }//定义设置英语的方法

    public void setJava(String Java) {
        this.javasubject = Java;
    }//定义设置Java的方法

    public void setPe(String Pe) {
        this.pe = Pe;
    }//定义设置体育的方法

    public void setTotal(String Total) {
        this.total = Total;
    }//定义设置总分的方法

    public void setAverage(String Average) {
        this.average = Average;
    }//定义设置均分的方法


    public String getID() {
        return this.ID;
    }//定义取得学号的方法

    public String getName() {
        return this.name;
    }//定义取得名字的方法

    public String getAge() {
        return this.age;
    }//定义取得年龄的方法

    public String getCollege() {
        return this.college;
    }//定义取得学院的方法

    public String getSchoolclass() {
        return this.schoolclass;
    }//定义取得班级的方法

    public String getsex() {
        return this.sex;
    }//定义取得性别的方法

    public String getMath() {
        return this.math;
    }//定义取得高数的方法

    public String getEnglish() {
        return this.english;
    }//定义取得英语的方法

    public String getJava() {
        return this.javasubject;
    }//定义取得Java的方法

    public String getPe() {
        return this.pe;
    }//定义取得体育的方法

    //定义取得总分的方法
    public String getTotal() {
        return String.valueOf(Double.parseDouble(this.math) + Double.parseDouble(this.english) + Double.parseDouble(this.javasubject) + Double.parseDouble(this.pe));
    }

    //定义取得均分的方法
    public String getAverage() {
        return String.valueOf(Double.parseDouble(this.math) + Double.parseDouble(this.english) + Double.parseDouble(this.javasubject) + Double.parseDouble(this.pe) / 4);
    }
    //定义构造方法
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
    //定义从字符串数组实例化的构造方法
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
    //生成学生信息字符串
    public String toString(){
        String str = "ID:"+ID;
        str += "name:"+name;
        //剩下的没写完
        return str;
    }
    //生成字符串数组
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
    //跟据下标检索
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

