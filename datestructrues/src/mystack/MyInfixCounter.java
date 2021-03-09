package mystack;

/**
 * @author maverick
 * @create 2020-12-07 12:21
 */
public class MyInfixCounter {
    public static void main(String[] args) {
        MyInfixCounter mf = new MyInfixCounter();
        Integer counter = mf.counter("10+10*2-4");
        System.out.println(counter);
    }

    /**
     * 栈模拟计算机算法
     *
     * @param expression
     * @return
     */
    public Integer counter(String expression) {
        ArrayStack1 num = new ArrayStack1(10);//数栈
        ArrayStack1 operator = new ArrayStack1(10);//运算符栈
        String numTwo = "";//定义一个String变量用于拼接多位数
        //遍历从字符串表达式中一个一个的提取字符，并判断是否为运算符，执行器对应的操作
        //顶一个遍历指针index从0开始
        Integer index = 0;
        while (true) {
            char c = expression.substring(index, index + 1).charAt(0);
            if (isope(c) >= 0) {//大于0代表是符号否则时数字
                //如果是运算符。先判断运算符栈是否为空
                if (operator.isemty()) {
                    //如果为空直接将该运算符压入zhan
                    operator.push(c-0);
                } else {
                    //如果不为空判断当前运算符的优先级是否高于栈顶运算符的优先级
                    if (isope(c) < isope((char) operator.peekTop())) {
                        //如果大于则执行：从数栈中pop两个数从运算符栈中pop一个运算符进行计算，计算结果push进数栈。当前运算符push进运算符栈中
                        Integer num1 = num.pop();
                        Integer num2 = num.pop();
                        Integer pop = operator.pop();
                        int i = myCounter(num1, num2, pop);
                        num.push(i);
                        operator.push(c-0);

                    } else {
                        //如果不大于则当前运算符直接push进运算符栈中
                        operator.push(c-0);
                    }
                }
            } else {
                //如果不是字符，即为num在判断其是否为一位数
                numTwo += c;
                //判单表达式的下一位字符是否为符号
                //如果最最后一位则直接push，如果不是最后以为再进行判断
                if(index >= expression.length()-1){
                    num.push(Integer.parseInt(numTwo));
                    numTwo = "";
                }else {
                    char c1 = expression.substring(index + 1, index + 2).charAt(0);
                    if (isope(c1) >= 0) {//大于0代表是符号否则时数字
                        //如果是符号则直接压入数字栈中，并将拼接字符串清零。如果时数字进行任何操作，让拼接字符串进行拼接，直到表达式的下一位为符号位置
                        num.push(Integer.parseInt(numTwo));
                        numTwo = "";
                    }
                }
            }

            //判断当前字符是否为表达式字符串的最后一位，如果是则跳出循环，如果不是让循环指针迭代
            if(index >= expression.length()-1){
                break;
            }
            index ++;
        }
        //循环结束之后将数字栈中的数字两辆取出并将运算符栈中的运算符一一取出进行运算，每次运算结果在压入数字栈中。直至运算符栈空
        while (true){
            if(operator.isemty()){
                break;
            }
            Integer num1 = num.pop();
            Integer num2 = num.pop();
            Integer pop = operator.pop();
            int i = myCounter(num1, num2, pop);
            num.push(i);
        }
        return num.pop();
    }

    /**
     * 判断输入字符是否是为运算符，不是运算符默认为数字，这里只模拟+,-,*,/
     *
     * @param c
     * @return
     */
    public int isope(char c) {
        if (c == '+' || c == '-') {
            return 0;
        }
        if (c == '*' || c == '/') {
            return 1;
        }
        return -1;//代表数
    }

    /**
     * 从数字栈去除两个数从运算符栈中取出一个运算符的计算逻辑
     * @param num1
     * @param num2
     * @param ope
     * @return
     */
    public int myCounter(int num1,int num2,int ope){
        int res = 1 ;//定义一个int变量用于存储计算结果
        switch (ope){
            case '+':
                res = num1 + num2;
            break;
            case '-':
                res = num2 - num1;
            break;
            case '*':
                res = num1 * num2;
            break;
            case '/':
                res = num2 / num1;
            break;
        }
        return res;
    }
}


/**
 * 中缀表达式模拟单位数计算器
 */
class ArrayStack1 {

    private Integer maxSize;//表示栈得最大容量
    private int[] arr;//表示站的容器

    private Integer top = -1;//表示栈顶

    //判断栈是否已满
    public boolean isFull() {
        return top >= maxSize - 1;
    }

    //判断栈是否为空
    public boolean isemty() {
        return top == -1;
    }

    //入栈
    public void push(Integer i) {
        if (isFull()) {
            System.out.println("栈满无法添加");
            return;
        }
        arr[++top] = i;
    }

    /**
     * 展示暂定数据
     *
     * @return
     */
    public int peekTop() {
        return arr[top];
    }

    //出栈
    public Integer pop() {
        if (isemty()) {
            throw new RuntimeException("栈空。无法去数据");
        }
        Integer value = arr[top--];
        return value;
    }

    //遍历栈
    public void show() {
        if (isemty()) {
            System.out.println("栈空，无法遍历数据");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }


    public ArrayStack1(Integer maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }


}
