package mylinkedlist;

import java.util.Stack;

/**
 * @author maverick
 * @create 2020-12-01 16:17
 */
public class MyLinkedList {

    public static void main(String[] args) {
        LinkedDate hero1 = new LinkedDate(1,"宋江","及时雨");
        LinkedDate hero2 = new LinkedDate(4,"卢俊义","玉麒麟");
        LinkedDate hero3 = new LinkedDate(3,"吴用","智多星");
        LinkedDate hero4 = new LinkedDate(6,"林冲","豹子头");
        LinkedDate hero5 = new LinkedDate(7,"燕青","浪子");
        LinkedDate hero6 = new LinkedDate(5,"鲁智深","花和尚");
        LinkedDate hero7 = new LinkedDate(2,"史进","九纹龙");
        MyLinked ml = new MyLinked();
        MyLinked ml1 = new MyLinked();
        MyLinked ml2 = new MyLinked();
        ml1.addByOrder(hero5);
        ml1.addByOrder(hero6);
        ml1.addByOrder(hero7);


//        hero1.setNext(ml1.getNext());
//        ml1.setNext(hero1.getNext());
        ml.addByOrder(hero1);
        ml.addByOrder(hero4);
        ml.addByOrder(hero3);
        ml.addByOrder(hero2);
        System.out.println("***************逆序打印**********************");
//        ml.reversadOut(ml.head);
        System.out.println("***************逆序打印**********************");
        System.out.println("***************链表合并**********************");
        ml.show();
        System.out.println("***************链表1**********************");

        ml1.show();
        System.out.println("***************链表2**********************");
        ml2.head = ml.megarLinked(ml.head, ml1.head);
        ml2.show();
        System.out.println("***************链表合并**********************");



//单链表的反转
        System.out.println("*************************************");
//        ml.show();
        System.out.println("*************************************");
//        ml.reversalLinked(ml.head);
//        ml.show();


//        ml.show();
//        System.out.println(hero1.getNext());
//        hero1.next= ml1.next;
//        hero2.next=ml1.next;
//        System.out.println("元数据的下一个"+hero1.getNext());
//        System.out.println("新头的下一个"+ml1.getNext());
//        System.out.println("而数据的下一个"+hero2.getNext());
        System.out.println("*************************************");
//        ml.add(hero1);
//        ml.add(hero2);
//        ml.add(hero3);
//        ml.add(hero4);
//        ml.update(hero5);
//        ml.delete(1);
//        ml.delete(2);
//        ml.delete(3);
//        ml.delete(4);

//        ml.show();
    }
}



//创建链表的关系
class MyLinked{

    //首先创建一个头节点
    LinkedDate head = new LinkedDate(0,"","");

    //合并两个单项链表
    public LinkedDate megarLinked(LinkedDate date1,LinkedDate date2){//LinkedDate单项链表的数据类型
        //首先判断两个链表是否为空
        //实现定义遍历指针，以指针判断是否为空
        LinkedDate temp1 = date1.getNext();
        LinkedDate temp2 = date2;
        if(temp1.getNext() == null){
            return date2;
        }
        if(temp2.getNext() == null){
            return date1;
        }
        //定义两个临时存储变量
        LinkedDate next1 = null;
        LinkedDate next2 = null;
        //以链表二为主体，将链表一的数据整合到链表二上面
        while(temp2 !=null){
            //保存原始链表2的第二个数据，防止在第一轮循环结束后链表2结构变化引起，第二个数据变成新增加的链表一种的数据造成脏读
            next2 = temp2.getNext();
            //重新定义链表1 的遍历指针，因为链表1在第一次循环结束后其结构结构可能变化，弱变化之前的遍历指针可能为空
            temp1 = date1.getNext();
            while(temp1 != null){
                //保存遍历指针的下一个数据，防止合并操作造成链表一断裂，造成无线死循环
                next1 = temp1.getNext();
                //判断链表1中取出的值的编号是否小于链表二当前值的下一个值的编号，如果小则证明链表1当前的值在链表二的当前值和当前值的下一个值之间，则进行合并操作
                if(temp1.getSerial() < next2.getSerial()){
                    //先将链表2的当前值的链断裂并指向链表1的当前值
                    temp2.setNext(temp1);
                    //将量表1的当前值的链断裂并指向链表2的当前值的下一个值，完成链表1当前值合并到链表2的正确位置
                    temp1.setNext(next2);
                    //程序到此证明链表2的当前值和其下一个值之间已经插入链表1的一个或多个值。所以必须将链表2的当前值换成最新插入的链表1的值，否则将闭环
                    temp2 = temp1;
                    //程序到此证明链表1的结构已经变化，如果内层循环的第一次全部结束，进入第二次循环则team1的值将为null，内层循环将不在执行
                    //所以必须重构链表1，内层循环再次从头开始的时候，从新链表的一个值开始
                    date1.setNext(next1);
                }
                //迭代链表1的遍历指针
                temp1 = next1;
            }
            //迭代链表2的遍历指针
            temp2 = next2;
        }
        return date2;
    }

    //单向链表反转

    public void reversalLinked(LinkedDate head){
        //①判断给定的链表是否为空，若为或者为一，直接返回
        if(head.getNext() == null || head.getNext().getNext() == null){
            return;
        }
        //定义新的链表和标记变量以及遍历指针
        LinkedDate newlink = new LinkedDate(0,"","");
        LinkedDate cur = head.getNext();
        LinkedDate next = null;
        //开始遍历反转
        while(cur!=null){
            next = cur.getNext();
            cur.setNext(newlink.getNext());
            newlink.setNext(cur);
            cur = next;
        }
        head.setNext(newlink.getNext());
    }

    //单项链表的逆序dayin
    public void reversadOut(LinkedDate head){
        //①判断给定的链表是否为空，若为或者为一，直接返回
        if(head.getNext() == null || head.getNext().getNext() == null){
            System.out.println("给定的链表为空，无法进行逆序打印");
            return;
        }
        //如链表不为空，先定义一个遍历指针，再创建一个栈，
        LinkedDate cur = head.getNext();
        Stack<LinkedDate> stack = new Stack<>();
        //将链表中的数据按照链表顺序压入栈中
        while(cur != null){
            stack.push(cur);
            cur = cur.getNext();
        }

        //数据出栈并打印
        while(stack.size() > 0){
            LinkedDate pop = stack.pop();
            System.out.println(pop);
        }

    }

    //链表的添加方法
    public void add(LinkedDate date){
        //实现定义一个变量作为操作的指针
        LinkedDate temp = head;
        while(true){
            if(temp.getNext() == null ){
                temp.setNext(date);
                break;
            }
            temp = temp.getNext();
        }

    }

    //链表的按照自定义编号的顺序添加方法
    //实现定义一个变量作为操作的指针

    public void addByOrder(LinkedDate date){
        LinkedDate temp = head;
        boolean isFlag =false;
        while(true){
            if(temp.getNext() == null){
                break;
            }
            if (temp.getNext().getSerial()>date.getSerial()){
                break;
            }
            if (temp.getNext().getSerial()==date.getSerial()){
                isFlag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(isFlag){
            System.out.println("准添加的英雄，已经存在");
            return;
        }else{
            date.setNext(temp.getNext());
            temp.setNext(date);

        }

    }


    //链表的修改
    public void  update(LinkedDate newLinkdate){
        //按照给定的数据的编号修改其内容
        LinkedDate temp = head;
        boolean isFlag =false;
        while(true){
            if(temp.getNext() == null){
                break;
            }
            if (temp.getNext().getSerial() == newLinkdate.getSerial()){
                isFlag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (isFlag){
            temp.getNext().setHeroName(newLinkdate.getHeroName());
            temp.getNext().setHeroNickName(newLinkdate.getHeroNickName());
        }else{
            System.out.println("没有要修改的数据");
        }
    }


    //链表的删除
    public void delete(Integer i){
        LinkedDate temp = head;
        boolean isFlag =false;
        while(true){
            if(temp.getNext() == null){
                break;
            }
            if (temp.getNext().getSerial() == i){
                isFlag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (isFlag){
           temp.setNext(temp.getNext().getNext());
        }else{
            System.out.println("没有要修改的数据");
        }
    }



    //链表的遍历方法
    //实现定义一个变量作为操作的指针

    public void show(){
        LinkedDate temp = head;
        if(temp.getNext() == null){
            System.out.println("链表为空");
            return;
        }

        while(true){
            if(temp.getNext()==null){
                break;
            }

            System.out.println(temp.getNext());
            temp = temp.getNext();
        }

    }

}


//首先指定一个变量容器，用于存放链表的一个节点的数据
class LinkedDate {
    public Integer serial;
    public String heroName;
    public String heroNickName;
    public LinkedDate next;

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroNickName() {
        return heroNickName;
    }

    public void setHeroNickName(String heroNickName) {
        this.heroNickName = heroNickName;
    }

    public LinkedDate getNext() {
        return next;
    }

    public void setNext(LinkedDate next) {
        this.next = next;
    }

    public LinkedDate(Integer serial, String heroName, String heroNickName){
        this.serial = serial;
        this.heroName = heroName;
        this.heroNickName = heroNickName;
    }

    @Override
    public String toString() {
        return "LinkedDate{" +
                "serial=" + serial +
                ", heroName='" + heroName + '\'' +
                ", heroNickName='" + heroNickName + '\'' +

                '}';
    }
}
