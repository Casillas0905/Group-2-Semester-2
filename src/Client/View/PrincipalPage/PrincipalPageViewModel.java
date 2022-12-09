package Client.View.PrincipalPage;

import Client.Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;

public class PrincipalPageViewModel
{
  private Model model;
  private ObservableList itemsSection;

  public PrincipalPageViewModel(Model model)
  {
    this.model = model;
    itemsSection = FXCollections.observableArrayList();
    model.addListener(this::itemsTable, "itemPosted");
  }

  private void itemsTable(PropertyChangeEvent event)
  {
    itemsSection.add(event.getNewValue());
  }

  public ObservableList getItemsSection()
  {
    return itemsSection;
  }

}
