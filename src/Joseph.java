/**
 * 约瑟夫问题
 */
public class Joseph {
    public static void main(String[] args) {
        new Joseph().LastRemaining_Solution(5,3);
    }

    public int LastRemaining_Solution(int n, int m) {
        int[] tag = new int [n];
        int begin = 0;
        int count = 0;
        int t = 0;
        while (true){
            if (tag[begin] == 0){
                count++;
                if (count >= m){
                    tag[begin] = 1;
                    count = 0;
                    t++;

                    if (t >= n)
                        return begin+1;
                }
            }
            begin = (begin + 1) % n;
        }
    }
    /*
    ： n个人（编号0~(n-1))，从0开始报数，报到(m-1)的退出，剩下的人 继续从0开始报数。求胜利者的编号。
       我们知道第一个人(编号一定是m%n-1) 出列之后，
       剩下的n-1个人组成了一个新      的约瑟夫环（以编号为k=m%n的人开始）:
        k  k+1  k+2  ... n-2, n-1, 0, 1, 2, ... k-2并且从k开始报0
        变成了一个子问题，逆向成了一个迭代问题
     */
    public int SolutionTwo(int n,int m){
        if (n <= 0 || m <= 0){
            return -1;
        }
        int s = 0;
        for (int i = 2; i < n; i++){
             s = (s + m) % n;
        }
        return s;
    }
}
