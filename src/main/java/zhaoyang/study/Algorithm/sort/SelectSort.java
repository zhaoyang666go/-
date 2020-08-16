package zhaoyang.study.Algorithm.sort;

/**
 * @author zhaoyang
 * @Date 2020/8/12 - 15:22
 *
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 2, 1, 4};
        selectSort(a);
        for(int i : a){
            System.out.print(i + " ");
        }
    }

    static void selectSort(int[] a){
        int length = a.length;
        int min;
        for (int i = 0; i < length-1; i++) {
            min = i;
            for (int j = i+1; j < length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(a, i, min);
            }
        }
    }

    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
