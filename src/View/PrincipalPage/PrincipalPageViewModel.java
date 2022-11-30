package View.PrincipalPage;

import Model.Model;
import Model.Item;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;

public class PrincipalPageViewModel
{
  private Model model;
  private ObservableList<Item> itemsSection;

  public PrincipalPageViewModel(Model model)
  {
    this.model = model;
    itemsSection = FXCollections.observableArrayList();
    model.addListener(this::itemsTable, "itemPosted");
  }

  private void itemsTable(PropertyChangeEvent event)
  {
    itemsSection.add((Item) event.getNewValue());
  }

  public ObservableList<Item> getItemsSection()
  {
    return itemsSection;
  }
}
