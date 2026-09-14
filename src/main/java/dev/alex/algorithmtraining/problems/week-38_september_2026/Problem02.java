package dev.alex.algorithmtraining;
import java.util.Arrays;

public class Problem02 {
    public static void main(String[] args) {
        int[] first = {0, 1, 0, 3, 12};
        moveZeroes(first);
        System.out.println(Arrays.toString(first));

        int[] second = {0};
        moveZeroes(second);
        System.out.println(Arrays.toString(second));
    }

    public static void moveZeroes(int[] nums) {
        int insPos = 0;
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(curr != 0) {
                swap(insPos++, i, nums);
            }
        }

        for(int i = insPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void swap(int to, int from, int [] arr) {
        if(to == from)
            return;

        arr[to] = arr[from];
    }
}
