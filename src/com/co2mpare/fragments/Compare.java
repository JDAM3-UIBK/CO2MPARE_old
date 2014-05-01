package com.co2mpare.fragments;

import java.util.ArrayList;
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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import code.InitialRoute;
import code.ListAdapter;
import code.Route;

import com.co2mpare.MainActivity;
import com.co2mpare.R;

public class Compare extends Fragment {
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
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
	
		//FOR TESTING ONLY
			
		InitialRoute testcar=new InitialRoute("Car",25.2f,10,120,110);
		InitialRoute testpublic=new InitialRoute("Public",23.5f,2,150,25);
		InitialRoute testbike=new InitialRoute("Bike",18.3f,0,170,0);
			
		ArrayList<InitialRoute> test = new ArrayList<InitialRoute>();
		
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
		         		 a.getChildAt(2).setBackgroundColor(Color.TRANSPARENT);break;
		         case 1: a.getChildAt(0).setBackgroundColor(Color.TRANSPARENT);
        		 		 a.getChildAt(2).setBackgroundColor(Color.TRANSPARENT);break;
		         case 2: a.getChildAt(0).setBackgroundColor(Color.TRANSPARENT);
        		  		 a.getChildAt(1).setBackgroundColor(Color.TRANSPARENT);break;	
		         }
            }
        });
		
		return rootView;
	}
}


