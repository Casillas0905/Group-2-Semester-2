package Client.View.PostItems;

import Client.Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public class PostItemsViewModel
{
  private Model model;
  private StringProperty title, description, subCategory, price, picture, error;



  public PostItemsViewModel(Model model)
  {
    this.model = model;
    title = new SimpleStringProperty();
    picture = new SimpleStringProperty();
    description = new SimpleStringProperty();
    subCategory = new SimpleStringProperty();
    price = new SimpleStringProperty();
    error = new SimpleStringProperty();
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

  void uploadItem() throws SQLException
  {
    String titleInput = title.get();
    String descInput = description.get();
    String subCategoryInput = subCategory.get();
    String priceInput = price.get();
    String pictureInput = picture.get();

    model.uploadItem(pictureInput, priceInput, titleInput, descInput, subCategoryInput);

    error.set("");

      System.out.println("item uploaded...");

  }

  void showError()
  {
    error.set("Please, write valid inputs");
  }

  public void clear()
  {
    title.setValue("");
    description.setValue("");
    subCategory.setValue("");
    price.setValue("");
    picture.setValue("");
  }

  public StringProperty pictureProperty()
  {
    return picture;
  }


  public StringProperty errorProperty()
  {
    return error;
  }
}
