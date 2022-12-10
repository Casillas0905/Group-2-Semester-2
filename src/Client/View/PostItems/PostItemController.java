package Client.View.PostItems;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class PostItemController
{
  private ViewHandler viewHandler;
  private PostItemsViewModel postItemsViewModel;

  @FXML
  public TextArea description;
  @FXML
  public TextField price;
  @FXML
  public TextField picture;
  @FXML
  public TextField subCategory;
  @FXML
  public TextField title;
  @FXML
  public Label errorLabel;

  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    this.postItemsViewModel = vmf.getPostItemsViewModel();

    title.textProperty().bindBidirectional(postItemsViewModel.titleProperty());
    picture.textProperty().bindBidirectional(postItemsViewModel.pictureProperty());
    price.textProperty().bindBidirectional(postItemsViewModel.priceProperty());
    description.textProperty().bindBidirectional(postItemsViewModel.descriptionProperty());
    subCategory.textProperty().bindBidirectional(postItemsViewModel.subCategoryProperty());

    errorLabel.textProperty().bind(postItemsViewModel.errorProperty());

  }

  @FXML
  public void onUpload() throws SQLException
  {
    if(title.textProperty().get() == null || "".equals(title.textProperty().get()) || price.textProperty().get() == null || "".equals(price.textProperty().get())
    || subCategory.textProperty().get() == null || "".equals(subCategory.textProperty().get()) || picture.textProperty().get() == null || "".equals(picture.textProperty().get()))
    {
      postItemsViewModel.showError();
    }
    else
    {
      postItemsViewModel.uploadItem();
      postItemsViewModel.clear();
      viewHandler.openPrincipalPageView();
    }
  }
  @FXML
  public void onCancel(){
    viewHandler.openPrincipalPageView();
    postItemsViewModel.clear();
  }
}
