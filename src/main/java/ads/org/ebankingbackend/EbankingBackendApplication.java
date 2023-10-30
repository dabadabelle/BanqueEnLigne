package ads.org.ebankingbackend;

import ads.org.ebankingbackend.entities.AccountOperation;
import ads.org.ebankingbackend.entities.CurrentAccount;
import ads.org.ebankingbackend.entities.Customer;
import ads.org.ebankingbackend.entities.SavingAccount;
import ads.org.ebankingbackend.enums.AccountStatus;
import ads.org.ebankingbackend.enums.OperationType;
import ads.org.ebankingbackend.repositories.AccountOperationRepository;
import ads.org.ebankingbackend.repositories.BankAccountRepository;
import ads.org.ebankingbackend.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(EbankingBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Aminata","Younouss","Doudou").forEach(name->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(client->{
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCreateDate(new Date());
                currentAccount.setStatus(AccountStatus.Cree);
                currentAccount.setCustomer(client);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);


                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCreateDate(new Date());
                savingAccount.setStatus(AccountStatus.Cree);
                savingAccount.setCustomer(client);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);
            });
            bankAccountRepository.findAll().forEach(cptClient->{
                for (int i = 0;i < 10 ; i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*120000);
                    accountOperation.setType(Math.random()>0.5? OperationType.Credit: OperationType.Debit);
                    accountOperation.setBankAccount(cptClient);
                    accountOperationRepository.save(accountOperation);
                }
            });
        };
    }

}
