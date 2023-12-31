package ads.org.ebankingbackend.repositories;

import ads.org.ebankingbackend.entities.AccountOperation;
import ads.org.ebankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
