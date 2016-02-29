package ar.com.futbolapp.ui;

import android.app.Application;

import ar.com.futbolapp.webservice.BenchWebService;
import ar.com.futbolapp.webservice.mocks.BenchWebServiceMock;
import flowengine.AppConfigurator;
import flowengine.FlowEngine;

/**
 * Created by Ignacio on 08/02/2016.
 */
public class FutbolAppApplication extends Application{

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
                registerSingleton(BenchWebService.class, BenchWebServiceMock.class);
            }
        });
    }
}
