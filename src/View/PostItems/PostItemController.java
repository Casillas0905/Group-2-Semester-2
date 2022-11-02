package View.PostItems;

import Core.ViewHandler;
import javafx.fxml.FXML;

import java.awt.*;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class PostItemController
{
  @FXML
  private Label titleLabel;
  @FXML
  private TextField descriptionField;
  @FXML
  private TextField priceField;

  private PostItemViewModel postItemViewModel;
  private ViewHandler viewHandler;

  //need change
  public void init(PostItemViewModel postItemViewModel, ViewHandler viewHandler)
  {
    this.postItemViewModel = postItemViewModel;
    this.viewHandler = viewHandler;
    titleLabel.textProperty().bind(postItemViewModel.titleProperty());
    descriptionField.textProperty().bind(postItemViewModel.descriptionProperty());

  }


  @FXML
  private void onUploadButton()
  {

  }
}
