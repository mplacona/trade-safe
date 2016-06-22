package uk.co.placona.tradesafe;

import android.content.Intent;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.assertj.android.api.Assertions.assertThat;

/**
 * Created by mplacona on 22/06/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, manifest = "src/main/AndroidManifest.xml", packageName = "uk.co.placona.tradesafe")
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        activity.onCreate(null);
    }

    @Test
    public void shouldNotBeNull() {
        assertThat(activity).isNotNull();

        FloatingActionButton fab = (FloatingActionButton) activity.findViewById(R.id.fab);
        assertThat(fab).isNotNull();

        assertThat(fab).isVisible();
    }


//    @Test
//    public void clickingPicture_shouldStartCameraActivity() {
//        activity.findViewById(R.id.fab).performClick();
//
//        Intent expectedIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//
//        assertThat(Shadows.shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
//    }

}
