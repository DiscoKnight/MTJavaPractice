package run;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        int i = 0;

        for(int y = 0; y < 10; y++){
            i++;

            System.out.println(y);
        }

    }

}
