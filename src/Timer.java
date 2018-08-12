public class Timer {


    public long startTime;
    public long endTime;
    public static void main(){



    }

    public void start(){

    startTime=System.currentTimeMillis();
    }

    public void stop(){

    endTime=System.currentTimeMillis();
    }

    public long getTime(){

        return endTime-startTime;
    }
}
