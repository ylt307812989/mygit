package sparesarray;

import java.io.*;
import java.util.Arrays;

/**
 * @author maverick
 * @create 2020-11-30 20:39
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //创建二位数组模拟棋盘
        int arr[][] = new int [11][11];
        for (int[] a : arr ){
            for(int i : a){
                i = 0;
            }
        }

        arr[1][2] = 2;
        arr[2][3] = 1;
        arr[4][5] = 2;


        for (int[] a : arr ){
            for(int i : a){
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

        //将该二位数组压缩为稀疏数组，便于存储

        //先遍历出二位数组中存储的有效数字的个数
        int num = 0;
        for (int[] a : arr ){
            for(int i : a){
                if (i != 0){
                    num ++;
                }
            }
        }
        System.out.println("___________________________________________________");
        //根据有效数字的个数创建稀疏数组
        int sparseArray[][] = new int[num + 1][3];
        for (int[] a : sparseArray ){
            for(int i : a){

                System.out.print(i);

            }
            System.out.println();
        }

        System.out.println("________________________赋值后的稀疏数组___________________________");
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = num;
        //给稀疏数组复制
        int num1 = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] != 0){
                    num1++;
                    sparseArray[num1][0] = i;
                    sparseArray[num1][1] = j;
                    sparseArray[num1][2] = arr[i][j];
                }
            }

        }
        for (int[] a : sparseArray ){
            for(int i : a){

                System.out.print(i+"  ");

            }
            System.out.println();
        }
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.println(Arrays.toString(sparseArray[i]));
        }



        System.out.println("________________________将稀疏数组存入磁盘___________________________");
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        for (int i = 0; i < sparseArray.length; i++) {
            bw.write(Arrays.toString(sparseArray[i]));
            bw.newLine();
            bw.flush();
        }

        String S = "11";
        System.out.println(Integer.parseInt(S) == 11);

        int arr1[][] = null;
        System.out.println("________________________将稀疏数组从磁盘中读出___________________________");
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        String date;
        int i1 = 0;
        while((date = br.readLine()) != null){
            String str = date.substring(1,date.length()-1);
            String[] split = str.split(",");
            System.out.println(split.length);


            if(i1 == 0){
                i1 ++;
                arr1 = new int[11][11];
                for (int[] a : arr1 ){
                    for(int i : a){
                        System.out.printf("%d\t",i);
                    }
                    System.out.println();
                }

            }else{
                Integer s1 = Integer.valueOf(split[0]);
                Integer s2 = Integer.valueOf(split[1]);
                Integer s3 = Integer.valueOf(split[2]);
                arr1[s1][s2] = s3;
            }
        }


        System.out.println("________________________x稀疏数组转为二位数组___________________________");


//        for (int[] a : arr1 ){
//            for(int i : a){
//                System.out.printf("%d\t",i);
//            }
//            System.out.println();
//        }

        System.out.println("________________________x稀疏数组转为二位数组___________________________");
//        for (int i = 1; i < sparseArray.length; i++) {
//
//        }

        for (int[] a : arr1 ){
            for(int i : a){
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }




    }
}
