package example.user.chefin;

import android.app.Activity;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class activity_discovery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discovery_2);
    }

    Button Clicker = (Button) findViewById(R.id.Clicker);
    Button Sizer = (Button) findViewById(R.id.SizeClicker);

Sizer.setOnClickListener(new Button.OnClickListener(){

        @Override
        public void onClick(View arg0) {
            ViewGroup.LayoutParams params = Clicker.getLayoutParams();
            Sizer.setLayoutParams(new RelativeLayout.LayoutParams(10, 100));
        }});
}
