package com.genbuzz.merygoesshopping;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import adapter.SuggestionAdapter;
import model.Suggestion;


public class ActivityMain extends AppCompatActivity {

    public final int REQ_CODE_SPEECH_INPUT = 100;

    private AutoCompleteTextView txtSpeechInput;
    private ImageView btnSpeak;
    private ArrayList<String> suggestionList;
    private SuggestionAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        suggestionList = new ArrayList<>();


        fillSuggestions();

        txtSpeechInput = (AutoCompleteTextView) findViewById(R.id.activity_main_auto_complete_name);

        adapter = new SuggestionAdapter(this, R.layout.row_suggestion,
                R.id.row_suggestion_txt_view_name, suggestionList);




        txtSpeechInput.setAdapter(adapter);


        btnSpeak = (ImageView) findViewById(R.id.activity_main_icon_microphone);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
    }


    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.speech_prompt));

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));
                }
                break;
            }

        }
    }

    public void fillSuggestions(){
        suggestionList.add(getResources().getString(R.string.bread_white));
        suggestionList.add(getResources().getString(R.string.bread_wheat));
        suggestionList.add(getResources().getString(R.string.bread_french));
        suggestionList.add(getResources().getString(R.string.spinach));
        suggestionList.add(getResources().getString(R.string.broccoli));
        suggestionList.add(getResources().getString(R.string.cauliflower));
        suggestionList.add(getResources().getString(R.string.green_pepper));
        suggestionList.add(getResources().getString(R.string.carrots));
        suggestionList.add(getResources().getString(R.string.asparagus));
        suggestionList.add(getResources().getString(R.string.red_pepper));
        suggestionList.add(getResources().getString(R.string.strawberry));
        suggestionList.add(getResources().getString(R.string.tomato));
        suggestionList.add(getResources().getString(R.string.orange));
        suggestionList.add(getResources().getString(R.string.apple));
        suggestionList.add(getResources().getString(R.string.cucumber));
        suggestionList.add(getResources().getString(R.string.salmon));
        suggestionList.add(getResources().getString(R.string.avocado));
        suggestionList.add(getResources().getString(R.string.milk));
        suggestionList.add(getResources().getString(R.string.potatoes));
        suggestionList.add(getResources().getString(R.string.eggs));
        suggestionList.add(getResources().getString(R.string.cheese));
    }
}
