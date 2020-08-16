package zhaoyang.study.Algorithm.sort;

/**
 * @author zhaoyang
 * @Date 2020/8/14 - 16:27
 * 
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        mergeSort(nums);
        for (int num : nums){
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        sort(nums, low, high);
    }

    private static int[] sort(int[] nums, int low, int high){
        int mid = (low+high)/2;
        if (low < high){
            sort(nums,low, mid);
            sort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;

        //把较小元素放在辅助数组中
        while (i<=mid && j<=high){
            if (nums[i] < nums[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        //左边剩余元素加入辅助数组
        while (i<=mid){
            temp[k++] = nums[i++];
        }

        //右边剩余元素加入辅助数组
        while (j<=high){
            temp[k++] = nums[j++];
        }

        //辅助数组元素覆盖原数组
        for (int x=0; x<temp.length; x++){
            nums[x+low] = temp[x];
        }
    }
}
