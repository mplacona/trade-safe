package uk.co.placona.tradesafe.view;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.realm.Realm;
import uk.co.placona.tradesafe.BuildConfig;
//
//@RunWith(RobolectricGradleTestRunner.class)
//@Config(constants = BuildConfig.class, sdk = 21)
//@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
//@PrepareForTest({Realm.class})
//public class CreateActivityTest {
//
//    Realm mockRealm;
//
//    @Rule
//    public PowerMockRule rule = new PowerMockRule();
//
//    @Before
//    public void setup() {
//        mockRealm = MockSupport.mockRealm();
//    }
//
//    @Test
//    public void realmShouldBeMocked() {
//        assertThat(Realm.getDefaultInstance(), is(mockRealm));
//    }
//}