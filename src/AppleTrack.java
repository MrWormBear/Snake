import java.awt.*;

public class AppleTrack {
    double time;
    Point Apple;
    public AppleTrack(Point Applepos){
              Apple=Applepos;
              this.time=5;
    }

    public void appledec(){
            time=time-0.5;
    }
    public boolean getTimeApple(){
            if(Math.ceil(time) <=0){
                return false;
            }else{
                return true;
            }


    }

    public Point getApplept(){


        return Apple;
    }
}
