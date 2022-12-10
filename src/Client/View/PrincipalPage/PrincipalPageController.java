package Client.View.PrincipalPage;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Shared.TransferObjects.Item;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class PrincipalPageController
{
  private ViewHandler viewHandler;
  private PrincipalPageViewModel principalPageViewModel;

  @FXML
  private TableView <Item> itemsTable;
  @FXML
  private TableColumn <Item, String> pictureColumn;
  @FXML
  private TableColumn <Item, String> userColumn;
  @FXML
  private TableColumn <Item, String> titleColumn;
  @FXML
  private TableColumn <Item, String> priceColumn;
  @FXML
  private TableColumn <Item, String> detailsColumn;

  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    principalPageViewModel = vmf.getPrincipalPageViewModel();

    itemsTable.setItems(principalPageViewModel.getItemsSection());

    pictureColumn.setCellValueFactory(new PropertyValueFactory<>("picture"));

    userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    detailsColumn.setCellValueFactory(new PropertyValueFactory<>("subCategory"));

  }

  @FXML
  public void onProfile()
  {
    System.out.println("profile button pressed");
  }

  @FXML
  public void onPostItem()
  {
    viewHandler.openPostItemView();
  }
}
