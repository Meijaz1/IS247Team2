//Younoussa Daffe
//ydaffe1@umbc.edu

import java.util.*;

public class Main {
    public static void printDetail(Map<String, String> map) {
        System.out.println("Map Size: " + map.size());
        System.out.println("Map is empty: " + map.isEmpty());
        System.out.println("Map contains CSS key: " + map.containsKey("CSS"));

        String usage = map.get("CSS");
        System.out.println("Usage: " + (usage != null?usage: "null"));

        String removed = map.remove("CSS");
        System.out.println("removed: " + (removed != null?removed: "null"));
    }

    public static void main(String[] args) {
        List<String> isList = new ArrayList<>();

        isList.add("IS147");
        isList.add("IS247");
        isList.add("IS413");

        System.out.println("Initial list: [" + isList + "]");

        isList.addAll(Arrays.asList("IS300", "IS310", "IS300"));
        System.out.println("----------------------------");

        System.out.println("After using addall method: [" + isList + "]");
        System.out.println("----------------------------");
        System.out.println("The size is " + isList.size());
        System.out.println("----------------------------");

        Set<String> hSet = new HashSet<>(isList);

        System.out.println("----USING HASHSET----");
        System.out.println("----------------------------");

        System.out.println("After adding array using HashSet: [" + hSet + "]");
        System.out.println("----------------------------");
        System.out.println("The set size is: " + hSet.size());
        System.out.println("----------------------------");

        System.out.println("----USING HASHMAP----");

        Map<String, String> isMap = new HashMap<>();

        isMap.put("CSS", "style");
        isMap.put("XML", "data");
        isMap.put("HTML", "mark up");
        isMap.put("Oracle", "database");

        System.out.println("Map: " + isMap);
        printDetail(isMap);
        System.out.println("----------------------------");

        isMap.clear();
        printDetail(isMap);
        System.out.println("----------------------------");
    }
}