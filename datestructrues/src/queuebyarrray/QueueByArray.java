package queuebyarrray;

/**
 * @author maverick
 * @create 2020-12-01 9:52
 */
public class QueueByArray {
    public static void main(String[] args) {
        Queue q = new Queue(3);



            q.add(10);
            q.add(20);
            q.add(30);


            int i1 = q.get();
            System.out.println(i1);
            int i2 = q.get();
            System.out.println(i2);
            int i3 = q.get();
            System.out.println(i3);
            int i4 = q.get();
            System.out.println(i4);
            q.add(40);

    }
}

class Queue{
    private Integer maxSize;//队列的最大值
    private Integer front;//队列头
    private Integer rear;//队列尾
    private int[] arr;//队列的容器

    //构造器，初始化队列的属性
    public Queue(Integer maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        rear = -1;
        front = -1;
    }

    //添加队列的方法
    public void add(Integer date){
        if(isFull()){
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear] = date;
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否空
    public boolean isEmty(){
        return rear == front;
    }
    //去除队列中的数据
    public Integer get(){
        if(isEmty()){
           throw new RuntimeException("队列空");
        }
        return arr[++front];
    }
    //展示队列的数据
    public void show(){
        if(isEmty()){
            throw new RuntimeException("队列空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //展示队列头
    public void showFront(){
        if(isEmty()){
            throw new RuntimeException("队列空");
        }
        System.out.println(arr[front+1]);

    }

}
