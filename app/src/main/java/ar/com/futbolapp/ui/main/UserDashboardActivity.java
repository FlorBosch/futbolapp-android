package ar.com.futbolapp.ui.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

import javax.inject.Inject;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.BaseActivity;
import ar.com.futbolapp.ui.activity.ProfileActivity;
import ar.com.futbolapp.ui.activity.SettingsActivity;
import ar.com.futbolapp.ui.fragment.BenchDashboardFragment;
import ar.com.futbolapp.ui.matchlist.MatchListFragment;
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

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Inject
    UserDashboardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        activityComponent().inject(this);
        ButterKnife.bind(this);
        presenter.attachView(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        setUpNavigationView();
        addTabs();
    }

    private void addTabs() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MatchListFragment(), "ONE");
        adapter.addFrag(new BenchDashboardFragment(), "TWO");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void setUpNavigationView() {
        TextView header = (TextView) navigationView.getHeaderView(0).findViewById(R.id.nav_header);
        header.setText(presenter.getUsername());
        SubMenu menu = navigationView.getMenu().getItem(0).getSubMenu();
        for (String team : presenter.getTeams()) {
            menu.add(team);
        }
        navigationView.setNavigationItemSelectedListener(item -> {
                    drawerLayout.closeDrawers();
                    switch (item.getItemId()) {
                        case R.id.drawer_profile:
                            startActivity(ProfileActivity.newIntent(this));
                            return true;
                        case R.id.drawer_settings:
                            startActivity(SettingsActivity.newIntent(this));
                            return true;
                        default:
                            onTeamSelected(item.getItemId());
                            return true;
                    }
                }
        );
    }

    private void onTeamSelected(int teamIndex) {

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
