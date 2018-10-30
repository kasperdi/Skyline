public class Building {

    private int left;
    private int height;
    private int right;

    public Building(int l,int h,int r){
        left = l;
        height = h;
        right = r;
    }

    public String toString(){
        return "(" + left + ", " + height + ", " + right + ")";
    }

    // getters and setters
    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

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


