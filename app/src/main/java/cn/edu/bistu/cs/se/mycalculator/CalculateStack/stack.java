package cn.edu.bistu.cs.se.mycalculator.CalculateStack;

/**
 * Created by lenovo on 2016/10/2.
 */

import android.util.Log;

import java.math.BigDecimal;

public class stack {

    private SeqStack<Double> num = new SeqStack<Double>();                           //数字栈
    private SeqStack<Character> operator = new SeqStack<Character>();                       //操作符栈
    private int leftBrackets = 0;            //计算左右括号个数，看是否匹配用
    private int rightBrackets = 0;
    private int error = 0;
    public String result = "";

    public stack(String formula) {//公式

        for (int q = 0; q < formula.length(); q++) {
            if (formula.charAt(q) == '(') {
                leftBrackets++;
            }
            if (formula.charAt(q) == ')') {
                rightBrackets++;
            }
        }

        if (leftBrackets != rightBrackets) {
            result = "括号不匹配";
        } else {
            //切词（Sin等）
            while (formula.contains("Sin") || formula.contains("Cos") || formula.contains("Tan") || formula.contains("√")) {

                String tempLeft = "";
                String tempRight = "";
                Double symbolvalue = 0.0;
                int symbolCount = 0;

                if (formula.contains("Sin")) {
                    String temp = formula.split("Sin\\(")[1];
                    int temp2 = 0;
                    for (int i = 0; i < temp.length(); i++) {
                        if (temp.charAt(i) == ')') {
                            temp2 = i;
                            break;
                        }
                    }
                    //截取一段字符串，从0开始，temp2结束
                    temp = temp.substring(0, temp2);

                    stack tempCal = new stack(temp);
                    temp = tempCal.result;
                     //计算Sin函数
                    symbolvalue = Math.sin(Double.parseDouble(tempCal.result));
               //取sin前的一段
                    tempLeft = formula.split("Sin\\(")[0];
                    for (symbolCount = 0; symbolCount < formula.length(); symbolCount++) {
                        if (formula.charAt(symbolCount) == 'S') {
                            symbolCount = symbolCount + 1;
                            for (; symbolCount < formula.length(); symbolCount++) {
                                if (formula.charAt(symbolCount) == '(') {
                                    symbolCount++;
                                    break;
                                }
                            }
                            break;

                        }
                    }
                    tempRight = formula.substring(symbolCount);
                    for (symbolCount = 0; symbolCount < tempRight.length(); symbolCount++) {
                        if (tempRight.charAt(symbolCount) == ')') {
                            break;
                        }
                    }
                    if (symbolCount == tempRight.length()) {
                        tempRight = "";
                    } else {
                        tempRight = tempRight.substring(symbolCount + 1);

                    }
                   if (symbolvalue.toString().charAt(0) == '-') {
                        String tempValue = "";
                        for (int k = 1; k < symbolvalue.toString().length(); k++) {
                            tempValue += symbolvalue.toString().charAt(k);
                        }
                        symbolvalue = Double.parseDouble(tempValue);
                        formula = tempLeft + "0-" + symbolvalue + tempRight;

                    } else {
                        formula = tempLeft + symbolvalue + tempRight;
                    }
                    Log.v("MyTagSin", formula);
                    continue;
                }



                else if (formula.contains("Cos")) {
                    String temp = formula.split("Cos\\(")[1];
                    int temp2 = 0;
                    for (int i = 0; i < temp.length(); i++) {
                        if (temp.charAt(i) == ')') {
                            temp2 = i;
                            break;
                        }
                    }
                    temp = temp.substring(0, temp2);
                    stack tempCal = new stack(temp);
                    temp = tempCal.result;
                    symbolvalue = Math.cos(Double.parseDouble(tempCal.result));

                    tempLeft = formula.split("Cos\\(")[0];

                    for (symbolCount = 0; symbolCount < formula.length(); symbolCount++) {
                        if (formula.charAt(symbolCount) == 'C') {
                            symbolCount = symbolCount + 1;
                            for (; symbolCount < formula.length(); symbolCount++) {
                                if (formula.charAt(symbolCount) == '(') {
                                    symbolCount++;
                                    break;
                                }
                            }
                            break;

                        }
                    }
                    tempRight = formula.substring(symbolCount);

                    for (symbolCount = 0; symbolCount < tempRight.length(); symbolCount++) {
                        if (tempRight.charAt(symbolCount) == ')') {
                            break;
                        }
                    }
                    if (symbolCount == tempRight.length()) {
                        tempRight = "";
                    } else {
                        tempRight = tempRight.substring(symbolCount + 1);

                    }
                    if (symbolvalue.toString().charAt(0) == '-') {
                        String tempValue = "";
                        for (int k = 1; k < symbolvalue.toString().length(); k++) {
                            tempValue += symbolvalue.toString().charAt(k);
                        }
                        symbolvalue = Double.parseDouble(tempValue);
                        formula = tempLeft + "0-" + symbolvalue + tempRight;

                    } else {
                        formula = tempLeft + symbolvalue + tempRight;

                    }
                    Log.v("MyTagCos", formula);
                    continue;
                } else if (formula.contains("Tan")) {
                    String temp = formula.split("Tan\\(")[1];
                    int temp2 = 0;
                    for (int i = 0; i < temp.length(); i++) {
                        if (temp.charAt(i) == ')') {
                            temp2 = i;
                            break;
                        }
                    }
                    temp = temp.substring(0, temp2);
                    stack tempCal = new stack(temp);
                    temp = tempCal.result;
                    symbolvalue = Math.tan(Double.parseDouble(tempCal.result));

                    tempLeft = formula.split("Tan\\(")[0];
                    for (symbolCount = 0; symbolCount < formula.length(); symbolCount++) {
                        if (formula.charAt(symbolCount) == 'T') {
                            symbolCount = symbolCount + 1;
                            for (; symbolCount < formula.length(); symbolCount++) {
                                if (formula.charAt(symbolCount) == '(') {
                                    symbolCount++;
                                    break;
                                }
                            }
                            break;

                        }
                    }
                    tempRight = formula.substring(symbolCount);

                    for (symbolCount = 0; symbolCount < tempRight.length(); symbolCount++) {
                        if (tempRight.charAt(symbolCount) == ')') {
                            break;
                        }
                    }
                    if (symbolCount == tempRight.length()) {
                        tempRight = "";
                    } else {
                        tempRight = tempRight.substring(symbolCount + 1);

                    }
                    if (symbolvalue.toString().charAt(0) == '-') {
                        String tempValue = "";
                        for (int k = 1; k < symbolvalue.toString().length(); k++) {
                            tempValue += symbolvalue.toString().charAt(k);
                        }
                        symbolvalue = Double.parseDouble(tempValue);
                        formula = tempLeft + "0-" + symbolvalue + tempRight;

                    } else {
                        formula = tempLeft + symbolvalue + tempRight;

                    }
                    Log.v("MyTagTan", formula);
                    continue;
                }


                if (formula.contains("√")) {
                    String temp = formula.split("√\\(")[1];
                    int temp2 = 0;
                    for (int i = 0; i < temp.length(); i++) {
                        if (temp.charAt(i) == ')') {
                            temp2 = i;
                            break;
                        }
                    }
                    temp = temp.substring(0, temp2);
                    stack tempCal = new stack(temp);

                    symbolvalue = Math.sqrt(Double.parseDouble(tempCal.result));
                    tempLeft = formula.split("√\\(")[0];

                    for (symbolCount = 0; symbolCount < formula.length(); symbolCount++) {
                        if (formula.charAt(symbolCount) == '√') {
                            symbolCount = symbolCount + 1;
                            for (; symbolCount < formula.length(); symbolCount++) {
                                if (formula.charAt(symbolCount) == '(') {
                                    symbolCount++;
                                    break;
                                }
                            }
                            break;

                        }
                    }
                    tempRight = formula.substring(symbolCount);

                    for (symbolCount = 0; symbolCount < tempRight.length(); symbolCount++) {
                        if (tempRight.charAt(symbolCount) == ')') {
                            break;
                        }
                    }
                    if (symbolCount == tempRight.length()) {
                        tempRight = "";
                    } else {
                        tempRight = tempRight.substring(symbolCount + 1);

                    }
                   if (symbolvalue.toString().charAt(0) == '-') {
                        String tempValue = "";
                        for (int k = 1; k < symbolvalue.toString().length(); k++) {
                            tempValue += symbolvalue.toString().charAt(k);
                        }
                        symbolvalue = Double.parseDouble(tempValue);
                        formula = tempLeft + "0-" + symbolvalue + tempRight;

                    } else {
                        formula = tempLeft + symbolvalue + tempRight;

                    }
                    Log.v("MyTagRoot", formula);
                    continue;
                }
            }


            //去掉错误字符后的算式
            formula += "#";
            Log.v("MyTagResult", formula);
            if (leftBrackets != rightBrackets || error != 0) {
                System.out.println("输入有误");
            } else {
                double numTemp = 0;
                int j = 0;
                while (j < formula.length()) {
                    //数字入栈
                    //0~9=48~57，。=46
                    while (formula.charAt(j) >= 48 && formula.charAt(j) <= 57 || formula.charAt(j) == 46) {
                        if (formula.charAt(j) >= 48 && formula.charAt(j) <= 57) {
                            numTemp *= 10;
                            numTemp += Double.parseDouble(formula.charAt(j) + "");
                        }

                        //读取带小数的数字
                        else if (formula.charAt(j) == 46) {
                            j++;

                            for (int i = -1; formula.charAt(j) >= 48 && formula.charAt(j) <= 57; i--) {
                                //返回指定数字的指定次幂。
                                numTemp += Double.parseDouble(formula.charAt(j) + "") * Math.pow(10, i);

                                if ((formula.charAt(j + 1) < 48 || formula.charAt(j + 1) > 57)) {
                                    break;
                                } else
                                    j++;
                            }
                        }

                        if (j <= formula.length() - 1)
                            j++;
                        else {
                            num.push(new Double(numTemp));
                            break;
                        }
                        if ((formula.charAt(j) < 48 || formula.charAt(j) > 57) && formula.charAt(j) != 46) {
                            num.push(new Double(numTemp));
                            numTemp = 0;
                        }
                    }

                    //符号入栈
                    //（=40，）=41，*=42，+=43，-=45，。=46，/=47，#=35.
                    if (formula.charAt(j) >= 40 && formula.charAt(j) <= 47 || formula.charAt(j) == 35) {
                        //符号栈空是直接入栈
                        if (operator.isEmpty()) {
                            operator.push(new Character('#'));
                            operator.push(new Character(formula.charAt(j)));
                            j++;
                        } else {
                            //右边符号优先级高
                            if (Right(formula.charAt(j)) > Left(operator.get().charValue())) {
                                operator.push(new Character(formula.charAt(j)));
                                j++;
                            }
                            //左边和右边符号优先级一样
                            else if (Right(formula.charAt(j)) == Left(operator.get().charValue())) {
                                operator.pop();
                                j++;
                            }
                            //左边符号优先级高
                            else
                                switch (operator.pop().charValue()) {
                                    case '+':
                                        num.push(new Double(num.pop().doubleValue() + num.pop().doubleValue()));
                                        break;
                                    case '-':
                                        double x = num.pop().doubleValue();
                                        num.push(new Double(num.pop().doubleValue() - x));
                                        break;
                                    case '*':
                                        num.push(new Double(num.pop().doubleValue() * num.pop().doubleValue()));
                                        break;
                                    case '/':
                                        double y = num.pop().doubleValue();
                                        num.push(new Double(num.pop().doubleValue() / y));
                                        break;
                                    default:
                                        return;

                                }

                        }

                    }

                }
               //结果保留4位小数，进行四舍五入
                BigDecimal bg = new BigDecimal(num.get());
                result = bg.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue() + "";

                //	System.out.println(num.get());
            }
        }


    }

    //左边符号优先级
    public int Left(char op) {
        switch (op) {
            case '+':
                return 3;
            case '-':
                return 3;
            case '*':
                return 5;
            case '/':
                return 5;
            case '(':
                return 1;
            case ')':
                return 6;
            case '#':
                return 0;
            default:
                return op;
        }
    }

    //右边符号优先级
    public int Right(char op) {
        switch (op) {
            case '+':
                return 2;
            case '-':
                return 2;
            case '*':
                return 4;
            case '/':
                return 4;
            case '(':
                return 6;
            case ')':
                return 1;
            case '#':
                return 0;
            default:
                return op;
        }
    }


}
