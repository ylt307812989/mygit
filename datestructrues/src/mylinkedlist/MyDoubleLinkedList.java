package mylinkedlist;

import java.util.Stack;

/**
 * @author maverick
 * @create 2020-12-01 16:17
 */
public class MyDoubleLinkedList {

    public static void main(String[] args) {
        DoubleLinkedDate hero1 = new DoubleLinkedDate(1,"宋江","及时雨");
        DoubleLinkedDate hero2 = new DoubleLinkedDate(4,"卢俊义","玉麒麟");
        DoubleLinkedDate hero3 = new DoubleLinkedDate(3,"吴用","智多星");
        DoubleLinkedDate hero4 = new DoubleLinkedDate(6,"林冲","豹子头");
        DoubleLinkedDate hero5 = new DoubleLinkedDate(7,"燕青","浪子");
        DoubleLinkedDate hero6 = new DoubleLinkedDate(5,"鲁智深","花和尚");
        DoubleLinkedDate hero7 = new DoubleLinkedDate(2,"史进","九纹龙");
        MyDoubleLinked ml = new MyDoubleLinked();

        ml.addByOrder(hero1);
        ml.addByOrder(hero4);
        ml.addByOrder(hero3);
        ml.addByOrder(hero2);
        ml.show();
        System.out.println("***********修改前***************");
        DoubleLinkedDate hero8 = new DoubleLinkedDate(3,"没有用","智星");
        ml.update(hero8);
        ml.show();
        System.out.println("***********删除前***************");
        ml.delete(3);
        ml.show();
        System.out.println("***********添加后***************");
        ml.addByOrder(hero7);
        ml.show();


    }
}


//创建链表的关系
class MyDoubleLinked{

    //首先创建一个头节点
    DoubleLinkedDate head = new DoubleLinkedDate(0,"","");


    //链表的按照自定义编号的顺序添加方法
    //实现定义一个变量作为操作的指针

    public void addByOrder(DoubleLinkedDate date){
        DoubleLinkedDate temp = head;
        boolean isFlag =false;
        while(temp.getNext() != null){

            if (temp.getSerial()>date.getSerial()){
                break;
            }
            if (temp.getSerial()==date.getSerial()){
                isFlag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(isFlag){
            System.out.println("准添加的英雄，已经存在");
            return;
        }else{
           if(temp.getNext() == null){
               temp.setNext(date);
               date.setPre(temp);
           }else{
               temp.getPre().setNext(date);
               date.setPre(temp.getPre());
               date.setNext(temp);
               temp.setPre(date);
           }
        }

    }


    //链表的添加方法
    public void add(DoubleLinkedDate date){
        //实现定义一个变量作为操作的指针
        DoubleLinkedDate temp = head;
        while(true){
            if(temp.getNext() == null ){
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(date);
        date.setPre(temp);

    }



    //链表的修改
    public void  update(DoubleLinkedDate newLinkdate){
        //按照给定的数据的编号修改其内容
        DoubleLinkedDate temp = head;
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
        DoubleLinkedDate temp = head.getNext();
        boolean isFlag =false;
        while(temp != null){

            if (temp.getSerial() == i){
                isFlag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (isFlag){
           temp.getPre().setNext(temp.getNext());
           if(temp.getNext() != null){
               temp.getNext().setPre(temp.getPre());
           }
        }else{
            System.out.println("没有要修改的数据");
        }
    }



    //链表的遍历方法
    //实现定义一个变量作为操作的指针

    public void show(){
        DoubleLinkedDate temp = head;
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
class DoubleLinkedDate {
    public Integer serial;
    public String heroName;
    public String heroNickName;
    public DoubleLinkedDate next;
    public DoubleLinkedDate pre;

    public DoubleLinkedDate(Integer serial, String heroName, String heroNickName){
        this.serial = serial;
        this.heroName = heroName;
        this.heroNickName = heroNickName;
    }

    public DoubleLinkedDate() {
    }

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

    public DoubleLinkedDate getNext() {
        return next;
    }

    public void setNext(DoubleLinkedDate next) {
        this.next = next;
    }

    public DoubleLinkedDate getPre() {
        return pre;
    }

    public void setPre(DoubleLinkedDate pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "DoubleLinkedDate{" +
                "serial=" + serial +
                ", heroName='" + heroName + '\'' +
                ", heroNickName='" + heroNickName + '\'' +
                '}';
    }
}
