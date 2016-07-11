package uk.co.placona.tradesafe.repository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.robolectric.annotation.Config;

import io.realm.Realm;
import uk.co.placona.tradesafe.BuildConfig;
import uk.co.placona.tradesafe.TestCustomApplication;
import uk.co.placona.tradesafe.models.Trade;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestCustomApplication.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest({Realm.class})
public class DatabaseRealmTest {

    Realm realmMock;

    @Ignore
    @Before
    public void setupRealm() {
        mockStatic(Realm.class);
        realmMock = PowerMockito.mock(Realm.class);

        when(realmMock.createObject(Trade.class)).thenReturn(new Trade());

        when(Realm.getDefaultInstance()).thenReturn(realmMock);

        doNothing().when(realmMock).beginTransaction();
        doNothing().when(realmMock).commitTransaction();
    }

    @Ignore
    @Test
    public void shouldBeAbleToGetDefaultInstance() {
        assertThat(Realm.getDefaultInstance(), is(realmMock));
    }

    @Ignore
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