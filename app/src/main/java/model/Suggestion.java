package model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/***
 * Created by Ivan on 27/04/2016.
 */

public class Suggestion extends RealmObject{

    @Ignore
    public static final String SUGGESTION_ID = "suggestion_id";
    @Ignore
    public static final String SUGGESTION_NAME = "suggestion_name";

    @PrimaryKey
    private int id;
    private String name;

    public Suggestion(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}