
package cn.edu.bistu.cs.se.mycalculator.Calculate;

import cn.edu.bistu.cs.se.mycalculator.R;

public class Temperature implements Strategy {

	public double Convert(String from, String to, double input) {
		// TODO Auto-generated method stub
		
		if((from.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.temperatureunitc)) && to.equals((AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.temperatureunitf))))){
			double ret = (double)((input*9/5)+32);
			return ret;
		}
	
		if((from.equals(AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.temperatureunitf)) && to.equals((AnotherActivity.getInstance().getApplicationContext().getResources().getString(R.string.temperatureunitc))))){
			double ret = (double)((input-32)*5/9);
			return ret;
		}

	if(from.equals(to)){
		return input;	
	}
	return 0.0;
	}

}
