package presenter;

import javax.inject.Inject;

import screen_contract.MainScreen;

/***
 * Created by Ivan on 02/05/2016.
 */

public class MainPresenter {

    @Inject
    public MainPresenter() {
    }

    public void onShowListButtonClick(MainScreen mainScreen){
        mainScreen.launchFragmentListDetail();
    }

}
