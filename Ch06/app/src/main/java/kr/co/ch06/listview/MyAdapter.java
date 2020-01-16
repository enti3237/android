package kr.co.ch06.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.co.ch06.R;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<MyData> dataList;

    public MyAdapter (Context context, List<MyData> dataList){
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View View, ViewGroup parent) {

        Log.i("listview", "list - "+position);

        if(View == null){
            View = inflater.inflate(R.layout.my_listview_item_layout, parent, false);
        }

        ImageView imgPoster = View.findViewById(R.id.img_poster);
        TextView txtTitle = View.findViewById(R.id.txt_title);
        TextView txtCompany = View.findViewById(R.id.txt_company);

        imgPoster.setImageResource(dataList.get(position).getPoster());
        txtTitle.setText(dataList.get(position).getTitle());
        txtCompany.setText(dataList.get(position).getCompany());

        return View;
    }
}
