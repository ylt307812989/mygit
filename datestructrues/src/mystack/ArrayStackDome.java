package mystack;

/**
 * @author maverick
 * @create 2020-12-06 18:07
 */
public class ArrayStackDome {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5);
//        as.show();
        as.push(10);
        as.push(20);
        as.push(30);
        as.push(40);
        as.push(50);
        as.pop();
        as.push(60);
        as.show();

    }


}

class ArrayStack{
    private Integer maxSize;//表示栈得最大容量
    private int[] arr;//表示站的容器
    private Integer top = -1;//表示栈顶

    //判断栈是否已满
    public boolean isFull(){
        return top >= maxSize-1;
    }
    //判断栈是否为空
    public boolean isemty(){
        return top == -1;
    }
    //入栈
    public void push(Integer i){
        if (isFull()){
            System.out.println("栈满无法添加");
            return;
        }
        arr[++top] = i;
    }
    //出栈
    public Integer pop(){
        if(isemty()){
            throw new RuntimeException("栈空。无法去数据");
        }
        Integer value = arr[top--];
        return value;
    }
    //遍历栈
    public void show(){
        if (isemty()){
            System.out.println("栈空，无法遍历数据");
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.println(arr[i]);
        }
    }



    public ArrayStack(Integer maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }


}































