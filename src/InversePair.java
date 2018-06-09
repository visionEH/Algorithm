/**
 * 在数组中的两个数字如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数
 */
public class InversePair {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        int[] copy = new int[array.length];
        System.out.println(new InversePair().inversePires(array,copy,0,array.length-1));
    }
    public int inversePires(int[] array, int[] copy, int start, int end){
        if(start == end){
            copy[start] = array[start];
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = inversePires(array,copy,start,mid);
        int right = inversePires(array,copy,mid+1,end);
        int count = 0;
        int i = mid;
        int j = end;
        int copyIndex = end;
        while((i >= start) && (j >= mid +1)){
            if (array[i] > array[j]){
                //存在逆序对
                copy[copyIndex--] = array[i];
                count += (j - mid);
                i--;
            } else {
                copy[copyIndex--] = array[j--];
            }
        }
        while (i >= start){
            copy[copyIndex--] = array[i--];
        }
        while (j >= mid +1){
            copy[copyIndex--] = array[j--];
        }
        for (int k = start; k <= end; k++){
            array[k] = copy[k];
        }
        return left + right + count;

    }
}
