package day12.race;


public interface Atm {
    public void checkBalance(long accountId);

    public void withDrawMoney(long accountId, int amount);
}
