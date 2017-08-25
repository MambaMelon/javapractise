import java.util.Scanner;

/**
 * 我们用每种字符代表一种宝石，A表示红宝石，
 * B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表
 * 钻石，F代表玉石，G代表玻璃等等，我们用一个全部
 * 为大写字母的字符序列表示项链的宝石序列，注意
 * 项链是首尾相接的。每行代表一种情况。
 */
public class CaiSeXiangLian {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(gem(sc.nextLine()));
        sc.close();
    }

    public static int gem(String str){
        char[] ca = str.toCharArray();
        int len = str.length();
        for(int x = 5;x < len; x++){
            for(int y = 0; y < len; y++){
                StringBuilder temp = new StringBuilder("");
                for(int z = y;z < y+x;z++){
                    temp.append(ca[z%len]);
                }
                String t = temp.toString();
                if(t.contains("A")&&t.contains("B")&&t.contains("C")&&t.contains("D")&&t.contains("E")){
                    return len - x;
                }
            }
        }
        return 0;
    }
}
