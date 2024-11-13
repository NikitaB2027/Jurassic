import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Start implements Runnable{
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

    public dinosaur Ben;
    public flydino Steve;
    public SmallDino Ted;

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
        Ted = new SmallDino(500,500,10,0);


    }// BasicGameApp()

    public void run() {

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
        }
    }

    public void moveThings()
    {
        //calls the move( ) code in the objects
        Ben.move();
        Steve.move();
        Ted.move();

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
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

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

        //draw the image of the astronaut
        g.drawImage(BenPic, Ben.xpos, Ben.ypos, Ben.width, Ben.height, null);
        g.drawImage(StevePic, Steve.xpos, Steve.ypos, Steve.width, Steve.height, null);
        g.drawImage(TedPic, Ted.xpos, Ted.ypos, Ted.width, Ted.height, null);
        g.dispose();

        bufferStrategy.show();
    }

}