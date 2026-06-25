package com.example.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.repository.query.Param;

/**
 * AOT generated JPA repository implementation for {@link PromocaoRepository}.
 */
@Generated
public class PromocaoRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public PromocaoRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link PromocaoRepository#findLikesById(java.lang.Long)}.
   */
  public int findLikesById(@Param("id") Long id) {
    String queryString = "select p.likes from Promocao p where p.id = :id";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("id", id);

    return (Integer) convertOne(query.getSingleResultOrNull(), false, Integer.class);
  }

  /**
   * AOT generated implementation of {@link PromocaoRepository#updateSomarLikes(java.lang.Long)}.
   */
  public void updateSomarLikes(@Param("id") Long id) {
    String queryString = "update Promocao p set p.likes = p.likes + 1 where p.id = :id";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("id", id);

    query.executeUpdate();
  }
}
