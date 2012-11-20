package cr.ac.ucr.ecci.golapp.ui;

import cr.ac.ucr.ecci.golapp.R;
import cr.ac.ucr.ecci.golapp.R.layout;
import cr.ac.ucr.ecci.golapp.R.menu;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends Activity {

	Handler mHandler = new Handler();
	Animation rotar;
	TextView appName;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        appName = (TextView) findViewById(R.id.appName);
        
        rotar = AnimationUtils.loadAnimation(this, R.anim.rotation);
        
        rotar.setAnimationListener(new AnimationListener(){

			public void onAnimationEnd(Animation arg0) {
				appName.setVisibility(View.VISIBLE);
				
			}

			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			public void onAnimationStart(Animation animation) {
				appName.setVisibility(View.INVISIBLE);
				
			}
        	
        });
        
        appName.startAnimation(rotar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_splash, menu);
        return true;
    }
    
	@Override
	protected void onResume() {
		super.onResume();

		mHandler.postDelayed(new Runnable() {

			public void run() {
				startActivity( new Intent(getApplicationContext(), MainActivity.class));
				finish();
			}
		}, 3000);
	}
}
