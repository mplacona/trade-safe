package uk.co.placona.tradesafe.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import uk.co.placona.tradesafe.BuildConfig;
import uk.co.placona.tradesafe.TestCustomApplication;
import uk.co.placona.tradesafe.component.DaggerApplicationComponentTest;
import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;
import uk.co.placona.tradesafe.models.Trade;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestCustomApplication.class)
public class TradeRepositoryTest {

    @Inject
    TradeRepository messageRepository;

    @Inject
    DatabaseRealm databaseRealm;

    @Before
    public void setupDagger() {
        DaggerApplicationComponentTest.builder()
                .applicationContextModuleTest(new ApplicationContextModuleTest())
                .repositoryModuleTest(new RepositoryModuleTest(false))
                .build().inject(this);
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

        when(databaseRealm.upsert(trade)).thenReturn(trade);

        messageRepository.upsert(trade);

        verify(databaseRealm).upsert(trade);
    }
}