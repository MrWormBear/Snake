import za.ac.wits.snake.DevelopmentAgent;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends DevelopmentAgent {



    public static void main(String args[]) throws IOException {
        Main agent = new Main();
        Main.start(agent, args);
    }

    @Override
    public void run() {



        ArrayList<AppleTrack> applelist = new ArrayList<AppleTrack>();
        Point AppleBackup = new Point();

        /////////////////////////////////////////////////////////////////////arraylists
        ArrayList<Point> mySnakepoints = new ArrayList<Point>();

        ArrayList<Point> ClosedList = new ArrayList<>();
        ArrayList<Point> OtherHeads= new ArrayList<Point>();

        ArrayList<ArrayList> OtherSnakes = new ArrayList<>();


        ////////////////////////////////////////////////////////////////points
        Point SnakeHead=new Point();
        Point Prevs = new Point();
        Point Appl1 = new Point();
       // Point Appl2 = new Point();


        ///////////////////////////////////////////////////////////////other Vars
        int move=0;
        //Moves moves = new Moves();
        String moveDirec = null;
        String Alive= "alive";

        ///////////////////////////////////////////////////////////////////////////////////////////Begin
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String initString = br.readLine();
            String[] temp = initString.split(" ");
            int nSnakes = Integer.parseInt(temp[0]);
            Point tempap = new Point();
            tempap.x=0;
            tempap.y=0;

            AppleTrack ap = new AppleTrack(tempap);


            while (true) {


                //ClosedList.clear();
                mySnakepoints.clear();
                OtherSnakes.clear();

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


                if(ap.getApplept()!=Appl1){
                    ap = new AppleTrack(Appl1);
                }
                ap.appledec();



                /////////////////////////////////////////////////////////////////





                int mySnakeNum = Integer.parseInt(br.readLine());
                for (int i = 0; i < nSnakes; i++) {
                    String snakeLine = br.readLine();


                    if (i == mySnakeNum) {
                        String[] Snekarr = snakeLine.split(" ");
                        Alive=Snekarr[0];
                        /////////////////////////////////////////////////


                        int count = 0;
                        for (int K = 3; K < Snekarr.length; K++) {
                            Point temppoint = new Point();
                            String[] Temppointholder = new String[2];
                            Arrays.fill(Temppointholder,null);
                            Temppointholder=Snekarr[K].split(",");


                            temppoint.x = Integer.parseInt(Temppointholder[0]);
                            temppoint.y = Integer.parseInt(Temppointholder[1]);

                            mySnakepoints.add(count,temppoint);
                            count++;

                        }
                    } else {

                       String[] Snekarr = snakeLine.split(" ");
                       ArrayList<Point> OtherSnakepoints =new ArrayList<Point>();
                        int count2 = 0;
                        if(Snekarr[0].contentEquals("invisible")) {
                            for (int K = 4; K < Snekarr.length; K++) {

                                Point temppoint = new Point();
                                String[] Temppointholder = new String[2];
                                Arrays.fill(Temppointholder, null);
                                Temppointholder = Snekarr[K].split(",");


                                temppoint.x = Integer.parseInt(Temppointholder[0]);
                                temppoint.y = Integer.parseInt(Temppointholder[1]);

                                OtherSnakepoints.add(temppoint);
                            }
                        }else{
                        for (int K = 3; K < Snekarr.length; K++) {

                            Point temppoint = new Point();
                            String[] Temppointholder = new String[2];
                            Arrays.fill(Temppointholder, null);
                            Temppointholder = Snekarr[K].split(",");


                            temppoint.x = Integer.parseInt(Temppointholder[0]);
                            temppoint.y = Integer.parseInt(Temppointholder[1]);

                            OtherSnakepoints.add(temppoint);

                        }



                        }

                            OtherSnakes.add(OtherSnakepoints);


                    }






                }


                //Creates closed list
                ClosedList.clear();
                CalcClosedList ccl = new CalcClosedList(mySnakepoints,OtherSnakes);
                ccl.fillsnakes();
                ClosedList=ccl.GetCL();

                //



                //getting Orientation of my snake;
                SnakeHead = mySnakepoints.get(0);
                Prevs=mySnakepoints.get(1);
                MoveDirec mv =new MoveDirec();

                moveDirec= mv.getDirec(SnakeHead,Prevs);


                int Dist = AStar.HCost(SnakeHead,Appl1);

                Timer time=new Timer();

                if(Dist < 30){
                    time=new Timer();
                    time.start();

                    Moves moves = new Moves(SnakeHead, Appl1, moveDirec, ClosedList);
                    moves.main(SnakeHead, Appl1, moveDirec, ClosedList);
                    moves.CalcMoveAStar();
                    move = moves.getMove();

                    time.stop();
                }else{


                    time.start();
                    Point SnakeTail = mySnakepoints.get(mySnakepoints.size()-1);
                    Moves moves = new Moves(SnakeHead, SnakeTail, moveDirec, ClosedList);
                    moves.main(SnakeHead, SnakeTail, moveDirec, ClosedList);
                    moves.CalcMoveAStar();
                    move = moves.getMove();

                    time.stop();
                }







            System.out.println("log calculating..."+Integer.toString(move)+"    "+Long.toString(time.getTime())+"\t"+ap.getApplept());
            //int move = new Random().nextInt(4);

            System.out.println(move);
        }
        } catch (IOException e) {

            e.printStackTrace();


            System.out.println(0);
        }
    }




    }