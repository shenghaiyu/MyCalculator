package cn.edu.bistu.cs.se.mycalculator.Calculate;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.edu.bistu.cs.se.mycalculator.R;

public class MainActivity extends AppCompatActivity {
    private EditText et_play; // 显示
    private String str_oper = "+"; // 运算符
    private StringBuffer str_display = new StringBuffer();// 显示，存储操作字符串，可扩展。
    private String result; // 结果显示
    private double num1;
    private double num2;
    private boolean flag = true; // 小数点个数开关控制；
    private boolean b_add,b_sub, b_mul, b_div; // 运算符开关控制
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //建立Button的对象
        Button bt_0 = (Button) findViewById(R.id.bt_0);
        Button bt_1 = (Button) findViewById(R.id.bt_1);
        Button bt_2 = (Button) findViewById(R.id.bt_2);
        Button bt_3 = (Button) findViewById(R.id.bt_3);
        Button bt_4 = (Button) findViewById(R.id.bt_4);
        Button bt_5 = (Button) findViewById(R.id.bt_5);
        Button bt_6 = (Button) findViewById(R.id.bt_6);
        Button bt_7 = (Button) findViewById(R.id.bt_7);
        Button bt_8 = (Button) findViewById(R.id.bt_8);
        Button bt_9 = (Button) findViewById(R.id.bt_9);
        final Button bt_add = (Button) findViewById(R.id.bt_add);
        Button bt_sub = (Button) findViewById(R.id.bt_sub);
        Button bt_multiply = (Button) findViewById(R.id.bt_multiply);
        Button bt_divide = (Button) findViewById(R.id.bt_divide);
        Button bt_back = (Button) findViewById(R.id.bt_back);     //撤回
        Button bt_equal = (Button) findViewById(R.id.bt_equal);   //等号
        Button bt_point = (Button) findViewById(R.id.bt_point);    //小数点
        Button bt_clear = (Button) findViewById(R.id.bt_clear);//清空
        et_play = (EditText) findViewById(R.id.et);
        et_play.setText("0.0");

        Button bt_sin = (Button) findViewById(R.id.bt_sin);
        Button bt_cos = (Button) findViewById(R.id.bt_cos);
        Button bt_tan = (Button) findViewById(R.id.bt_tan);
        Button bt_ln = (Button) findViewById(R.id.bt_ln);
        Button bt_bin = (Button) findViewById(R.id.bt_bin);
        Button bt_ocl = (Button) findViewById(R.id.bt_ocl);
        Button bt_hex = (Button) findViewById(R.id.bt_hex);


        bt_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取et_play这个文本输入框的文字,赋值给loginName变量
                String myStringSin=et_play.getText().toString();
                //把字符串变成数字赋值给num1
                num1=Double.valueOf(myStringSin);
                //输出
                et_play.setText("sin"+myStringSin+"="+Math.sin(num1));
                return;
            }
        });
        bt_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myStringCos=et_play.getText().toString();
                //把字符串变成数字赋值给num1
                num1=Double.valueOf(myStringCos);
                et_play.setText("cos"+myStringCos+"="+Math.cos(num1));
                return;
            }
        });
        bt_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myStringTan=et_play.getText().toString();
                num1=Double.valueOf(myStringTan);
                et_play.setText("tan"+myStringTan+"="+Math.tan(num1));
                return;
            }
        });

        bt_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myStringLn=et_play.getText().toString();
                if(myStringLn.equals(""))
                {
                    return;
                }

                num1=Double.valueOf(myStringLn);
                et_play.setText("ln"+myStringLn+"="+Math.log(num1));
                return;
            }
        });

        bt_bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取et_play这个文本输入框的文字,赋值给myStringBin变量
                String myStringBin=et_play.getText().toString();
                if(myStringBin.equals(""))
                {
                    return;
                }
                num1=Double.valueOf(myStringBin);
                et_play.setText(""+myStringBin+"转二进制为"+Integer.toBinaryString((int)num1));
                return;
            }
        });

        bt_ocl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myStringocl=et_play.getText().toString();
                if(myStringocl.equals(""))
                {
                    return;
                }
                num1=Double.valueOf(myStringocl);

                et_play.setText(""+myStringocl+"转八进制为"+Integer.toOctalString((int)num1));
                return;
            }
        });

        bt_hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myStringhex=et_play.getText().toString();
                if(myStringhex.equals(""))
                {
                    return;
                }
                num1=Double.valueOf(myStringhex);

                et_play.setText(""+myStringhex+"转十六进制为"+Integer.toHexString((int)num1));
                return;
            }
        });

        bt_0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //用StringBuffer的append方法添加object（对象），实质为：将object的toString返回值（即String信息）加入StringBuffer尾部
                str_display.append("0");
                et_play.setText(str_display.toString());
            }
        });

        bt_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("1");
                et_play.setText(str_display.toString());
            }
        });

        bt_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("2");
                et_play.setText(str_display.toString());
            }
        });

        bt_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("3");
                et_play.setText(str_display.toString());
            }
        });

        bt_4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("4");
                et_play.setText(str_display.toString());
            }
        });

        bt_5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("5");
                et_play.setText(str_display.toString());
            }
        });

        bt_6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("6");
                et_play.setText(str_display.toString());
            }
        });

        bt_7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("7");
                et_play.setText(str_display.toString());
            }
        });

        bt_8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("8");
                et_play.setText(str_display.toString());
            }
        });
        bt_9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("9");
                et_play.setText(str_display.toString());
            }
        });

        bt_point.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    str_display.append(".");
                    flag = false;
                }
            }
        });

        bt_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_display.length() != 0) {
                    //java.lang.StringBuffer.deleteCharAt() 在这个序列中的指定位置删除字符。此序列是由一个char缩短
                    str_display.deleteCharAt(str_display.length() - 1);
                    et_play.setText(str_display.toString());
                }
            }
        });

        bt_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //当运算符为加法时
                str_oper = "+";
                //当str_display显示的值不为"" 占用了一个空串
                if (!b_add && !(str_display.toString() == "")) {
                    //用num1的值加上str_display字符串转变为Double的值
                    num1 += Double.parseDouble(str_display.toString());
                 //清空StringBuffer
                   str_display = new StringBuffer("");
                }
                //当str_result结果的值不为空时
                if (!(result == null)) {
                    //将字符的结果赋值给NUM1
                    num1 = Double.parseDouble(result);
                    //结果不分配内存
                    result = null;
                }
                //否则，显示字符串num1
                et_play.setText(String.valueOf(num1));
                //小数点可视化
                flag = true;
            }
        });


        bt_sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_oper = "-";
                //当减法的运算符关闭时，
                if (!b_sub && !(str_display.toString() == "")) {
                    num1 = Double.parseDouble(str_display.toString());
                    et_play.setText(String.valueOf(num1));
                    str_display = new StringBuffer("");
                    b_sub = true;
                }
                else {
                    if (!(str_display.toString() == "")) {
                        num1 -= Double.parseDouble(str_display.toString());
                        str_display = new StringBuffer("");
                    }
                    if (!(result == null)) {
                        num1 = Double.parseDouble(result);
                        result = null;
                    }

                    et_play.setText(String.valueOf(num1));
                }
                flag = true;
            }
        });

        bt_multiply.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_oper = "*";
                if (!b_mul && !(str_display.toString() == "")) {
                    num1 = Double.parseDouble(str_display.toString());
                    et_play.setText(String.valueOf(num1));
                    str_display = new StringBuffer("");
                    b_mul = true;
                } else {
                    if (!(str_display.toString() == "")) {
                        num1 *= Double.parseDouble(str_display.toString());
                        str_display = new StringBuffer("");
                    }
                    if (!(result == null)) {
                        num1 = Double.parseDouble(result);
                        result = null;
                    }
                    et_play.setText(String.valueOf(num1));
                }
                flag = true;
            }
        });

        bt_divide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_oper = "/";
                if (!b_div && !(str_display.toString() == "")) {
                    num1 = Double.parseDouble(str_display.toString());
                    et_play.setText(String.valueOf(num1));
                    str_display = new StringBuffer("");
                    b_div = true;
                } else {
                    if (!(str_display.toString() == "")) {
                        if (Double.parseDouble(str_display.toString()) == 0) {
                            Toast.makeText(MainActivity.this, "除数不能为0！",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            num1 /= Double.parseDouble(str_display.toString());
                            str_display = new StringBuffer("");
                        }
                    }
                    if (!(result == null)) {
                        num1 = Double.parseDouble(result);
                        result = null;
                    }
                    et_play.setText(String.valueOf(num1));
                }
                flag = true;
            }
        });

        bt_clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_oper = "+";
                str_display = new StringBuffer("");
                result = null;
                num1 = 0;
                num2 = 0;
                flag = true;//小数点开
                b_sub = false;
                b_mul = false;
                b_div = false;
                et_play.setText("0.0");
            }
        });

        bt_equal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_oper.equals("+")) {
                    num2 = Double.parseDouble(str_display.toString());
                    result = String.valueOf((num1 + num2));
                    et_play.setText(result);
                    str_display = new StringBuffer("");
                }
                if (str_oper.equals("-")) {
                    num2 = Double.parseDouble(str_display.toString());
                    result = String.valueOf((num1 - num2));
                    et_play.setText(result);
                    str_display = new StringBuffer("");
                }
                if (str_oper.equals("*")) {
                    num2 = Double.parseDouble(str_display.toString());
                    result = String.valueOf((num1 * num2));
                    et_play.setText(result);
                   str_display = new StringBuffer("");
                }
                if (str_oper.equals("/")) {
                    num2 = Double.parseDouble(str_display.toString());
                    if (!(num2 == 0)) {
                        result = String.valueOf((num1 / num2));
                        et_play.setText(result);
                    } else {
                        Toast.makeText(MainActivity.this,
                                "除数不能为0！",
                                Toast.LENGTH_LONG).show();
                    }
                  str_display = new StringBuffer("");
                }
            }
        });

        Button bt_jump = (Button) findViewById(R.id.bt_jump);
    bt_jump.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
            startActivityForResult(intent, 0);
        }
    });
}

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //请求码和返回码都为0
        if(requestCode==0 && resultCode==0){
            String str1=data.getStringExtra("result");
        }

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.help:
                //et_play.setText("这是帮助");
                Toast.makeText(this, "这是帮助", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                System.exit(0);

        }
        return super.onOptionsItemSelected(item);
    }
}