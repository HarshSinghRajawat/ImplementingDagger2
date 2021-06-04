package com.one.daggerdummy.Dagger2;

import com.one.daggerdummy.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;



@Singleton
@Component(modules = {NetworksModule.class})
public interface NetworkComponent {
        @Component.Builder
        interface Builder{
                @BindsInstance
                Builder url(String url);
                NetworkComponent build();
        }
        void inject(MainActivity activity);


}
