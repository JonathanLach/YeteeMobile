package com.android.yetee.yeteemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.MainContract;
import com.android.yetee.yeteemobile.presenter.MainPresenterImpl;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.ViewHandler {

    private String ERROR_DEBUG_TAG = "DEBUG INFO";
    private DrawerLayout mDrawerLayout;

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenterImpl(this);
    }

    @Override
    public void sendErrorDialog(String text) {
        Log.d(ERROR_DEBUG_TAG, text);
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void sendSuccessDialog(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public String getStringValue(int refId) {
        return getString(refId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.eventsListMenu:
            case R.id.eventsListMenuItem:
                presenter.setEventsListView();
                return true;
            case R.id.eventsMapMenuItem:
            case R.id.eventsMapMenu:
                presenter.setEventsMapView();
                return true;
            case R.id.profileMenu:
            case R.id.profileMenuItem:
                presenter.setProfileView();
                return true;
            case R.id.subscriptionsMenuItem:
                presenter.setSubscribtionView();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setEventsListView() {
        startActivity(new Intent(this, EventsListActivity.class));
    }

    @Override
    public void setEventsMapView() {
        startActivity(new Intent(this, EventMapActivity.class));
    }

    @Override
    public void setEventSubscribtionView() {
        startActivity(new Intent(this, EventSubscribtionsActivity.class));
    }

    @Override
    public void setProfileView() {
        startActivity(new Intent(this, ProfileActivity.class));
    }
}
