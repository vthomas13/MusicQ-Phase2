package vthomas13.musicq_phase2;

/**
 * Created by vthomas13 on 4/14/2016.
 */
public class AppManager{
    private static AppManager _instance = null;
    public static AppManager getInstance(){
        if(_instance == null)
            _instance= new AppManager();
        return _instance;
    }
    private AppManager(){} //Making the constructor private, so no 2 object can be created
    public void someMethod(){}
}
