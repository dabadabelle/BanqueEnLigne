package ads.org.ebankingbackend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CE")
// Compte Epargne
// Compte qui possede un taux d'interet
@Data @AllArgsConstructor @NoArgsConstructor
public class SavingAccount extends BankAccount{
    private double interestRate;
}

