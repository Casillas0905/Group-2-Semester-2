package Model;

public class Item
{
  private User user;
  private int price;
  private String title, description, subCategory;
  private boolean sold;

  public Item(User user, int price, String title, String description, String subCategory)
  {
    this.user = user;
    this.price = price;
    this.title = title;
    this.description = description;
    this.subCategory = subCategory;
    sold=false;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public int getPrice()
  {
    return price;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getSubCategory()
  {
    return subCategory;
  }

  public void setSubCategory(String subCategory)
  {
    this.subCategory = subCategory;
  }

  public boolean isStatus()
  {
    return sold;
  }

  public void setStatusAsSold()
  {
    sold=true;
  }
}
