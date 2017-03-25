package ar.com.futbolapp.ui;

import android.app.Application;

import com.auth0.core.Strategies;
import com.auth0.facebook.FacebookIdentityProvider;
import com.auth0.googleplus.GooglePlusIdentityProvider;
import com.auth0.lock.Lock;
import com.auth0.lock.LockProvider;

import flowengine.AppConfigurator;
import flowengine.FlowEngine;

public class FutbolAppApplication extends Application implements LockProvider{

    private Lock lock;

    public void onCreate() {
        super.onCreate();
        FlowEngine.initApp(new AppConfigurator() {
            @Override
            public void createWebAdapters() {

            }

            @Override
            public void createWebServices() {

            }

            @Override
            public void registerSingletons() {

            }
        });
        lock = new Lock.Builder()
                .loadFromApplication(this)
                .withIdentityProvider(Strategies.Facebook, new FacebookIdentityProvider(this))
                .withIdentityProvider(Strategies.GooglePlus, new GooglePlusIdentityProvider(this))
                /** Other configuration goes here */
                .closable(true)
                .build();
    }


    @Override
    public Lock getLock() {
        return lock;
    }
}
