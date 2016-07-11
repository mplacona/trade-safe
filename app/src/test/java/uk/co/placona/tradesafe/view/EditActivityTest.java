package uk.co.placona.tradesafe.view;

import android.widget.EditText;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import uk.co.placona.tradesafe.BuildConfig;
import uk.co.placona.tradesafe.R;
import uk.co.placona.tradesafe.component.ApplicationComponentTest;
import uk.co.placona.tradesafe.component.DaggerApplicationComponentTest;
import uk.co.placona.tradesafe.component.Injector;
import uk.co.placona.tradesafe.component.module.ApplicationContextModuleTest;
import uk.co.placona.tradesafe.component.module.RepositoryModuleTest;
import uk.co.placona.tradesafe.repository.TradeRepository;

import static org.assertj.android.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
@PrepareForTest({Injector.class})
public class EditActivityTest {
    private EditActivity activity;
    private EditText reference_txt;

    @Inject
    TradeRepository tradeRepository;

    @Before
    public void setupDagger() {
        ApplicationComponentTest applicationComponentTest = DaggerApplicationComponentTest.builder()
                .applicationContextModuleTest(new ApplicationContextModuleTest())
                .repositoryModuleTest(new RepositoryModuleTest(false))
                .build();

        PowerMockito.mockStatic(Injector.class);
        PowerMockito.when(Injector.getApplicationComponent()).thenReturn(applicationComponentTest);

        ((ApplicationComponentTest) Injector.getApplicationComponent()).inject(this);
    }

    @Ignore
    @Test
    public void ActivityShouldNotBeNull() throws Exception {
        activity = Robolectric.setupActivity(EditActivity.class);
        reference_txt = (EditText) activity.findViewById(R.id.reference_txt);
        assertThat(activity).isNotNull();
    }
}
