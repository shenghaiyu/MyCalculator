package cn.edu.bistu.cs.se.mycalculator.Calculate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import cn.edu.bistu.cs.se.mycalculator.R;
import cn.edu.bistu.cs.se.mycalculator.CalculateStack.stack;



public class Another1Activity extends AppCompatActivity {

    int tempResult = 0;
    int preKey = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.buttonReturn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                setResult(0, intent);
                finish();
            }
        });

        Button bt0 = (Button) findViewById(R.id.bt0);
        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2= (Button) findViewById(R.id.bt2);
        Button bt3 = (Button) findViewById(R.id.bt3);
        Button bt4 = (Button) findViewById(R.id.bt4);
        Button bt5 = (Button) findViewById(R.id.bt5);
        Button bt6 = (Button) findViewById(R.id.bt6);
        Button bt7 = (Button) findViewById(R.id.bt7);
        Button bt8 = (Button) findViewById(R.id.bt8);
        Button bt9 = (Button) findViewById(R.id.bt9);
        Button btpoint = (Button) findViewById(R.id.btpoint);
        Button btadd = (Button) findViewById(R.id.btadd);
        Button btsub = (Button) findViewById(R.id.btsub);
        Button btmul = (Button) findViewById(R.id.btmul);
        Button btdiv = (Button) findViewById(R.id.btdiv);
        Button btac = (Button) findViewById(R.id.btac);
        Button bteqnal = (Button) findViewById(R.id.btequal);
        Button btsin = (Button) findViewById(R.id.btsin);
        Button btcos = (Button) findViewById(R.id.btcos);
        Button bttan = (Button) findViewById(R.id.bttan);
        Button btsqr = (Button) findViewById(R.id.btsqr);
        Button btl = (Button) findViewById(R.id.btl);
        Button btr = (Button) findViewById(R.id.btr);
        Button btdel = (Button) findViewById(R.id.btdel);

        ScienceButtonListener ButtonListener = new ScienceButtonListener();
        bt0.setOnClickListener(ButtonListener);
        bt1.setOnClickListener(ButtonListener);
        bt2.setOnClickListener(ButtonListener);
        bt3.setOnClickListener(ButtonListener);
        bt4.setOnClickListener(ButtonListener);
        bt5.setOnClickListener(ButtonListener);
        bt6.setOnClickListener(ButtonListener);
        bt7.setOnClickListener(ButtonListener);
        bt8.setOnClickListener(ButtonListener);
        bt9.setOnClickListener(ButtonListener);
        btpoint.setOnClickListener(ButtonListener);
        btadd.setOnClickListener(ButtonListener);
        btsub.setOnClickListener(ButtonListener);
        btmul.setOnClickListener(ButtonListener);
        btdiv.setOnClickListener(ButtonListener);
        btac.setOnClickListener(ButtonListener);
        bteqnal.setOnClickListener(ButtonListener);
        btsin.setOnClickListener(ButtonListener);
        btcos.setOnClickListener(ButtonListener);
        bttan.setOnClickListener(ButtonListener);
        btsqr.setOnClickListener(ButtonListener);
        btl.setOnClickListener(ButtonListener);
        btr.setOnClickListener(ButtonListener);
        btdel.setOnClickListener(ButtonListener);


    }

    public class ScienceButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            TextView tvS = (TextView) findViewById(R.id.Result);
            TextView tvR = (TextView) findViewById(R.id.Result1);

            switch (view.getId()) {
                case R.id.bt0:
                    preKey = R.id.bt0;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("0");

                    } else if (tvS.getText().charAt(tvS.length() - 1) == '0' && (tvS.getText().charAt(tvS.length() - 2) == '+' || tvS.getText().charAt(tvS.length() - 2) == '-' ||
                            tvS.getText().charAt(tvS.length() - 2) == '*' || tvS.getText().charAt(tvS.length() - 2) == '/' ||
                            tvS.getText().charAt(tvS.length() - 2) == '(')) {
                        break;
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText());
                            break;
                        }
                        tvS.setText(tvS.getText());
                    }
                    break;
                case R.id.bt1:
                    preKey = R.id.bt1;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("1");
                    } else {
                        //当最后一个字符为）时，在当输入数字时，自动相乘
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "1");
                    }
                    break;
                case R.id.bt2:
                    preKey = R.id.bt2;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("2");
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "2");
                    }
                    break;
                case R.id.bt3:
                    preKey = R.id.bt3;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("3");
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "3");
                    }
                    break;
                case R.id.bt4:
                    preKey = R.id.bt4;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("4");
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "4");
                    }
                    break;
                case R.id.bt5:
                    preKey = R.id.bt5;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("5");
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "5");
                    }
                    break;
                case R.id.bt6:
                    preKey = R.id.bt6;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("6");
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "6");
                    }
                    break;
                case R.id.bt7:
                    preKey = R.id.bt7;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("7");
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "7");
                    }
                    break;
                case R.id.bt8:
                    preKey = R.id.bt8;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("8");
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "8");
                    }
                    break;
                case R.id.bt9:
                    preKey = R.id.bt9;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("9");
                    } else {
                        if (tvS.getText().charAt(tvS.length() - 1) == ')') {
                            tvS.setText(tvS.getText() + "*");
                        }
                        tvS.setText(tvS.getText() + "9");
                    }
                    break;
                case R.id.btpoint:
                    preKey = R.id.btpoint;
                    int length = tvS.getText().length();
                    int jugge = 0;
                    int k = length - 1;
                    for (; k >= 0; k--) {
                        if (tvS.getText().charAt(k) == '.') {
                            break;
                        }
                        if (tvS.getText().charAt(k) == '+' || tvS.getText().charAt(k) == '-' ||
                                tvS.getText().charAt(k) == '*' || tvS.getText().charAt(k) == '/' || k == 0) {
                            jugge = 1;
                            break;
                        }
                    }

                    if (
                               tvS.getText().charAt(tvS.getText().length() - 1) == '.'
                            || tvS.getText().charAt(tvS.getText().length() - 1) == '('
                            || tvS.getText().charAt(tvS.getText().length() - 1) == ')') {

                        break;
                    } else if (
                            tvS.getText().charAt(tvS.getText().length() - 1) == '+' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '-' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '*' ||
                                    tvS.getText().charAt(tvS.getText().length() - 1) == '/')
                    {
                        break;
                    } else if (tvS.getText().equals("0")) {
                        tvS.setText("0.");
                        break;
                    } else if (jugge == 0) {
                        break;
                    } else {
                        tvS.setText(tvS.getText() + ".");

                    }
                    break;


                case R.id.btac:
                    preKey = R.id.btac;
                    tvS.setText("0");
                    tvR.setText("0");
                    break;

                case R.id.btsin:
                    if (preKey == R.id.btequal) {
                        tvS.setText("Sin(");
                        tvR.setText("0");
                        break;
                    }
                    preKey = R.id.btsin;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("Sin(");
                    } else if (
                            tvS.getText().charAt(tvS.getText().length() - 1) == '0' || tvS.getText().charAt(tvS.getText().length() - 1) == '1' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '2' || tvS.getText().charAt(tvS.getText().length() - 1) == '3' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '4' || tvS.getText().charAt(tvS.getText().length() - 1) == '5' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '6' || tvS.getText().charAt(tvS.getText().length() - 1) == '7' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '8' || tvS.getText().charAt(tvS.getText().length() - 1) == '9' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == ')')
                    {
                        tvS.setText(tvS.getText() + "*");
                    }
                    else
                        tvS.setText(tvS.getText() + "Sin(");
                    break;


                case R.id.btcos:
                    if (preKey == R.id.btequal) {
                        tvS.setText("Cos(");
                        tvR.setText("0");
                        break;
                    }
                    preKey = R.id.btcos;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("Cos(");
                        break;
                    } else if (
                            tvS.getText().charAt(tvS.getText().length() - 1) == '0' || tvS.getText().charAt(tvS.getText().length() - 1) == '1' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '2' || tvS.getText().charAt(tvS.getText().length() - 1) == '3' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '4' || tvS.getText().charAt(tvS.getText().length() - 1) == '5' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '6' || tvS.getText().charAt(tvS.getText().length() - 1) == '7' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '8' || tvS.getText().charAt(tvS.getText().length() - 1) == '9' ||
                                    tvS.getText().charAt(tvS.getText().length() - 1) == ')')
                    {
                        tvS.setText(tvS.getText() + "*");
                    } else
                        tvS.setText(tvS.getText() + "Cos(");


                case R.id.bttan:
                    if (preKey == R.id.btequal) {
                        tvS.setText("Tan(");
                        tvR.setText("0");
                        break;
                    }
                    preKey = R.id.bttan;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("Tan(");
                    } else if (
                            tvS.getText().charAt(tvS.getText().length() - 1) == '0' || tvS.getText().charAt(tvS.getText().length() - 1) == '1' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '2' || tvS.getText().charAt(tvS.getText().length() - 1) == '3' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '4' || tvS.getText().charAt(tvS.getText().length() - 1) == '5' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '6' || tvS.getText().charAt(tvS.getText().length() - 1) == '7' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '8' || tvS.getText().charAt(tvS.getText().length() - 1) == '9' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == ')') {
                        tvS.setText(tvS.getText() + "*");
                    } else
                        tvS.setText(tvS.getText() + "Tan(");
                    break;

                case R.id.btl:
                    if (preKey == R.id.btequal) {
                        tvS.setText("(");
                        tvR.setText("0");
                        break;
                    }
                    preKey = R.id.btl;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("(");
                    } else if (tvS.getText().charAt(tvS.getText().length() - 1) == '.') {

                    } else if (tvS.getText().charAt(tvS.getText().length() - 1) == '0' || tvS.getText().charAt(tvS.getText().length() - 1) == '1' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '2' || tvS.getText().charAt(tvS.getText().length() - 1) == '3' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '4' || tvS.getText().charAt(tvS.getText().length() - 1) == '5' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '6' || tvS.getText().charAt(tvS.getText().length() - 1) == '7' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '8' || tvS.getText().charAt(tvS.getText().length() - 1) == '9' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == ')') {
                        tvS.setText(tvS.getText() + "*");
                    } else
                        tvS.setText(tvS.getText() + "(");
                    break;



                case R.id.btr:
                    if (preKey == R.id.btequal) {
                        tvS.setText("0");
                        tvR.setText("0");
                        break;
                    }
                    preKey = R.id.btr;
                    int countLeft = 0;
                    int countRight = 0;
                    for (int i = 0; i < tvS.length(); i++) {
                        if (tvS.getText().charAt(i) == '(') {
                            countLeft++;
                        }
                        if (tvS.getText().charAt(i) == ')') {
                            countRight++;
                        }
                    }

                    if (
                            tvS.getText().charAt(tvS.getText().length() - 1) == '('
                                    || tvS.getText().charAt(tvS.getText().length() - 1) == '.'
                                    || tvS.getText().charAt(tvS.getText().length() - 1) == '+'
                                    || tvS.getText().charAt(tvS.getText().length() - 1) == '-'
                                    || tvS.getText().charAt(tvS.getText().length() - 1) == '*'
                                    || tvS.getText().charAt(tvS.getText().length() - 1) == '/') {
                        break;

                    } else {
                        if (countLeft > countRight) {
                            tvS.setText(tvS.getText() + ")");
                            break;
                        } else {
                            break;
                        }

                    }


                case R.id.btsqr:
                    if (preKey == R.id.btequal) {
                        tvS.setText("√(");
                        tvR.setText("0");
                        break;
                    }
                    preKey = R.id.btsqr;
                    if (tvS.getText().equals("0")) {
                        tvS.setText("√(");
                    } else if (tvS.getText().charAt(tvS.getText().length() - 1) == '0' || tvS.getText().charAt(tvS.getText().length() - 1) == '1' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '2' || tvS.getText().charAt(tvS.getText().length() - 1) == '3' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '4' || tvS.getText().charAt(tvS.getText().length() - 1) == '5' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '6' || tvS.getText().charAt(tvS.getText().length() - 1) == '7' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '8' || tvS.getText().charAt(tvS.getText().length() - 1) == '9'
                            || tvS.getText().charAt(tvS.getText().length() - 1) == ')') {
                        tvS.setText(tvS.getText() + "*");
                    } else
                        tvS.setText(tvS.getText() + "√(");
                    break;


                case R.id.btadd:
                    preKey = R.id.btadd;
                    if (tvS.getText().charAt(tvS.getText().length() - 1) == '+' || tvS.getText().charAt(tvS.getText().length() - 1) == '-' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '(' || tvS.getText().charAt(tvS.getText().length() - 1) == '*' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '/'
                            || tvS.getText().charAt(tvS.getText().length() - 1) == '.') {

                    } else {
                        tvS.setText(tvS.getText() + "+");
                    }
                    break;



                case R.id.btsub:
                    if (preKey == R.id.btequal) {
                        tvS.setText("0");
                        tvR.setText("0");
                        break;
                    }
                    preKey = R.id.btsub;
                    if (tvS.getText().charAt(tvS.getText().length() - 1) == '+' || tvS.getText().charAt(tvS.getText().length() - 1) == '-' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '(' || tvS.getText().charAt(tvS.getText().length() - 1) == '.'
                            || tvS.getText().charAt(tvS.getText().length() - 1) == '*' || tvS.getText().charAt(tvS.getText().length() - 1) == '/') {

                    } else {
                        tvS.setText(tvS.getText() + "-");
                    }
                    break;



                case R.id.btmul:
                    preKey = R.id.btmul;
                    if (tvS.getText().charAt(tvS.getText().length() - 1) == '+' || tvS.getText().charAt(tvS.getText().length() - 1) == '-' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '(' || tvS.getText().charAt(tvS.getText().length() - 1) == '.'
                            || tvS.getText().charAt(tvS.getText().length() - 1) == '*' || tvS.getText().charAt(tvS.getText().length() - 1) == '/') {

                    } else {
                        tvS.setText(tvS.getText() + "*");
                    }
                    break;


                case R.id.btdiv:
                    if (preKey == R.id.btequal) {
                        tvS.setText("0");
                        tvR.setText("0");
                        break;

                    }
                    preKey = R.id.btdiv;
                    if (tvS.getText().charAt(tvS.getText().length() - 1) == '+' || tvS.getText().charAt(tvS.getText().length() - 1) == '-' ||
                            tvS.getText().charAt(tvS.getText().length() - 1) == '(' || tvS.getText().charAt(tvS.getText().length() - 1) == '.'
                            || tvS.getText().charAt(tvS.getText().length() - 1) == '*' || tvS.getText().charAt(tvS.getText().length() - 1) == '/') {

                    } else {
                        tvS.setText(tvS.getText() + "/");
                    }
                    break;



                case R.id.btequal:
                    preKey = R.id.btequal;
                    if (!tvS.getText().toString().contains("+") && !tvS.getText().toString().contains("-") && !tvS.getText().toString().contains("*")
                            && tvS.getText().toString().contains("/") && tvS.getText().toString().contains("Sin") && tvS.getText().toString().contains("Cos")
                            && tvS.getText().toString().contains("Tan") && tvS.getText().toString().contains("√")) {

                        tvR.setText(tvS.getText());
                        break;
                    }
                    if(tvS.getText().charAt(tvS.getText().length() -1) == '+'||tvS.getText().charAt(tvS.getText().length() -1) == '-'
                            ||tvS.getText().charAt(tvS.getText().length() -1) == '*'||tvS.getText().charAt(tvS.getText().length() -1) == '/'){
                        tvR.setText("输入错误");
                        break;
                    }

                    int o  = 0;
                    String tempInt = "";
                    stack cal = new stack(tvS.getText().toString());
                    if(cal.result.equals("括号不匹配")){
                        tvR.setText("括号不匹配");
                        break;
                    }
                    else {
                        for(int i = 0 ; i < cal.result.length() ; i++){
                            if(cal.result.charAt(i) != '.'){
                                tempInt += cal.result.charAt(i);
                            }
                            else {
                                i++;
                                String tempp = "";
                                tempp += cal.result.charAt(i);
                                if(Integer.parseInt(tempp) > 4){
                                    o = 1;
                                }
                                break;
                            }
                        }

                        if(cal.result.equals("符号不匹配")){
                        }else {
                            if(o == 1 ){
                                tempResult = Integer.parseInt(tempInt) + 1;
                            }
                            else {
                                tempResult = Integer.parseInt(tempInt);
                            }
                        }
                        tvR.setText(cal.result);
                        break;
                    }



                    //回退键
                case R.id.btdel:
                    preKey = R.id.btdel;
                    String temp = "";
                    String temp2 = "";
                    if (tvS.length() == 1) {
                        tvS.setText("0");
                    } else {
                        for (int i = 0; i < tvS.length() - 1; i++) {
                            temp += tvS.getText().charAt(i);
                        }

                        if (temp.charAt(temp.length() - 1) == 'n' || temp.charAt(temp.length() - 1) == 's') {
                            for (int j = 0; j < temp.length() - 3; j++) {
                                temp2 += temp.charAt(j);
                            }
                            if (temp2.equals("")) {
                                tvS.setText("0");
                                break;
                            } else
                                tvS.setText(temp2);
                            break;

                        } else
                            tvS.setText(temp);
                        break;

                    }
                    break;
            }

        }
    }
}