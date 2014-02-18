package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends Activity {

	String [] question = { "Czy Agnieszka jest najpiekniejsza na swiecie?", "Ile jest gwiazd na niebie?", "Lubisz maslo?"};
	String [][] answers = {{"Tak","Zdecydowanie tak", "Oczywiscie ze tak"}, {"100","200","300"},{"tak","nie","lubie"}};
	int [][]score = {{1,1,1},{0,0,1},{1,0,0}};
	int [] userAnswers = { -1,-1,-1};
	private static final String TAG = "QuestionActivity";
	public static final String SCORE ="score";
	public static int count = 0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		// Show the Up button in the action bar.
//		setupActionBar();
		Intent i = getIntent();
		String name = i.getStringExtra(MainActivity.NAME);
		String last = i.getStringExtra(MainActivity.SURNAME);
		
//		Toast.makeText(this.getApplicationContext(), name + " " + last, Toast.LENGTH_LONG).show();
		
	TextView text = (TextView) findViewById(R.id.question);
	text.setText(question[0]);
	RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
	RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
	RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
	Log.d(TAG , "onCreate");
	
	radio1.setText(answers[count][0]);
	radio2.setText(answers[count][1]);
	radio3.setText(answers[count][2]);
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
//	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
//	private void setupActionBar() {
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//			getActionBar().setDisplayHomeAsUpEnabled(true);
//		}
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		return true;
	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case android.R.id.home:
//			// This ID represents the Home or Up button. In the case of this
//			// activity, the Up button is shown. Use NavUtils to allow users
//			// to navigate up one level in the application structure. For
//			// more details, see the Navigation pattern on Android Design:
//			//
//			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
//			//
//			NavUtils.navigateUpFromSameTask(this);
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
	
	public void showScore(View view){
		RadioGroup v = (RadioGroup) findViewById(R.id.radioGroup);
		View view2 = v.findViewById(v.getCheckedRadioButtonId());
		userAnswers[count] = v.indexOfChild(view2);
		int points = 0;
		for(int j=0;j<userAnswers.length;j++){
			if(userAnswers[j] != -1)
				points += score[j][userAnswers[j]];
		}
		
		Log.d(TAG,"showScore");
		Intent i = new Intent(this, EndActivity.class);
		i.putExtra(SCORE, Integer.toString(points));
		Log.d(TAG,"showScore");
		startActivity(i);
		
		
	}
	
	public void next(View view){
		Log.d(TAG , "next");
		RadioGroup v = (RadioGroup) findViewById(R.id.radioGroup);
		View view2 = v.findViewById(v.getCheckedRadioButtonId());
		userAnswers[count] = v.indexOfChild(view2);
//		 Log.d(TAG, Integer.toString(userAnswers[count]));
		
		
		if(count != question.length-1){
			count++;
			v.clearCheck();
			Log.d(TAG , "next2");
			TextView text = (TextView) findViewById(R.id.question);
			text.setText(question[count]);
			RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
			RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
			RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
			Log.d(TAG , "next");
			
			radio1.setText(answers[count][0]);
			radio2.setText(answers[count][1]);
			radio3.setText(answers[count][2]);	
			
		}
		
		
		
	}
	
	public void previous(View view){
		
		RadioGroup v = (RadioGroup) findViewById(R.id.radioGroup);
		View view2 = v.findViewById(v.getCheckedRadioButtonId());
		userAnswers[count] = v.indexOfChild(view2);
//		 Log.d(TAG, Integer.toString(userAnswers[count]));
		
		
		if(count != 0){
			count--;
			v.clearCheck();
			Log.d(TAG , "next2");
			TextView text = (TextView) findViewById(R.id.question);
			text.setText(question[count]);
			RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
			RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
			RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
			Log.d(TAG , "next");
			
			radio1.setText(answers[count][0]);
			radio2.setText(answers[count][1]);
			radio3.setText(answers[count][2]);	
		}
		
	}
	
	

}
