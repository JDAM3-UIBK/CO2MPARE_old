package com.co2mpare.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.co2mpare.MainActivity;
import com.co2mpare.R;

public class Login extends Activity{
	
	Button loginbtn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        // Be sure to call the super class.
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // See assets/res/any/layout/translucent_background.xml for this
        // view layout definition, which is being set here as
        // the content of our screen.
        setContentView(R.layout.fragment_login);
       loginbtn=(Button)findViewById(R.id.loginbutton);
            
       loginbtn.setOnClickListener(new OnClickListener(){
     
		@Override
		public void onClick(View v) {
			Intent intent=new Intent(v.getContext(), MainActivity.class);
			v.getContext().startActivity(intent);			
		}
    	   
       });
       
        
    }
}
