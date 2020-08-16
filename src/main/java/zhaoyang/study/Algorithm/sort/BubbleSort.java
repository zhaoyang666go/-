package zhaoyang.study.Algorithm.sort;

/**
 * @author zhaoyang
 * @Date 2020/8/12 - 15:32
 *
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        bubbleSort(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }

    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean sorted; //交换标识

        for (int i=0; i<n-1; i++){
            sorted = false;
            for (int j=0; j<n-1-i; j++){
                if (nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                    sorted = true;
                }
            }
            if (!sorted){
                break;
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
