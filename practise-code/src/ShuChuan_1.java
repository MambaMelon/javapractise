import java.util.*;

/**
 * Created by Melon on 2017/8/17
 *
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 *
 */
public class ShuChuan_1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = sc.nextInt();   //字符串个数
        for(int num=0;num<i;num++){
            list.add(sc.nextInt());
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1.toString() + o2.toString();
                String str2 = o2.toString() + o1.toString();
                return str1.compareTo(str2);
            }
        });
        for(int k=list.size()-1;k>=0;k--){

            System.out.print(list.get(k));
        }
    }
}
