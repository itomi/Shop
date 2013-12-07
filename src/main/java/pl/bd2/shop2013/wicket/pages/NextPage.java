package pl.bd2.shop2013.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 20.08.13
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */


public class NextPage extends WebPage {

    private String name = "name";
    private String old  = "year";

    public NextPage() {
        
            // This model references the page's name property and is
            // shared by the label and form component
            PropertyModel<String> messangeNameModel = new PropertyModel<String>(this, "name");
            PropertyModel<String> messangeOldModel = new PropertyModel<String>(this, "old");

            // The label displays the currently set name
            add(new Label("name", messangeNameModel));
            add(new Label("old", messangeOldModel));

            // Add a form to change the name. We don't need to do anything
            // else with this form as the shared model is automatically updated
            // on form submits
            Form<?> formulation = new Form("form");
            formulation.add(new TextField<String>("msgName", messangeNameModel));
            formulation.add(new TextField<String>("msgOld", messangeOldModel));
            add(formulation);
        }

        /**
         * @return the name
         */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }
}
