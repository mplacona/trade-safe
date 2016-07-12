package uk.co.placona.tradesafe.view;

import android.support.design.widget.FloatingActionButton;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import uk.co.placona.tradesafe.BuildConfig;
import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.TestCustomApplication;
import uk.co.placona.tradesafe.component.DaggerApplicationComponentTest;
import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;
import uk.co.placona.tradesafe.repository.TradeRepository;

import static org.assertj.android.api.Assertions.assertThat;
import static org.mockito.Matchers.any;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestCustomApplication.class)
public class MainActivityTest {
    private MainActivity activity;

    FloatingActionButton fab;
    RealmRecyclerView rvTrades;

    @Inject
    TradeRepository tradeRepository;

    @Before
    public void setupDagger() {
        DaggerApplicationComponentTest.builder()
                .applicationContextModuleTest(new ApplicationContextModuleTest())
                .repositoryModuleTest(new RepositoryModuleTest(false))
                .build().inject(this);

        activity = Robolectric.setupActivity(MainActivity.class);
        fab = (FloatingActionButton) activity.findViewById(R.id.fab);
        rvTrades = (RealmRecyclerView) activity.findViewById(R.id.list_trades);
    }

    @Ignore
    @Test
    public void ActivityShouldNotBeNull() throws Exception {
        assertThat(activity).isNotNull();
    }

//    @Test
//    public void shouldHaveVisibleFab() throws Exception {
//        assertThat(fab).isNotNull();
//        assertThat(fab).isVisible();
//    }

//    @Test
//    public void shouldHaveVisibleListView() throws Exception {
//        assertThat(rvTrades).isNotNull();
//        assertThat(rvTrades).isVisible();
//    }

//    @Test
//    public void shouldDisplayListViewWhenUserCancels() throws Exception {
//        fab.performClick();
//
//        ShadowActivity.IntentForResult intentForResult = Shadows.shadowOf(activity).peekNextStartedActivityForResult();
//        assertNotNull(intentForResult);
//
//        Shadows.shadowOf(activity).receiveResult(
//                new Intent(MediaStore.ACTION_VIDEO_CAPTURE),
//                Activity.RESULT_OK,
//                null);
//
//
//    }

//    @Test
//    public void clickingAddVideoShouldStartCameraActivity() {
//        fab.performClick();
//
//        Intent startedIntent = Shadows.shadowOf(activity).getNextStartedActivity();
//        Intent expectedIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//        assertThat(startedIntent).isEqualTo(expectedIntent);
//    }
//
//    @Test
//    public void buttonClickShouldStartNewActivity() throws Exception
//    {
//        fab.performClick();
//
//        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
//        Intent startedIntent = shadowActivity.getNextStartedActivity();
//        ShadowIntent shadowIntent = Shadows.shadowOf(startedIntent);
//        assertEquals(shadowIntent.getIntentClass().getCanonicalName(),CreateActivity.class.getName());
//
//    }

}
