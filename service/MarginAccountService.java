package service;

import java.math.BigDecimal;

import pojo.CashAccount;
import pojo.MarginAccount;
import repository.TradeAccountRepository;

public class MarginAccountService implements TradeAccountService {
       private TradeAccountRepository repository;
    
    @Override
    public void deposit(String id, BigDecimal amount) {
       MarginAccount account = retrieveTradeAccount(id);
       account.setMargin(account.getMargin().add(amount));
       updateTradeAccount(account);
        
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        MarginAccount account = retrieveTradeAccount(id);
        account.setMargin(account.getMargin().subtract(amount));
        updateTradeAccount(account);
        
    }

    public MarginAccountService(TradeAccountRepository repository) {
        this.repository = repository;
    }

    public MarginAccount retrieveTradeAccount(String id) {
        return (MarginAccount) this.repository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(MarginAccount account) {
        this.repository.updateTradeAccount(account);
    }
}
