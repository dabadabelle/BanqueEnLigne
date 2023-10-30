package ads.org.ebankingbackend.services;

import ads.org.ebankingbackend.entities.BankAccount;
import ads.org.ebankingbackend.entities.Customer;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    BankAccount saveBankAccount(double initialeBalance, String type, Long customerId);
    List<Customer> listcustomers();
    BankAccount getBankAccount(String accountId);
    void debit(String accountId, double amount, String description);
    void credit(String accountId, double amount, String description);
    void transfert (String accountIdSource, String accountIdDestination, double amount );

;
}
