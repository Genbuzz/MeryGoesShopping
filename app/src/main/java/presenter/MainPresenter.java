package presenter;

import view.MainScreen;

/***
 * Created by Ivan on 02/05/2016.
 */

public class MainPresenter {


    public MainPresenter() {
    }

    public void onShowListButtonClick(MainScreen mainScreen){
        mainScreen.launchFragmentListDetail();
    }

}
