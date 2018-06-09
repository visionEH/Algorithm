/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
 */
public class ROL {
    public String LeftRotateString(String str,int n) {
        int size = str.length();
        if (size == 0)
            return "";
        n = n % size;
        String ans = str.substring(n) + str.substring(0,n-1);
        return ans;
    }
}
