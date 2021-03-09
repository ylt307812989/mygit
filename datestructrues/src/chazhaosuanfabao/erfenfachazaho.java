package chazhaosuanfabao;

import sun.plugin2.message.GetAppletMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class erfenfachazaho {

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,3,3,3,4,4,4,5,5,6,7,8,8,9,9};
        System.out.println(Arrays.toString(arr));
        List<Integer> integers = get(arr, 0, 0, arr.length - 1);
        System.out.println(integers);
    }

    public static List<Integer> get(int[] arr, Integer value, int left, int right) {
        //第一步先定义两个变量保存数组的最左边的值和最右边的值
//        int left = 0;
//        int right = arr.length;

        //第二步先定义数组的中间的下标和其对应的值
        int mid = (left + right) / 2;

        //第三步确定递归的出口①
        if (left > right) {
            return new ArrayList<>();
        }
        //如果数组中间值比目标值大则向左递归查找
        if (arr[mid] > value) {
            return get(arr, value, left, mid - 1);
        }else  if (arr[mid] < value) {//如果数组中间值比目标值小这向右递归查找
            return get(arr, value, mid + 1, right);
        }else{//第四步编写算法主体结构
            List<Integer> list = new ArrayList<>();
            //如果找到目标值，先将目标值存入集合中，分别像目标值的左右两边遍历拿到所有的目标值
            //全部存入集合中
            list.add(mid);
            //向左
            int index = mid - 1;
            while (true) {
                if (index < 0 || arr[index] != value) {
                    break;
                }
                list.add(index--);
            }
            //向又
            index = mid + 1;
            while (true) {
                if (index > arr.length - 1 || arr[index] != value) {
                    break;
                }
                list.add(index++);
            }
            //递归的第二出口
            return list;
        }



    }


}
