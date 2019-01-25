package ru.hlynov.alxk.jira;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConfigTools {

    public ConfigTools() {
    }

    public static boolean GetPermission(String JsonStr, String OptionStr) {

        boolean retVal = false;

        if (JsonStr == null) {
            return false;
        }

        if (JsonStr.isEmpty()) {
            return false;
        }

        JsonParser parser = new JsonParser();
        JsonObject cfgObj = parser.parse(JsonStr).getAsJsonObject();

        JsonElement jsonElement = cfgObj.get(OptionStr);

        if (jsonElement == null) {
            return false;
        }

        String currVar = cfgObj.get(OptionStr).getAsString();
        if (currVar != null && currVar.equals("on")) {
            retVal = true;
        }

        return retVal;
    }
}
