class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        int match = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++){
            // incoming 
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                map.put(in, count);
                if(count == 0){
                    match++;
                }
            }
            
            //outgoing
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    if(count == 1){
                        match--;
                    }
                }
            }
            if(match == map.size()){
                result.add(i - p.length() + 1);
            } 
        }
        return result;
    }
}
