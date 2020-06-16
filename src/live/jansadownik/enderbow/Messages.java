package live.jansadownik.enderbow;

import java.util.HashMap;
import java.util.Map;

public class Messages {
    public static String CommandNoSuchPlayer = "No such player on the server";
    public static String CommandTypePlayerName = "Type targeted Player name!";
    public static String PlayerNotHavePermission = "You don't have permission!";
    public static String PlayerNotHaveItem = "You don't have %item%!";

    public static String parseMessage(String message, HashMap<String, String> parameters) {
        String messageToReturn = message;
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            messageToReturn = messageToReturn.replace(entry.getKey(), entry.getValue());
        }
        return messageToReturn;
    }
}
