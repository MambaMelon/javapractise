import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 求出一串字符串中最先出现三次的字符
 */
public class TongJiZiFu {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();  //字符串
        Set<String> s = new LinkedHashSet<String>();
        for(int i=0;i<str.length();i++) {
            s.add(str.substring(i, i + 1));
        }
        System.out.println(s);
        Object[] ch = s.toArray();
        for(int i=0;i<ch.length;i++){
            boolean first = false;
            int count = 0;
            for(int j=0;j<str.length();j++){
                if(ch[i].toString().equals(str.substring(j,j+1))){
                    count++;
                    if(count == 3){
                        System.out.println(ch[i]);
                    }
                }
            }
        }
    }
}
