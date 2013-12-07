package pl.bd2.shop2013.wicket.pages;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import pl.bd2.shop2013.domain.Category;
import pl.bd2.shop2013.service.ICategoryService;
import pl.bd2.shop2013.wicket.forms.CategoryForm;
import pl.bd2.shop2013.wicket.service.HelloService;

import java.util.List;


public class SimplePage extends AbstractMainLayout {

    private String name;
    private Long parentId;

    @SpringBean
    private HelloService helloService;

    @SpringBean
    private ICategoryService categoryService;

    private List<Category> categories;

    public SimplePage() {
//        set title page
        initTitleLabel("Categories");
//        main container
        WebMarkupContainer container = new WebMarkupContainer("container");

        /*FORM*/
        CategoryForm categoryForm = new CategoryForm("categoryForm") {
            @Override
            protected void onConfigure() {
                categories = categoryService.findItems();
                setCategories(categories);
            }
        };

        container.add(categoryForm);

        container.add(new ListView<Category>("categoryList", new PropertyModel<List<? extends Category>>(this, "categories")) {
            @Override
            protected void populateItem(ListItem<Category> components) {
                final Category cat = components.getModelObject();
                components.add(new Label("id", cat.getId()));
                components.add(new Label("name", cat.getName()));
                if (cat.getParentCategory() != null) {
                    components.add(new Label("displayParentId", cat.getParentCategory().getId()));
                    components.add(new Label("displayParent", cat.getParentCategory().getName()));
                } else {
                    components.add(new Label("displayParentId", "brak"));
                    components.add(new Label("displayParent", "brak"));
                }

            }
        });

        add(container);


//        ajax learning
        Model<Integer> model = new Model<Integer>() {
            private int counter = 0;

            public Integer getObject() {
                return counter++;
            }
        };

        final Label label = new Label("counter", model);
        label.setOutputMarkupId(true);
        add(new AjaxFallbackLink("link") {
            public void onClick(AjaxRequestTarget target) {
                if (target != null) {
                    // target is only available in an Ajax request
                    target.add(label);
                }
            }
        });

        add(label);
    }
}
