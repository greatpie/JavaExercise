package liuyixiao;

/**
 * Created by pie on 2015-6-18.
 */
public class GetNumCob {
    public static void main(String[] args) {
        /**
         * 分析ijk+kji=1333
         * 最高位组合3+9=12，故i从3开始
         * 1333由一奇数一偶数构成，故i奇k偶，i偶k奇
         * i = m时，k在[13-m-1,13-m+1]的范围间,只有13-m和i奇偶性相反，故k=13-i
         */
        for(int i=3;i<10;i++){
            for (int j=0;j<10;j++){
                int k = 13-i;
                if ((i*101+j*20+k*101)==1333){
                    System.out.println("i: "+i+",j= "+j+",k= "+k);
                }
            }
        }
    }
}
