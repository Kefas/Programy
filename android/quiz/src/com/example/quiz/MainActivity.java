package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static final String NAME = "name";
	public static final String SURNAME = "surname";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void start(View view){
		EditText mName = (EditText) findViewById(R.id.name);
		EditText mLast = (EditText) findViewById(R.id.lastname);
		String name = mName.getText().toString();
		String last  = mLast.getText().toString();
		
		if( name.length() == 0){
			Toast.makeText(this.getApplicationContext(), "Podaj imię",Toast.LENGTH_LONG ).show();
			return;
		}
		if(last.isEmpty()){
			Toast.makeText(this.getApplicationContext(), "Podaj nazwisko",Toast.LENGTH_LONG ).show();
			return;
		}
		
		Intent i = new Intent(this, QuestionActivity.class);
		Log.d("MainActivity","start");
		
		i.putExtra(NAME,name);
		i.putExtra(SURNAME,last);
		
		
		startActivity(i);
		//Log.d("MainActivity","start");
		
		
	
	}

}
