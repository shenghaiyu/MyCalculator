package cn.edu.bistu.cs.se.mycalculator.Calculate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import cn.edu.bistu.cs.se.mycalculator.*;

public class AnotherActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private Spinner SpinnerUnit;
    private EditText inputValue;
    private Spinner SpinnerFrom;
    private Spinner SpinnerTo;
    private Button ButtonConvert;
    private EditText ResultView;
    ArrayAdapter<String> unitarray;
    ArrayAdapter<String> unitarrayadapter;
    private Strategy currentStrategy;
    private Strategy lastStrategy;
    private String unitfrom;
    private String unitto;
    private static AnotherActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.buttonReturn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                setResult(0, intent);
                finish();
            }
        });

          //建立对象
        SpinnerUnit = (Spinner) findViewById(R.id.SpinnerUnit);
       // 指的是鼠标获得一个条目的焦点，字面上理解是选择一个条目
        SpinnerUnit.setOnItemSelectedListener(this);
       // 在所有ArrayAdapter构造方法中第一个参数都是Context
        unitarray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
       //使用自带的xml，
        unitarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //获取适配器
        SpinnerUnit.setAdapter(unitarray);
        unitarray.add(getResources().getString(R.string.unit1));
        unitarray.add(getResources().getString(R.string.unit2));
        unitarray.add(getResources().getString(R.string.unit3));
        unitarray.add(getResources().getString(R.string.unit4));
        //对列表的编辑会自动的调用notifyDataSetChanged()方法。
        unitarray.setNotifyOnChange(true);

        SpinnerFrom = (Spinner) findViewById(R.id.SpinnerFrom);
        SpinnerFrom.setOnItemSelectedListener(this);

        SpinnerTo = (Spinner) findViewById(R.id.SpinnerTo);
        SpinnerTo.setOnItemSelectedListener(this);

        unitarrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        unitarrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //获取适配器
        SpinnerFrom.setAdapter(unitarrayadapter);
        SpinnerTo.setAdapter(unitarrayadapter);
        unitarrayadapter.setNotifyOnChange(true);


        ResultView = (EditText) findViewById(R.id.TextViewResult);
        ResultView.setClickable(false);

        ButtonConvert = (Button) findViewById(R.id.Button01);
       ButtonConvert.setOnClickListener(this);
        inputValue = (EditText) findViewById(R.id.EditTextValue);

        //initialization
        currentStrategy = new Temperature();
        lastStrategy = currentStrategy;
        instance = this;


        Button bt_jump = (Button) findViewById(R.id.bt_jump1);
        bt_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnotherActivity.this, Another1Activity.class);
                startActivityForResult(intent, 1);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //请求码和返回码都为0
        if (requestCode == 1 && resultCode == 1) {
            String str2 = data.getStringExtra("result");
        }

    }
     //对象的实例化
    public static AnotherActivity getInstance() {
        return instance;
    }
   // public void onItemSelected(AdapterView<?> parent) {}

     //当我们的adapter为空的时候就会调用到这个方法
    public void onNothingSelected(AdapterView<?> parent) {

    }
//Viiew view 是你当前选择的view     position是在Adapter中的位置，从0开始。
    public void onItemSelected(AdapterView<?> parent, View v,
                               int position, long id) {

        if (v.getParent() == SpinnerUnit) {

            switch (position) {
                case 0:
                    setStrategy(new Temperature());
                    break;

                case 1:
                    setStrategy(new Weight());
                    break;

                case 2:
                    setStrategy(new Length());
                    break;

                case 3:
                    setStrategy(new Power());
                    break;
            }
            fillFromToSpinner(position);
            //将列表移动到指定的Position处
            SpinnerFrom.setSelection(0);
            SpinnerTo.setSelection(0);

            unitfrom = (String) (SpinnerFrom.getItemAtPosition(0).toString());
            unitto = (String) (SpinnerTo.getItemAtPosition(0).toString());
            //reset the result
            ResultView.setText("");
        } else if (v.getParent() == SpinnerFrom) {
            //返回一个字符串
            unitfrom = (String) (SpinnerFrom.getSelectedItem().toString());
        } else if (v.getParent() == SpinnerTo) {

            unitto = (String) (SpinnerTo.getSelectedItem().toString());
        }
    }


    private void fillFromToSpinner(int position) {

        switch (position) {
            case 0:
                fillSpinnerWithTempUnit();
                break;

            case 1:
                fillSpinnerWithWeightUnit();
                break;

            case 2:
                fillSpinnerWithLengthUnit();
                break;

            case 3:
                fillSpinnerWithPowerUnit();
                break;
        }

    }

    private void fillSpinnerWithTempUnit() {
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.temperatureunitc));
        unitarrayadapter.add(getResources().getString(R.string.temperatureunitf));//华氏摄氏度
        unitarrayadapter.notifyDataSetChanged();
    }

    private void fillSpinnerWithWeightUnit() {
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.weightunitkg));//千克
        unitarrayadapter.add(getResources().getString(R.string.weightunitgm));//公克
        unitarrayadapter.add(getResources().getString(R.string.weightunitlb));//磅
        unitarrayadapter.add(getResources().getString(R.string.weightunitounce));//盎司
        unitarrayadapter.add(getResources().getString(R.string.weightunitmg));//毫克
        unitarrayadapter.notifyDataSetChanged();
    }

    private void fillSpinnerWithLengthUnit() {
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.lengthunitmile));//英里
        unitarrayadapter.add(getResources().getString(R.string.lengthunitkm));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitm));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitcm));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitmm));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitinch));//英寸
        unitarrayadapter.add(getResources().getString(R.string.lengthunitfeet));//英尺
    }

    private void fillSpinnerWithPowerUnit() {
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.powerunitwatts));//瓦特
        unitarrayadapter.add(getResources().getString(R.string.powerunithorseposer));//马力
        unitarrayadapter.add(getResources().getString(R.string.powerunitkilowatts));//千瓦特
    }
    //点击单位换算
    public void onClick(View v) {
        if (v == ButtonConvert) {
            if (!inputValue.getText().toString().equals("")) {
                double in = Double.parseDouble(inputValue.getText().toString());
                double result = currentStrategy.Convert(unitfrom, unitto, in);
                ResultView.setText(Double.toString(result));
            } else {
                ResultView.setText("");
            }
        }
    }

    private void setStrategy(Strategy s) {

        lastStrategy = currentStrategy;
        currentStrategy = s;
        //make the last strategy eligible for garbage collection
        lastStrategy = null;
    }
}
