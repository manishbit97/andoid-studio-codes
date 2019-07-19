package com.example.appp53animation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity53 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity53);
    }

    public void zoom(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        image.startAnimation(animation);
     }
     
     public void clockwise(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(animation1);
     }
     
     public void fade(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(animation1);
     }
     
    /* public void blink(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);
     }*/
     
     public void slide(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
     }
     
    /* public void slide(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView1);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);*/
     
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity53, menu);
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
          return true;
       }
       return super.onOptionsItemSelected(item);
    }
    
}