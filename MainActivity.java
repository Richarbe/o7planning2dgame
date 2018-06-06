package net.wereduck.o7planning2dgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String ButtonKey = "net.wereduck.o7planning2dgame.ButtonKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnClick(View view) {

        int sendInt = Integer.parseInt(((EditText)findViewById(R.id.editText)).getText().toString());
        Intent intent = new Intent (this, GameActivity.class);
        intent.putExtra(ButtonKey, sendInt);

        startActivity(intent);
    }



}
