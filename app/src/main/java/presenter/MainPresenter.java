package presenter;

import view.MainView;

/***
 * Created by Ivan on 02/05/2016.
 */

public class MainPresenter {

    /////////////////////////// ATTRIBUTES ////////////////////////////////
    private final MainView mMainView;

    ////////////////////////// CONSTRUCTOR ///////////////////////////////
    public MainPresenter(MainView mMainView) {
        this.mMainView = mMainView;
    }

    ///////////////////////////// METHOD /////////////////////////////////
    public void onCreate(){
        mMainView.setContentView();
        mMainView.launchActivityDetail();
    }

}
