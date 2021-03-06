package com.anonymous.emojiproject.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anonymous.emojiproject.Presenters.EmojiPresenter;
import com.anonymous.emojiproject.R;


public class EmojiActivity extends AppCompatActivity {

    EditText editText;
    EditText textView;
    EmojiPresenter emojiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (EditText) findViewById(R.id.textView);
        emojiPresenter = new EmojiPresenter(this);
        emojiPresenter.loadEmoji();
    }

    public void onShareClick(View v){
        Toast.makeText(EmojiActivity.this, "ahahahahahah", Toast.LENGTH_SHORT).show();
        Intent sharing = new Intent(Intent.ACTION_SEND);
        sharing.setType("text/plain");
        sharing.putExtra(Intent.EXTRA_TEXT,textView.getText().toString());
        startActivity(Intent.createChooser(sharing, "Share via"));
    }

    public void onMagicClick(View v){
        if (!editText.getText().toString().equals(null))
            emojiPresenter.parseEmojiSentence(editText.getText().toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

        }

        return super.onOptionsItemSelected(item);
    }

    public void displayEmoji(String string){
        textView.setText(string);
    }

}
