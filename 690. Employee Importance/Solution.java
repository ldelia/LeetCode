class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        return helper(map, id);
    }
    
    protected int helper(HashMap<Integer, Employee> map, int id) {
        
        Employee current = map.get(id);
        
        int sum = current.importance;
        
        for (Integer sid : current.subordinates) {
            sum += helper(map, sid);
        }
        
        return sum;
    }
}
