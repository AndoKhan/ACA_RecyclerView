package am.aca.first.aca_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TodoItemRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_TODO_ITEM = 0;
    public static final int TYPE_TODO_AD = 1;

    private List<TodoItem> mData = new ArrayList<>();
    private AdItem mAdItem;
    private OnItemSelectedListener mOnItemSelectedListener;

    public TodoItemRecyclerAdapter(List<TodoItem> data, AdItem adItem) {
        mAdItem = adItem;
        mData.addAll(data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_TODO_AD: {
                    View view = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.view_ad_item, parent, false);
                    return new AdViewHolder(view);
                }
            case TYPE_TODO_ITEM: {
                    View view = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.view_todo_item, parent, false);
                    return new TodoItemViewHolder(view);
                }
            default:
                throw new IllegalStateException("Unknown view type");
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case TYPE_TODO_AD: {
                    AdViewHolder viewHolderPlh = (AdViewHolder)holder;
                    viewHolderPlh.ad.setText(mAdItem.getContent());
                }
                break;
            case TYPE_TODO_ITEM:
                TodoItemViewHolder viewHolderPlh = (TodoItemViewHolder)holder;
                final TodoItem todoItem = mData.get(position - 1);
                viewHolderPlh.title.setText(todoItem.getTitle());
                viewHolderPlh.description.setText(todoItem.getDescription());
                viewHolderPlh.date.setText(todoItem.getDate().toString());

                viewHolderPlh.description.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mOnItemSelectedListener != null) {
                            mOnItemSelectedListener.onRemove(holder.getAdapterPosition());
                        }
                    }
                });

                viewHolderPlh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mOnItemSelectedListener != null) {
                            mOnItemSelectedListener.onItemSelected(todoItem, holder.getAdapterPosition());
                        }
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TODO_AD;
        } else {
            return TYPE_TODO_ITEM;
        }
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        mOnItemSelectedListener = onItemSelectedListener;
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }

    public interface OnItemSelectedListener {
        void onItemSelected(TodoItem item, int position);
        void onRemove(int position);
    }
}
