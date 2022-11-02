package View.PostItems;

import Model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Item;

public class PostItemViewModel
{
  private Model model;
  private StringProperty title;
  private ObservableList<Item> items;
  private StringProperty description;
  private IntegerProperty price;

  //Need change
  public PostItemViewModel(Model model)
  {
    this.model = model;
    items = FXCollections.observableArrayList();
    description = new SimpleStringProperty();
    price = new SimpleIntegerProperty();
    title = new SimpleStringProperty();
  }

  public String getDescription()
  {
    return description.get();
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }

  public int getPrice()
  {
    return price.get();
  }

  //Need change
  public IntegerProperty priceProperty()
  {
    return price;
  }

  public ObservableList<Item> getItems()
  {
    return items;
  }

  public StringProperty titleProperty()
  {
    return title;
  }
}
