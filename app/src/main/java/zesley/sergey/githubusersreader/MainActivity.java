package zesley.sergey.githubusersreader;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import zesley.sergey.githubusersreader.Fragments.AllUsersFragment;
import zesley.sergey.githubusersreader.Fragments.OneUserFragment;
import zesley.sergey.githubusersreader.Presenters.MainActivityPresenter;

public class MainActivity extends MvpAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,MainActivityView {
    @InjectPresenter
    MainActivityPresenter presenter;


    private FloatingActionButton fab;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    private void initUi(){
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(view ->{
            presenter.showMessage();

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (presenter.oneUserFragment.isAdded()) presenter.showAllUsersFragment(); else
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container,fragment).commit();
        if(fragment instanceof AllUsersFragment) fab.show(); else fab.hide();
    }

    @Override
    public void hideMessage() {
       if(dialog!=null) dialog.dismiss();
    }

    @Override
    public void showMessage() {
        EditText input = new EditText(this);
        dialog = new AlertDialog.Builder(MainActivity.this).setTitle("Введите имя пользователя")
                .setView(input)
                .setOnDismissListener(dialog1 -> {presenter.onDismissMessage();})
                .setPositiveButton("OK", (dialog, which) -> {
                    presenter.addNewUser(input.getText().toString());
                    dialog.dismiss();
                }).setNegativeButton("Отмена", (dialog, which) -> {
                    dialog.dismiss();
                }).show();
    }

    @Override
    public void showUser(int index, String name, OneUserFragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container,fragment).commit();
        fab.hide();
        fragment.showUser(index,name);
       // presenter2.showUser(index,name);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dialog!=null){
            dialog.setOnDismissListener(null);
            dialog.dismiss();
        }
    }
}
