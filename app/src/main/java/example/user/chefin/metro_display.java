package example.user.chefin;

/**
 * Created by abhij on 4/15/2018.
 */

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


public class metro_display  extends AppCompatActivity {
    private metro_adapter mAdapter;
    private RecyclerView recyclerView;
    EditText inputSearch;
    public String[] metronamelist;
    public String[] metronamelistforadapter;
    public int noofmetrotodisplay;
    int noofmetrotodisplaynoarr[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metro_display);
        metronamelist= getResources().getStringArray(R.array.metro_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        noofmetrotodisplay=metronamelist.length;
        metronamelistforadapter=metronamelist;
        noofmetrotodisplaynoarr=new int [noofmetrotodisplay];
        for(int i=0;i<noofmetrotodisplay;i++)
            noofmetrotodisplaynoarr[i]=i;

        mAdapter = new metro_adapter(metronamelistforadapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new metro_touch_listener(getApplicationContext(), recyclerView, new metro_touch_listener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent();
                intent.setClass(metro_display.this, Grid_Activity.class);
                intent.putExtra("metrono",noofmetrotodisplaynoarr[position]+1);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        inputSearch = (EditText) findViewById(R.id.inputSearch);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                int noofmetrotodisplaytemp=0;
                String metronamelisttemp[]=new String[noofmetrotodisplay];
                for(int l=0;l<noofmetrotodisplay;l++)
                {
                    if((metronamelist[l].toUpperCase())
                            .contains(cs.toString().toUpperCase()))
                    //does all string contain null coz it shows all string when text changed back to null
                    {
                        metronamelisttemp[noofmetrotodisplaytemp]=metronamelist[l];
                        noofmetrotodisplaynoarr[noofmetrotodisplaytemp]=l;
                        noofmetrotodisplaytemp++;
                    }
                }
                metronamelistforadapter=new String[noofmetrotodisplaytemp];
                for(int i=0;i<noofmetrotodisplaytemp;i++)
                    metronamelistforadapter[i]=metronamelisttemp[i];

                mAdapter = new metro_adapter(metronamelistforadapter);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

    }
}

