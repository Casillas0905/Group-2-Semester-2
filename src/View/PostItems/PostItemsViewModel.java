package View.PostItems;

import Model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PostItemsViewModel
{
  private Model model;
  private StringProperty title, description, subCategory, price;


  public PostItemsViewModel(Model model)
  {
    this.model = model;
    title = new SimpleStringProperty();
    description = new SimpleStringProperty();
    subCategory = new SimpleStringProperty();
    price = new SimpleStringProperty();
  }

  public StringProperty titleProperty()
  {
    return title;
  }


  public StringProperty descriptionProperty()
  {
    return description;
  }


  public StringProperty subCategoryProperty()
  {
    return subCategory;
  }


  public StringProperty priceProperty()
  {
    return price;
  }

  void uploadItem()
  {
    String titleInput = title.get();
    String descInput = description.get();
    String subCategoryInput = subCategory.get();
    String priceInput = price.get();

    model.uploadItem(priceInput, titleInput, descInput, subCategoryInput);
  }

  public void clear()
  {
    title.setValue("");
    description.setValue("");
    subCategory.setValue("");
    price.setValue("");
  }
}
