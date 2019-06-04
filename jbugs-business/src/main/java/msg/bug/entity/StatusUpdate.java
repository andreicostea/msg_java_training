package msg.bug.entity;


import java.util.*;

public class StatusUpdate {

    public static final  Map<String, List<String>> statusValue = createMap();



    public static Map<String, List<String> > createMap(){
        Map<String, List<String>> result = new HashMap<>();

        result.put(StatusType.NEW.toString(), new ArrayList<String>(){
            {
                add(StatusType.IN_PROGRESS.toString());
                add(StatusType.REJECTED.toString());
            }});
        result.put(StatusType.REJECTED.toString(), new ArrayList<String>(){
            {
                add(StatusType.CLOSED.toString());

            }});
        result.put(StatusType.IN_PROGRESS.toString(), new ArrayList<String>(){
            {
                add(StatusType.REJECTED.toString());
                add(StatusType.INFO_NEEDED.toString());
                add(StatusType.FIXED.toString());
            }});
        result.put(StatusType.INFO_NEEDED.toString(), new ArrayList<String>(){
            {
                add(StatusType.IN_PROGRESS.toString());

            }});
        result.put(StatusType.FIXED.toString(), new ArrayList<String>(){
            {
                add(StatusType.NEW.toString());
                add(StatusType.CLOSED.toString());
            }});
        result.put(StatusType.CLOSED.toString(), new ArrayList<String>(){
            {

            }});


        return result;
    }
}
