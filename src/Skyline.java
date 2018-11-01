import java.util.*;

public class Skyline {

    private Building[] buildings;



    /**
     * Creates new skyline from input
     */

    public Skyline(Building[] a) {
       buildings = a;
    }


    public void updateBuildings(){
        buildings = findSkyline2(buildings, 0, buildings.length-1);
    }

    public Building[] getBuildings() {
        return buildings;
    }


    /**
     * Finds the skyline of a given Building array
     *
     * @param buildingArray - An array of Buildings
     * @return - Returns a Building array representing the skyline
     */


    public Building[] findSkyline(Building[] buildingArray) {

        int length = buildingArray.length;

        /*
            We are on the lowest layer: only a single building is contained in our array.
            We therefore return the building as a skyline
        */

        if (length == 1) {
            Building[] skylineBuilding = new Building[2];
            skylineBuilding[0] = new Building(buildingArray[0].getLeft(), buildingArray[0].getHeight()); //building start and height
            skylineBuilding[1] = new Building(buildingArray[0].getRight(), 0); //building end
            return skylineBuilding;
        }

        //Calls recursively on the first half of the buildings
        Building[] skylineLeft = findSkyline(Arrays.copyOfRange(buildingArray, 0, length / 2));
        //calls recursively on the second half
        Building[] skylineRight = findSkyline(Arrays.copyOfRange(buildingArray, length / 2+1, length));

        return mergeSkylines(skylineLeft, skylineRight);
    }

    public Building[] findSkyline2(Building[] buildingArray,int p, int q) {

        int mid = (p+q)/2;
        int length = buildingArray.length;

        /*
            We are on the lowest layer: only a single building is contained in our array.
            We therefore return the building as a skyline
        */

        if (p == q) {
            Building[] skylineBuilding = new Building[2];
            skylineBuilding[0] = new Building(buildingArray[p].getLeft(), buildingArray[p].getHeight()); //building start and height
            skylineBuilding[1] = new Building(buildingArray[p].getRight(), 0); //building end
            return skylineBuilding;
        }

        //Calls recursively on the first half of the buildings
        Building[] skylineLeft = findSkyline2(buildingArray, p, mid);
        //calls recursively on the second half
        Building[] skylineRight = findSkyline2(buildingArray, mid+1, q);

        return mergeSkylines(skylineLeft, skylineRight);
    }


    /**
     * Opg b : merges two skylines
     * @param skyline1 - skyline 1
     * @param skyline2 - skyline 2
     */

    private Building[] mergeSkylines(Building[] skyline1, Building[] skyline2) {

        //Resultant skyline with length being the sum of lengths of original 2 skylines
        Building[] skylineResult = new Building[skyline1.length + skyline2.length];

        //Current height information of 2 arrays
        int currentHeight1 = 0;
        int currentHeight2 = 0;
        int Currentx = 0;

        //indexes of the two arrays
        int i = 0;
        int j = 0;

        int slIndex = 0;

        //Merges the two skylines mergesort-style
        while (i < skyline1.length && j < skyline2.length) {
            if (skyline1[i].getLeft() < skyline2[j].getLeft()) {

                Currentx = skyline1[i].getLeft();
                currentHeight1 = skyline1[i].getHeight();

                skylineResult[slIndex] = new Building(Currentx, Math.max(currentHeight1,currentHeight2));
                i++;
                slIndex++;

            } else {

                Currentx = skyline2[j].getLeft();
                currentHeight2 = skyline2[j].getHeight();

                skylineResult[slIndex] = new Building(Currentx, Math.max(currentHeight1,currentHeight2));
                j++;
                slIndex++;
            }
        }

        // adds remaining buildings from the other skyline.
        if (i < skyline1.length) {
            while (i < skyline1.length) {
                skylineResult[slIndex] = skyline1[i];
                i++;
                slIndex++;
            }
        } else if (j < skyline2.length) {
            while (j < skyline2.length) {
                skylineResult[slIndex] = skyline2[j];
                j++;
                slIndex++;
            }
        }

        return skylineResult;
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
     */
    /*
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
            System.out.println(b.toStringAlternative());
        }


        System.out.println("");
        System.out.print("(");
        for(Building b : buildings){
            System.out.print(b.getLeft() + ", " + b.getHeight() + ", ");
        }
        System.out.print(")");

    }
*/

    private ArrayList<Building> ArrayToBuilding(int[] a){
        ArrayList<Building> temp = new ArrayList<>();

        for(int i = 0; i < a.length-2; i+=2){
            Building build = new Building(a[i], a[i+1], a[i+2]);
            temp.add(build);
        }
        return temp;
    }
}
