
package cn.edu.bistu.cs.se.mycalculator.Calculate;
//抽象策略（Strategy）:定义了多个具体策略的公共接口，具体策略类中各种不同的算法以不同的方式实现这个接口
public interface Strategy {
	//类型转换，第1个是目标数据类型，第2个是源数据
	public double Convert(String from, String to, double input);
}
