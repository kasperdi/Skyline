import java.util.*;

public class Skyline {

    private Building[] buildings;

    /**
     * Creates new skyline from input
     */
    public Skyline(Building[] a) {
        buildings = a;
    }

    public void updateBuildings() {
        buildings = findSkyline(buildings, 0, buildings.length - 1);
        buildings = removeRedundant(buildings);
    }

    /**
     * Removes all buildings that are the same height as the previous building.
     * @param a - building array
     * @return Building[] - Returns a building array without redundant buildings.
     */
    private Building[] removeRedundant(Building[] a) {
        int amountRemoved = 0;

        ArrayList<Building> buildArray = new ArrayList<>();

        buildArray.addAll(Arrays.asList(a));

        //Removes redundant buildings
        for (int i = buildArray.size() - 1; i > 0; i--) {
            if (buildArray.get(i).getHeight() == buildArray.get(i - 1).getHeight()) {
                buildArray.remove(i);
                amountRemoved++;
            }
        }
        return buildArray.toArray(new Building[a.length - amountRemoved]);
    }

    /**
     * Opgave c: Finds the skyline of a given building array
     *
     * @param buildingArray - An array of Buildings
     * @return - Returns a Building array representing the skyline
     */

    public Building[] findSkyline(Building[] buildingArray, int p, int q) {

        //Calculates the middle of the building array
        int mid = (p + q) / 2;

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
        Building[] skylineLeft = findSkyline(buildingArray, p, mid);
        //calls recursively on the second half
        Building[] skylineRight = findSkyline(buildingArray, mid + 1, q);

        return mergeSkylines(skylineLeft, skylineRight);
    }


    /**
     * Opgave b: Merges two skylines
     *
     * @param skyline1 - Skyline 1
     * @param skyline2 - Skyline 2
     * @return Building[] - returns the resultant building array.
     */

    private Building[] mergeSkylines(Building[] skyline1, Building[] skyline2) {

        //Resultant skyline with length being the sum of lengths of original 2 skylines
        Building[] skylineResult = new Building[skyline1.length + skyline2.length];

        //Current height information of 2 arrays
        int currentHeight1 = 0;
        int currentHeight2 = 0;

        //indexes of the two arrays
        int i = 0;
        int j = 0;

        //index of the resultant skyline
        int slIndex = 0;

        //Merges the two skylines mergesort-style
        while (i < skyline1.length && j < skyline2.length) {
            if (skyline1[i].getLeft() < skyline2[j].getLeft()) {
                currentHeight1 = skyline1[i].getHeight();
                skylineResult[slIndex] = new Building(skyline1[i].getLeft(), Math.max(currentHeight1, currentHeight2));
                slIndex++;
                i++;
            } else {
                currentHeight2 = skyline2[j].getHeight();
                skylineResult[slIndex] = new Building(skyline2[j].getLeft(), Math.max(currentHeight1, currentHeight2));
                slIndex++;
                j++;
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

    /**
     * getter method for buildings array
     * @return Building[]
     */
    public Building[] getBuildings() {
        return buildings;
    }
}
