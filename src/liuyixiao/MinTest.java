package liuyixiao;

/**
 * Created by pie on 2015-6-18.
 */
public class MinTest {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if((i*10+j)*(i+j*10)==1300){
                    System.out.println(i+","+j);
                }
            }
        }
    }
}
