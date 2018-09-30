import java.awt.*;
import java.util.Arrays;

public class OS {


    String SnakePoints;
    String SnakeKills;
    String isAlive;
    String Head;
    String Tail;
    String Distance;

    Point SHead;
    Point STail;

    int DisttoApple;

    public OS(String alv , String points , String kills , String SnakeHead,String SnakeTail){
        this.SnakeKills=kills;
        this.isAlive=alv;
        this.SnakePoints=points;
        this.Head = SnakeHead;
        this.Tail=SnakeTail;


        toPoint();
    }

    public void toPoint(){
        Point temppoint = new Point();
        String[] Temppointholder = new String[2];
        Arrays.fill(Temppointholder, null);
        Temppointholder = Head.split(",");


        temppoint.x = Integer.parseInt(Temppointholder[0]);
        temppoint.y = Integer.parseInt(Temppointholder[1]);

        SHead = temppoint;

         temppoint = new Point();
        String[] Temppointholder2 = new String[2];
        Arrays.fill(Temppointholder2, null);
        Temppointholder2 = Tail.split(",");


        temppoint.x = Integer.parseInt(Temppointholder[0]);
        temppoint.y = Integer.parseInt(Temppointholder[1]);

        STail = temppoint;
    }



    public Point GetHead(){

        return SHead;
    }

    public Point GetTail(){

        return STail;
    }

}
