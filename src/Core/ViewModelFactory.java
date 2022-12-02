package Core;

import View.Login.LoginViewModel;
import View.PostItems.PostItemsViewModel;
import View.PrincipalPage.PrincipalPageViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private LoginViewModel loginViewModel;
  private PostItemsViewModel postItemsViewModel;
  private PrincipalPageViewModel principalPageViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public LoginViewModel getLoginViewModel()
  {
    if(loginViewModel == null)
    {
      loginViewModel = new LoginViewModel(modelFactory.getModel());
    }
    return loginViewModel;
  }

  public PostItemsViewModel getPostItemsViewModel()
  {
    if(postItemsViewModel == null)
    {
      postItemsViewModel = new PostItemsViewModel(modelFactory.getModel());
    }
    return postItemsViewModel;
  }

  public PrincipalPageViewModel getPrincipalPageViewModel()
  {
    if(principalPageViewModel == null)
    {
      principalPageViewModel = new PrincipalPageViewModel(modelFactory.getModel());
    }
    return principalPageViewModel;
  }

}
