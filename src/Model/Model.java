package Model;

import Util.PropertyChangeSubject;

public interface Model extends PropertyChangeSubject
{
  Item uploadItem(String price, String title, String desc, String subCategory);
  void setUser(String user);
}
