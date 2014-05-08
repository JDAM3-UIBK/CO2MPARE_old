package com.co2mpare.fragments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import code.ListAdapter;
import code.Route;

import com.co2mpare.MainActivity;
import com.co2mpare.R;

public class Compare extends Fragment {
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	
	
	int selectedPos=-1;
	
	public static Compare newInstance(int sectionNumber) {
		Compare fragment = new Compare();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public Compare() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		
	   
	
		
		View rootView = inflater.inflate(R.layout.fragment_compare, container,
				false);
		
		Button confirmbtn=(Button) rootView.findViewById(R.id.cfbtn);

		
		//FOR TESTING ONLY//////////////////////////////////////////////////////////////
		String date="07.05.2014";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String text[]={"Geyrstraße","Südring"};
		Route testcar=new Route(12, 3, "Car", text, 10.0, 1.27, sdf.getCalendar().getTime());
		Route testpublic=new Route(14, 3, "Public", text, 4.7, 1.27, sdf.getCalendar().getTime());
		Route testbike=new Route(8, 3, "Bike", text, 0.0, 0.0, sdf.getCalendar().getTime());
			
		/////////////////////////////////////////////////////////////////////////////
		
		ArrayList<Route> test = new ArrayList<Route>();
		
		test.add(testcar);
		test.add(testpublic);
		test.add(testbike);
		
		ListAdapter la=new ListAdapter(getActivity(),test);
		
        final ListView lv = (ListView) rootView.findViewById(R.id.listView1);
        lv.setAdapter(la);
  
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv.getItemAtPosition(position);
                
                final View item=a.getChildAt(position);
		         item.setBackgroundColor(Color.LTGRAY);
		         switch(position){
		         case 0: a.getChildAt(1).setBackgroundColor(Color.TRANSPARENT);
		         		 a.getChildAt(2).setBackgroundColor(Color.TRANSPARENT);selectedPos=0;break;
		         case 1: a.getChildAt(0).setBackgroundColor(Color.TRANSPARENT);
        		 		 a.getChildAt(2).setBackgroundColor(Color.TRANSPARENT);selectedPos=1;break;
		         case 2: a.getChildAt(0).setBackgroundColor(Color.TRANSPARENT);
        		  		 a.getChildAt(1).setBackgroundColor(Color.TRANSPARENT);selectedPos=2;break;	
		         }
            }
        });
        
        confirmbtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Log.e("Position:",""+selectedPos);
				switch(selectedPos){
				case 0: ;break;
				case 1: ;break;
				case 2: ;break;
				default:
					Toast toast=new Toast(v.getContext());
					toast.makeText(v.getContext(),"Warning: Please select your desired vehicle to log this route.",Toast.LENGTH_LONG).show()
					;break;
				}
			}
        	
        });
		
		return rootView;
	}
}


