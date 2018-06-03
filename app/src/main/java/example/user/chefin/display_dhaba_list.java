package example.user.chefin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class display_dhaba_list extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public Button btn;
    public Button btnDismiss;
    public PopupWindow popupWindow;
    int noofdhabatodisplay=0;
    int noofdhabatodisplayforlistview=0;
    int[] dhabatodisplaynoarrforlistview;
    public View popupView;
CustomAdapter customAdapter;
    int metrono;
    EditText inputSearch;
    ListView listview;
    char foodtypecode;
    String[][] dhabaarr;
    String url;
    int[] dhabatodisplaynoarr;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dhaba_list);
        Intent intent1 = getIntent();
        metrono = intent1.getIntExtra("metrono", 0);
        foodtypecode = intent1.getCharExtra("foodtypecode", ' ');
        String metroarrname = "metro" + metrono;
        int res = getResources().getIdentifier(metroarrname, "array", getPackageName());
        TypedArray ta = getResources().obtainTypedArray(res);
        int n = ta.length();
        dhabaarr = new String[n][];
        for (int i = 0; i < n; ++i) {
            int id = ta.getResourceId(i, 0);
            dhabaarr[i] = getResources().getStringArray(id);
        }
        ta.recycle();
        int[] dhabatodisplaynoarrtemp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                if (dhabaarr[i][1].charAt(j) == foodtypecode) {
                    dhabatodisplaynoarrtemp[noofdhabatodisplay] = i;
                    noofdhabatodisplay++;
                    break;
                } else if (dhabaarr[i][1].charAt(j) > foodtypecode) {
                    break;
                }

            }
        }
        dhabatodisplaynoarr = new int[noofdhabatodisplay];
        for (int i = 0; i < noofdhabatodisplay; i++) {
            dhabatodisplaynoarr[i] = dhabatodisplaynoarrtemp[i];
            dhabatodisplaynoarrforlistview = new int[noofdhabatodisplay];
            dhabatodisplaynoarrforlistview = dhabatodisplaynoarr;
            noofdhabatodisplayforlistview = noofdhabatodisplay;

        }
        listview = (ListView) findViewById(R.id.listview);
        listview.setOnItemClickListener(this);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        customAdapter = new CustomAdapter();
        listview.setAdapter(customAdapter);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                int noofdhabatodisplayforlistviewtemp = 0;
                int dhabatodisplaynoarrforlistviewtemp[] = new int[noofdhabatodisplay];
                for (int l = 0; l < noofdhabatodisplay; l++) {
                    if ((dhabaarr[dhabatodisplaynoarr[l]][0].toUpperCase())
                            .contains(cs.toString().toUpperCase()))
                    //does all string contain null coz it shows all string when text changed back to null
                    {
                        dhabatodisplaynoarrforlistviewtemp[noofdhabatodisplayforlistviewtemp] = dhabatodisplaynoarr[l];
                        noofdhabatodisplayforlistviewtemp++;
                    }
                }
                dhabatodisplaynoarrforlistview = dhabatodisplaynoarrforlistviewtemp;
                noofdhabatodisplayforlistview = noofdhabatodisplayforlistviewtemp;
                //can use jst one dhabatodisplaynoarr coz the loop runs according to noofdhabatodisplay and rest zeros are left away
                //as happens here coz dhabatodisplaynoarrforlistview is same size always
                listview.setAdapter(customAdapter);

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
    public void onItemClick(AdapterView<?> l, View v, int position, long id) {

        Intent intent = new Intent();
        intent.setClass(this, display_dhaba.class);
        intent.putExtra("dhabadetailsarr", dhabaarr[dhabatodisplaynoarrforlistview[position]]);
        startActivity(intent);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return (noofdhabatodisplayforlistview);
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.diplay_dhaba_layout, null);

            ImageView imageview=(ImageView)view.findViewById(R.id.imageView);
            TextView textview1 = view.findViewById(R.id.textview1);
            TextView textview2 = view.findViewById(R.id.textview2);
            url= dhabaarr[dhabatodisplaynoarrforlistview[i]][2];
            Glide.with(display_dhaba_list.this)
                    .load(url)
                    .into(imageview);
            //imageview.setImageResource(images[i]);
            textview1.setText(dhabaarr[dhabatodisplaynoarrforlistview[i]][0]);
            textview2.setText(dhabaarr[dhabatodisplaynoarrforlistview[i]][15]);
            return view;
        }
    }

}




