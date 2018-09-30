import javax.print.attribute.standard.MediaSize;
import java.awt.*;
import java.util.ArrayList;

public class H2H {
    Point SnakeHead;
    ArrayList<Point> ClosedList;
    String MoveDirec;
    ArrayList<Point> OtherSHeads;



    public H2H(Point SH , ArrayList CL , String Move ,ArrayList otherHeads){
        SnakeHead = SH;
        ClosedList = CL;
        MoveDirec = Move ;
        OtherSHeads = otherHeads;
    }

    public ArrayList<String> HeadtoHead() {
         ArrayList<String> moves = new ArrayList<>();
        switch (MoveDirec) {

            case "UP":{
                Point DR = new Point(SnakeHead);
                DR.x = DR.x + 1;
                DR.y = DR.y - 1;

                Point DL = new Point(SnakeHead);
                DL.x = DL.x + 1;
                DL.y = DL.y - 1;

                Point DS = new Point(SnakeHead);
                DS.y = DS.y - 2;

                if (OtherSHeads.contains(DS) ) {
                    moves.add("U");
                }else if(OtherSHeads.contains(DR)){
                    moves.add("R");

                }else if(OtherSHeads.contains(DL)){
                    moves.add("L");
                }

                break;

            }

            case "DOWN":{
                Point DR = new Point(SnakeHead);
                DR.x = DR.x + 1;
                DR.y = DR.y + 1;

                Point DL = new Point(SnakeHead);
                DL.x = DL.x - 1;
                DL.y = DL.y + 1;

                Point DS = new Point(SnakeHead);
                DS.y = DS.y + 2;

                if (OtherSHeads.contains(DS) ) {
                    moves.add("U");
                }else if(OtherSHeads.contains(DR)){
                    moves.add("R");

                }else if(OtherSHeads.contains(DL)){
                    moves.add("L");
                }
                break;



            }

            case"RIGHT":{
                Point DR = new Point(SnakeHead);
                DR.x = DR.x + 1;
                DR.y = DR.y + 1;

                Point DL = new Point(SnakeHead);
                DL.x = DL.x + 1;
                DL.y = DL.y - 1;

                Point DS = new Point(SnakeHead);
                DS.x = DS.x + 2;

                if (OtherSHeads.contains(DS) ) {
                    moves.add("U");
                }else if(OtherSHeads.contains(DR)){
                    moves.add("R");

                }else if(OtherSHeads.contains(DL)){
                    moves.add("L");
                }
                break;

            }

            case"LEFT":{
                Point DR = new Point(SnakeHead);
                DR.x = DR.x - 1;
                DR.y = DR.y + 1;

                Point DL = new Point(SnakeHead);
                DL.x = DL.x - 1;
                DL.y = DL.y - 1;

                Point DS = new Point(SnakeHead);
                DS.x = DS.x - 2;

                if (OtherSHeads.contains(DS) ) {
                    moves.add("U");
                }else if(OtherSHeads.contains(DR)){
                    moves.add("R");

                }else if(OtherSHeads.contains(DL)){
                    moves.add("L");
                }
                break;

            }


        }

        return moves;
    }

    public Point INV(){
        Point inv=null;
        switch (MoveDirec) {

            case "UP":{
                Point INV = new Point(SnakeHead);
                INV.y=INV.y-1;
                inv=INV;
                break;

            }

            case "DOWN":{
                Point INV = new Point(SnakeHead);
                INV.y=INV.y+1;
                inv=INV;
                break;

            }

            case"RIGHT":{
                Point INV = new Point(SnakeHead);
                INV.x=INV.x+1;
                inv=INV;
                break;
            }

            case"LEFT":{
                Point INV = new Point(SnakeHead);
                INV.x=INV.x-1;
                inv=INV;
                break;
            }


        }

        return inv;
    }


}
