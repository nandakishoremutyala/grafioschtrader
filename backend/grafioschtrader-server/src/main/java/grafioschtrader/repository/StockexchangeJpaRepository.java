/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafioschtrader.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import grafioschtrader.dto.StockexchangeHasSecurity;
import grafioschtrader.entities.Stockexchange;
import grafioschtrader.rest.UpdateCreateJpaRepository;

/**
 *
 * @author Hugo Graf
 */
@Repository
public interface StockexchangeJpaRepository extends JpaRepository<Stockexchange, Integer>,
    StockexchangeJpaRepositoryCustom, UpdateCreateJpaRepository<Stockexchange> {

  List<Stockexchange> findAllByOrderByNameAsc();

  List<Stockexchange> findByNoMarketValueFalse();
  
  Optional<Stockexchange> findByIdStockexchangeAndNoMarketValueFalse(int idStockexchange);

  Stockexchange findByName(String name);


  @Query(value = "SELECT DISTINCT s.country_code FROM stockexchange s", nativeQuery = true)
  String[] findDistinctCountryCodes();

  @Query(value = "SELECT (CASE WHEN EXISTS(SELECT NULL FROM security s WHERE s.id_stockexchange = e.id_stockexchange)"
      + " THEN 1 ELSE 0 END) AS has_security FROM stockexchange e WHERE e.id_stockexchange = ?1", nativeQuery = true)
  int stockexchangeHasSecurity(Integer idStockexchange);

  @Query(value = "SELECT e.id_stockexchange AS id, (CASE WHEN EXISTS(SELECT NULL FROM security s WHERE s.id_stockexchange = e.id_stockexchange)"
      + " THEN 1 ELSE 0 END) AS s FROM stockexchange e", nativeQuery = true)
  List<StockexchangeHasSecurity> stockexchangesHasSecurity();

  @Query(nativeQuery = true)
  List<IdStockexchangeIndexName> getIdStockexchangeAndIndexNameForCalendarUpd();

  public interface IdStockexchangeIndexName {
    public Integer getIdStockexchange();

    public String getNameIndexSecurity();
  }
}
