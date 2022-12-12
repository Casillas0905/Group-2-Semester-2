package Client.View.PrincipalPage;

import Client.Model.Model;
import Database.Database;
import Database.DatabaseMethods;
import Shared.TransferObjects.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.sql.SQLException;

public class PrincipalPageViewModel
{
  private Model model;
  private ObservableList<Item> itemsSection;
  private  Database database= new DatabaseMethods();

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

  public ObservableList<Item> getItemsSection() throws SQLException
  {
    itemsSection= database.getAllItems();
    return itemsSection;
  }

}
