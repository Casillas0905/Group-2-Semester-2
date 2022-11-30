package View.PostItems;

import Core.ViewHandler;
import Core.ViewModelFactory;
import View.PrincipalPage.PrincipalPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PostItemController
{
  private ViewHandler viewHandler;
  private PostItemsViewModel postItemsViewModel;

  @FXML
  public TextArea description;
  @FXML
  public TextField price;
  @FXML
  public TextField subCategory;
  @FXML
  public TextField title;

  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    this.postItemsViewModel = vmf.getPostItemsViewModel();

    title.textProperty().bindBidirectional(postItemsViewModel.titleProperty());
    price.textProperty().bindBidirectional(postItemsViewModel.priceProperty());
    description.textProperty().bindBidirectional(postItemsViewModel.descriptionProperty());
    subCategory.textProperty().bindBidirectional(postItemsViewModel.subCategoryProperty());

  }

  @FXML
  public void onUpload()
  {
    postItemsViewModel.uploadItem();
    postItemsViewModel.clear();
    viewHandler.openPrincipalPageView();
  }
  @FXML
  public void onCancel(){viewHandler.openPrincipalPageView();}
}
