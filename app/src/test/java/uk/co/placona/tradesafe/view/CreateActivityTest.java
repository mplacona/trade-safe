//package uk.co.placona.tradesafe.view;
//
//import android.widget.EditText;
//import android.widget.VideoView;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PowerMockIgnore;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.robolectric.Robolectric;
//import org.robolectric.RobolectricGradleTestRunner;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.annotation.Config;
//
//import javax.inject.Inject;
//
//import uk.co.placona.tradesafe.BuildConfig;
//import uk.co.placona.tradesafe.R;
//import uk.co.placona.tradesafe.component.ApplicationComponentTest;
//import uk.co.placona.tradesafe.component.DaggerApplicationComponentTest;
//import uk.co.placona.tradesafe.component.Injector;
//import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
//import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;
//
//import static org.assertj.android.api.Assertions.assertThat;
//
//@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class, sdk = 21)
//@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
//public class CreateActivityTest {
//    private CreateActivity activity;
//    private EditText reference_txt;
//    private EditText description_text;
//    private VideoView video_view;
//
//
//    @Before
//    public void setupDagger() {
//        ApplicationComponentTest applicationComponentTest = DaggerApplicationComponentTest.builder()
//                .applicationContextModuleTest(new ApplicationContextModuleTest())
//                .repositoryModuleTest(new RepositoryModuleTest(false))
//                .build();
//
//        PowerMockito.when(Injector.getApplicationComponent()).thenReturn(applicationComponentTest);
//
//        ((ApplicationComponentTest) Injector.getApplicationComponent()).inject(this);
//
//        activity = Robolectric.setupActivity(CreateActivity.class);
//        reference_txt = (EditText) activity.findViewById(R.id.reference_txt);
//        description_text = (EditText) activity.findViewById(R.id.description_txt);
//        video_view = (VideoView) activity.findViewById(R.id.video_view);
//    }
//
//    @Test
//    public void ActivityShouldNotBeNull() throws Exception {
//        assertThat(activity).isNotNull();
//    }
////
////    @Test
////    public void shouldHaveVisibleReference() throws Exception {
////        assertThat(reference_txt).isNotNull();
////        assertThat(reference_txt).isVisible();
////    }
////
////    @Test
////    public void shouldHaveVisibleDescription() throws Exception {
////        assertThat(description_text).isNotNull();
////        assertThat(description_text).isVisible();
////    }
////
////    @Test
////    public void shouldHaveVisibleVideo() throws Exception {
////        assertThat(video_view).isNotNull();
////        assertThat(video_view).isVisible();
////    }
//}