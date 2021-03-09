package mystack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author maverick
 * @create 2020-12-07 20:21
 */
public class MySuffixCounter {
    public static void main(String[] args) {
//        System.out.println(myCounter("4 5 * 8 - 60 + 8 2 / +"));
        List<String> infix = StringToiInfix.infix("1+((2+3)*4)-5");
        List<String> suffix = StringToiInfix.infixToSuffix(infix);
        System.out.println(myCounter(suffix));
    }



    /**
     * 栈模拟后缀表达式计算器

     * @return 计算结果
     */
    public static int myCounter( List<String> list){

        //首先是准备工作，实现声明一个栈、ArrayList集合用于封装拆解的后缀表达式，便于计算
        Stack<String> stack = new Stack<String>();
//        List<String> list = new ArrayList<>();

//        //第一步拆解后缀表达式，这里为了简单起见默默传入的后缀表达式中的字符之间用空格隔开
//        String[] split = suffixExpession.split(" ");

//        //第二步遍历拆解后的字符串数组，并将每一个元素封装进list集合中，便于后面算法使用
//        for(String str : split){
//            list.add(str);
//        }

        //第三步利用正则表达式遍历将拆解后的字符串的元素如果是数字一一压入实现准备好的栈中，如果是运算符栈中pop出两个进行运算，将其结果pudh入栈中。最后栈中的数字就是结果
//        list.forEach((l) -> {
//
//        });
        Integer count = null;
        for (String l : list){
            if (l.matches("\\d+")){//代表是一个数字
                stack.push(l);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                if(l.equals("+")) stack.push((num1 + num2) + "");
                else if(l.equals("-")) stack.push((num1 - num2) + "");
                else if(l.equals("*")) stack.push((num1 * num2) + "");
                else if(l.equals("/")) stack.push((num1 / num2) + "");
                else throw new RuntimeException("运算符有误");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
/**
 * 将字符串表达式转换为中缀表达式，存入list<String>集合中，最后再利用栈将得到的
 * 中缀表达式集合遍历转换为后缀表达式集合List<String>
 */
class StringToiInfix{

    /**
     * 将字符串表达式转换为中缀表达式，存入list<String>集合中
     * @param expreesion
     * @return
     */
    public static List<String> infix(String expreesion){
        //创建Stringlist集合用于存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        //声明一个int类型的遍历指针，用于循环扫描string表达式
        int i = 0;
        //声明一个String类型的变量用于多位数的string字符拼接
        String str = "";
        //开始循环扫描String表达式字符串
        do{
            //扫描每一个字符之后首先判断其是否是数字，如果是数字再判断其是否是多位数。其不是数字，这里默认是该方法所支持的运算符
            if(expreesion.charAt(i) < 48 || expreesion.charAt(i) > 57){//ture代表是运算符反之代表是数字
                //如果是运算符则直接放进list集合中
                list.add(expreesion.charAt(i)+"");
                i ++;
            }else{
                //如果数只则判断其是否是多位数
                while (i < expreesion.length() && expreesion.charAt(i) >= 48 && expreesion.charAt(i) <= 57){
                    str += expreesion.charAt(i);
                    i++;
                }
                list.add(str);
                str = "";
            }

        }while(i < expreesion.length());
        return list;
    }

    /**
     * 利用栈将得到的中缀表达式集合遍历转换为后缀表达式集合List<String>
     * @param list :已经的得到的中缀表达式
     * @return
     */
    public static List<String> infixToSuffix(List<String> list){
        //事先做准备工作，声明一个栈存放临时的运算符逻辑，声明一个list集合存放得到的后缀表达式，详细描写参看韩顺平老师的数据结构和算法笔记
        List<String> newList = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        //遍历中缀表达式集合
       for(String str : list){
           //每遍历出一个元素先判断其实是否数字，如果是数字则直接放入新的list中，如果不是数字在进行相应的算法逻辑
           if(str.matches("\\d+")){//满足该正则表达式则这证明是数字，反之这是运算符
               newList.add(str);
           }else{
               //不是数字，先判断其是否是左括号（，如果是直接压住栈中
               if(str.equals("(")){
                   stack.push(str);
               }else if(str.equals(")")){//如果是右括号将栈中的运算符一次弹出放入list中直到遇到了”（“。并且将左括号弹出栈
                   while(true){
                       if (stack.peek().equals("(")){
                           stack.pop();
                           break;
                       }
                       newList.add(stack.pop());
                   }
               }else{//如果是运算符则判单当前运算符与栈顶运算符的优先级，如果当前运算符优先级高于栈顶，则直接入栈，如果低于栈顶优先级则
                     //将栈顶运算符弹出栈并放入新集合中，然后再重复上一步
                    while (stack.size() != 0 && !stack.peek().equals("(") &&  getPriority(str) <= getPriority(stack.peek())){
                        newList.add(stack.pop());
                    }
                    stack.push(str);
               }
           }
       }
       //循环结束之后，将战中的运算符一次弹出并放入list中
        while (stack.size()!= 0){
            newList.add(stack.pop());
        }
        return newList;
    }

    /**
     * 返回指定运算符的优先级
     * @param str 指定的运算符
     * @return
     */
    public static int getPriority(String str){
        switch (str){
            case "+":
                return 0;
            case "-":
                return 0;
            case "*":
                return 1;
            case "/":
                return 1;
            default:
                throw new RuntimeException("指定的运算符暂不支持");

        }

    }


}
















































