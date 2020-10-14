package web_2.data;

public class RequestObj {

    private Double x;
    private Double y;
    private Double r;
    private boolean is_hit;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isIs_hit() {
        return is_hit;
    }

    public void setIs_hit(boolean is_hit) {
        this.is_hit = is_hit;
    }
    
    public void check_hit() {
        if (x == null || y == null || r == null) throw new NullPointerException();
        if ((x == 0 && Math.abs(y) <= r) || (y == 0 && Math.abs(x) <= r)) is_hit = true;
        else if ((x > 0) && (y < 0)) is_hit = (x <= r / 2) && (y >= -r);
        else if ((x > 0) && (y > 0)) is_hit = false;
        else if ((x < 0) && (y > 0)) is_hit = y - x <= r;
        else if ((x < 0) && (y < 0)) is_hit = x * x + y * y <= (-r / 2) * (-r / 2);
    }
}
