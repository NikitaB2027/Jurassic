import java.awt.*;

public class man {
    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;

    public man(int pXpos, int pYpos, int pdx, int pdy) {
        xpos = pXpos;
        ypos = pYpos;
        dx = pdx;
        dy = pdy;
        width = 50;
        height = 140;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);
    }

    public void move(){
        xpos=xpos-dx;
        ypos=ypos-dy;
        rec=new Rectangle (xpos,ypos,width,height);
        if (xpos>950){
            dx=-dx;
        }
        if (xpos<50){
            dx=-dx;
        }
        if (ypos>560) {
            dy=-dy;
        }
        if (ypos<140){
            dy=-dy;
        }

    }
}
