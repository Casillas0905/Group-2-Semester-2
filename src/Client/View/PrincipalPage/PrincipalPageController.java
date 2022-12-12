package Client.View.PrincipalPage;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import Shared.TransferObjects.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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


  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    principalPageViewModel = vmf.getPrincipalPageViewModel();

    itemsTable.setItems(principalPageViewModel.getItemsSection());

    addButtonToTable();

    userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


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

  private void addButtonToTable() {
    TableColumn<Item, Void> colBtn = new TableColumn("Button Column");

    Callback<TableColumn<Item, Void>, TableCell<Item, Void>> cellFactory = new Callback<>() {
      @Override
      public TableCell<Item, Void> call(final TableColumn<Item, Void> param) {
        final TableCell<Item, Void> cell = new TableCell<>() {

          private final Button btn = new Button("Comment");

          {
            btn.setOnAction((ActionEvent event) -> {
              System.out.println("Comment button pressed...");
            });
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(btn);
            }
          }
        };
        return cell;
      }
    };

    colBtn.setCellFactory(cellFactory);

    itemsTable.getColumns().add(colBtn);

  }


}
