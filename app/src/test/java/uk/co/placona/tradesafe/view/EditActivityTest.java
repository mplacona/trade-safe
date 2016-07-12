package uk.co.placona.tradesafe.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import javax.inject.Inject;

import uk.co.placona.tradesafe.BuildConfig;
import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.TestCustomApplication;
import uk.co.placona.tradesafe.component.DaggerApplicationComponentTest;
import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;
import uk.co.placona.tradesafe.repository.TradeRepository;

import static org.assertj.android.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestCustomApplication.class)
public class EditActivityTest {
    private EditActivity activity;
    private EditText reference_txt;

    @Inject
    TradeRepository tradeRepository;

    @Before
    public void setupDagger() {
        DaggerApplicationComponentTest.builder()
                .applicationContextModuleTest(new ApplicationContextModuleTest())
                .repositoryModuleTest(new RepositoryModuleTest(false))
                .build().inject(this);

        Intent intent = new Intent(RuntimeEnvironment.application, EditActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ID", "id");
        intent.putExtra("ID", "id");
        activity = Robolectric.buildActivity(EditActivity.class)
                .withIntent(intent)
                .create()
                .get();
    }

    @Ignore
    @Test
    public void ActivityShouldNotBeNull() throws Exception {

        reference_txt = (EditText) activity.findViewById(R.id.reference_txt);
        assertThat(activity).isNotNull();
    }
}
