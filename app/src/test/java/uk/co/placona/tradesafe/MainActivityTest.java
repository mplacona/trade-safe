package uk.co.placona.tradesafe;

import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import uk.co.placona.tradesafe.Activities.MainActivity;

import static org.assertj.android.api.Assertions.assertThat;

/**
 * Created by mplacona on 22/06/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, manifest = "src/main/AndroidManifest.xml", packageName = "uk.co.placona.tradesafe")
public class MainActivityTest {
    private MainActivity activity;
    private FloatingActionButton fab;
    private RecyclerView rvTrades;

    @Before
    public void setup() throws Exception{
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .start()
                .resume()
                .get();
        fab = (FloatingActionButton) activity.findViewById(R.id.fab);
        rvTrades = (RecyclerView) activity.findViewById(R.id.list_trades);
        ShadowLog.stream = System.out;
    }

    @Test
    public void ActivityShouldNotBeNull() throws Exception {
        assertThat(activity).isNotNull();
    }

    @Test
    public void shouldHaveVisibleFab() throws Exception {
        assertThat(fab).isNotNull();
        assertThat(fab).isVisible();
    }

    @Test
    public void shouldHaveVisibleListView() throws Exception {
        assertThat(rvTrades).isNotNull();
        assertThat(rvTrades).isVisible();
    }

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

}
