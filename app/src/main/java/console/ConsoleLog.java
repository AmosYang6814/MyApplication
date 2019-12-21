package console;

import java.util.LinkedList;
import java.util.Queue;

public abstract class ConsoleLog implements ConsoleLogQueue {
    static ConsoleLog instance;



    /**
     * 控制台输出打印设置，在程序内进行访问
     * @param errorMessage
     * @return
     */
    public boolean LogPrint(ErrorMessage errorMessage){
        return getQueue().offer(errorMessage);
    }

    public boolean LogPrint(String message){
        ErrorMessage errormessageIns=new ErrorMessage().setErrorMessage(message);
        return LogPrint(errormessageIns);
    }
    public boolean LogPrint(String deuginfo,String message){
        ErrorMessage errormessageIns=new ErrorMessage().setErrorMessage(message).setDeugFlag(deuginfo);
        return LogPrint(errormessageIns);
    }
    public boolean LogPrint(String errorLevel,String deuginfo,String message){
        ErrorMessage errormessageIns=new ErrorMessage().setDeugFlag(deuginfo).setErrorLevel(errorLevel).setErrorMessage(message);
        return LogPrint(errormessageIns);
    }





    /**
     * 输出方法，对于不同的平台，需要重写该方法
     */
    public abstract void ConsoleOut();


    /**
     * 对队列进行操作同步，
     * @return
     */
    private synchronized Queue<ErrorMessage> getQueue(){
        return this.errorMessage;
    }
}
