import java.awt.*;

public class flydino {
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;

    public flydino(int pXpos, int pYpos, int pdx, int pdy){
        xpos=pXpos;
        ypos=pYpos;
        dx=pdx;
        dy=pdy;
        width=200;
        height=200;
        isAlive = true;
        rec=new Rectangle (xpos,ypos,width,height);
    }

    public void move(){
        xpos=xpos-dx;
        ypos=ypos-dy;
        rec=new Rectangle (xpos,ypos,width,height);
        if (xpos>800){
            dx=-dx;
        }
        if (xpos<0){
            dx=-dx;
        }
        if (ypos>500) {
            dy=-dy;
        }
        if (ypos<0){
            dy=-dy;
        }

    }
}
