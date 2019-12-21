package console;

import java.util.LinkedList;
import java.util.Queue;

public interface ConsoleLogQueue {
     Queue<ErrorMessage> errorMessage=new LinkedList<>();

    public boolean LogPrint(ErrorMessage errorMessage);

    public void ConsoleOut();

}
