public class Building {

    private int left;
    private int height;
    private int right;

    public Building(int l,int h,int r){
        left = l;
        height = h;
        right = r;
    }

    public Building(int l,int h){
        left = l;
        height = h;
    }

    public String toString(){
        return "(" + left + ", " + height + ")";
    }

    public String toStringAlternative(){
        return "(" + left + ", " + height + ", " + right + ") ";
    }

    // getters and setters
    public int getLeft() {
        return left;
    }

    public int getHeight() {
        return height;
    }

    public int getRight() {
        return right;
    }
}


