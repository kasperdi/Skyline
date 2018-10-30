import java.util.*;

public class Skyline {

    //public int[] skyline = new int[0];
    public ArrayList<Building> buildings;


    public Skyline(ArrayList<Building> temp){
        buildings.addAll(temp);

    }

    /**
     *
     */

    public void MergeS() {

        MergeS();
        MergeS();
        Merge();
    }

    private void Merge() {

    }



    /**
     * Opgave a
     *
     * @param l - venstre
     * @param h - hoejde
     * @param r - hoejre
     */

    public void Insert(int l, int h, int r) {

    }

}
