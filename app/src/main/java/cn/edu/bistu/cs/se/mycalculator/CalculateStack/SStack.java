package cn.edu.bistu.cs.se.mycalculator.CalculateStack;

/**
 * Created by lenovo on 2016/10/2.
 */
public interface SStack<T> {    //栈接口，栈抽象数据类型

    boolean isEmpty();    //判断是否为空栈。
    void push(T x);    //元素x入栈
    T pop();      //出栈，返回当前栈顶元素
    T get();      //取栈顶元素，未出栈

}
