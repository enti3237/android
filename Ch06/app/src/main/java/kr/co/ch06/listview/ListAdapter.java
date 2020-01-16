package kr.co.ch06.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import kr.co.ch06.R;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    public ListAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 100;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.listview_item_layout, parent, false);
        TextView txtItemTit = view.findViewById(R.id.txt_item_tit);
        txtItemTit.setText("아이템 : " + position);

        return view;
    }


}
