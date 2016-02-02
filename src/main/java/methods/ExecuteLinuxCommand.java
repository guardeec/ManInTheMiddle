package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Guardeec on 01.02.16.
 */
public class ExecuteLinuxCommand {
    public static String executeLinuxCommand(String comand){
        String answer = "";
        Process p;
        try{
            p = Runtime.getRuntime().exec(comand);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                answer +=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
