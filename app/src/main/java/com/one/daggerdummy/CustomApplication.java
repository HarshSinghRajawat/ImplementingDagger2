package com.one.daggerdummy;

import android.app.Application;

import com.one.daggerdummy.Dagger2.DaggerNetworkComponent;
import com.one.daggerdummy.Dagger2.NetworkComponent;
import com.one.daggerdummy.Dagger2.NetworksModule;

public class CustomApplication extends Application {

    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent= DaggerNetworkComponent.builder()
                .url("https://jsonplaceholder.typicode.com/")
                .build();
    }
    public NetworkComponent getNetworkComponent(){
        return networkComponent;
    }
}

