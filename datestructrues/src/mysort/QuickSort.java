package mysort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    @Test
    public void srotTest() {
        int[] arr = {11, 31, 52, 4, 8, 6, -5, 3, 7, 3,3,9,90};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        int[] arr = new int[100000
//                ];
//        for (int i = 0; i < 100000; i++) {
//            arr[i] = (int) (Math.random() * 100000);
//        }
//        Date date = new Date();
//        shellSort1(arr);
//        System.out.println(new Date().getTime() - date.getTime());
//        System.out.println("");
    }


    /**
     * 快速排序（冒泡排序的升级版）
     * 分析：首先找找到一个基准点。然后定义两个遍历指针分别从数组的两端开始往中间遍历，直到两个指针碰头，期间将数组中比基准大的数据放到数组的右边，小的放在数组的左边
     * 然后将数组以基准点一分为二，从基准但开始分别往左右两边递归上面的步骤，直至分开的数组长度都为1无法继续递归，排序完成
     *
     * @param arr 需要被排序的数组
     */
    public void quickSort(int[] arr, int l, int r) {

        //第一步：先完成将数组中的数据一个基准数据为准分为比基准小的和比基准大的分别放到基准数据的两端的算法
        //事先先定义两个遍历指针一个位数组的第一个为一个是数组的最后一位用于两端往中间的遍历
        //再定义一个临时变量用于交换数组的两个元素，
        //再定义一个基准数据，
        int left = l;
        int right = r;
        int privot = arr[(left + right) / 2];
        int temp = 0;
        while (left < right) {//循环结束的时候数组刚好遍历一边，比基准大的和比基准小的分别放在基准的两遍，该步骤完成
            while (arr[left] < privot) left++;
            while (arr[right] > privot) right--;
            if (left >= right) {
                break;
            }

            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            if (arr[left] == privot){
                left ++;
            }
            if (arr[right] == privot){
                right --;
            }


        }
        //避免无穷递归
        if (left == right) {
            left--;
            right++;
        }

//        向左递归
        if (l < left)
            quickSort(arr, l, right);
        //向右递归

        if (r > right)
            quickSort(arr, right, arr.length-1);

    }

}

/**
 * 快速排序
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 *
 * @author shkstart
 * 2018-12-17
 */
class QuickSort1 {
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static void subSort(int[] data, int start, int end) {
        if (start < end) {
            int base = data[start];
            int low = start;
            int high = end + 1;
            while (true) {
                while (low < end && data[++low] - base <= 0) ;
                while (high > start && data[--high] - base >= 0) ;
                if (low < high) {
                    swap(data, low, high);
                } else {
                    break;
                }
            }
            swap(data, start, high);

            subSort(data, start, high - 1);//递归调用
            subSort(data, high + 1, end);
        }
    }

    public static void quickSort(int[] data) {
        subSort(data, 0, data.length - 1);
    }


    public static void main(String[] args) {
        int[] data = {11, 31, 52, 14, 8, 6, -5, 3, 7, 3};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        quickSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}