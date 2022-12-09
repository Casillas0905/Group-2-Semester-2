package Shared.TransferObjects;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class CustomImage implements Serializable
{

  public CustomImage(ImageView imageView)
  {
    imageView = new ImageView();
  }


}
