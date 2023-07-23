package org.myalerts.plugin.httprequesthelper;

import org.myalerts.domain.TestScenarioRunHelper;
import org.myalerts.provider.HelpersProvider;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

import java.util.stream.Stream;

/**
 * @author Mihai Surdeanu
 * @since 1.0.0
 */
public class HttpRequestHelperPlugin extends Plugin {

    public HttpRequestHelperPlugin(final PluginWrapper wrapper) {
        super(wrapper);
    }

    @Extension
    public static class HttpRequestHelperProvider implements HelpersProvider {

        @Override
        public Stream<TestScenarioRunHelper> getTestScenarioRunHelpersAsStream() {
            return Stream.of(TestScenarioRunHelper.builder()
                    .name("httpRequest")
                    .descriptionKey("plugin.http-request-helper.description")
                    .helperSupplier(HttpRequestHelper::new)
                    .build());
        }

    }

}
