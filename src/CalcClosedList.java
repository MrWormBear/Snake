import java.awt.*;
import java.util.ArrayList;

public class CalcClosedList {

    ArrayList<Point> mysnake=new ArrayList<Point>();
    ArrayList<ArrayList> othersnakes=new ArrayList<ArrayList>();
    ArrayList<Point> ClosedList = new ArrayList<Point>();
    Point temppoint = new Point();

    public CalcClosedList(ArrayList<Point> mysnake, ArrayList<ArrayList> othersnakes){
        this.mysnake= mysnake;

        this.othersnakes=othersnakes;
        this.othersnakes.add(this.mysnake);



        //this.othersnakes.add(this.mysnake);

    }
    public static void main(String[] args) {

    }

    public void fillsnakes() {


        String moveDirec = "";
        for (int k=0;k<4;k++) {
            ArrayList<Point> temp = new ArrayList<>();
            //temp.clear();
            temp=othersnakes.get(k);
            int ssize=0;

           while(ssize<=(temp.size())-2) {


               Point Point1 = temp.get(ssize) ;
               Point Point2 = temp.get(ssize+1);
               if (Point1.y == Point2.y && Point1.x < Point2.x) {

                   moveDirec = "LEFT";

               }
               if (Point1.y == Point2.y && Point1.x > Point2.x) {

                   moveDirec = "RIGHT";

               }
               if (Point1.x == Point2.x && Point1.y < Point2.y) {

                   moveDirec = "UP";

               }
               if (Point1.x == Point2.x && Point1.y > Point2.y) {

                   moveDirec = "DOWN";

               }
               switch(moveDirec){


                   case "UP":{

                       temppoint=Point1;
                       int count =0;
                       Point Frontsnake=new Point();

                       while(temppoint.y<Point2.y){
                           temppoint = new Point(Point1);
                           temppoint.y = (temppoint.y)+count;
                           ClosedList.add(temppoint);
                           count++;

                       }
                       break;
                   }
                   case "DOWN":{
                       //Point temppoint = new Point();
                       temppoint=Point1;
                       int count =0;
                       Point Frontsnake=new Point();


                       while(temppoint.y>Point2.y) {
                           temppoint = new Point(Point1);
                           temppoint.y = (temppoint.y)-count;
                           ClosedList.add(temppoint);
                           count++;

                       }
                       break;
                   }
                   case "LEFT":{
                      // Point temppoint = new Point();
                       temppoint=Point1;
                       int count =0;
                       Point Frontsnake=new Point();



                       while(temppoint.x<Point2.x) {
                           temppoint = new Point(Point1);
                           temppoint.x = (temppoint.x)+count;
                           ClosedList.add(temppoint);
                           count++;

                       }
                       break;
                   }
                   case "RIGHT":{
                       //Point temppoint = new Point();

                       temppoint=Point1;
                       int count =0;
                       Point Frontsnake=new Point();


                       while(temppoint.x>Point2.x) {
                           temppoint = new Point(Point1);
                           temppoint.x = (temppoint.x)-count;
                           ClosedList.add(temppoint);
                           count++;


                       }

                       for(int K =0;K<othersnakes.size()-1;K++){

                               Point TempPoint = new Point();
                               ArrayList<Point> Snake = new ArrayList<>();

                               Snake = othersnakes.get(K);
                               if(Snake.size()<1){

                               }else {
                                   TempPoint = Snake.get(0);


                                   Point Nextpt = new Point();
                                   Nextpt = TempPoint;
                                   Nextpt.x = Nextpt.x + 1;
                                   ClosedList.add(Nextpt);
                                   Nextpt.x = Nextpt.x - 1;


                                   Nextpt.x = Nextpt.x - 1;
                                   ClosedList.add(Nextpt);
                                   Nextpt.x = Nextpt.x + 1;


                                   Nextpt.y = Nextpt.y + 1;
                                   ClosedList.add(Nextpt);
                                   Nextpt.y = Nextpt.y - 1;


                                   Nextpt.y = Nextpt.y - 1;
                                   ClosedList.add(Nextpt);
                                   Nextpt.y = Nextpt.y + 1;
                               }
                       }
                       break;
                   }





               }
               //temp=othersnakes.get(k);

               ssize++;
           }//While


        }


        return;

    }

    public ArrayList GetCL(){
       // ClosedList.remove(mysnake.get(0));
        return ClosedList;

    }

}
