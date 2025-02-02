package grafioschtrader.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import grafioschtrader.entities.BaseID;

public abstract class UpdateCreateResource<T extends BaseID> extends UpdateCreate<T> {

  /**
   * Request for a new entity. The new URI-location of the created record is not
   * returned.
   */
  @Override
  @PostMapping(value = "/", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<T> create(@Valid @RequestBody T entity) throws Exception {
    return createEntity(entity);
  }

  /**
   * Request for update entity.
   */
  @Override
  @PutMapping(value = "/", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<T> update(@Valid @RequestBody final T entity) throws Exception {
    return updateEntity(entity);
  }

}
