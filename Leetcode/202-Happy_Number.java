class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> visitedNums = new HashSet<>();
        int currNum = n;

        while(currNum != 1){
            int newNum = 0;
            while(currNum != 0){
                int lastDigit = currNum % 10;
                newNum += lastDigit * lastDigit;
                currNum /= 10;
            }
            currNum = newNum;

            if(visitedNums.contains(currNum)){return false;}
            else{visitedNums.add(currNum);}
        }

        if(currNum == 1){return true;}
        return false;
    }
}