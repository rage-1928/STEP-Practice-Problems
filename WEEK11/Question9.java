import java.util.*;
class Question9 {
    static int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] a = {-4, -1, 0, 3, 5, 9};
        int[] b = {1, 2, 3};
        int[] result1 = pairSumSorted(a, 4);
        int[] result2 = pairSumSorted(b, 100);
        System.out.println(result1 == null ? "Not Found" : Arrays.toString(result1));
        System.out.println(result2 == null ? "Not Found" : Arrays.toString(result2));
    }
}