package zhaoyang.study.Algorithm.sort;

/**
 * @author zhaoyang
 * @Date 2020/8/14 - 9:34
 *
 * 希尔排序——简单插入排序的改进
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        shellSort(nums);
        for (int num : nums){
            System.out.print(num + " ");
        }
    }

    private static void shellSort(int[] nums) {
        int n = nums.length;
        int j;
        for (int gap=n/2; gap>0; gap/=2){
            for (int i=gap; i<n; i++){
                j = i;
//                while (j-gap>=0 && nums[j-gap] > nums[j]){
//                    swap(nums, j, j-gap);
//                    j -= gap;
//                }
                while (j-gap >=0){
                    if(nums[j-gap] > nums[j]){
                        swap(nums, j, j-gap);
                    }
                    j -= gap;
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
