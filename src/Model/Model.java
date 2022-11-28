package Model;

import Util.PropertyChangeSubject;

public interface Model extends PropertyChangeSubject
{
  void uploadItem(int price, String title, String desc, String subCategory);
}
