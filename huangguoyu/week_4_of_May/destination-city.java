class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> routes = new HashMap<>();
        for(List<String> item : paths) {
            routes.put(item.get(0), item.get(1));
        }

        for(List<String> item : paths) {
            if (routes.get(item.get(0)) == null) 
                return item.get(0);
            if (routes.get(item.get(1)) == null) 
                return item.get(1);
        }
        return null;
    }
}