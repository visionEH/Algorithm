/**
 * 一个数组中只有两个数字是出现一次，其他所有数字都出现了两次。 找出这两个数字
 */
public class FindTwo {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,6,5,4,3,2,1,10};
        find(a,a.length);
    }
    public static void find(int[] a, int n){
        int temp = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n; i++){
            temp ^= a[i];
        }
        int pos = 0;
        while (pos < 32){
            if (((temp >> pos) & 1) == 1){
                   break;
            }
            pos++;
        }
        for (int i = 0; i < n; i++){
            if(((a[i] >> pos) & 1) == 1) {
                num1 ^= a[i];
            } else {
                num2 ^= a[i];
            }
        }
        System.out.println("number are "+num1+" "+num2);
    }
}
