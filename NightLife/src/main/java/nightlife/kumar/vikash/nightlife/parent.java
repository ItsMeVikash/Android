package nightlife.kumar.vikash.nightlife;

import java.util.ArrayList;

/**
 * Created by vikash kumar on 16-12-2017.
 */

public class parent {
    public String Name;
    public ArrayList<String> parents=new ArrayList<String>();

    public parent(String Name)
    {
        this.Name=Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<String> getParents() {
        return parents;
    }

    public void setParents(ArrayList<String> parents) {
        this.parents = parents;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Name;
    }
}