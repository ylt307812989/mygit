package recursion;


/**
 * @author maverick
 * @create 2020-12-08 22:00
 */
public class Queen8 {

    //实现定一个以为数组存储结构，每一个数组对应的一个解。
    //其中该一维数组的下标值对应八皇后棋盘的行值，下标对应的数组元素对应的八皇后当前行的列
    static int max = 8;
    static int[] arr = new int[max];
    static int count = 0;//记录一共多少个解
    public static void main(String[] args) {
        solve(0);
        System.out.println("解的个数" + count);
    }

    /**
     * ①该方法是整个递归回溯的中心算法，这里n将代表八皇后棋盘的行。即：递归就是递归这个方法，每递归一次代表再八皇后的棋盘中的一行放一个棋子
     * ②回溯的是现实是：每在一行放一个棋子后先判断该棋子的坐标和片面的棋子规则上是否冲突，如果冲突则同一行更换其他坐标放置棋子，如果不冲突则继续放下一行棋子重复判断当前②规则
     * ③在2规则递归回溯的时候，每一个逻辑成功则返回true失败则返回false，递归终点是当当数组的长度达到9时证明证明前面八个棋子摆放正确返回true，直接打印结果，而后进入下一个回溯逻辑
     * ④无论成功与否②规则每一行的棋子都要循环执行8次，这里正式递归的回溯
     *
     * @param n 代表第几行，从0开始，递归一次就是一行，
     */
    public static void solve(int n) {
        //先写递归终点
        if (n == max) {
            myPrint();
            return;
        }
        //验证当前行摆放的皇后是否和前面的行的皇后在同一列或者在在同一些线上,这里循环验证每一轮循环通过则可以得到一个姐
        //循环通不过则证明当前行的当前循环坐标的得到不到正确姐，可以直接下一轮循环
        for (int i = 0; i < arr.length; i++) {
            arr[n] = i;
            //验证当前行皇后冲不冲突算法
            if (judage(n)) {//证明不冲突，可以进行下一行皇后递归
                solve(n + 1);
            }
            //如果冲突则直接进行下一轮当前行皇后递归，这里不需要多余的逻辑
        }
    }

    /**
     * 判断第行皇后是否和前面的n-1个皇后冲突
     * @param n 表示第几行皇后
     * @return
     */
    private static boolean judage(int n) {
        //这里循环n次代表判断前面n-1个皇后
        for (int i = 0; i < n; i++) {
            /*
            ①arr[n]代表第n行皇后的列值，arr[i]代表第i行皇后的列值
            ②Math.abs(n-i) == Math.abs(arr[n] - arr[i])判断是否在同一列上
            ③同一行无用判断
             */
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 该方法负责打印出求出的八皇后正确解的数组
     */
    public static void myPrint() {
        count++;
        System.out.print(" ");
        System.out.print("第"+count+"个正确解:");
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.print(" ");
        if (count%7== 0){
            System.out.println();
        }


    }

}
