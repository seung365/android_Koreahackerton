package com.example.dabaewo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SearchAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public SearchAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context); // 오타 수정: inflate -> inflater
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position); // 수정: 실제 아이템 반환
    }

    @Override
    public long getItemId(int position) {
        return position; // 수정: 아이템의 식별자로 position 반환
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_listview, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.label = convertView.findViewById(R.id.label);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.label.setText(list.get(position));

        return convertView;
    }

    class ViewHolder {
        TextView label;
    }
}
