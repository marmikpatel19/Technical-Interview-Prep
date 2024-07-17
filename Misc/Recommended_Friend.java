public class Main {
    public static void main(String[] args) {
        List<List<Integer>> friendships1 = new ArrayList<>();
        List<Integer> friendship1 = new ArrayList<>();
        friendship1.add(0);
        friendship1.add(1);
        friendships1.add(friendship1);
        List<Integer> friendship2 = new ArrayList<>();
        friendship2.add(0);
        friendship2.add(2);
        friendships1.add(friendship2);
        List<Integer> friendship3 = new ArrayList<>();
        friendship3.add(1);
        friendship3.add(3);
        friendships1.add(friendship3);
        List<Integer> friendship4 = new ArrayList<>();
        friendship4.add(2);
        friendship4.add(3);
        friendships1.add(friendship4);
        List<Integer> friendship5 = new ArrayList<>();
        friendship5.add(3);
        friendship5.add(4);
        friendships1.add(friendship5);
        List<Integer> res1 = getRecommendations(5, friendships1); // correct res is 3,2,1,0,1
        System.out.println("");
        for(Integer maxCommon : res1){
            System.out.print(maxCommon + ", ");
        }
        
        List<List<Integer>> friendships2 = new ArrayList<>();
        List<Integer> friendship11 = new ArrayList<>();
        friendship11.add(0);
        friendship11.add(1);
        friendships2.add(friendship11);
        List<Integer> friendship22 = new ArrayList<>();
        friendship22.add(1);
        friendship22.add(2);
        friendships2.add(friendship22);
        List<Integer> friendship33 = new ArrayList<>();
        friendship33.add(2);
        friendship33.add(0);
        friendships2.add(friendship33);
        List<Integer> res2 = getRecommendations(3, friendships2); // correct res is -1,-1,-1
        System.out.println("");
        for(Integer maxCommon : res2){
            System.out.print(maxCommon + ", ");
        }
        
        List<List<Integer>> friendships3 = new ArrayList<>();
        List<Integer> friendship111 = new ArrayList<>();
        friendship111.add(0);
        friendship111.add(1);
        friendships3.add(friendship111);
        List<Integer> friendship222 = new ArrayList<>();
        friendship222.add(0);
        friendship222.add(2);
        friendships3.add(friendship222);
        List<Integer> res3 = getRecommendations(3, friendships3); // correct res is -1,2,1
        System.out.println("");
        for(Integer maxCommon : res3){
            System.out.print(maxCommon + ", ");
        }
    }
    
    // time: O(n^2m), space: O(nm), m is friendships.size()
    private static List<Integer> getRecommendations(int n, List<List<Integer>> friendships){
        HashMap<Integer, ArrayList<Integer>> friendsPerPerson = new HashMap<>(); // each person mapped to their friend -- adjacency list
        
        for(List<Integer> friends : friendships){
            Integer friendOne = friends.get(0);
            Integer friendTwo = friends.get(1);
            
            if(friendsPerPerson.containsKey(friendOne) &&            
            !friendsPerPerson.get(friendOne).contains(friendTwo)){
                friendsPerPerson.get(friendOne).add(friendTwo);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(friendTwo);
                friendsPerPerson.put(friendOne, temp);
            }
            if(friendsPerPerson.containsKey(friendTwo) &&            
            !friendsPerPerson.get(friendTwo).contains(friendOne)){
                friendsPerPerson.get(friendTwo).add(friendOne);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(friendOne);
                friendsPerPerson.put(friendTwo, temp);
            }
        }
        
        ArrayList<Integer> recommendedFriend = new ArrayList<>();
        
        for(Integer friend : friendsPerPerson.keySet()){
            Integer maxCommonFriend = -1;
            Integer maxCommonFriendsCount = 0;
            
            for(Integer friend2 : friendsPerPerson.keySet()){
                if(friend2 != friend && !friendsPerPerson.get(friend).contains(friend2) && !friendsPerPerson.get(friend2).contains(friend)){
                    Integer currCommonFriends = 0;
                    
                    for(Integer friendsFriend : friendsPerPerson.get(friend)){
                        if(friendsPerPerson.get(friend2).contains(friendsFriend)){
                            currCommonFriends++;
                        }
                    }
                    
                    if(currCommonFriends > maxCommonFriendsCount){
                        maxCommonFriendsCount = currCommonFriends;
                        maxCommonFriend = friend2;
                    }
                }
            }
            
            recommendedFriend.add(maxCommonFriend);
        }
        
        return recommendedFriend;
    }
}