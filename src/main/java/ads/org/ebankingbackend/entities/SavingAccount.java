package ads.org.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Compte Epargne
// Compte qui possede un taux d'interet
@Data @AllArgsConstructor @NoArgsConstructor
public class SavingAccount {
    private double interestRate;
}

