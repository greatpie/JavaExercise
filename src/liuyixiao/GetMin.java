package liuyixiao;

/**
 * Created by pie on 2015-6-18.
 */
public class GetMin {
    public static void main(String[] args){
        //分析1300值的特征，发现只能由一奇数一偶数构成
        //拆分奇偶循环，减少一半遍历
        //i和j对称减少一次遍历

        for(int i=0;i<9;i=i+2){
            for(int j=1;j<10;j = j+2){
                if((i*10+j)*(i+j*10) == 1300){
                    System.out.println("i="+i+",j="+j);
                }
            }
        }
    }
}
