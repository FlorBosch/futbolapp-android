package ar.com.futbolapp.injection.component;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import ar.com.futbolapp.injection.ApplicationContext;
import ar.com.futbolapp.injection.module.ApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();
}