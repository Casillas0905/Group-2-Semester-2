package Model;

import Util.PropertyChangeSubject;

public interface Model extends PropertyChangeSubject
{
  void uploadItem(User user, int price, String title, String desc, String subCategory);
}
