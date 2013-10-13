package pl.solsoft.shop2013.wicket.pages;

import org.apache.wicket.bootstrap.Bootstrap;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 22.08.13
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class AbstractMainLayout extends WebPage {

    private Label titleLabel;

    public void initTitleLabel(String title){
        titleLabel = new Label("title", title);
        add(titleLabel);
    }

    @Override
    public void renderHead(IHeaderResponse container) {
        super.renderHead(container);
        Bootstrap.renderHeadPlain(container);
    }
}
