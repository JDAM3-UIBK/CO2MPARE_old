package com.co2mpare.weather;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Example main activity for the use of open
 * weather access. Can be deleted after implementing.
 * 
 * @author Manuel Kapferer
 *
 */
public class ExampleMainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WeatherHttpClient client = new WeatherHttpClient();
		TextView textView = (TextView) findViewById(R.id.textViewName);
		String weatherText = "Wettervorschau:";
		ArrayList<Weather> weatherArr = null;
		Weather weatherDay = null;
		
		if(ConnectionDetection.isNetworkAvailable(this)){
//			weatherArr = WeatherFacade.getInstance().getForecastWeather("Innsbruck");
			weatherDay = WeatherFacade.getInstance().getTodayWeather("Innsbruck");
		}
		
//		if(weatherArr != null){
//			for(int i = 0; i < weatherArr.size(); i++){
//				weatherText = weatherText + "\n" + (i+1) + " Tag: " + weatherArr.get(i).getAllDataString();
//			}
//		}
		
		weatherText = weatherText + "\n Today: " + weatherDay.getAllDataString();
		
		textView.setText(weatherText);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
