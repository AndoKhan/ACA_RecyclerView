package am.aca.first.aca_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TodoItemRecyclerAdapter.OnItemSelectedListener mOnItemSelectedListener
            = new TodoItemRecyclerAdapter.OnItemSelectedListener() {
        @Override
        public void onItemSelected(TodoItem item, int position) {
            Toast.makeText(MainActivity.this, "OnItemClicked", Toast.LENGTH_SHORT).show();
            // TODO start detail activity
        }

        @Override
        public void onRemove(int position) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TodoItem> items = generateMockResources();

        ListView listView = findViewById(R.id.list_activity_main);
        listView.setAdapter(new TodoAdapter(items));

        RecyclerView recyclerView = findViewById(R.id.rlist_activity_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        TodoItemRecyclerAdapter adapter = new TodoItemRecyclerAdapter(items, new AdItem());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemSelectedListener(mOnItemSelectedListener);
    }

    private List<TodoItem> generateMockResources() {
        List<TodoItem> rv = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            rv.add(new TodoItem("title" + i, "desc" + i, new Date()));
        }
        return rv;
    }
}
