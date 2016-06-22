package com.ikeda.sumo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //以下にメインメニューボタンが押されたときの動作を定義する。
        //
        if (id == R.id.nav_story) {
            // Handle the camera action
            Toast.makeText(this,"相撲物語モード！",Toast.LENGTH_SHORT).show();
            Intent monogatari = new Intent(MainActivity.this,KawaigariActivity.class);
            startActivity(monogatari);
        } else if (id == R.id.nav_torikumi) {
            Toast.makeText(this,"取り組みモード！",Toast.LENGTH_SHORT).show();
            Intent torikumi = new Intent(MainActivity.this,TorikumiMenuActivity.class);
            startActivity(torikumi);
        } else if (id == R.id.nav_shop) {
            Toast.makeText(this,"相撲ショップ！",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this,"設定！",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_add) {
            Toast.makeText(this,"力士追加！",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_reset) {
            Toast.makeText(this,"初期化！",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_online) {
            Toast.makeText(this,"オンライン参加！",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_other) {
            Toast.makeText(this,"その他？！",Toast.LENGTH_SHORT).show();
            Intent win = new Intent(MainActivity.this,WinActivity.class);
            startActivity(win);
        }

        //どのボタンが押されてもメインメニューを閉じて、コンテンツビューを表示する。
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
