package training.Immobilier.management.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import training.Immobilier.management.model.entity.LoanEntity;

public interface LoanRepo extends JpaRepository<LoanEntity,Long> {
}
