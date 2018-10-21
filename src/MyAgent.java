import za.ac.wits.snake.DevelopmentAgent;
import za.ac.wits.snake.Snake;

import javax.print.attribute.standard.MediaSize;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyAgent extends DevelopmentAgent {



    public static void main(String args[]) throws IOException {
        MyAgent agent = new MyAgent();
        MyAgent.start(agent, args);
    }

    @Override
    public void run() {




        Point AppleBackup = new Point();

        /////////////////////////////////////////////////////////////////////arraylists
        ArrayList<Point> mySnakepoints = new ArrayList<Point>();

        ArrayList<Point> ClosedList = new ArrayList<>();
        ArrayList<String> Alive = new ArrayList<>();
        ArrayList<Point> otherSHeads = new ArrayList<>();
        ArrayList<ArrayList> OtherSnakes = new ArrayList<>();

        ArrayList<OS> Snakedets = new ArrayList<>();


        ////////////////////////////////////////////////////////////////points
        Point SnakeHead=new Point();
        Point Prevs = new Point();
        Point Appl1 = new Point();
       // Point Appl2 = new Point();


        ///////////////////////////////////////////////////////////////other Vars
        int move=0;
        //Moves moves = new Moves();
        String moveDirec = null;
        //String Alive= "alive";
        int snake1dist= 0 ;
        int snake2dist = 0 ;
        int snake3dist = 0 ;

        ///////////////////////////////////////////////////////////////////////////////////////////Begin
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {


            String initString = br.readLine();
            String[] temp = initString.split(" ");
            int nSnakes = Integer.parseInt(temp[0]);
            Point tempap = new Point();
            tempap.x=0;
            tempap.y=0;
            int Dist;
            double timer = 6;
            Point applebackup = new Point(1,1);


            while (true) {
                Timer time=new Timer();


                mySnakepoints.clear();
                OtherSnakes.clear();
                ClosedList.clear();
                Snakedets.clear();

                String line = br.readLine();
                if (line.contains("Game Over")) {
                    break;
                }
                /////////////////////////////////////////////////////////////////ApplePoints
                String apple1 = line;
                String[] TemppointholderA1 = apple1.split(" ");
                int x1= Integer.parseInt(TemppointholderA1[0]);
                int y1 = Integer.parseInt(TemppointholderA1[1]);

                Point tmpA1=new Point();
                tmpA1.x=x1;
                tmpA1.y=y1;
                Appl1=tmpA1;






                /////////////////////////////////////////////////////////////////





                int mySnakeNum = Integer.parseInt(br.readLine());
                for (int i = 0; i < nSnakes; i++) {
                    String snakeLine = br.readLine();

                    time.start();
                    if (i == mySnakeNum) {
                        String[] Snekarr = snakeLine.split(" ");



                        for (int K = 3; K < Snekarr.length; K++) {
                            Point temppoint = new Point();
                            String[] Temppointholder = new String[2];
                            Arrays.fill(Temppointholder,null);
                            Temppointholder=Snekarr[K].split(",");


                            temppoint.x = Integer.parseInt(Temppointholder[0]);
                            temppoint.y = Integer.parseInt(Temppointholder[1]);

                            mySnakepoints.add(temppoint);


                        }
                    } else {

                       String[] Snekarr = snakeLine.split(" ");
                       ArrayList<Point> OtherSnakepoints =new ArrayList<Point>();
                       int count = 0;
                       Alive.add(Snekarr[0]);
                       String Head;
                       String Tail;

                       if(Snekarr[0].contains("dead")){
                           Head = "1,1";
                           Tail = "3,3";
                       }else{
                           Head=Snekarr[3];
                            Tail = Snekarr[Snekarr.length-1];

                       }
                       Snakedets.add(new OS(Snekarr[0],Snekarr[1],Snekarr[2],Head,Tail));


                            for (int K = 3; K < Snekarr.length; K++) {

                                Point temppoint = new Point();
                                String[] Temppointholder = new String[2];
                                Arrays.fill(Temppointholder, null);
                                Temppointholder = Snekarr[K].split(",");


                                temppoint.x = Integer.parseInt(Temppointholder[0]);
                                temppoint.y = Integer.parseInt(Temppointholder[1]);
                                if (count == 0){
                                    otherSHeads.add(temppoint);
                                }

                                OtherSnakepoints.add(temppoint);
                                count++;
                            }


                            OtherSnakes.add(OtherSnakepoints);


                    }






                }


                //Creates closed list

                CalcClosedList ccl = new CalcClosedList(mySnakepoints,OtherSnakes);
                ccl.fillsnakes();
                ClosedList=ccl.GetCL();



                if(!applebackup.equals(Appl1)){
                    applebackup = Appl1;
                    timer = 6;
                }


                Timer time2=new Timer();


                //getting Orientation of my snake;
                SnakeHead = mySnakepoints.get(0);
                Prevs=mySnakepoints.get(1);
                MoveDirec mv =new MoveDirec();

                moveDirec= mv.getDirec(SnakeHead,Prevs);

                //ClosedList.remove(SnakeHead);
                //boolean go=false;

                Dist = AStar.HCost(SnakeHead,Appl1);

                int Dist2=AStar.HCost(Snakedets.get(0).GetHead(),Appl1);
                int Dist3=AStar.HCost(Snakedets.get(1).GetHead(),Appl1);
                int Dist4=AStar.HCost(Snakedets.get(2).GetHead(),Appl1);
                int shortestdist=Dist2;

                if(Dist2>Dist3 && Dist4>Dist3){
                    shortestdist=Dist3;
                }else if(Dist3>Dist4 && Dist2>Dist4){
                    shortestdist=Dist4;
                }



                    if(Dist < shortestdist &&  Math.floor(timer) > 0){

                     Moves moves = new Moves(SnakeHead, Appl1, moveDirec, ClosedList);
                     moves.main(SnakeHead, Appl1, moveDirec, ClosedList);
                     moves.CalcMoveAStar();
                     move = moves.getMove();

                    }else{

                        int counts = 0;
                        Point STailtrck=Appl1;
                       while(Snakedets.get(counts).isAlive.contains("alive")){
                           if(Snakedets.get(counts).isAlive.contains("alive")){
                               STailtrck=Snakedets.get(counts).GetTail();
                               counts++;
                               break;
                               }


                       }time2.start();


                        Moves moves = new Moves(SnakeHead, STailtrck, moveDirec, ClosedList);
                        moves.main(SnakeHead, STailtrck, moveDirec, ClosedList);
                        moves.CalcMoveAStar();
                        move = moves.getMove();
                        time2.stop();
                    }



                time.stop();

            //System.out.println("log calculating..."+Integer.toString(move)+"    "+Long.toString(time.getTime())+"\t"+SnakeHead +"\t" + Long.toString(time2.getTime())+"\t" + (timer) );
            System.out.println(move);
                timer =(timer-0.1);
        }
        } catch (IOException e) {

            e.printStackTrace();


            System.out.println(0);
        }
    }




    }