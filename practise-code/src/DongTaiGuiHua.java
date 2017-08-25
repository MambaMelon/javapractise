/**
 * 背包问题具体例子：假设现有容量10kg的背包，
 * 另外有3个物品，分别为a1，a2，a3。物品a1重
 * 量为3kg，价值为4；物品a2重量为4kg，价值为5；
 * 物品a3重量为5kg，价值为6。将哪些物品放入背
 * 包可使得背包中的总价值最大？
 */
public class DongTaiGuiHua {
    public static void main(String[] args){
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = BackPack(m, n, w, p);
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                System.out.print(c[i][j]+"\t");
                if(j == m){
                    System.out.println();
                }
            }
        }
    }

    public static int[][] BackPack(int m, int n, int[] w, int[] p) {
        int c[][] = new int[n+1][m+1];
        for(int i = 0;i < n+1;i++){
            c[i][0] = 0;
        }
        for(int i = 0;i < m+1;i++){
            c[0][i] = 0;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(w[i-1] <= j){
                    if(c[i-1][j] < (c[i-1][j-w[i-1]]+p[i-1]))
                        c[i][j] = c[i-1][j-w[i-1]] + p[i-1];
                    else
                        c[i][j] = c[i-1][j];
                }else {
                    c[i][j] = c[i-1][j];
                }
            }
        }
        return c;
    }
}
