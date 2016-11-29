

package cn.edu.bistu.cs.se.mycalculator.Calculate;

import cn.edu.bistu.cs.se.mycalculator.R;

public class Power implements Strategy {

	public double Convert(String from, String to, double input) {
		// TODO Auto-generated method stub
		
		if((from.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunitwatts)) && to.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunithorseposer)))){
			double ret = 0.00134*input;
			return ret;
		}
		
		if((from.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunithorseposer)) && to.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunitwatts)))){
			double ret = 745.7*input;
			return ret;
		}
		
		if((from.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunitwatts)) && to.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunitkilowatts)))){
			double ret = input/1000;
			return ret;
		}
		
		if((from.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunitkilowatts)) && to.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunitwatts)))){
			double ret = input*1000;
			return ret;
		}
		
		if((from.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunitkilowatts)) && to.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunithorseposer)))){
			double ret = input*1.34102;
			return ret;
		}
		
		if((from.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunithorseposer)) && to.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.powerunitkilowatts)))){
			double ret = input*0.7457;
			return ret;
		}
		if(from.equals(to)){
			return input;	
		}
		return 0.0;
	}

}
