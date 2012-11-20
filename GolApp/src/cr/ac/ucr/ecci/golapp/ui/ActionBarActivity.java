package cr.ac.ucr.ecci.golapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class ActionBarActivity extends SherlockActivity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    		case android.R.id.home:
    			NavUtils.navigateUpFromSameTask(this);
    			return true;
    		case 7:
    			startActivity(new Intent(ActionBarActivity.this, GoleadoresActivity.class));
    			return true;
    		default:
    			return super.onOptionsItemSelected(item);
    	}
    } 
}
