package liuyixiao;

/**
 * Created by pie on 2015-6-18.
 */
public class GetMin {
    public static void main(String[] args){
        //����1300ֵ������������ֻ����һ����һż������
        //�����żѭ��������һ�����
        //i��j�ԳƼ���һ�α���

        for(int i=0;i<9;i=i+2){
            for(int j=1;j<10;j = j+2){
                if((i*10+j)*(i+j*10) == 1300){
                    System.out.println("i="+i+",j="+j);
                }
            }
        }
    }
}
