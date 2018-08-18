package com.android.yetee.yeteemobile.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.MainContract;
import com.android.yetee.yeteemobile.presenter.MainPresenterImpl;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.View {

    private static String ERROR_DEBUG_TAG = "DEBUG INFO";
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            case R.id.eventsListMenuItem:
                startActivity(new Intent(this, EventsListActivity.class));
                return true;
            case R.id.eventsMapMenuItem:
            case R.id.eventsMapMenu:
                startActivity(new Intent(this, EventMapActivity.class));
                return true;
            case R.id.profileMenu:
            case R.id.profileMenuItem:
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            case R.id.subscriptionsMenu:
            case R.id.subscriptionsMenuItem:
                startActivity(new Intent(this, EventSubscribtionsActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
