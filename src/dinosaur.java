import java.awt.*;

public class dinosaur {
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;

    public dinosaur(int pXpos, int pYpos, int pdx, int pdy){
        xpos=pXpos;
        ypos=pYpos;
        dx=pdx;
        dy=pdy;
        width=375;
        height=375;
        isAlive = true;
        rec=new Rectangle (xpos,ypos,width,height);
    }

    public void move(){
        xpos=xpos-dx;
        ypos=ypos-dy;
        rec=new Rectangle (xpos,ypos,width,height);
        if (xpos>625){
            dx=-dx;
        }
        if (xpos<0){
            dx=-dx;
        }
        if (ypos>325) {
            dy=-dy;
        }
        if (ypos<0){
            dy=-dy;
        }
    }

}
