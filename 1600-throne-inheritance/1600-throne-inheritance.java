class ThroneInheritance {

    String kingName;
    Map<String,List<String>> map = new HashMap<>();
    Map<String,Boolean> alive = new HashMap<>();

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;    
    }
    
    public void birth(String parentName, String childName) {
        map.computeIfAbsent(parentName, k-> new ArrayList<>());
        map.get(parentName).add(childName);
    }
    
    public void death(String name) {
        alive.put(name,false);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> list = getList(this.kingName);
        List<String> res = new ArrayList<>();
        for(String str : list){
            if(alive.getOrDefault(str,true)){
                res.add(str);
            }
        }
        return res;
    }
    private List<String> getList(String p){
        List<String> res = new ArrayList<>();
        res.add(p);
        List<String> child = map.getOrDefault(p, new ArrayList<>());
        for(String c : child){
            List<String> curr = getList(c);
            for(String cc: curr){
                res.add(cc);
            }
        }
        return res;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */