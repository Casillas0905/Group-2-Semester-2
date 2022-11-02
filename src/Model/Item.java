package Model;

public class Item
{
  private User user;
  private int price;
  private String title, description, subCategory;
  private boolean status;

  public Item(User user, int price, String title, String description, String subCategory)
  {
    this.user = user;
    this.price = price;
    this.title = title;
    this.description = description;
    this.subCategory = subCategory;
  }
}
