import javax.xml.soap.Node;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AStar {
   // public List<Point> OpenList;
   Point start;
   Point goal;

    public List<Point> main(Point Start, Point Goal, ArrayList<Point> ClosedList){
         ArrayList<Point> closedlist=new ArrayList<>();

        ArrayList<Point> Closedset = new ArrayList<>();
        Closedset.clear();
        Closedset=ClosedList;

         this.start =Start;
        this.goal = Goal;

        List<Point> Output=A_star(Start,Goal);
        return Output;

    }

    public  static List<Point> A_star(Point Start, Point goal ){

        ArrayList<Point> Closedset = new ArrayList<>();


        ArrayList<Point> Openset = new ArrayList<>();
            Point Current = new Point();
            Openset.add(Start);
            Point[][] CameFrom = new Point[50][50];
            int[][] GScore = new int[50][50];
            int[][] FScore = new int[50][50];


            for (int k = 0; k < 50; k++) {
                for (int j = 0; j < 50; j++) {
                    GScore[k][j] = -1;
                    FScore[k][j] = -1;

                }
            }
            GScore[Start.x][Start.y] = 0;
            FScore[Start.x][Start.y] = (100000);


            while (!Openset.isEmpty()) {


                if (Openset.size() == 1) {
                    Current = Openset.get(0);
                    if (Current == goal) {

                        return reconstructPath(CameFrom, Current, Start);
                    }

                } else {
                    Point min = new Point(Openset.get(0));
                    Current = Openset.get(0);
                    for (int l = 1; l < Openset.size(); l++) {

                        if ((FScore[Openset.get(l).x][Openset.get(l).y]) < (FScore[min.x][min.y])) {
                            Current = new Point();
                            min.x = Current.x;
                            min.y = Current.y;
                            Current.x = Openset.get(l).x;
                            Current.y = Openset.get(l).y;
                            // System.out.println(Current);
                            // System.out.println(min);
                            // System.out.println();


                        }
                    }

                    //end of Getting current
                    // Current = min;
                    if (Current.x == goal.x && Current.y == goal.y) {
                        return reconstructPath(CameFrom, Current, Start);
                    }


                }


                Openset.remove(Current);
                Closedset.add(Current);

                //for each neighbour
                //up
                Point Neighbour = new Point(Current);
                // Neighbour=(Current);
                Neighbour.y = Neighbour.y - 1;
                if (Neighbour.y > 0) {
                    if (Closedset.contains(Neighbour)) {

                    } else {
                        int tentative_G = GScore[Current.x][Current.y] + 1;
                        if (!Openset.contains(Neighbour)) {
                            Openset.add(Neighbour);
                        } else if (tentative_G >= GScore[Neighbour.x][Neighbour.y]) {


                        }
                        CameFrom[Neighbour.x][Neighbour.y] = Current;
                        GScore[Neighbour.x][Neighbour.y] = tentative_G;
                        FScore[Neighbour.x][Neighbour.y] = GScore[Neighbour.x][Neighbour.y] + HCost(Neighbour, goal);

                    }
                }

                //Right
                Neighbour = new Point(Current);
                //Neighbour.equals(Current);
                Neighbour.x = Neighbour.x + 1;
                if (Neighbour.x < 49) {
                    if (Closedset.contains(Neighbour)) {

                    } else {
                        int tentative_G = GScore[Current.x][Current.y] + 1;
                        if (!Openset.contains(Neighbour)) {
                            Openset.add(Neighbour);
                        } else if (tentative_G >= GScore[Neighbour.x][Neighbour.y]) {


                        }
                        CameFrom[Neighbour.x][Neighbour.y] = Current;
                        GScore[Neighbour.x][Neighbour.y] = tentative_G;
                        FScore[Neighbour.x][Neighbour.y] = GScore[Neighbour.x][Neighbour.y] + HCost(Neighbour, goal);
                    }
                }
                //Down
                Neighbour = new Point(Current);
                //Neighbour.equals(Current);
                Neighbour.y = Neighbour.y + 1;
                if (Neighbour.y < 49) {
                    if (Closedset.contains(Neighbour)) {

                    } else {
                        int tentative_G = GScore[Current.x][Current.y] + 1;
                        if (!Openset.contains(Neighbour)) {
                            Openset.add(Neighbour);
                        } else if (tentative_G >= GScore[Neighbour.x][Neighbour.y]) {


                        }
                        CameFrom[Neighbour.x][Neighbour.y] = Current;
                        GScore[Neighbour.x][Neighbour.y] = tentative_G;
                        FScore[Neighbour.x][Neighbour.y] = GScore[Neighbour.x][Neighbour.y] + HCost(Neighbour, goal);

                    }
                }

                //Left

                Neighbour = new Point(Current);
                //Neighbour=Current;
                Neighbour.x = Neighbour.x - 1;
                if (Neighbour.x >0) {
                    if (Closedset.contains(Neighbour)) {

                    } else {
                        int tentative_G = GScore[Current.x][Current.y] + 1;
                        if (!Openset.contains(Neighbour)) {
                            Openset.add(Neighbour);
                        } else if (tentative_G >= GScore[Neighbour.x][Neighbour.y]) {


                        }
                        CameFrom[Neighbour.x][Neighbour.y] = Current;
                        GScore[Neighbour.x][Neighbour.y] = tentative_G;
                        FScore[Neighbour.x][Neighbour.y] = GScore[Neighbour.x][Neighbour.y] + HCost(Neighbour, goal);

                    }
                }


            }

            return reconstructPath(CameFrom, Current, Start);



    }

    public static int HCost(Point Start,Point Goal){


     return (Math.abs(Start.x-Goal.x)+Math.abs(Start.y-Goal.y));
    }


    public static List<Point> reconstructPath(Point[][] CameFrom,Point Current,Point Start){
        Point temp = new Point(Current);
        List<Point> tot_path =new LinkedList<>();
        List<Point> output =new LinkedList<>();
               tot_path.add(Current);

               while(!Current.equals(Start)){
                   Current=CameFrom[Current.x][Current.y];
                   tot_path.add(Current);

               }
               int count =0;
               for(int k=tot_path.size()-1;k>-1;k--){
                   output.add(tot_path.get(k));


               }

       // while(true){}
        return output;
    }
}

