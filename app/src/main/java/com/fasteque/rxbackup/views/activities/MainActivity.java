package com.fasteque.rxbackup.views.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fasteque.rxbackup.R;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.apps_toolbar)
    Toolbar toolbar;

    @Bind(R.id.apps_swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.apps_recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_attributions) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
