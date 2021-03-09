package mytree.ordertree;

import java.io.Serializable;

public class OrderErCharShu {

}

class MyTree{
    private TreeDate root;


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

       //前序遍历顺序二叉树
    public void orderShow(int[] arr){

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



