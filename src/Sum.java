import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Sum {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new Sum().FindContinuousSequence(100);

        for (ArrayList<Integer> list : ans){
            System.out.println(list);
        }
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int x, y;
        x = y = 0;
        for (int i = 2; i < sum; i++){
            y = i * (i - 1) / 2;
            x = sum - y;
            if (x <= 0){
                break;
            }
            if (x % i == 0){
                int start = x / i;
                int count = i;
                ArrayList<Integer> temp = new ArrayList<>();
                while (count > 0){
                    temp.add(start++);
                    count--;
                }
                ans.add(temp);
            }
        }
        ArrayList<ArrayList<Integer>> ansReverse = new ArrayList<>();
        for (int i = ans.size()-1; i >= 0; i--){
            ansReverse.add(ans.get(i));
        }
        return ansReverse;
    }
}

