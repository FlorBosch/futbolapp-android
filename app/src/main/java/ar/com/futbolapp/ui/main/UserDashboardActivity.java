package ar.com.futbolapp.ui.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDashboardActivity extends BaseActivity implements UserDashboardView {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle toggle;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    UserDashboardPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        activityComponent().inject(this);
        ButterKnife.bind(this);
        mPresenter.attachView(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(item -> false);
        setUpNavigationView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    private void setUpNavigationView() {
        Menu menu = navigationView.getMenu().getItem(0).getSubMenu();
        addBenches(menu);
    }

    private void addBenches(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "Grupo 1");
        menu.add(Menu.NONE, 2, Menu.NONE, "Grupo 2");
        menu.add(Menu.NONE, 3, Menu.NONE, R.string.create_bench)
                .setIcon(R.drawable.ic_add);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
