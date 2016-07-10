//package uk.co.placona.tradesafe.view;
//
//import android.support.design.widget.FloatingActionButton;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PowerMockIgnore;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.modules.junit4.rule.PowerMockRule;
//import org.robolectric.Robolectric;
//import org.robolectric.RobolectricGradleTestRunner;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.annotation.Config;
//import org.robolectric.shadows.ShadowLog;
//
//import javax.inject.Inject;
//
//import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
//import io.realm.Realm;
//import io.realm.RealmConfiguration;
//import io.realm.RealmQuery;
//import io.realm.RealmResults;
//import io.realm.internal.RealmCore;
//import uk.co.placona.tradesafe.BuildConfig;
//import uk.co.placona.tradesafe.R;
//import uk.co.placona.tradesafe.component.ApplicationComponentTest;
//import uk.co.placona.tradesafe.component.DaggerApplicationComponentTest;
//import uk.co.placona.tradesafe.component.Injector;
//import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
//import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;
//import uk.co.placona.tradesafe.databinding.ActivityMainBinding;
//import uk.co.placona.tradesafe.repository.TradeRepository;
//
//import static org.assertj.android.api.Assertions.assertThat;
//import static org.mockito.Matchers.any;
//import static org.powermock.api.mockito.PowerMockito.mockStatic;
//
///**
// * Created by mplacona on 22/06/2016.
// */
//@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class, sdk = 21)
//@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
//@PrepareForTest({Injector.class})
//public class MainActivityTest {
//    private MainActivity activity;
//    private ActivityMainBinding binding;
//
//    FloatingActionButton fab;
//    RealmRecyclerView rvTrades;
//
//    @Rule
//    public PowerMockRule rule = new PowerMockRule();
//
//    @Inject
//    TradeRepository tradeRepository;
//
//    @Before
//    public void setup() throws Exception{
//        mockStatic(Injector.class);
//
//        ApplicationComponentTest applicationComponentTest = DaggerApplicationComponentTest.builder()
//                .applicationContextModuleTest(new ApplicationContextModuleTest())
//                .repositoryModuleTest(new RepositoryModuleTest(true))
//                .build();
//
//
//        PowerMockito.when(Injector.getApplicationComponent()).thenReturn(applicationComponentTest);
//
//        ((ApplicationComponentTest) Injector.getApplicationComponent()).inject(this);
//
//        activity = Robolectric.setupActivity(MainActivity.class);
//
//        fab = (FloatingActionButton) activity.findViewById(R.id.fab);
//        rvTrades = (RealmRecyclerView) activity.findViewById(R.id.list_trades);
//
//        ShadowLog.stream = System.out;
//    }
//
//    @Test
//    public void ActivityShouldNotBeNull() throws Exception {
//        Realm.getInstance(any(RealmConfiguration.class));
//        assertThat(activity).isNotNull();
//    }
//
////    @Test
////    public void shouldHaveVisibleFab() throws Exception {
////        assertThat(fab).isNotNull();
////        assertThat(fab).isVisible();
////    }
//
////    @Test
////    public void shouldHaveVisibleListView() throws Exception {
////        assertThat(rvTrades).isNotNull();
////        assertThat(rvTrades).isVisible();
////    }
//
////    @Test
////    public void shouldDisplayListViewWhenUserCancels() throws Exception {
////        fab.performClick();
////
////        ShadowActivity.IntentForResult intentForResult = Shadows.shadowOf(activity).peekNextStartedActivityForResult();
////        assertNotNull(intentForResult);
////
////        Shadows.shadowOf(activity).receiveResult(
////                new Intent(MediaStore.ACTION_VIDEO_CAPTURE),
////                Activity.RESULT_OK,
////                null);
////
////
////    }
//
////    @Test
////    public void clickingAddVideoShouldStartCameraActivity() {
////        fab.performClick();
////
////        Intent startedIntent = Shadows.shadowOf(activity).getNextStartedActivity();
////        Intent expectedIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
////        assertThat(startedIntent).isEqualTo(expectedIntent);
////    }
////
////    @Test
////    public void buttonClickShouldStartNewActivity() throws Exception
////    {
////        fab.performClick();
////
////        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
////        Intent startedIntent = shadowActivity.getNextStartedActivity();
////        ShadowIntent shadowIntent = Shadows.shadowOf(startedIntent);
////        assertEquals(shadowIntent.getIntentClass().getCanonicalName(),CreateActivity.class.getName());
////
////    }
//
//}
