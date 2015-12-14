package sjx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pie on 2015-6-3.
 */
public class Test {
    public static void main(String args[]) {
        String[][] student = new String[100][25];
        Student[] stus = new Student[100];
        String FileName = "./information.txt";

        String str = null;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 12; j++) {
                student[i][j] = " ";
            }
        }
        try {
            FileReader fr = new FileReader(FileName);
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; (str = br.readLine()) != null; i++) {
                String[] stustr = str.split(" ");
                if(stustr.length>1 && stustr.length<15){
                    student[i] = stustr;
                }
                for(int k1=0;k1<student[i].length;k1++){
                    String pie2 = student[i][k1];
                    System.out.println(pie2);

                }
                System.out.println("len:" + student[i].length);
                stus[i] = new Student(student[i][0], student[i][1], student[i][2],
                        student[i][3], student[i][4], student[i][5], student[i][6],
                        student[i][7], student[i][8], student[i][9],student[i][10],student[i][11]);

//

                System.out.println("pie");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
