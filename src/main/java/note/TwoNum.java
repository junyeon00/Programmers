package note;

import java.util.HashSet;

public class TwoNum {
    private static boolean solution(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);

        for (int i = 0; i < set.size(); i++){
            if((target-arr[i]) != (target/2) && set.contains(target - arr[i])){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TwoNum twoNum = new TwoNum();
        int[] arr = {2,3,5,9};
        int target = 10;
        System.out.println(twoNum.solution(arr, target));
    }
}