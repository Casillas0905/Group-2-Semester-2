package Client.View.PrincipalPage;

import Shared.TransferObjects.CommentButton;
import Shared.TransferObjects.Item;
import javafx.scene.control.Button;

public class DataRow
{
  private Item item;
  private CommentButton button;

  public DataRow(Item item)
  {
    this.item = item;
    this.button = new CommentButton(new Button("Comment"));
  }

  public Item getItem()
  {
    return item;
  }

  public CommentButton getButton()
  {
    return button;
  }
}
