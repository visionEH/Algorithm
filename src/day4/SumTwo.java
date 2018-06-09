package day4;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class SumTwo {
    /**
     *
     *    第一步：相加各位的值，不算进位
     *    第二步：计算进位值
     *    第三步重复上述两步
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int temp;
        while (num2 != 0){
           temp = num1 ^ num2;
           num2 = (num1 & num2) << 1;
           num1 = temp;
       }
       return num1;
    }
}
