package com.example.wattana.bc_prototype_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Wattana on 12/11/2558.
 */
public class MyAdapter extends BaseAdapter {
    private Context  objContext;
    private String[] birdString,sourceString;

    public MyAdapter(Context objContext, String[] strBird) {
        this.objContext = objContext;
        this.birdString = birdString;
        this.sourceString = sourceString;
    }

    @Override
    public int getCount() {
        return birdString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = objLayoutInflater.inflate(R.layout.my_listview, viewGroup, false);
        TextView biTextView = (TextView) view1.findViewById(R.id.txtList);



        return view1;
    }
} //Main Class
