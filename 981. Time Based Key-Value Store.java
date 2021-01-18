class TimeMap {
    Map<String, TreeMap<Integer, String>> mp;

    /** Initialize your data structure here. */
    public TimeMap() {
        mp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!mp.containsKey(key))
            mp.put(key, new TreeMap());
        mp.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!mp.containsKey(key)) return "";
        TreeMap<Integer, String> tmp = mp.get(key);
        Integer temp = tmp.floorKey(timestamp);
        return (temp != null ? tmp.get(temp) : "");
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */