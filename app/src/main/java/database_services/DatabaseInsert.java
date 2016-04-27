package database_services;

import android.content.Context;

import io.realm.Realm;
import model.Suggestion;

/***
 * Created by Ivan on 27/04/2016.
 */

public class DatabaseInsert {

    private Realm realm;
    private Context context;

    public DatabaseInsert(Context context){
        this.context = context;
        realm = Realm.getInstance(context);
    }

    public void insertNewSuggestion(Suggestion suggestion){








    }
}
