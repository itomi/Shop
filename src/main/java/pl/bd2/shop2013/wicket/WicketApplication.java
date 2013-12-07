package pl.bd2.shop2013.wicket;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.stereotype.Component;
import pl.bd2.shop2013.wicket.pages.NextPage;
import pl.bd2.shop2013.wicket.pages.SimplePage;

@Component(value = "wicketApplication")
public class WicketApplication extends WebApplication {

    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public Class<SimplePage> getHomePage() {

        mountBookmarkablePages();
        return SimplePage.class; // return default page
    }

    @Override
    protected void init() {

        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

        getMarkupSettings().setDefaultMarkupEncoding(DEFAULT_ENCODING);
        getRequestCycleSettings().setResponseRequestEncoding(DEFAULT_ENCODING);

        // (...)

        if (getConfigurationType().equals(WebApplication.CONFIGURATION)) {
            getMarkupSettings().setStripWicketTags(true);
            getMarkupSettings().setStripComments(true);
            getMarkupSettings().setCompressWhitespace(true);
        }
    }

    private void mountBookmarkablePages() {
//        mountPage("NextPage", NextPage.class);
    }

}