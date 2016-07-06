package uk.co.placona.tradesafe.view;

import android.widget.EditText;
import android.widget.VideoView;

import org.assertj.android.api.preference.EditTextPreferenceAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import uk.co.placona.tradesafe.BuildConfig;
import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.databinding.ActivityCreateBinding;

import static org.assertj.android.api.Assertions.assertThat;

//
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CreateActivityTest {
    private CreateActivity activity;
    private ActivityCreateBinding binding;
    private EditText reference_txt;
    private EditText description_text;
    private VideoView video_view;

    @Before
    public void setupActivity(){
        activity = Robolectric.setupActivity(CreateActivity.class);
        reference_txt = (EditText) activity.findViewById(R.id.reference_txt);
        description_text = (EditText) activity.findViewById(R.id.description_txt);
        video_view = (VideoView) activity.findViewById(R.id.video_view);
    }

    @Test
    public void ActivityShouldNotBeNull() throws Exception {
        assertThat(activity).isNotNull();
    }

    @Test
    public void shouldHaveVisibleReference() throws Exception {
        assertThat(reference_txt).isNotNull();
        assertThat(reference_txt).isVisible();
    }

    @Test
    public void shouldHaveVisibleDescription() throws Exception {
        assertThat(description_text).isNotNull();
        assertThat(description_text).isVisible();
    }

    @Test
    public void shouldHaveVisibleVideo() throws Exception {
        assertThat(video_view).isNotNull();
        assertThat(video_view).isVisible();
    }

//    @Test
//    public void shouldHaveVisibleListView() throws Exception {
//        assertThat(rvTrades).isNotNull();
//        assertThat(rvTrades).isVisible();
//    }
//
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
//
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