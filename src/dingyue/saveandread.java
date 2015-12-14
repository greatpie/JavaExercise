package dingyue;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;
 
public class saveandread {
	
	//static String student[][]=new String [200][15];
	
	static sscStuInfo arrStuInfo[] = new sscStuInfo[200];
	
	//static String student2[][] = new String[200][15];
	
	static sscStuInfo arrStuInfo2[] = new sscStuInfo[200];
	static int iReadCount = 0;
	
	static int i=0;
	
	public void save (String filename, 
			String name, 
			String no,
			String course,
			String gradeY,
			String gradeM,
			String gradeE,
			String grade1,
			String grade2,
			String grade3,
			String cbcoursename1,
			String cbcoursename2,
			String cbcoursename3
			){
		java.io.File file = new java.io.File(filename);
		if(file.exists()){
			System.out .println("File already exists");
			//System.exit(0);
			
		}
		java.io.PrintWriter output=null;
		try {
			 output = new java.io.PrintWriter(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		output.println(name);
		output.println(no);
		output.println(course);
		output.println(gradeY);
		output.println(gradeM);
		output.println(gradeE);
		output.println(grade1);
		output.println(grade2);
		output.println(grade3);
		output.println(cbcoursename1 );
		output.println(cbcoursename2 );
		output.println( cbcoursename3);
		
		output.close();
		
		
		
		 
	}
	
	

	static public void StuInfortoArray2 ( sscStuInfo sinfo )
	{
		arrStuInfo[i] = sinfo;
		
		
		i++;
	}
	
	
//	static public void StuInfortoArray (String name,String no,String course,
//			String gradeY,String gradeM,String gradeE,
//			String grade1,String grade2,String grade3,
//			String cbcoursename1,
//			String cbcoursename2,
//			String cbcoursename3){
//		
//		student[i][0] = name;
//		student[i][1] = no;
//		student[i][2] = course;
//		student[i][3] = gradeY;
//		student[i][4] = gradeM;
//		student[i][5] = gradeE;
//		student[i][6] = grade1;
//		student[i][7] = grade2;
//		student[i][8] = grade3;
//		student[i][9] = cbcoursename1;
//		student[i][10] = cbcoursename2 ;
//		student[i][11] =  cbcoursename3;
//		
//		
//		i++;
//										
				
				
	//}
	
	public void WriteArraytoFile(String filename) throws FileNotFoundException{
	
		java.io.File file = new java.io.File(filename);
		if(file.exists()){
			System.out .println("File already exists");
			//System.exit(0);
			
		}
		java.io.PrintWriter output=null;
		output = new java.io.PrintWriter(filename);
		for(int n=0;n<i;n++){
		output.print(arrStuInfo[n].name+" " );
		output.print( arrStuInfo[n].no+" ");
		output.print(arrStuInfo[n].course +" ");
		output.println( arrStuInfo[n].gradeY);
		output.println( arrStuInfo[n].gradeM);
		output.println( arrStuInfo[n].gradeE);
		output.println( arrStuInfo[n].grade1);
		output.println( arrStuInfo[n].grade2);
		output.println( arrStuInfo[n].grade3);
		output.println( arrStuInfo[n].cbcoursename1);
		output.println( arrStuInfo[n].cbcoursename2);
		output.println( arrStuInfo[n].cbcoursename3);
		
		
		}
		output.close();
		
	}
	
	
	
public void  read()  {
	java.io.File file = new java.io.File("testfile1.txt");
	Scanner input = null;
	try {
		input = new Scanner(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	int i=0;
	while (input.hasNext()){
		String name = input.next();
		String no = input.next();
		String course = input.next();
		String gradeY = input.next();
		String gradeM = input.next();
		String gradeE = input.next();
		String grade1 = input.next();
		String grade2 = input.next();
		String grade3 = input.next();
		String cbcoursename1 = input.next();
		String cbcoursename2 = input.next();
		String cbcoursename3 = input.next();
		 
		sscStuInfo _info = new sscStuInfo();
		
		arrStuInfo2[i] = _info;
		
		arrStuInfo2[i].name = name;
		 arrStuInfo2[i].no = no ;
		 arrStuInfo2[i].course = course  ;
		  arrStuInfo2[i].gradeY = gradeY;
		  arrStuInfo2[i].gradeM = gradeM;
		  arrStuInfo2[i].gradeE = gradeE;
		  arrStuInfo2[i].grade1 = grade1;
		  arrStuInfo2[i].grade2 = grade2;
		  arrStuInfo2[i].grade3 = grade3;
		  arrStuInfo2[i].cbcoursename1  = cbcoursename1;
		  arrStuInfo2[i].cbcoursename2  = cbcoursename2;
		  arrStuInfo2[i].cbcoursename3 = cbcoursename3; 
//		student2[i][0] = name;
//	    student2[i][1] = no;
//	    student2[i][2] = course;
//	    student2[i][3] = gradeY;
//	    student2[i][4] = gradeM;
//	    student2[i][5] = gradeE;
//	    student2[i][6] = grade1;
//	    student2[i][7] = grade2;
//	    student2[i][8] = grade3;
//	    student2[i][9] = cbcoursename1;
//	    student2[i][10] = cbcoursename2;
//	    student2[i][11] = cbcoursename3;
	    
	    i++;
	    
	    
	     iReadCount++;    
	    
		
	}
	input.close();
		
		
	}
	 
	
}

