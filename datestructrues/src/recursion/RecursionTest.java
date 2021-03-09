package recursion;

import org.junit.Test;

/**
 * @author maverick
 * @create 2020-12-08 17:05
 */
public class RecursionTest {
    @Test
    public void test(){
        print(1);
    }
    @Test
    public void test1(){
        System.out.println(factorial(3, 5));
    }
    @Test
    public void test2(){
        System.out.println(factorial1(3));
    }

    public void print(int i){
        if(i <= 5){
            print(i + 1);
        }
        System.out.println(i);
    }

    /**
     * i到j的阶乘
     * @param i
     * @param j
     */
    public int factorial(int i,int j){
        if(i >= j){
            return i;
        }
        return factorial(i,j - 1) * j;
    }

    /**
     * 1到i的的阶乘
     * @param i
     * @return
     */
    public int factorial1(int i){
        if(i == 1){
            return i;
        }
        return factorial1(i- 1) * i;
    }
}
