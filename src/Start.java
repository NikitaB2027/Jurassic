import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Start implements Runnable, KeyListener {
    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image BenPic;
    public  Image StevePic;
    public Image TedPic;
    public Image backPic;
    public Image BobPic;
    public Image BobrunPic;
    public Image eggoPic;
    public Image BobrunLPic;
    public Image BobdeadPic;

    public dinosaur Ben;
    public flydino Steve;
    public SmallDino Ted;
    public int holddx,holddy;
    public Background back;
    public man Bob;
    public String isPressed;{
        isPressed="1";
        isPressed="2";
        isPressed="3";
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Start Jurassic;
        Jurassic=new Start();
        Jurassic.run();
    }

    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public Start() {

        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game and load up
        BenPic = Toolkit.getDefaultToolkit().getImage("dino.png"); //load the picture
        Ben = new dinosaur(500,100, 2, 1);
        StevePic=Toolkit.getDefaultToolkit().getImage("flying.png");
        Steve = new flydino(10,100,3,0);
        TedPic = Toolkit.getDefaultToolkit().getImage("small.png");
        Ted = new SmallDino(300,575,10,4);
        backPic=Toolkit.getDefaultToolkit().getImage("dinoback.png");
        back=new Background (700,2656);
        BobrunPic=Toolkit.getDefaultToolkit().getImage("cavemanrun.png");
        eggoPic=Toolkit.getDefaultToolkit().getImage("eggo.png");
        BobPic=Toolkit.getDefaultToolkit().getImage("caveman.png");
        BobrunLPic=Toolkit.getDefaultToolkit().getImage("caveman runl.png");
        BobdeadPic=Toolkit.getDefaultToolkit().getImage("caveman dead.png");
        Bob=new man(500,550,0,0);


    }// BasicGameApp()

    public void run() {

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
            crash();
        }
    }

    public void crash(){
      //  System.out.println("crash");
        if(Bob.rec.intersects(Steve.rec)){
            //holddx=Bob.dx;
            //holddy=Bob.dy;
            //Bob.dx=Steve.dx;
            //Bob.dy=Steve.dy;
            //Steve.dx=holddx;
            //Steve.dy=holddx;
            Bob.isStone=true;
            Bob.dx=0;
            Bob.dy=0;
        }

    }

    public void moveThings() {
        //calls the move( ) code in the objects
        Ben.move();
        Steve.move();
        Ted.move();
        Bob.move();

    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ){
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, 700));  //sizes the JPanel
        //change the picture to the height as 700
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, 1000, HEIGHT);
        canvas.setIgnoreRepaint(true);
        canvas.addKeyListener(this);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }

    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(backPic,0,0 ,back.width, back.height,null);

        //draw the image of the astronaut
        g.drawImage(BenPic, Ben.xpos, Ben.ypos, Ben.width, Ben.height, null);
        g.drawImage(StevePic, Steve.xpos, Steve.ypos, Steve.width, Steve.height, null);
        g.drawImage(TedPic, Ted.xpos, Ted.ypos, Ted.width, Ted.height, null);
        if (isPressed=="2" && Bob.isStone==false) {
           if(Bob.lastDX>0){
               g.drawImage(BobrunLPic, Bob.xpos, Bob.ypos, 70, Bob.height, null);
           }
           if(Bob.lastDX<0 ){
               System.out.println("b");
               g.drawImage(BobrunPic, Bob.xpos, Bob.ypos, 70, Bob.height, null);
           }
       }
       if (isPressed=="3" && Bob.isStone==false){
           g.drawImage(eggoPic, Bob.xpos, Bob.ypos, 100, 100, null);
           //if(Bob.isStone==false) {
               //g.drawImage(eggoPic, Bob.xpos, Bob.ypos, 100, 100, null);
           //}
          // if(Bob.isStone==true){
               //g.drawImage(BobdeadPic, Bob.xpos, Bob.ypos, 140, 50, null);
        //  }
       }

        if(Bob.isStone==true){
            g.drawImage(BobdeadPic, Bob.xpos, Bob.ypos, 140, 50, null);
             }

        if(isPressed=="1" && Bob.isStone==false) {
            g.drawImage(BobPic, Bob.xpos, Bob.ypos, Bob.width, Bob.height, null);

        }

        g.dispose();

        bufferStrategy.show();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        isPressed="1";
        if(e.getKeyCode()==87){
            isPressed="2";
            Bob.dx=0;
            Bob.dy=4;
            if(Bob.rec.intersects(Steve.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
            if(Bob.rec.intersects(Ben.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
            if(Bob.rec.intersects(Ted.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
        }
        if(e.getKeyCode()==65){
            isPressed="2";
            Bob.dx=4;
            Bob.lastDX=Bob.dx;

            Bob.dy=0;
            if(Bob.rec.intersects(Steve.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
            if(Bob.rec.intersects(Ben.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
            if(Bob.rec.intersects(Ted.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
        }
        if(e.getKeyCode()==83){
            isPressed="2";
            Bob.dx=0;
            Bob.dy=-4;
            if(Bob.rec.intersects(Steve.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
            if(Bob.rec.intersects(Ben.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
            if(Bob.rec.intersects(Ted.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
        }
        if(e.getKeyCode()==68){
            isPressed="2";
            Bob.width=-50;
            Bob.dx=-4;
            Bob.lastDX=Bob.dx;

            Bob.dy=0;
            if(Bob.rec.intersects(Steve.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
            if(Bob.rec.intersects(Ben.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
            if(Bob.rec.intersects(Ted.rec)){
                Bob.isStone=true;
                Bob.dx=0;
                Bob.dy=0;
            }
        }
        if(e.getKeyCode()==72){
            isPressed="3";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        isPressed="1";
        if(e.getKeyCode()==87){
            //Bob.lastDX=Bob.dx;
            Bob.dx=0;
            Bob.dy=0;
        }
        if(e.getKeyCode()==65){
           // Bob.lastDX=Bob.dx;
            Bob.dx=0;
            Bob.dy=0;
            Bob.width=-50;
        }
        if(e.getKeyCode()==83){
            //Bob.lastDX=Bob.dx;
            Bob.dx=0;
            Bob.dy=0;
        }
        if(e.getKeyCode()==68){
            //Bob.lastDX=Bob.dx;
            Bob.dx=0;
            Bob.dy=0;
            Bob.width=50;
        }
        if(e.getKeyCode()==72){
            isPressed="1";
        }

    }
}