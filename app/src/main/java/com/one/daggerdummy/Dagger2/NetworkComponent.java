package com.one.daggerdummy.Dagger2;

import com.one.daggerdummy.MainActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;



@Singleton
@Component(modules = {NetworksModule.class})
public interface NetworkComponent {

        public void inject(MainActivity activity);
        @Component.Builder
        interface Builder{
                @BindsInstance
                Builder url(@Named("url") String url);
                NetworkComponent build();
        }

}
