package ads.org.ebankingbackend.services;

import ads.org.ebankingbackend.entities.BankAccount;
import ads.org.ebankingbackend.entities.Customer;
import ads.org.ebankingbackend.repositories.AccountOperationRepository;
import ads.org.ebankingbackend.repositories.BankAccountRepository;
import ads.org.ebankingbackend.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService{
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;
   // Logger log = LoggerFactory.getLogger(this.getClass().getName());


    /*public BankAccountServiceImpl(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, AccountOperationRepository accountOperationRepository) {
        this.customerRepository = customerRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.accountOperationRepository = accountOperationRepository;
    }*/

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Enregister un nouveau client");
        Customer savedCustomer =  customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public BankAccount saveBankAccount(double initialeBalance, String type, Long customerId) {
        return null;
    }

    @Override
    public List<Customer> listcustomers() {
        return null;
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfert(String accountIdSource, String accountIdDestination, double amount) {

    }
}
