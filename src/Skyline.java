import java.util.*;

public class Skyline {

    private int[] silhouette = new int[]{1,11,3,13,9,0,12,7,16,3,19,18,22,3,23,13,29};
    private ArrayList<Building> buildings;


    public Skyline(ArrayList<Building> temp){
        buildings.addAll(temp);

    }

    /**
     *
     */

    public void mergeS() {

        mergeS();
        mergeS();
        //Merge();
    }

    private void mergeTwoBuildings(Building a, Building b) {
        if (a.getRight() < b.getRight()){
            merge(b,a);

        } else {
            merge(a,b);
        }
    }

    private void merge(Building a, Building b){
        if (a.getLeft() < b.getRight()){
            if(a.getHeight() > b.getHeight()){
                b.setRight(a.getLeft());
                if(b.getRight()<b.getLeft()){
                    buildings.remove(b);
                }
            } else{
                a.setLeft(b.getRight());
                if(a.getRight()<a.getLeft()){
                    buildings.remove(a);
                }
            }
        }
    }



    /**
     * Opgave a
     *
     * @param l - venstre
     * @param h - hoejde
     * @param r - hoejre
     */

    public void addBuilding(int l, int h, int r) {
        int[] temp = new int[silhouette.length+1]; //array with all x's

        //makes the array
        for (int i = 0; i <silhouette.length; i+=2){
            int incrementer = 0;
            temp[incrementer]= silhouette[i];
            incrementer++;
        }

        while(true){

        }

    }
}
