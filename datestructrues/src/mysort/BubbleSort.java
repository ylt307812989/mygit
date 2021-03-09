package mysort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    @Test
    public void srotTest(){
//        int[] arr = {1,-1,2,4,5,6};
//        int[] ints = bubbleSrot(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[100000] ;
        for (int i = 0; i < 100000; i++) {
            arr[i] =(int)(Math.random()*100000);
        }
        Date date = new Date();
//                int[] ints = selectSrot1(arr);
        int[] ints = bubbleSrot(arr);
        System.out.println(new Date().getTime() - date.getTime());
    }
    public int[] bubbleSrot(int[] arr){
        int temp = 0;
        boolean isFlag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isFlag = false;
                }
            }

            if (isFlag){
                break;
            }else{
                isFlag = true;
            }
        }
        return arr;
    }


}
