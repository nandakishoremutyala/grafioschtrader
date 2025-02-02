package grafioschtrader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import grafioschtrader.entities.UserEntityChangeCount;
import grafioschtrader.entities.UserEntityChangeCount.UserEntityChangeCountId;
import grafioschtrader.entities.projection.UserCountLimit;

@Repository
public interface UserEntityChangeCountJpaRepository
    extends JpaRepository<UserEntityChangeCount, UserEntityChangeCountId> {

  @Query(nativeQuery = true)
  Optional<UserCountLimit> getCudTransactionAndUserLimit(Integer idUser, String entityName);

}
