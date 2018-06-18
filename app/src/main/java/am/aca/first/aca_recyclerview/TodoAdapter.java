package am.aca.first.aca_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends BaseAdapter {

    private List<TodoItem> mData = new ArrayList<>();

    public TodoAdapter(List<TodoItem> data) {
        mData.addAll(data);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public TodoItem getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.view_todo_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.title = view.findViewById(R.id.title_view_todo_item);
            viewHolder.description = view.findViewById(R.id.description_view_todo_item);
            viewHolder.date = view.findViewById(R.id.date_view_todo_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)view.getTag();
        }
        TodoItem todoItem = mData.get(position);

        viewHolder.title.setText(todoItem.getTitle());
        viewHolder.description.setText(todoItem.getDescription());
        viewHolder.date.setText(todoItem.getDate().toString());
        return view;
    }

    private class ViewHolder {
        TextView title;
        TextView description;
        TextView date;
    }
}
