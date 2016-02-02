package methods.threads;

import POJO.Data;
import methods.ExecuteLinuxCommand;

/**
 * Created by Guardeec on 01.02.16.
 */
public class Driftnet implements Runnable {
    private final Data data = Data.getInstance();
    public void run() {
        String command;
        synchronized (data){
            command = "driftnet -i "+data.getNetworkInteface();
        }
        System.out.println(command);
        ExecuteLinuxCommand.executeLinuxCommand(command);

        System.out.println("Ошибка при запуске Driftnet");
        System.exit(0);
    }
}
