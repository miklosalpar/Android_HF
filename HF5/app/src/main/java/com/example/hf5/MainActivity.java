package com.example.hf5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListAdapter adapter;
    private List<ListItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = createInitialData();

        listView = findViewById(R.id.main_list_view);
        adapter = new CustomListAdapter(this, dataList);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_sort) {
            Collections.sort(dataList, new Comparator<ListItem>() {
                @Override
                public int compare(ListItem item1, ListItem item2) {
                    return item1.getText().compareTo(item2.getText());
                }
            });
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Lista rendezve.", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_clear) {
            dataList.clear();
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "A teljes lista törölve.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;
        ListItem selectedItem = dataList.get(position);

        int newColorId;
        int id = item.getItemId();

        if (id == R.id.context_red) {
            newColorId = android.R.color.holo_red_dark;
        } else if (id == R.id.context_green) {
            newColorId = android.R.color.holo_green_dark;
        } else if (id == R.id.context_yellow) {
            newColorId = android.R.color.holo_orange_dark;
        } else {
            return super.onContextItemSelected(item);
        }

        selectedItem.setColorResId(newColorId);
        adapter.notifyDataSetChanged();

        Toast.makeText(this, selectedItem.getText() + " színe megváltoztatva.", Toast.LENGTH_SHORT).show();
        return true;
    }



    private List<ListItem> createInitialData() {
        List<ListItem> list = new ArrayList<>();
        int defaultColor = android.R.color.black;

        list.add(new ListItem("Zebra", defaultColor));
        list.add(new ListItem("Alma", defaultColor));
        list.add(new ListItem("Macska", defaultColor));
        list.add(new ListItem("Kutya", defaultColor));
        list.add(new ListItem("Egér", defaultColor));
        return list;
    }
}