package mystack;


import java.util.Stack;

/**
 * @author maverick
 * @create 2020-12-06 20:22
 */
public class LinkStackDome {
    public static void main(String[] args) {
        //测试链表组装是否正确
        MyLinked ml = new MyLinked();
        MyLink l0= new MyLink(10);
        MyLink l1 = new MyLink(20);
        MyLink l3 = new MyLink(30);
        MyLink l4 = new MyLink(40);
        MyLink l5 = new MyLink(50);
        MyLink l6 = new MyLink(60);
//        ml.add(l0);
//        ml.add(l1);
//        ml.add(l3);
//        ml.add(l5);
//        ml.add(l4);
//        MyLink delete = ml.delete();
//        System.out.println("被删除的数据"+delete);
//       ml.show();
        LinkStack ls = new LinkStack(5);
        ls.push(l0);
        ls.push(l1);
        ls.push(l3);
        ls.push(l4);
        ls.push(l5);
        ls.pop();
        ls.push(l6);
        ls.reversadOut(ls.ml.head);



    }
}


/**
 * 链表模拟栈
 */
class LinkStack{
    private Integer maxSize;//栈的最大值
     MyLinked ml;//栈的链表容器
    private Integer top = -1;//栈顶


    //栈是否为空
    public boolean ifFull(){
        return top >= maxSize - 1;
    }
    //栈是否满
    public boolean isEmty(){
        return top == -1;
    }
    //入栈
    public void push(MyLink date){
        if (ifFull()){
            System.out.println("栈满无法添加");
            return;
        }
        top ++;
        ml.add(date);

    }
    //出栈
    public MyLink pop(){
        if (isEmty()){
            System.out.println("栈空无法取出数据");
            throw new RuntimeException("栈空，无法出栈");
        }
        top --;
        MyLink delete = ml.delete();
        return delete;
    }
    //遍历
    public void reversadOut(MyLink head){
        //①判断给定的链表是否为空，若为或者为一，直接返回
        if(head.getNext() == null){
            System.out.println("给定的链表为空，无法进行逆序打印");
            return;
        }
        //如链表不为空，先定义一个遍历指针，再创建一个栈，
        MyLink cur = head.getNext();
        Stack<MyLink> stack = new Stack<>();
        //将链表中的数据按照链表顺序压入栈中
        while(cur != null){
            stack.push(cur);
            cur = cur.getNext();
        }

        //数据出栈并打印
        while(stack.size() > 0){
            MyLink pop = stack.pop();
            System.out.println(pop);
        }

    }

    public LinkStack(Integer maxSize) {
        this.maxSize = maxSize;
        ml = new MyLinked();
    }


    public LinkStack() {
    }
}


/**
 * 组装链表
 */
class MyLinked {
    MyLink head = new MyLink(0);

    //判断是否为空
    //判断是否满
    //添加
    public void add(MyLink date){
        MyLink  temp = head;
        while(true){
            if(temp.getNext() == null){
                temp.setNext(date);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 创建一个指定节点数量的链表
     * @param num
     * @return
     */
    public MyLinked getMyLinked(Integer num){
        MyLinked ml = new MyLinked();
        //遍历添加该链表
        for (int i = 0; i < num - 1; i++) {
            MyLink date = new MyLink(i+1);
            ml.add(date);
        }
         return ml;
    }
    //遍历
    public void show(){
        MyLink  temp = head.getNext();
        if(temp == null){
            System.out.println("链表为空");
            return;
        }
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    //删除
    public MyLink delete(){
        MyLink temp = head;
        if (temp == null){
            System.out.println("链表为空");
        }

        MyLink value = null;
        while(true){
            if (temp.getNext().getNext() == null) {
                value = temp.getNext();
                break;
            }
            temp = temp.getNext();

        }

        temp.setNext(null);
        return value;
    }

}

/**
 * 链表节点
 */
class MyLink {
    private Integer date;//链表中需要存储的数据类型
    private MyLink next;//记录下一个节点

    public MyLink getNext() {
        return next;
    }

    public void setNext(MyLink next) {
        this.next = next;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public MyLink(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MyLink{" +
                "date=" + date +
                '}';
    }
}













































