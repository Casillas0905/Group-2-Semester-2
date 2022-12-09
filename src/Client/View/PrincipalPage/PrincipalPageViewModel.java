package Client.View.PrincipalPage;

import Client.Model.Model;
import Shared.TransferObjects.Item;
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
