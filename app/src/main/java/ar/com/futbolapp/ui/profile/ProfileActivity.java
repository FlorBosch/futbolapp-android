package ar.com.futbolapp.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import ar.com.futbolapp.R;
import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.ui.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity implements ProfileMvpView {

    @BindView(R.id.profile_picture)
    ImageView profilePicture;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    ProfilePresenter presenter;

    public static Intent newIntent(Context context) {
        return new Intent(context, ProfileActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        presenter.attachView(this);
        presenter.restoreState();
    }

    @Override
    public void displayUserInfo(Player user) {
        toolbar.setTitle(user.getName());
        Glide.with(this)
                .load(user.getProfilePicture())
                .placeholder(R.drawable.ic_person)
                .error(R.drawable.ic_notifications)
                .into(profilePicture);
    }
}
