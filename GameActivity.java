package net.wereduck.o7planning2dgame;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int chibiNum = 2;
        //Get number of chibi to generate
        Bundle b = getIntent().getExtras();
        if(b!=null){
            chibiNum = (int)b.get(MainActivity.ButtonKey);
            Log.d("chibiNum", Integer.toString(chibiNum));
        }

        //Set fullscreen
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Set No Title
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setContentView(new GameSurface(this, chibiNum));

    }
}
