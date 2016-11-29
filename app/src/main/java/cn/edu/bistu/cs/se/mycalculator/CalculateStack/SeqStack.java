package cn.edu.bistu.cs.se.mycalculator.CalculateStack;

/**
 * Created by lenovo on 2016/10/2.
 */
public class SeqStack<T> implements SStack<T>{   //顺序栈类，实现栈接口

    public Object[] element; //存取栈数据元素的数组
    private int top;    //栈顶元素下标

    public SeqStack(int size){    //构造容量为size的空栈
        this.element = new Object[Math.abs(size)];
        this.top = -1;
    }

    public SeqStack(){
        this(64);
    }   //构造默认容量的空栈


    @Override
    public boolean isEmpty() {  //判断栈是否为空，若空返回true
        // TODO Auto-generated method stub
        return this.top == -1;
    }

    @Override
    public void push(T x) {  //元素x入栈，空对象不能入栈
        // TODO Auto-generated method stub
        if(x == null){ //空对象不能入栈
            return ;
        }

        if(this.top == element.length-1){ //若栈满，则扩充栈容量
            Object[] temp = this.element;
            this.element = new Object[temp.length * 2];  //重新申请一个更大的数组
            for(int i = 0;i < temp.length;i++){//复制数组元素
                this.element[i] = temp[i];
            }
        }

        this.top++;
        this.element[this.top] = x;

    }


    @Override
    //出栈，返回栈顶元素，若栈空返回null
    public T pop() {
        // TODO Auto-generated method stub
        return this.top == -1?null:(T)this.element[this.top--];
    }

    @Override
    //取栈顶元素，未出栈，若栈空返回null
    public T get() {
        // TODO Auto-generated method stub
        return this.top == -1?null:(T)this.element[this.top];
    }

}
