/**
 * Created by Melon on 2017/9/21.
 * 链接：https://www.nowcoder.com/questionTerminal/57cf0b1050834901933e9b48daafbb9a
 来源：牛客网

 这3道题能满足下列条件：
 a<=b<=c
 b-a<=10
 c-b<=10
 所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），
 然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求，
 然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
 */
public class BuShu {

    public static void main(String[] args){
        int a[] = {20, 23, 36, 56};
        int t = 1;
        int cnt = 0;
        for(int i=1;i<4;i++){
            if(t<3){
                if(a[i]-a[i-1] <= 10){
                    t++;
                }else if(t==1 && a[i]-a[i-1]<=20){
                    cnt++;
                    t = 3;
                }else{
                    cnt += 3-t;
                    t = 1;
                }
            }else{
                t = 1;
            }
        }
        cnt += 3-t;
        System.out.println(cnt);
    }
}
