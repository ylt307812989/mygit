package hashtab;

import javax.xml.bind.SchemaOutputResolver;
import java.util.TooManyListenersException;

public class MyHashTab {
    public static void main(String[] args) {
        HashTab myhashtab = new HashTab();
        myhashtab.addEmp(new Emp(1,"tom"));
        myhashtab.showEmp();
    }

}


class HashTab{
    private linkdeEmp[] myHashTab;
    private int maxsize = 7  ;
    public HashTab() {
        myHashTab = new linkdeEmp[maxsize];
        for (int i = 0; i < maxsize; i++) {
            myHashTab[i] = new linkdeEmp();
        }
    }

    /**
     * 添加员工
     * @param emp
     */
    public void addEmp(Emp emp){
        int hash = hash(emp.getId());
        myHashTab[hash].add(emp);
    }

    /**
     * 遍历hash表
     */
    public void showEmp(){
        for (int i = 0; i < myHashTab.length; i++) {
            System.out.println("第"+(i+1)+"条链表");
            myHashTab[i].show();
        }
    }

    /**
     * 散列函数
     * @param id 员工id
     * @retur 散列值
     */
    public int hash(Integer id){
        return  id % maxsize;
    }

}

class linkdeEmp{
    private Emp head = new Emp(null,null);

    public void  add(Emp emp){
        Emp temp = head;
        while (true){
            if (temp.getNext() != null){
                temp = temp.getNext();
            }
            break;
        }
        temp.setNext(emp);
    }

    public void show(){

        Emp temp = head.getNext();
        if (temp == null){
            System.out.println("链表为空");
        }
        while (temp != null){
            System.out.println(temp);
            temp= temp.getNext();
        }

    }
}


class Emp{
    private Integer id;
    private String name;
    private Emp next;

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
