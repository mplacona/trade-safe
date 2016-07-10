package uk.co.placona.tradesafe.component;

import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;
import uk.co.placona.tradesafe.repository.TradeRepositoryTest;
//import uk.co.placona.tradesafe.view.MainActivityTest;
//import uk.co.placona.tradesafe.view.CreateActivityTest;
import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationContextModuleTest.class, RepositoryModuleTest.class})
public interface ApplicationComponentTest extends ApplicationComponent {

    //void inject(MainActivityTest activity);
    //void inject(CreateActivityTest activity);
    void inject(TradeRepositoryTest repository);

}
