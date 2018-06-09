package day4;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class Multiply {
    /**
     * ：首先进行一次迭代：
     * i：1-n-1
     * b[i]=b[i-1]*a[i-1];
     * 这样下去就是：
     * b[1] = a[0]
     * b[2] = a[0]a[1]
     * …
     * b[i] = a[0]a[1]a[2]…a[i-1]
     * …
     * b[n-1] = a[0]a[1]…a[n-2]
     * …
     * b[i] = a[0]a[1]a[2]…a[i-1]
     * …
     * b[n-1] = a[0]a[1]…a[n-2]
     * 然后进行二次迭代。。通过不断扩展b[0]，来实现数组转换
     * 通过b[0]这个变量来迭代出1, a[n-1], a[n-2]a[n-1], a[n-3]a[n-2]a[n-1], … ,
     * a[1]a[2]a[3]…a[n-1]，迭代过程中分别乘以b[n-1], b[n-2], … , b[0]
     */
    public int[] multiply(int[] A) {
        int size = A.length;
        int[] ans = new int[size];
        ans[0] = 1;
        for (int i = 1; i < size; i++){
            ans[i] = ans[i-1] * A[i-1];
        }
        for (int i = size-1; i >= 0; i--){
            ans[i] *= ans[0];
            ans[0] *= A[i];
        }
        return ans;
    }
}
