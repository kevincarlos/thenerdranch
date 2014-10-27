package com.example.kevinkurtlcarlos.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.kevinkurtlcarlos.geoquiz.asnwer_is_true";
    public static final String EXTRA_ANSWER_IS_SHOWN = "com.example.kevinkurtlcarlos.geoquiz.asnwer_is_shown";
    public static final String KEY_CHEATER = "cheater";
    public static final String KEY_ANSWER_SHOWN = "answer is shown";

    private boolean mAnswerIsTrue, mIsCheater;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private int mCurrentAnswer;


    private void setAnswerIsShown(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_IS_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
        mIsCheater = isAnswerShown;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null){
            setAnswerIsShown(savedInstanceState.getBoolean(KEY_CHEATER));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                    mCurrentAnswer = R.string.true_button;
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                    mCurrentAnswer = R.string.false_button;
                }
                setAnswerIsShown(true);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_CHEATER, mIsCheater);
        savedInstanceState.putInt(KEY_ANSWER_SHOWN, mCurrentAnswer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cheat, menu);
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
}
