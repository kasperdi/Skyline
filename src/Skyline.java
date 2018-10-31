import java.util.*;

public class Skyline {

    private ArrayList<Building> buildings;



    /**
     * Creates new skyline from input
     */
    public Skyline(ArrayList<Building> temp) {
        buildings = new ArrayList<>();
        buildings.addAll(temp);
    }

    public Skyline(int[] a) {
        buildings = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i += 2) {
            Building temp = new Building(a[i], a[i + 1], a[i + 2]);
            buildings.add(temp);
        }
    }


    /**
     * findSkyline is very similar to mergeSort, in that it splits the problem up into small parts
     * using divide and conquer, and then solves the subproblems recursively.
     */

    public Building[] findSkyline(Building[] arr, int start, int end) {


        if (start == end) {
            Building[] result = new Building[0];
            return result;
        }

        int mid = (start + end) / 2;

        Building[] skylineLeft = findSkyline(arr, 0, mid);
        Building[] skylineRight = findSkyline(arr, mid + 1, arr.length);
        mergeSkylines(skylineLeft, skylineRight);

        return null;
    }

    public void mergeSkylines(Building[] arr1, Building[] arr2) {

        //Resultant skyline with length being the sum of lengths of original 2 skylines
        int[] skylineResult = new int[arr1.length + arr2.length];

        //Current height information of 2 arrays
        int h1 = 0;
        int h2 = 0;

        //indexes of the two arrays
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].getLeft() < arr2[j].getLeft()) {
                int x1 = arr1[i].getLeft();
                h1 = arr1[i].getHeight();

                int currentHeight = Math.max(arr1[i].getHeight(), arr1[j].getHeight());
                i++;

            } else {

                int x2 = arr1[j].getLeft();
                h2 = arr1[j].getHeight();

                int currentHeight = Math.max(arr1[i].getHeight(), arr1[j].getHeight());
                j++;

            }


        }

        System.out.println(skylineResult);
    }


    private void mergeTwoBuildings(Building a, Building b) {
        if (a.getLeft() < b.getLeft() && a.getRight() > b.getLeft()) {
            if (a.getHeight() < b.getHeight()) {
                a.setRight(b.getLeft());
            } else {
                b.setLeft(a.getRight());
            }
        } else if (b.getLeft() < a.getLeft() && b.getRight() > a.getLeft()) {
            if (b.getHeight() < a.getHeight()) {
                b.setRight(a.getLeft());
            } else {
                a.setLeft(b.getRight());
            }
        }
    }


    /**
     * Opgave a - unnecessary after method: merge skyline
     *
     * @param l - venstre
     * @param h - hoejde
     * @param r - hoejre
     */

    public void addBuilding(int l, int h, int r) {
        Building temp = new Building(l, h, r);
        int index = 0;
        int indexFinder = 1;
        for (Building b : buildings) {

            mergeTwoBuildings(temp, b);

            if (temp.getLeft() == b.getRight()) {
                index = indexFinder;
            }
            indexFinder++;
        }

        buildings.add(index, temp);

        for (Building b : buildings) {
            System.out.println(b.toString());
        }

        /*
        System.out.println("");
        System.out.print("(");
        for(Building b : buildings){
            System.out.print(b.getLeft() + ", " + b.getHeight() + ", ");
        }
        System.out.print(")");
        */
    }


    private ArrayList<Building> ArrayToBuilding(int[] a) {
        // ArrayList<Building>
        for (int i = 0; i < a.length - 2; i += 2) {
            Building temp = new Building(a[i], a[i + 1], a[i + 2]);
            buildings.add(temp);
        }


        return null;
    }

}
