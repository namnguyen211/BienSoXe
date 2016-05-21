package com.bsx.vtca.biensoxe;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bsx.vtca.biensoxe.Data.DataSource;
import com.bsx.vtca.biensoxe.Data.DistrictItem;
import com.bsx.vtca.biensoxe.RecyclerAdapters.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ArrayAdapter<DistrictItem> adapter;
    CuastomListView cuastomListView;
    DataSource dataSource = new DataSource();
    ListView listView;
    Toolbar toolbar;
    MyRecyclerAdapter myRecyclerAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        listView = (ListView) findViewById(R.id.listView)
//        adapter = new ArrayAdapter<DistrictItem>(this, android.R.layout.simple_list_item_1, dataSource.districtDataSource());
//        cuastomListView = new CuastomListView(this, R.layout.custom_listview, dataSource.districtDataSource());
//        listView.setAdapter(cuastomListView);
        recyclerView = (RecyclerView) findViewById(R.id.lvHienThi);
        recyclerView.setHasFixedSize(true);

        recyclerView.setItemAnimator(new SlideInOutLeftItemAnimator(recyclerView));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        myRecyclerAdapter = new MyRecyclerAdapter(this, dataSource.districtDataSource());

        recyclerView.setAdapter(myRecyclerAdapter);


        getSupportActionBar().setTitle("Biển Số Xe");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        List<DistrictItem> newDistrict = new ArrayList<>();
        for (DistrictItem item : dataSource.districtDataSource()) {
            String title = item.getTitle().toLowerCase();
            String titleSearch = item.getTitleSearch().toLowerCase();
            String id = item.getId().toString();
            if (title.contains(newText) || titleSearch.contains(newText) || id.contains(newText)) {
                newDistrict.add(item);
            }
        }

        myRecyclerAdapter = new MyRecyclerAdapter(this, newDistrict);
        recyclerView.setAdapter(myRecyclerAdapter);

        return true;
    }
}
