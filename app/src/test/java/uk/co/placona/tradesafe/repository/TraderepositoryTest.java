package uk.co.placona.tradesafe.repository;

import uk.co.placona.tradesafe.BuildConfig;
import uk.co.placona.tradesafe.component.ApplicationComponentTest;
import uk.co.placona.tradesafe.component.DaggerApplicationComponentTest;
import uk.co.placona.tradesafe.component.Injector;
import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;
import uk.co.placona.tradesafe.models.Trade;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;



import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
@PowerMockIgnore({"org.mockito.*"})
@PrepareForTest({Injector.class})
public class TradeRepositoryTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Inject
    TradeRepository messageRepository;

    @Inject
    DatabaseRealm databaseRealm;

    @Before
    public void setupDagger() {
        ApplicationComponentTest applicationComponentTest = DaggerApplicationComponentTest.builder()
                .applicationContextModuleTest(new ApplicationContextModuleTest())
                .repositoryModuleTest(new RepositoryModuleTest(false))
                .build();

        PowerMockito.mockStatic(Injector.class);
        PowerMockito.when(Injector.getApplicationComponent()).thenReturn(applicationComponentTest);

        ((ApplicationComponentTest) Injector.getApplicationComponent()).inject(this);
    }

    @Test
    public void tradeRepository_add() {
        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        String TRADE_UUID = "UUID";
        String TRADE_REFERENCE = "REFERENCE";
        String TRADE_URI = "URI";
        Date TRADE_DATE = new Date(mydate);

        Trade trade = new Trade();
        trade.setId(TRADE_UUID);
        trade.setReference(TRADE_REFERENCE);
        trade.setUri(TRADE_URI);
        trade.setDate(TRADE_DATE);

        when(databaseRealm.add(trade)).thenReturn(trade);

        messageRepository.add(trade);

        verify(databaseRealm).add(trade);
    }
}