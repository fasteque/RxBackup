package com.fasteque.rxbackup.views.activities;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fasteque.rxbackup.R;
import com.fasteque.rxbackup.RxBackupApplication;
import com.fasteque.rxbackup.injection.components.DaggerAppListComponent;
import com.fasteque.rxbackup.injection.modules.ActivityModule;
import com.fasteque.rxbackup.model.entities.ApplicationInfo;
import com.fasteque.rxbackup.presenters.AppListPresenter;
import com.fasteque.rxbackup.views.AppListView;
import com.fasteque.rxbackup.views.adapters.AppListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements AppListView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.apps_toolbar)
    Toolbar toolbar;

    @Bind(R.id.apps_swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.apps_recyclerview)
    RecyclerView recyclerView;

    @Inject
    AppListPresenter appListPresenter;

    private AppListAdapter appListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initToolbar();
        initSwipeRefreshLayout();
        initRecyclerView();
        initDependencyInjector();
        initPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        appListPresenter.onPresenterStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        appListPresenter.onPresenterStop();
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
            startActivity(new Intent(this, AttributionsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.app_name));
        }
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.primary, getTheme()));
        swipeRefreshLayout.setProgressViewOffset(false, 0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));

        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        appListAdapter = new AppListAdapter();
        recyclerView.setAdapter(appListAdapter);

        // TODO: handle clicks here?
    }

    private void initDependencyInjector() {
        RxBackupApplication rxBackupApplication = (RxBackupApplication) getApplication();

        // We need to inject the presenter
        DaggerAppListComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(rxBackupApplication.getApplicationComponent())
                .build().inject(this);
    }

    private void initPresenter() {
        appListPresenter.attachView(this);
    }

    @Override
    public void displayError(@StringRes int message) {
        Snackbar.make(findViewById(android.R.id.content), getString(message), Snackbar.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void refreshAppList(List<ApplicationInfo> applicationInfoList) {
        recyclerView.setVisibility(View.VISIBLE);
        appListAdapter.addApplications(applicationInfoList);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        if(appListPresenter != null) {
            appListPresenter.refreshAppList();
        }
    }
}