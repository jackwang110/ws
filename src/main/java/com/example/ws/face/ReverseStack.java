package com.example.ws.face;

import java.util.Stack;
//如何仅用递归函数和栈操作逆序一个栈？
public class ReverseStack {
    public static void main(String[] args) {
        Stack stack = new Stack<Integer>();
        stack.add(3);
        stack.add(1);
        stack.add(2);

        reverse(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    /**
     * * 1、取出并删除栈低元素
     * 	 * 2、翻转剩下的元素
     * 	 * 3、再将之前的栈低元素压回栈顶
     * 	 * 其中第二步为递归调用，递归终止条件是栈为空
     * @param stack
     */
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.add(i);
    }

    /**
     * 1、首先，取出栈顶元素
     * 2、然后求剩下元素的最后一个元素
     * 3、最后将栈顶元素放回
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int res = stack.pop();
        if(stack.isEmpty()){
            return res;
        }
        int last = getAndRemoveLastElement(stack);
        stack.add(res);
        return last;
    }
}
