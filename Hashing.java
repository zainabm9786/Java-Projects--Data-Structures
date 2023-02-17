// Name:	Zainab Mohammed
// Assignment:  10-Part-1-Hashing

public class Hashing {
    public static void main (String [] args){//COMMENT CODE!!!
        //from textbook
        MyMap<String, Integer> map = new MyHashMap<>();
        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Smith", 65);
        map.put("Rosie", 12);//added this for myself

        System.out.println("Entries in map: " + map);// print entires

        System.out.println("The age for " + "Lewis is " + map.get("Lewis"));//takes key in as Lweis and get index/age

        System.out.println("Is Smith in the map? " +
                map.containsKey("Smith"));//find smith
        System.out.println("Is age 33 in the map? " +
                map.containsValue(33));

        map.remove("Smith");//removes smith form map
        System.out.println("Entries in map: " + map);

        map.clear();//clears map
        System.out.println("Entries in map: " + map);

    }

}

