package dev.alex.algorithmtraining.problems.week_38_september_2026;

public class Problem02 {
    public int removeElement(int[] nums, int val) {
        int insPos = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            if(insPos != i) {
                nums[insPos] = nums[i];
            }
            insPos++;
        }
        return insPos;
    }
}
