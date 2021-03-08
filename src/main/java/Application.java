import call.MyCallable;
import run.MyRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Application {

    public static ConcurrentSkipListSet<String> concurrentSkipListSet = new ConcurrentSkipListSet();

    public static void main(String[] args){

        DelayQueue queue = new DelayQueue();
        MyCallable callableHello = new MyCallable("hello");
        MyCallable callableWorld = new MyCallable("world");

        ExecutorService service = new ThreadPoolExecutor(2, 2, 1l, TimeUnit.SECONDS, queue);

        List<MyCallable> listOfCallables = new ArrayList<>();
        listOfCallables.add(callableHello);
        listOfCallables.add(callableWorld);

        //
        try {
            List<Future<String>> li = service.invokeAll(listOfCallables);

            for(Future<String> s : li){
                concurrentSkipListSet.add(s.get());
            }

            for(String s : concurrentSkipListSet){
                System.out.println(s);
            }

            if(li.get(0).isDone() && li.get(1).isDone()){
                service.shutdown();
            }

            ///////////////////////////////

//            Future fu = service.submit(new MyRunnable());
//
//            System.out.println("smurf");
//
//            if(fu.isDone()){
//                service.shutdown();
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
