package com.rishabhjaiswal.listviewagain;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rishabhjaiswal.listviewagain.ItemActivity;
import com.rishabhjaiswal.listviewagain.R;

import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    // no need to make public coz no other class -> but we ARE using it OUTSIDE
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView textView;


        MyViewHolder(View view) {
            super(view);
            containerView = view.findViewById(R.id.my_row); // int id android generates to repr this view
            textView = view.findViewById(R.id.my_row_text_view);
            // use that adapter
            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String current = (String) containerView.getTag();
                    Intent intent =  new Intent(v.getContext(), ItemActivity.class);
                    intent.putExtra("name", current);

                    v.getContext().startActivity(intent);

                }
            });

//            containerView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String current = (String) containerView.getTag();
//                    Intent intent = new Intent(v.getContext(), ItemActivity.class); // i want to goto this activity
//                    intent.putExtra("name ", current); // pass along this data
//                    // start the activity by attaching to the view v
//                    v.getContext().startActivity(intent);
//                }
//            });

        }
    }

    private List<String> items = Arrays.asList(
            "Onion",
            "Cucumber",
            "Tomato",
            "Carrot"
    );

    @NonNull
    @Override // from RecyvlerView.Adapter 1st meth
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        // fo from some xml file to java view object in memory

        return new MyViewHolder(view);
    }

    @Override // set values inside of this rows
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // controller does this : model->view
        String current = items.get(position);
        holder.textView.setText(current);

        // since we got position here, Intent(segue) must be from here FIRST
        holder.containerView.setTag(current);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
