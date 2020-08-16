package zhaoyang.study.Algorithm.sort;

/**
 * @author zhaoyang
 * @Date 2020/8/14 - 9:00
 *
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        insertSort(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }

    private static void insertSort(int[] nums) {
        int n = nums.length;
        for (int i=1; i<n; i++){
            for (int j=i; j>0 && nums[j-1]>nums[j]; j--){
                swap(nums, j-1, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
