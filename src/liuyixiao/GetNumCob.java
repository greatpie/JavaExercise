package liuyixiao;

/**
 * Created by pie on 2015-6-18.
 */
public class GetNumCob {
    public static void main(String[] args) {
        /**
         * ����ijk+kji=1333
         * ���λ���3+9=12����i��3��ʼ
         * 1333��һ����һż�����ɣ���i��kż��iżk��
         * i = mʱ��k��[13-m-1,13-m+1]�ķ�Χ��,ֻ��13-m��i��ż���෴����k=13-i
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
