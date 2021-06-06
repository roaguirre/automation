import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;
import sut.steps.YoutubeSteps;

import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(JUnitReportingRunner.class)
public class WebTest extends JUnitStories {
    private final URL classFile;
    private static final Logger log = Logger.getLogger(String.valueOf(MethodHandles.lookup().lookupClass()));

    public WebTest() {
        super();
        classFile = codeLocationFromClass(this.getClass());
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    @Override
    public Configuration configuration() {
        Configuration jbehaveConfiguration = new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
        return jbehaveConfiguration;
    }

    // Here we specify the steps classes
    @Override
    public InjectableStepsFactory stepsFactory() {
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new YoutubeSteps());
    }

    protected List<String> storyPaths(){
        return new StoryFinder().findPaths(classFile.getFile(),
                Collections.singletonList("**/" + System.getProperty("story.name", "*") + ".story"),
                Collections.singletonList(""));
    }
}
