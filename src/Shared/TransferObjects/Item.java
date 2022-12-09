package Shared.TransferObjects;

import java.io.Serializable;

public class Item implements Serializable
{
  private String picture;
  private String user;
  private String price;
  private String title, description, subCategory;
  private boolean sold;

  public Item(String picture, String user, String price, String title, String description, String subCategory)
  {
    this.picture = picture;
    this.user = user;
    this.price = price;
    this.title = title;
    this.description = description;
    this.subCategory = subCategory;
    sold=false;
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

  public String getPrice()
  {
    return price;
  }

  public void setPrice(String price)
  {
    this.price = price;
  }

  public String getUser()
  {
    return user;
  }

  public void setUser(String user)
  {
    this.user = user;
  }

  public String getPicture()
  {
    return picture;
  }
}
