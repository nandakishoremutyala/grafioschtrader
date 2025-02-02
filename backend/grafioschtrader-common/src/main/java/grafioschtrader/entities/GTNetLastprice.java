package grafioschtrader.entities;

import static javax.persistence.InheritanceType.JOINED;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = GTNetLastprice.TABNAME)
@Inheritance(strategy = JOINED)
public abstract class GTNetLastprice extends BaseID {
  public static final String TABNAME = "gt_net_lastprice";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_net_lastprice")
  protected Integer idNetLastprice;

  @Schema(description = "Time of the last instraday price update")
  @Column(name = "timestamp")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date timestamp;

  @Schema(description = "Opening price for the last or current trading day")
  @Column(name = "open")
  protected Double open;

  @Schema(description = "Lowest price for the last or current trading day.")
  @Column(name = "low")
  protected Double low;

  @Schema(description = "Higest price for the last or current trading day.")
  @Column(name = "high")
  protected Double high;

  @Schema(description = "The most current price - possibly with after hour trade.")
  @Column(name = "last")
  protected Double last;

  @Schema(description = "The traded volume for this trading day. Cryptocurrencies can also have a volume.")
  @Column(name = "volume")
  protected Long volume;

  public GTNetLastprice() {
    super();
  }

  public Integer getIdNetLastprice() {
    return idNetLastprice;
  }

  public void setIdNetLastprice(Integer idNetLastprice) {
    this.idNetLastprice = idNetLastprice;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Double getOpen() {
    return open;
  }

  public void setOpen(Double open) {
    this.open = open;
  }

  public Double getLow() {
    return low;
  }

  public void setLow(Double low) {
    this.low = low;
  }

  public Double getHigh() {
    return high;
  }

  public void setHigh(Double high) {
    this.high = high;
  }

  public Double getLast() {
    return last;
  }

  public void setLast(Double last) {
    this.last = last;
  }

  public Long getVolume() {
    return volume;
  }

  public void setVolume(Long volume) {
    this.volume = volume;
  }

  @Override
  public Integer getId() {
    return idNetLastprice;
  }

}
