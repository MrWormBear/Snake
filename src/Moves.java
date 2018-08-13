import za.ac.wits.snake.agent.SnakeAgent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Moves {

    int Move;
    Point SnakeHead;
    Point Appl2;
    String moveDirec;
    ArrayList<Point> CheckUse = new ArrayList<>();
    ArrayList<Point> ClosedList=new ArrayList<>();

    public Moves(Point snakeHead, Point appl2, String moveDirec,ArrayList<Point> CL) {
        this.SnakeHead = SnakeHead;
        this.Appl2 = Appl2;
        this.moveDirec = moveDirec;
        this.ClosedList=CL;
    }


    public void main(Point SnakeHead, Point Appl2, String moveDirec ,ArrayList<Point> CLi) {
        this.SnakeHead = SnakeHead;
        this.Appl2 = Appl2;
        this.moveDirec = moveDirec;
        this.ClosedList=CLi;

    }


    public void ToApple() {
        int move = 0;
        boolean hasmove = true;
        while (hasmove == true) {

            if (Math.abs(SnakeHead.x - Appl2.x) > Math.abs(SnakeHead.y - Appl2.y)) {

                if (SnakeHead.x > Appl2.x && (hasmove == true)) {
                    if (moveDirec == "UP") {
                        move = 2;

                    }
                    if (moveDirec == "DOWN") {
                        move = 2;

                    }
                    if (moveDirec == "LEFT") {
                        move = 2;

                    }
                    if (moveDirec == "RIGHT") {
                        move = 0;

                    }
                    hasmove = false;
                    //break;

                }

                if (SnakeHead.x < Appl2.x && (hasmove == true)) {
                    if (moveDirec == "UP") {
                        move = 3;

                    }
                    if (moveDirec == "DOWN") {
                        move = 3;

                    }
                    if (moveDirec == "LEFT") {
                        move = 0;

                    }
                    if (moveDirec == "RIGHT") {
                        move = 3;

                    }
                    hasmove = false;
                    // break;

                }
            } else {

                if (SnakeHead.y > Appl2.y && (hasmove == true)) {
                    if (moveDirec == "UP") {
                        move = 0;

                    }

                    if (moveDirec == "DOWN") {
                        move = 3;

                    }

                    if (moveDirec == "LEFT") {
                        move = 0;

                    }

                    if (moveDirec == "RIGHT") {
                        move = 0;

                    }
                    hasmove = false;


                }

                if (SnakeHead.y < Appl2.y && (hasmove == true)) {
                    if (moveDirec == "UP") {
                        move = 3;

                    }

                    if (moveDirec == "DOWN") {
                        move = 1;

                    }

                    if (moveDirec == "LEFT") {
                        move = 1;

                    }

                    if (moveDirec == "RIGHT") {
                        move = 1;

                    }
                    hasmove = false;


                }

            }

        }

        this.Move = move;

    }

    public void toOpApple(){
        int move = 0;
        boolean hasmove = true;
        Point OpApple=new Point();
        OpApple.x=Appl2.y;
        OpApple.y=Appl2.x;
        while (hasmove == true) {

            if (Math.abs(SnakeHead.x - OpApple.x) > Math.abs(SnakeHead.y - OpApple.y)) {

                if (SnakeHead.x > OpApple.x && (hasmove == true)) {
                    if (moveDirec == "UP") {
                        move = 2;

                    }
                    if (moveDirec == "DOWN") {
                        move = 2;

                    }
                    if (moveDirec == "LEFT") {
                        move = 2;

                    }
                    if (moveDirec == "RIGHT") {
                        move = 0;

                    }
                    hasmove = false;
                    //break;

                }

                if (SnakeHead.x < OpApple.x && (hasmove == true)) {
                    if (moveDirec == "UP") {
                        move = 3;

                    }
                    if (moveDirec == "DOWN") {
                        move = 3;

                    }
                    if (moveDirec == "LEFT") {
                        move = 0;

                    }
                    if (moveDirec == "RIGHT") {
                        move = 3;

                    }
                    hasmove = false;
                    // break;

                }
            } else {

                if (SnakeHead.y > OpApple.y && (hasmove == true)) {
                    if (moveDirec == "UP") {
                        move = 0;

                    }

                    if (moveDirec == "DOWN") {
                        move = 3;

                    }

                    if (moveDirec == "LEFT") {
                        move = 0;

                    }

                    if (moveDirec == "RIGHT") {
                        move = 0;

                    }
                    hasmove = false;


                }

                if (SnakeHead.y < OpApple.y && (hasmove == true)) {
                    if (moveDirec == "UP") {
                        move = 3;

                    }

                    if (moveDirec == "DOWN") {
                        move = 1;

                    }

                    if (moveDirec == "LEFT") {
                        move = 1;

                    }

                    if (moveDirec == "RIGHT") {
                        move = 1;

                    }
                    hasmove = false;


                }

            }

        }

        this.Move = move;

    }



    public int getMove() {

        return this.Move;
    }


    public int AppleProbab(ArrayList<Point> OtherHeads) {
        ArrayList<Point> Heads = OtherHeads;
        int YesNo = 0;
        Point temp = new Point();
        int myDist=myDisttoApple();
        int GoOrNo = 0;
        for (int K = 0; K < Heads.size()-1; K++) {
            temp = null;
            temp = Heads.get(K);
            int otherDist=odtApple(temp);

            if (myDist < otherDist) {
                YesNo = 1;
            } else {
                YesNo = 0;
                break;
            }

        }


        return YesNo;
    }


    ////////////////////////////////////////////////////////////////////////////////Distance to apple

    public int myDisttoApple() {
        int Dist = 0;
        if(SnakeHead!=Appl2) {
            Dist = Math.abs(SnakeHead.x - Appl2.x) + Math.abs(SnakeHead.y - Appl2.y);
            return Dist;
        }else{

            return 0;
        }

    }


    public int odtApple(Point SH) {

        int Dist = 0;
        if(SH!=Appl2) {
            Dist = Math.abs(SH.x - Appl2.x) + Math.abs(SH.y - Appl2.y);
            return Dist;
        }else{

            return 0;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////ends dist apple


    public void CalcMoveAStar() {


            AStar ast = new AStar();
            Point MoveTo = new Point();
            ArrayList<Point> movelist = new ArrayList<Point>(ast.main(SnakeHead, Appl2, ClosedList));
            ast.A_star(SnakeHead, Appl2);
            if (movelist.size() > 1) {
                MoveTo = new Point(movelist.get(1));
                //System.out.println("A*");
                if (SnakeHead.y > MoveTo.y) {
                    this.Move = 0;

                } else if (SnakeHead.y < MoveTo.y) {
                    this.Move = 1;

                } else if (SnakeHead.x > MoveTo.x) {
                    this.Move = 2;

                } else if (SnakeHead.x < MoveTo.x) {
                    this.Move = 3;
                }

            } else {

                //ToApple();
                //Move to corner
                Point corner = new Point();
                corner.x = 0;
                corner.y = 49;
                ArrayList<Point> mv = new ArrayList<Point>(ast.main(SnakeHead, corner, ClosedList));
                ast.A_star(SnakeHead, corner);
                if (mv.size() > 1) {
                    MoveTo = new Point(mv.get(1));
                    //System.out.println("A*");
                    if (SnakeHead.y > MoveTo.y) {
                        this.Move = 0;

                    } else if (SnakeHead.y < MoveTo.y) {
                        this.Move = 1;

                    } else if (SnakeHead.x > MoveTo.x) {
                        this.Move = 2;

                    } else if (SnakeHead.x < MoveTo.x) {
                        this.Move = 3;
                    }


                }

            }
            //return Move;


    }

}
