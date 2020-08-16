package zhaoyang.study.Algorithm.sort;

/**
 * @author zhaoyang
 * @Date 2020/8/14 - 16:48
 * 
 * 快速排序——冒泡排序改进
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        quickSort(nums, 0, nums.length-1);
        for (int num : nums){
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high){
            int i = partition(nums, low, high);
            quickSort(nums, low, i-1);
            quickSort(nums, i+1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int temp = nums[low];
        int i = low;
        int j = high;

        while (i != j){
            while (i<j && nums[j]>temp){
                j--;
            }
            if (i < j){
                nums[i] = nums[j];
                i++;
            }
            while (i<j && nums[i]<temp){
                i++;
            }
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
            nums[i] = temp;
        }
        nums[i] = temp;
        return i;
    }
}
