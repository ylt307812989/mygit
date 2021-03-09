package mytree;

import java.awt.print.PrinterAbortException;
import java.io.Serializable;
import java.util.TreeMap;

public class erchatreedome {
    public static void main(String[] args) {
        MyTree root = new MyTree();
        TreeDate node1 = new TreeDate(1,"宋江");
        TreeDate node2 = new TreeDate(2,"吴用");
        TreeDate node3 = new TreeDate(3,"卢俊义");
        TreeDate node4 = new TreeDate(4,"林冲");
        TreeDate node5 = new TreeDate(5,"关胜");
        root.setRoot(node1);
        root.getRoot().setLeft(node2);
        root.getRoot().setRight(node3);
        root.getRoot().getRight().setLeft(node5);
        root.getRoot().getRight().setRight(node4);
        System.out.println("********************前序遍历******************");
        root.preShow();
        System.out.println("********************中序遍历******************");
        root.inorderShow();
        System.out.println("********************后续遍历******************");
        root.sufferShow();
        TreeDate getpre = root.getSuffer(3);
        System.out.println(getpre);
        System.out.println("***************************************************");
        root.delete(1);
        root.preShow();

    }
}

class MyTree{
    private TreeDate root;

    //删除指定节点给
    public void delete(Integer id){
        if (this.root != null){
            if (this.root.getId() == id){
                this.root = null;
            }else{
                this.root.deleteById(id);
            }
        }else {
            System.out.println("空树无法删除");
        }
    }
    //前序查找
    public TreeDate getpre(Integer id){
        if (root != null){
            return root.getpre(id);
        }else{
            return null;
        }
    }
 //中序查找
    public TreeDate getInorder(Integer id){
        if (root != null){
            return root.getInorder(id);
        }else{
            return null;
        }
    }

    //前序查找
    public TreeDate getSuffer(Integer id) {
        if (root != null) {
            return root.getsuffer(id);
        } else {
            return null;
        }
    }

    //前序遍历
    public void preShow(){
        if (root != null){
            root.preShow(root);
        }else{
            System.out.println("kongshuwufabianli");
        }
    }
    public void inorderShow(){
        if (root != null){
            root.inorderShow(root);
        }else{
            System.out.println("kongshuwufabianli");
        }
    }
    public void sufferShow(){
        if (root != null){
            root.sufferShow(root);
        }else{
            System.out.println("kongshuwufabianli");
        }
    }

    public TreeDate getRoot() {
        return root;
    }

    public void setRoot(TreeDate root) {
        this.root = root;
    }
}

class TreeDate implements Serializable {
    private Integer id;
    private String name;
    private TreeDate left;
    private TreeDate right;

    //删除指定节点
    public void deleteById(Integer id){
        if(this.getLeft() != null && this.getLeft().getId() == id){
            this.setLeft(null);
            return;
        }
        if (this.getRight() != null && this.getRight().getId() == id){
            this.setRight(null);
            return;
        }
        if (this.getLeft() != null){
            this.getLeft().deleteById(id);
        }
        if (this.getRight() != null){
            this.getRight().deleteById(id);
        }

    }

    //前序查找
    public TreeDate getpre(Integer id){
        System.out.println("前序查找次数");
        if (this.getId() == id){
            return this;
        }
        TreeDate result = null;
        if(this.getLeft() != null){
            result = this.getLeft().getpre(id);
            if (result != null){
                return result;
            }
        }
        if (this.getRight() != null){
            return this.getRight().getpre(id);
        }
        return result;
    }
    //中序查找
    public TreeDate getInorder(Integer id){
        TreeDate reault = null;
        if (this.getLeft() != null) {
            reault = this.getLeft().getInorder(id);
            if (reault != null) {
                return reault;
            }
        }
        System.out.println("中序查找次数");
        if (this.getId() == id){
            return this;
        }
        if (this.getRight() != null){
            return this.getRight().getInorder(id);
        }
        return reault;
    }
    //后续查找
    public TreeDate getsuffer(Integer id){
        TreeDate reault = null;
        if (this.getLeft() != null){
            reault = this.getLeft().getsuffer(id);
            if (reault != null){
                return reault;
            }
        }
        if (this.getRight() != null){
            reault = this.getRight().getsuffer(id);
            if (reault != null){
                return reault;
            }
        }
        System.out.println("后续查找次数");
        if (this.getId() == id){
            return this;
        }
        return reault;
    }

    //前序遍历
    public void preShow(TreeDate root){
        System.out.println(root);
        if (root.getLeft() != null){
            preShow(root.getLeft());
        }
        if (root.getRight() != null){
            preShow(root.getRight());
        }
    }

    //中序遍历
    public void inorderShow(TreeDate root){
        if (root.getLeft() != null){
            inorderShow(root.getLeft());
        }
        System.out.println(root);
        if (root.getRight() != null){
            inorderShow(root.getRight());
        }
    }
    //后序遍历
    public void sufferShow(TreeDate root){
        if (root.getLeft() != null){
            sufferShow(root.getLeft());
        }
        if (root.getRight() != null){
            sufferShow(root.getRight());
        }
        System.out.println(root);
    }

    @Override
    public String toString() {
        return "TreeDate{" +
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

    public TreeDate getLeft() {
        return left;
    }

    public void setLeft(TreeDate left) {
        this.left = left;
    }

    public TreeDate getRight() {
        return right;
    }

    public void setRight(TreeDate right) {
        this.right = right;
    }

    public TreeDate(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TreeDate() {
    }
}
