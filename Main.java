import java.math.BigDecimal;

import pojo.CashAccount;
import pojo.MarginAccount;
import pojo.TradeAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;

public class Main {
    public static void main(String[] args) {
        //Part One Solution
        /* CashAccount cashAccount = new CashAccount("C123", new BigDecimal("1000.00"));
        System.out.println("Cash Account Details:");
        System.out.println("ID: " + cashAccount.getId());
        System.out.println("Cash Balance: " + cashAccount.getCashBalance());
 
        CashAccount clonedCashAccount = (CashAccount) cashAccount.clone();
        System.out.println("Cloned Cash Account Details:");
        System.out.println("ID: " + clonedCashAccount.getId());
        System.out.println("Cash Balance: " + clonedCashAccount.getCashBalance());
 
        System.out.println();
 
        MarginAccount marginAccount = new MarginAccount("M456", new BigDecimal("5000.00"));
        System.out.println("Margin Account Details:");
        System.out.println("ID: " + marginAccount.getId());
        System.out.println("Margin: " + marginAccount.getMargin());
 
        MarginAccount clonedMarginAccount = (MarginAccount) marginAccount.clone();
        System.out.println("Cloned Margin Account Details:");
        System.out.println("ID: " + clonedMarginAccount.getId());
        System.out.println("Margin: " + clonedMarginAccount.getMargin()); */

        //Part Two Solution
/*         TradeAccountRepository repository = new TradeAccountRepository();
 
        CashAccount cashAccount = new CashAccount("C123", new BigDecimal("1000.00"));
        repository.createTradeAccount(cashAccount);
 
        MarginAccount marginAccount = new MarginAccount("M456", new BigDecimal("5000.00"));
        repository.createTradeAccount(marginAccount);
 
        TradeAccount retrievedCashAccount = repository.retrieveTradeAccount("C123");
        System.out.println("Retrieved Cash Account ID: " + retrievedCashAccount.getId());
        System.out.println("Cash Balance: " + ((CashAccount) retrievedCashAccount).getCashBalance());
 
        TradeAccount retrievedMarginAccount = repository.retrieveTradeAccount("M456");
        System.out.println("Retrieved Margin Account ID: " + retrievedMarginAccount.getId());
        System.out.println("Margin: " + ((MarginAccount) retrievedMarginAccount).getMargin()); */

        //Part 3 Solution
    TradeAccountRepository repository = new TradeAccountRepository();
    CashAccountService cashAccountService = new CashAccountService(repository);
    MarginAccountService marginAccountService = new MarginAccountService(repository);
 
    // Create CashAccount and MarginAccount objects
    CashAccount cashAccount = new CashAccount("1", BigDecimal.valueOf(1000));
    MarginAccount marginAccount = new MarginAccount("2", BigDecimal.valueOf(2000));
 
    // Add the accounts to the repository
    cashAccountService.createTradeAccount(cashAccount);
    marginAccountService.createTradeAccount(marginAccount);
 
    // Deposit and withdraw amounts
    cashAccountService.deposit("1", BigDecimal.valueOf(500));
    cashAccountService.withdraw("1", BigDecimal.valueOf(200));
    marginAccountService.deposit("2", BigDecimal.valueOf(1000));
    marginAccountService.withdraw("2", BigDecimal.valueOf(500));
 
    // Retrieve and print the updated account balances
    CashAccount updatedCashAccount = cashAccountService.retrieveTradeAccount("1");
    MarginAccount updatedMarginAccount = marginAccountService.retrieveTradeAccount("2");
    System.out.println("Updated CashAccount balance: " + updatedCashAccount.getCashBalance());
    System.out.println("Updated MarginAccount margin: " + updatedMarginAccount.getMargin());
 
    // Delete the accounts
    cashAccountService.deleteTradeAccount("1");
    marginAccountService.deleteTradeAccount("2");
    }
}