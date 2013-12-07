package pl.bd2.shop2013.wicket.forms;

import org.apache.wicket.extensions.markup.html.form.select.Select;
import org.apache.wicket.extensions.markup.html.form.select.SelectOptions;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import pl.bd2.shop2013.domain.Category;
import pl.bd2.shop2013.dto.CategoryDTO;
import pl.bd2.shop2013.service.ICategoryService;
import pl.bd2.shop2013.wicket.pages.SimplePage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 21.08.13
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
public class CategoryForm extends Form<CategoryDTO> {


    @SpringBean
    ICategoryService categoryService;

    private TextField<String> nameField;
    private PropertyModel<String> namePropertyModel;
    private PropertyModel<Long> parentIdPropertyModel;
    private PropertyModel<Category> categoryPropertyModel;
    private Model<CategoryDTO> myModel;

    private Category category;
    private List<Category> categories;

    public CategoryForm(String id) {
        super(id);

        CategoryDTO categoryDTO = new CategoryDTO();
        myModel = new Model<CategoryDTO>(categoryDTO);
        setModel(myModel);

        namePropertyModel = new PropertyModel<String>(categoryDTO,"name");
        parentIdPropertyModel = new PropertyModel<Long>(categoryDTO, "parentId");

        nameField = new TextField<String>("name", namePropertyModel);
        add(nameField);

        categoryPropertyModel = new PropertyModel<Category>(this, "category");
        ChoiceRenderer<Category> choiceRenderer = new ChoiceRenderer<Category>("name");
        PropertyModel<List<? extends Category>> categoriesPropertyModel = new PropertyModel<List<? extends Category>>(this, "categories");
        DropDownChoice<Category> categoryList = new DropDownChoice<Category>(
                "categories",
                categoryPropertyModel,
                categoriesPropertyModel,
                choiceRenderer){
            @Override
            protected void onConfigure() {
            }
        };
        add(categoryList);
    }

    public CategoryForm(String id, IModel<CategoryDTO> model) {
        super(id, model);
    }

    public void onSubmit(){
        if(categoryPropertyModel.getObject() != null)
            parentIdPropertyModel.setObject(categoryPropertyModel.getObject().getId());
        else
            parentIdPropertyModel.setObject(null);

        Category category = getModelObject().createObject();
        Category parentCategory = categoryService.getItemById(getModelObject().getParentId());
        category.setParentCategory(parentCategory);
        categoryService.create(category);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}