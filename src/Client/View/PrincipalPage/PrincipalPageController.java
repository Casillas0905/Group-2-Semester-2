package Client.View.PrincipalPage;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Shared.TransferObjects.CommentButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrincipalPageController
{
  private ViewHandler viewHandler;
  private PrincipalPageViewModel principalPageViewModel;

  @FXML
  private TableView <DataRow> itemsTable;
  @FXML
  private TableColumn <DataRow, String> pictureColumn;
  @FXML
  private TableColumn <DataRow, String> userColumn;
  @FXML
  private TableColumn <DataRow, String> titleColumn;
  @FXML
  private TableColumn <DataRow, String> priceColumn;
  @FXML
  private TableColumn <DataRow, CommentButton> commentColumn;



  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    principalPageViewModel = vmf.getPrincipalPageViewModel();

    itemsTable.setItems(principalPageViewModel.getItemsSection());

    pictureColumn.setCellValueFactory(new PropertyValueFactory<>("picture"));
    userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    commentColumn.setCellValueFactory(new PropertyValueFactory<>("button"));

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
