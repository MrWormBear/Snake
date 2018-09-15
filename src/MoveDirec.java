import java.awt.*;

public class MoveDirec {
    public void main(){

    }

    public String getDirec(Point SnakeHead , Point Prevs ){

        if(SnakeHead.y == Prevs.y && SnakeHead.x < Prevs.x){

            return "LEFT";

        } else if(SnakeHead.y == Prevs.y && SnakeHead.x > Prevs.x){

            return "RIGHT";

        }else  if(SnakeHead.x == Prevs.x && SnakeHead.y < Prevs.y){

            return "UP";

        }else{

            return "DOWN";

        }

        //return "";
    }
}
