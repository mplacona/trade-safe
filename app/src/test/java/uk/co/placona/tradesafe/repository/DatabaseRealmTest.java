package uk.co.placona.tradesafe.repository;
import io.realm.Realm;
import uk.co.placona.tradesafe.BuildConfig;
import uk.co.placona.tradesafe.TestCustomApplication;
import uk.co.placona.tradesafe.models.Trade;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.hamcrest.CoreMatchers.*;

@RunWith(PowerMockRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestCustomApplication.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest({Realm.class})
public class DatabaseRealmTest {

    Realm realmMock;

    @Before
    public void setupRealm() {
        mockStatic(Realm.class);
        realmMock = PowerMockito.mock(Realm.class);

        when(realmMock.createObject(Trade.class)).thenReturn(new Trade());

        when(Realm.getDefaultInstance()).thenReturn(realmMock);

        doNothing().when(realmMock).beginTransaction();
        doNothing().when(realmMock).commitTransaction();
    }

    @Test
    public void shouldBeAbleToGetDefaultInstance() {
        assertThat(Realm.getDefaultInstance(), is(realmMock));
    }

    @Test
    public void test_add() {
        // TODO
        /*
        assertThat(Realm.getDefaultInstance(), is(realmMock));
        verify(realmMock).beginTransaction();
        verify(realmMock).copyToRealm(environment);
        verify(realmMock).commitTransaction();
        */
    }
}