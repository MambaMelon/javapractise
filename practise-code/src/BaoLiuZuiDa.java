import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个十进制的正整数number，
 * 选择从里面去掉一部分数字，希望
 * 保留下来的数字组成的正整数最大
 */
public class BaoLiuZuiDa {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();  //接收一串数字
        Integer num = sc.nextInt();  //去掉数字的个数
        List<String> list = new ArrayList<String>();
        for(int i=0;i<str.length();i++){
            list.add(str.substring(i,i+1));
        }
        Collections.sort(list);
        for(int i=num;i<list.size();i++){
            System.out.print(list.get(i));
        }

    }
}
