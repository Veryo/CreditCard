package creditcard;

import java.math.BigDecimal;

public class CreditCard {

    private BigDecimal creditLimit;
    private BigDecimal balance;
    

    public BigDecimal getBalance() {
        return balance;
    }

    public void assignCredit(BigDecimal creditLimit) {
        
        if(isCreditAlreadyAssigned()){
            throw new CreditCantBeReassingmentException();
        }
        //
        if(isBelowThreshold(creditLimit)) {
            throw new CreditBelowThresholdException();
        }

        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }

    private boolean isBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    public void pay(BigDecimal money) {
        if(!canAfford(money)){
            throw new NotEnoughMoneyException();
        }

        this.balance = this.balance.subtract(money);


    }

    private boolean canAfford(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) > 0;
    }
}
