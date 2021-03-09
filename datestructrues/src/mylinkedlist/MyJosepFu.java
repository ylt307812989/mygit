package mylinkedlist;

/**
 * @author maverick
 * @create 2020-12-03 8:30
 */
public class MyJosepFu {
    public static void main(String[] args) {
        //测试环形链表的创建遍历
        CircleLinked cl = new CircleLinked();
        cl.getCircleLinked(5);
        cl.show();
        cl.JosepFu(1,2,5);
    }
}

class CircleLinked{
    //首先定义一个链表容器的成员变量备用
    MyCircleLinked first = new MyCircleLinked(0);



    /**
     * 单项环形链表解决约瑟夫问题
     *
     * @param num      起点编号
     * @param numSize  每次移动的个数
     * @param count    最初的环形总个数
     */
    public void JosepFu(Integer num,Integer numSize,Integer count){
        //算法开始前先进行数据校验
        if(first == null || num > count || num < 1){
            System.out.println("输入的数据有误，重新输入");
        }
        //符合条件之后
        //首先创建一个辅助指针loper
        MyCircleLinked loper = first;
        //将loper移动到first的前一位
        while(true){
            if(loper.getNext() == first){
                break;
            }
            loper = loper.getNext();
        }
        //将辅助指针loper和遍历指针first移动到约瑟夫起点
        while(true){
            if(first.getSerial() == num){
                break;
            }
            first = first.getNext();
            loper = loper.getNext();
        }
        //从指针first开始遍历约瑟夫环，每向前numSize—1步first指针指向的数据取出，即先将first向前移动一步再将loper指向first形成新的约瑟夫环
        while(true){
            //当first指针和loper指针从何时证明，该约瑟夫换只剩一个数据，循环可以结束
            if(first == loper){
                break;
            }
            //通过指定循环次数的方式让约瑟夫问题运行起来（即每次向前走num步）
            for (int i = 0; i < numSize -1; i++) {
                first = first.getNext();
                loper = loper.getNext();
            }
            //循环结束先打印出需要去除的数据
            System.out.println(first.getSerial()+"号数据被取出");
            first = first.getNext();
            loper.setNext(first);

            //打印最后还留在约瑟夫换中的幸运数据
            System.out.println("营运数据为"+first.getSerial());
        }


    }


    //创建环形链表的方法
    public void getCircleLinked(int num){
        //创建环形链表时链表最小不能小于1
        if(num < 1){
            System.out.println("数字过小无法创建环形链表");
            return;
        }
        //创建环无头结点的形链表的首节点
        first = new MyCircleLinked(1);
        //符合环形链表的田条件，创建遍历指针遍历创建该圆形链表
        MyCircleLinked temp = first;
        for (int i = 0; i < num; i++) {
            //当i等于1 的时候自成一个换
            if(i == 0){
                temp.setNext(first);
            }else{
                MyCircleLinked boy = new MyCircleLinked(i + 1);
                temp.setNext(boy);
                boy.setNext(first);
            }
            temp = temp.getNext();
        }
    }

    //遍历环形链表
    public void show(){
        //遍历链表不能为空，首先定义遍历指针核实
        MyCircleLinked temp = first;
        if(temp == null){
            System.out.println("链表为空无法遍历");
        }
        while(true){
            System.out.println(temp);
            temp = temp.getNext();
            if(temp == first){
                break;
            }
        }

    }


}

//链表的容器
class MyCircleLinked{
    private Integer serial; //换装链表的编号
    private MyCircleLinked next;

    public MyCircleLinked(Integer serial) {
        this.serial = serial;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public MyCircleLinked getNext() {
        return next;
    }

    public void setNext(MyCircleLinked next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyCircleLinked{" +
                "serial=" + serial +
                '}';
    }
}




