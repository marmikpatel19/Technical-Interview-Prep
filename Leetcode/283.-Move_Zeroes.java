class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        while(zero < nums.length && nums[zero] != 0){zero++;}

        for(int nonZero = 0; nonZero < nums.length; nonZero++){
            if(zero >= nums.length || zero >= nonZero || nums[nonZero] == 0){
                continue;
            }else{
                // swap
                int temp = nums[nonZero];
                nums[nonZero] = nums[zero];
                nums[zero] = temp;
                zero++;
            }
        }
    }
}