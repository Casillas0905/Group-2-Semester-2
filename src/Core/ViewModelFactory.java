package Core;

import View.PostItems.PostItemViewModel;

public class ViewModelFactory
{
  private PostItemViewModel postItemViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public PostItemViewModel getPostItemViewModel()
  {
    if(postItemViewModel==null)
    {
      postItemViewModel = new PostItemViewModel(modelFactory.getModel());
    }
    return postItemViewModel;
  }
}
