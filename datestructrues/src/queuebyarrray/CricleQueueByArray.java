package queuebyarrray;

/**
 * @author maverick
 * @create 2020-12-01 9:34
 */
public class CricleQueueByArray {
    public static void main(String[] args) {
        CricleQueue cq = new CricleQueue(4);
        try {
            cq.add(10);
            cq.add(20);
            cq.add(30);
            System.out.println("取出的数据为"+cq.get());
            System.out.println("取出的数据为"+cq.get());
            System.out.println("取出的数据为"+cq.get());

            cq.add(40);

            cq.add(50);
            cq.add(60);
            System.out.println("取出的数据为"+cq.get());
            System.out.println("取出的数据为"+cq.get());
            System.out.println("取出的数据为"+cq.get());
            cq.add(70);

            cq.show();
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
}

class CricleQueue{
    private Integer maxSize;//队列的最大值
    private Integer front;//队列头
    private Integer rear;//队列尾
    private int[] arr;//队列的容器

    //构造器，初始化队列的属性
    public CricleQueue(Integer maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        rear = 0;
        front = 0;
    }

    //添加队列的方法
    public void add(Integer date){
        if(isFull()){
            System.out.println("队列满");
            return;
        }
        arr[rear] = date;
        rear = (rear + 1) % maxSize;
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmty(){
        return rear == front;
    }
    //取出队列中的数据
    public Integer get(){
        if(isEmty()){
            throw new RuntimeException("队列空");
        }
        Integer value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //展示队列的数据
    public void show(){
        if(isEmty()){
            throw new RuntimeException("队列空");
        }
        for (int i = front; i < front  + size() ; i++) {
            System.out.println(arr[i%maxSize]);
        }
    }
    //展示队列头
    public void showFront(){
        if(isEmty()){
            throw new RuntimeException("队列空");
        }
        System.out.println(arr[front]);

    }
    public Integer size(){
        return (rear + maxSize - front) % maxSize;
    }

}
