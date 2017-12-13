package com.app.ryanbansal.uidesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RyanBansal on 12/8/17.
 */


class orderAdapter extends ArrayAdapter<Order> {

    public orderAdapter(@NonNull Context context, @NonNull List<Order> objects) {
        super(context, 0, objects);
    }

    public class MyViewHolder {

        public TextView textView1;

        public TextView textView2;

        public TextView textView3;

        public MyViewHolder(View view) {

            textView1 = (TextView) view.findViewById(R.id.image);

            textView2 = (TextView) view.findViewById(R.id.details);

            textView3 = (TextView) view.findViewById(R.id.artistname);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MyViewHolder myViewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.orderlayout, parent, false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }

        else
            myViewHolder = (MyViewHolder) convertView.getTag();

        TextView t1 = (TextView) convertView.findViewById(R.id.qty);
        t1.setText(getItem(position).getQuantity());

        TextView t2 = (TextView) convertView.findViewById(R.id.dish);
        t2.setText(getItem(position).getDish());

        TextView t3 = (TextView) convertView.findViewById(R.id.address);
        t3.setText(getItem(position).getAddress());

        Animation animation = AnimationUtils
                .loadAnimation(getContext(), R.anim.fui_slide_in_right);
        convertView.startAnimation(animation);

        return convertView;
    }
}