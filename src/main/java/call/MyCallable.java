package call;


import java.util.Locale;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private String word;

    public MyCallable(String word){
        this.word = word;
    }

    @Override
    public String call() throws Exception {
        return upCase(word);
    }

    private String upCase(String str){
        return str.toUpperCase(Locale.ROOT);
    }

}
