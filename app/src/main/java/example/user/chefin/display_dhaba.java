package example.user.chefin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.net.Uri;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class display_dhaba extends AppCompatActivity {
    String[] dhabadetails;
    String URI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dhaba);
        Intent intent = getIntent();
        dhabadetails = intent.getStringArrayExtra("dhabadetailsarr");
        int t = dhabadetails.length;
        int noofdhabapics=0, noofmenupics=0;
        for(int i=2;i<=4;i++)
        {
            if(!(dhabadetails[i].isEmpty()))
                noofdhabapics++;
        }
        for(int i=5;i<=14;i++)
        {
            if(!(dhabadetails[i].isEmpty()))
                noofmenupics++;
        }
        LinearLayout dhabapicslinearlayout = (LinearLayout) findViewById(R.id.dhabapics);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout menupicslinearlayout = (LinearLayout) findViewById(R.id.menupics);
        int n=0;
        n=2;
        for(int i=1;i<=noofdhabapics;i++)
        {
            ImageButton imgbtn=new ImageButton(this);
            URI=dhabadetails[n];
            Glide.with(display_dhaba.this)
                    .load(URI)
                    .into(imgbtn);
            dhabapicslinearlayout.addView(imgbtn, lp);
            n++;
        }
        n=5;
        for(int i=1;i<=noofmenupics;i++)
        {
            ImageButton imgbtn=new ImageButton(this);
            URI=dhabadetails[n];
            Glide.with(display_dhaba.this)
                    .load(URI)
                    .into(imgbtn);
            menupicslinearlayout.addView(imgbtn, lp);
            n++;
        }
        TextView txt=(TextView)findViewById(R.id.dhabadetails);
        txt.setText("BALAJI PITTHI WAALE \n WHAT ARE YOU LOOKING? \n TIMIMG: 10AM-11PM");
    }
}
