package Client.Model;

import Shared.Util.PropertyChangeSubject;

public interface Model extends PropertyChangeSubject
{
  void uploadItem(String picture, String price, String title, String desc, String subCategory);
  void setUser(String user);
}
