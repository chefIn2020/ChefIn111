package example.user.chefin;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Grid_Activity extends AppCompatActivity {

        public static int metrono=0;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grid_);
            Intent intent1=getIntent();
            metrono=intent1.getIntExtra("metrono",0);
        }
        public void getmetrochoice(View view) {
            Intent intent = new Intent(this,display_dhaba_list.class);
            char i = view.getTag().toString().charAt(0);
            intent.putExtra("metrono", metrono);
            intent.putExtra("foodtypecode", i);
            startActivity(intent);
        }
    }
