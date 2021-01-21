package assignment04;

import java.util.ArrayList;
import java.util.List;

/*
    Bradley Estus
    B00780491
    Assignment 04
 */

public class Question3 {

    /**
     * Finds and returns the longest elements in list. Uses only one for loop and .clear() for logic.
     * @param list given list of String
     * @return null if list is null, empty ArrayList if list is empty, else List<String> with all longest elements
     */
    public static List<String> longest(List<String> list) {
        List<String> rtn = new ArrayList<>();
        int x = 0;
        if(list == null){
            return null;
        }else if(list.size()==0){
            return rtn;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).length() == x) {
                    rtn.add(list.get(i));
                } else if (list.get(i).length() > x){
                    rtn.clear();
                    x = list.get(i).length();
                    rtn.add(list.get(i));
                }
            }
        }
        return rtn;
    }

    /**
     * Finds the shortest elements in list, using modified logic from longest,
     * then places these entries in a String array and returns
     * @param list given list of String
     * @return null if list is null, empty ArrayList if list is empty, else String[] with all shortest elements
     */
    public static String[] shortest(List<String> list){
        List<String> rtn = new ArrayList<>();
        if(list == null){
            return null;
        }else if(list.size()==0){
            return new String[]{};
        }
        int x = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).length() == x) {
                    rtn.add(list.get(i));
                } else if (list.get(i).length() < x){
                    rtn.clear();
                    x = list.get(i).length();
                    rtn.add(list.get(i));
                }
            }
        }
        String[] lines = {};
        return rtn.toArray(lines);
    }

    /**
     * Finds the locations of the longest elements in list, using modified logic from longest,
     * then places these entries in an int array and returns
     * @param list given list of String
     * @return null if list is null, empty ArrayList if list is empty, else int[] with locations of longest elements
     */
    public static int[] longestLocations(List<String> list){
        List<Integer> rtn = new ArrayList<>();
        int x = 0;
        if(list == null){
            return null;
        }else if(list.size()==0){
            return new int[]{};
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).length() == x) {
                    rtn.add(i);
                } else if (list.get(i).length() > x){
                    rtn.clear();
                    x = list.get(i).length();
                    rtn.add(i);
                }
            }
        }
        int[] locs = new int[rtn.size()];
        for(int i = 0; i < rtn.size(); i++){
            locs[i] = rtn.get(i);
        }
        return locs;
    }

    /**
     * Finds and returns the elements with the most of a given char, logic similar to longest
     * @param list given list of String
     * @param c given char to count in elements
     * @return null if list is null, empty ArrayList if list is empty, else List<String> of elements with most char c
     */
    public static List<String> mostCs(List<String> list, char c){
        List<String> rtn = new ArrayList<>();
        if(list == null){
            return null;
        }else if(list.size()==0){
            return rtn;
        }
        char c1 = Character.toUpperCase(c);
        char c2 = Character.toLowerCase(c);
        int x = 0;
        String regex =  "[" + Character.toString(c1)  + Character.toString(c2) + "]";
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)!=null) {
                int difference = list.get(i).length() - list.get(i).replaceAll(regex,"").length();
                if(difference == x){
                    rtn.add(list.get(i));
                }else if(difference > x){
                    rtn.clear();
                    rtn.add(list.get(i));
                    x = difference;
                }
            }
        }
        return rtn;
    }

    /**
     * Finds the elements with the most of a given char, using logic modified from mostCs,
     * then places these elements in a String array and returns
     * @param list given list of String
     * @param c given char to count in elements
     * @return null if list is null, empty ArrayList if list is empty, else String[] of elements with fewest char c
     */
    public static String[] fewestCs(List<String> list, char c){
        if(list == null){
            return null;
        }else if(list.size()==0){
            return new String[]{};
        }
        List<String> rtn = new ArrayList<>();
        char c1 = Character.toUpperCase(c);
        char c2 = Character.toLowerCase(c);
        int x = Integer.MAX_VALUE;
        String regex =  "[" + Character.toString(c1)  + Character.toString(c2) + "]";
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)!=null) {
                int difference = list.get(i).length() - list.get(i).replaceAll(regex,"").length();
                if(difference == x){
                    rtn.add(list.get(i));
                }else if(difference < x){
                    rtn.clear();
                    rtn.add(list.get(i));
                    x = difference;
                }
            }
        }
        String[] fewest = {};
        return rtn.toArray(fewest);
    }

    /**
     * Finds the locations of the elements with the most of a given char, using logic mofified from mostCs
     * then places these entries in an int array and returns
     * @param list given list of String
     * @return null if list is null, empty ArrayList if list is empty, else int[] with locations elements with most char c
     */
    public static int[] mostCsLocations(List<String> list, char c){
        if(list == null){
            return null;
        }else if(list.size()==0){
            return new int[]{};
        }
        List<Integer> rtn = new ArrayList<>();
        char c1 = Character.toUpperCase(c);
        char c2 = Character.toLowerCase(c);
        int x = 0;
        String regex =  "[" + Character.toString(c1)  + Character.toString(c2) + "]";
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)!=null) {
                int difference = list.get(i).length() - list.get(i).replaceAll(regex,"").length();
                if(difference == x){
                    rtn.add(i);
                }else if(difference > x){
                    rtn.clear();
                    rtn.add(i);
                    x = difference;
                }
            }
        }
        int[] locs = new int[rtn.size()];
        for(int i = 0; i < rtn.size(); i++){
            locs[i] = rtn.get(i);
        }
        return locs;
    }
}
