
public class Main {
    public static void main(String args[]) {

        Building[] b = new Building[8];

        b[0] = new Building(1,11,5);
        b[1] = new Building(2,6,7);
        b[2] = new Building(3,13,9);
        b[3] = new Building(12,7,16);
        b[4] = new Building(14,3,25);
        b[5] = new Building(19,18,22);
        b[6] = new Building(23,13,29);
        b[7] = new Building(24,4,28);

        Skyline sl = new Skyline(b);

        sl.updateBuildings();



    }
}
