package web_2.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestObj {
    private Double x;
    private Double y;
    private Double r;
    private boolean is_hit;
    long microseconds;
    String date;


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setDate() {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        this.date = ft.format(dNow);
    }

    public void setMicroseconds(long microseconds) {
        this.microseconds = microseconds;
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

    public String getDate() {
        return date;
    }

    public String getMicroseconds() {
        return String.format("%.6f",(double) microseconds/10000000);
    }

    public boolean isIs_hit() {
        return is_hit;
    }

    public void check_hit() {
        long start = System.nanoTime();
        if (x == null || y == null || r == null) throw new NullPointerException();
        else if ((x >= 0) && (y <= 0)) is_hit = (x <= r / 2) && (y >= -r);
        else if ((x >= 0) && (y >= 0)) is_hit = (x * x) + (y * y) <= (r / 2) * (r / 2);
        else if ((x <= 0) && (y >= 0)) is_hit = (y / 2) - x <= r / 2;
        else if ((x <= 0) && (y <= 0)) is_hit = false;
        long end = System.nanoTime();
        setMicroseconds(end-start);
    }
}
