import java.awt.*;

public class SmallDino {
    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;

    //constructor
    public SmallDino(int pXpos, int pYpos, int pdx, int pdy){
        xpos=pXpos;
        ypos=pYpos;
        dx=pdx;
        dy=pdy;
        width=100;
        height=100;
        isAlive = true;
        rec=new Rectangle (xpos,ypos,width,height);
    }

    public void move(){
        xpos=xpos-dx;
        ypos=ypos-dy;
        rec=new Rectangle (xpos,ypos,width,height);
        if (xpos>1000){
            dx=-dx;
            width=-width;
        }
        if (xpos<100){
            dx=-dx;
            width=-width;
        }
        if (ypos>600) {
            dy=-dy;
        }
        if (ypos<400){
            dy=-dy;
        }
    }
}
