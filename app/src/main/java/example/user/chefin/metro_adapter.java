package example.user.chefin;

/**
 * Created by abhij on 4/15/2018.
 */
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class metro_adapter extends RecyclerView.Adapter<metro_adapter.MyViewHolder> {
    private String[] namelist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button btn;

        public MyViewHolder(View view) {
            super(view);
            btn=(Button) view.findViewById(R.id.button);
        }
    }
    public metro_adapter(String[] namelistf) {

        namelist=namelistf;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.metro_display_layout, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.btn.setText(namelist[position]);//use array here
    }
    @Override
    public int getItemCount() {
        return namelist.length;
    }
}




