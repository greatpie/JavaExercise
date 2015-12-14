package student_system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pie on 2015-6-4.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "information.txt";
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String str = "";
        try
        {
            for (int i = 0; (str = br.readLine()) != null; i++)
            {

                String[] studentStr = str.split(" ");
                Student pie = new Student(studentStr);
                System.out.println(pie.toString());
//                if (studentStr[0].equals("201310020"))
//                {
//                    System.out.println("find it ");
//                }else{
//                    System.out.println("failed");
//                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }



}
