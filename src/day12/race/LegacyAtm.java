package day12.race;


public class LegacyAtm implements Atm{

    public LegacyAtm(){

    }
   // private Lock accountLock;

    //public BadAtm(){
    //    accountLock=new ReentrantLock();
   // }


    @Override
    public void checkBalance(long accountId) {
        System.out.println(accountId+" going to whithdraw some money.");
    }

    private boolean allowWithdrawal(long accountId, int amount){
        return true;
    }

    @Override
    public void withDrawMoney(long accountId, int amount) {
        //accountLock.lock();

        try{
            if(allowWithdrawal(accountId, amount)){
                updateBalance(accountId, amount, TransactionType.WITHDRAWAL);
            }
        }finally{
           // accountLock.unlock();
        }
    }

    private void updateBalance(long accountId, int amount, TransactionType type){
        System.out.println("Successful "+type+" account:"+accountId+" amount:"+amount);
    }


    enum TransactionType{
        DEPOSIT, WITHDRAWAL
    }
}
