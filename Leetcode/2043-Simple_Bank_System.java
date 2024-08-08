class SimpleBankSystem {
    private long[] accountBalances;
    private int numAcccounts;

    public Bank(long[] balance) {
        this.accountBalances = balance;
        this.numAcccounts = accountBalances.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!accountExists(account1) || !accountExists(account2)){return false;}
        if(accountBalances[account1 - 1] < money){return false;}

        accountBalances[account1 - 1] -= money;
        accountBalances[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!accountExists(account)){return false;}
        accountBalances[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!accountExists(account)){return false;}
        if(accountBalances[account - 1] < money){return false;}

        this.accountBalances[account - 1] -= money;
        return true;
    }

    private boolean accountExists(int account){
        return account - 1 >= 0 && account - 1 < numAcccounts; 
    }
}