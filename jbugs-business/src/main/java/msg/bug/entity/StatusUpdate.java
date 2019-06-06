package msg.bug.entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusUpdate {

    public static final Map<String, List<String>> allStatusValue = createMapComplete();
    public static final Map<String, List<String>> limitedStatusValue = createMapLimited();


    public static Map<String, List<String>> createMapComplete() {
        Map<String, List<String>> result = new HashMap<>();

        result.put(StatusType.NEW.toString(), new ArrayList<String>() {
            {
                add(StatusType.IN_PROGRESS.toString());
                add(StatusType.REJECTED.toString());
            }
        });
        result.put(StatusType.REJECTED.toString(), new ArrayList<String>() {
            {
                add(StatusType.CLOSED.toString());

            }
        });
        result.put(StatusType.IN_PROGRESS.toString(), new ArrayList<String>() {
            {
                add(StatusType.REJECTED.toString());
                add(StatusType.INFO_NEEDED.toString());
                add(StatusType.FIXED.toString());
            }
        });
        result.put(StatusType.INFO_NEEDED.toString(), new ArrayList<String>() {
            {
                add(StatusType.IN_PROGRESS.toString());

            }
        });
        result.put(StatusType.FIXED.toString(), new ArrayList<String>() {
            {
                add(StatusType.NEW.toString());
                add(StatusType.CLOSED.toString());
            }
        });
        result.put(StatusType.CLOSED.toString(), new ArrayList<String>() {
            {

            }
        });


        return result;
    }

    public static Map<String, List<String>> createMapLimited() {
        Map<String, List<String>> result = createMapComplete();

        result.remove(StatusType.FIXED.toString());
        result.put(StatusType.FIXED.toString(), new ArrayList<String>() {{
            add(StatusType.NEW.toString());
        }});
        return result;
    }
}
