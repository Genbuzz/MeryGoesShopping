package model;

/***
 * Created by Ivan on 27/04/2016.
 */

public class Suggestion {

    private int id;
    private String name;

    public Suggestion(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
