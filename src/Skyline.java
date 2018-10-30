import java.util.*;

public class Skyline {

    private ArrayList<Building> buildings;


    public Skyline(ArrayList<Building> temp){
        buildings = new ArrayList<>();
        buildings.addAll(temp);
    }

    public Skyline(int[] a){
        buildings = new ArrayList<>();
        for(int i = 0; i < a.length-2; i+=2){
            Building temp = new Building(a[i], a[i+1], a[i+2]);
            buildings.add(temp);
        }
    }


    /**
     *
     */

    public void mergeS() {

        mergeS();
        mergeS();
       // mergeTwoBuildings(buildings.get(i), buildings.get(j));
    }


    private void mergeTwoBuildings(Building a, Building b) {
        if (a.getRight() < b.getRight()){
            merge(b,a);

        } else {
            merge(a,b);
        }
    }

    private void merge(Building a, Building b){ //helper method
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
        Building temp = new Building(l,h,r);
        int index = 0;
        int indexFinder = 1;
        for(Building b : buildings){

            mergeTwoBuildings(temp,b);

            if(temp.getLeft() == b.getRight()){
                index = indexFinder;
            }
            indexFinder++;
        }

        buildings.add(index,temp);

        for(Building b : buildings){
            System.out.println(b.toString());
        }

    }
}
