package mysort;

import org.junit.Test;
import java.util.Date;
public class SelectionSort {

    @Test
    public void srotTest() throws InterruptedException {
//        int[] arr = {1,2,6,3,7,23,8,2} ;
        int[] arr = new int[100000] ;
        for (int i = 0; i < 100000; i++) {
            arr[i] =(int)(Math.random()*100000);
        }
        Date date = new Date();
//                int[] ints = selectSrot1(arr);
        int[] ints = selectSrot2(arr);
        System.out.println(new Date().getTime() - date.getTime());


//        System.out.println(Arrays.toString(ints));
    }

    public int[] selectSrot1(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i; j < arr.length ; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public int[] selectSrot2(int[] arr) {

        for (int i = 0; i < arr.length ; i++) {
            int index = 0;
            int min = arr[i];
            for (int j = i; j < arr.length ; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                   index = j;
                }
            }
            if(index != 0){
                arr[index] = arr[i];
                arr[i] =  min;
            }
        }
        return arr;
    }

}
