package ar.com.futbolapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import ar.com.futbolapp.R;

public class UserDashboardActivity extends BaseActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setUpNavigationView();

        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

    private void setUpNavigationView() {
        Menu menu = navigationView.getMenu().getItem(0).getSubMenu();
        addBenches(menu);
    }

    private void addBenches(Menu menu) {
        menu.add(Menu.NONE, 1,Menu.NONE,"Grupo 1");
        menu.add(Menu.NONE, 2,Menu.NONE,"Grupo 2");
        menu.add(Menu.NONE, 3,Menu.NONE, R.string.create_bench).setIcon(R.drawable.ic_add_black_18dp);
    }

    private Long getGroupId(int itemId) {
        return itemId * 1L;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
