package mysort;

import org.junit.Test;
import sun.security.util.Length;

import java.util.Arrays;
import java.util.Date;

public class ShlleSort {
    @Test
    public void srotTest(){
//        int[] arr = {1,-1,2,4,8,6,-5,35,7,3};
//        shellSort1(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[100000
                ] ;
        for (int i = 0; i < 100000; i++) {
            arr[i] =(int)(Math.random()*100000);
        }
        Date date = new Date();
//                int[] ints = selectSrot1(arr);
        shellSort1(arr);
        System.out.println(new Date().getTime() - date.getTime());
        System.out.println("");
    }


    /**
     * 这里从低到高进行希尔排序
     * 首先使用交换法完成
     * 希尔排序实在插入排序的基础上进行优化的，为了避免过多以为造成的性能损耗，希尔排序首先讲数组进行分组
     * 第一轮先将数组/2分为length/2组，步长也为length/2组，将数组按照分组过后的情况进行一次插入排序，
     * 第一轮排序完成之后，循环进行分组并插入排序的步骤，直至剩下的唯一一组排序完成，整个希尔排序结束
     * 由于数组分组后需要执行的插入排序步骤直接减半，所以可以快速的将数组整理成相对有序的新数组，直至分组剩下一组的时候在执行完整的插入排序
     * 此时完整的插入排序每次只需要移位一步，故整个排序效率会大大提高，数据量越大效率越高
     *
     *
     * @param arr 需要被排序的数组
     */
    public void shellSort1(int [] arr){

        //第一步：先进行排序前的分组，由于分组步骤数量取决于数组长度，所以需要循环进行
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {

            //先声明一个遍历临时变量，在每一次内层循环开始前记录当前外层循环需要插入的无序列表值
            int inserValue;
            //声明一个遍历指针，记录内层循环结束后需要改变的有序表的下标的前一位
            int insertIndex;
            for (int i = gap; i < arr.length; i++) {
                //循环开始前初始化两
                // 个实现生命的变量
                inserValue = arr[i];//本轮数组中无需列表的第一个值，即需要被插入的元素
                insertIndex = i - gap;//记录有序列表的最后一位，即被插入元素比较的第一位，不成立则一位一位向前比较，成立则书写插入逻辑
                while (insertIndex >= 0 && //保证如果待插入元素数组中的最小值，也不会角标越界
                        arr[insertIndex] > inserValue //如果有序表的元素比待插入值大，则后移一位直至找到大插入值比有序表中值大位置插入即可
                ){
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                if (insertIndex != i - gap){
                    arr[insertIndex + gap] = inserValue;
                }

            }
        }

    }
}
