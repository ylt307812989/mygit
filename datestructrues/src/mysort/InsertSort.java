package mysort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    @Test
    public void srotTest(){

//        int[] arr = {1,-1,2,4,8,6};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[1000000] ;
        for (int i = 0; i < 1000000; i++) {
            arr[i] =(int)(Math.random()*1000000);
        }
        Date date = new Date();
//                int[] ints = selectSrot1(arr);
        insertSort(arr);
        System.out.println(new Date().getTime() - date.getTime());
    }
    public void inserSrot(int[] arr) {
        //第一步定义一个变量存储循环开始前被插入元素
        int num;
        //定义一个指针辅助遍历
        int indexNum;
        for (int i = 1; i < arr.length; i++) {
            num = arr[i];
            indexNum = i - 1;
            while (indexNum >= 0 && arr[indexNum] > num){
                arr[indexNum + 1] = arr[indexNum];
                indexNum--;
            }
            arr[indexNum+1] = num;
        }
    }

    /**
     * 这里从高到低排序
     * 插入排序是指针遍历控制排序
     * 一开始的时候默认给定数组的第一位是有序的表，第一位以后为无需表的，
     * 通过一个从第二位数据到最后一位的循环完成排序，
     * 其中每一轮循环中书写插入排序的逻辑。
     * 每一轮循环从无序表中拿出一个数据，通过遍历的方式插入到有序列表合适位置
     * 外层循环结束排序完成
     *
     *
     *
     *
     * @param arr 需要被排序的数组
     */
    public void insertSort(int [] arr){

        //先声明一个遍历临时变量，在每一次内层循环开始前记录当前外层循环需要插入的无序列表值
        int inserValue;
        //声明一个遍历指针，记录内层循环结束后需要改变的有序表的下标的前一位
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            //循环开始前初始化两
            // 个实现生命的变量
            inserValue = arr[i];//本轮数组中无需列表的第一个值，即需要被插入的元素
            insertIndex = i - 1;//记录有序列表的最后一位，即被插入元素比较的第一位，不成立则一位一位向前比较，成立则书写插入逻辑
            while (insertIndex >= 0 && //保证如果待插入元素数组中的最小值，也不会角标越界
                arr[insertIndex] < inserValue //如果有序表的元素比待插入值大，则后移一位直至找到大插入值比有序表中值大位置插入即可
                ){
                 arr[insertIndex + 1] = arr[insertIndex];
                 insertIndex --;
            }
            if (insertIndex != i - 1){
                arr[insertIndex + 1] = inserValue;
            }

        }
    }
}