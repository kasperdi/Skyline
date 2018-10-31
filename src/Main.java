public class Main {
    public static void main(String args[]) {

        int[] silhouette = new int[]{1,11,3,13,9,0,12,7,16,3,19,18,22,3,23,13,29};

       Skyline sk = new Skyline(silhouette);
       sk.addBuilding(14, 6, 17);

       //sk.findSkyline()

    }
}
