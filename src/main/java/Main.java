import POJO.Data;
import methods.threads.Driftnet;
import methods.threads.Router;
import methods.threads.Victim;

/**
 * Created by Guardeec on 01.02.16.
 */
public class Main{

    public static void main(String[] args) {
        if ((args.length==0) || args[0].contains("-h")){
            System.out.println("ManInTheMiddle [source] [target] [interface (optional)]");
        }else {
            Data data = Data.getInstance();
            data.setSourceIP(args[0]);
            data.setTargetIP(args[1]);

            if (args.length==3){
                data.setNetworkInteface(args[2]);
            }else {
                data.setNetworkInteface("eth0");
            }

            System.out.println(data.getSourceIP()+data.getTargetIP()+data.getNetworkInteface());

            Thread victim = new Thread(new Victim());
            Thread router = new Thread(new Router());
            Thread driftnet = new Thread(new Driftnet());

            victim.start();
            router.start();
            driftnet.start();

            synchronized (data){
                data.notify();
            }
        }

    }
}
