package am.aca.first.aca_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TodoItemViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView description;
    public TextView date;

    public TodoItemViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_view_todo_item);
        description = itemView.findViewById(R.id.description_view_todo_item);
        date = itemView.findViewById(R.id.date_view_todo_item);
    }
}
