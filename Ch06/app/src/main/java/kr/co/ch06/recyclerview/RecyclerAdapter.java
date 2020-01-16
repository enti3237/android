package kr.co.ch06.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.co.ch06.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<MyData> dataList;

    public RecyclerAdapter (Context context, List<MyData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_listview_item_layout, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imgPoster.setImageResource(dataList.get(position).getPoster());
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtCompany.setText(dataList.get(position).getCompany());
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


    // ViewHolder 내장 클래스 정의

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPoster;
        TextView txtTitle;
        TextView txtCompany;

        public ViewHolder(View itemView) {
            super(itemView);

            imgPoster  = itemView.findViewById(R.id.img_poster);
            txtTitle   = itemView.findViewById(R.id.txt_title);
            txtCompany = itemView.findViewById(R.id.txt_company);

        }
    }

}
