package ru.learnup.vtb.news.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import ru.learnup.vtb.news.entities.PostEntity;
import ru.learnup.vtb.news.repositories.interfaces.PostRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Description
 *
 * @author bse71
 * Created on 14.12.2021
 * @since
 */
public class PostRepositoryImpl implements PostRepository {

    private SessionFactory sessionFactory;

    public PostRepositoryImpl() {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        this.sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    @Override
    public PostEntity get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Query<PostEntity> query = session.createQuery("FROM PostEntity p where p.id = :id", PostEntity.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public Collection<PostEntity> get() {
        try (Session session = sessionFactory.openSession()) {
            Query<PostEntity> query = session.createQuery("FROM PostEntity p join fetch p.comments", PostEntity.class);
            return new HashSet<>(query.getResultList());
        }
    }

    @Override
    public void create(PostEntity postEntity) {
        try (Session session = sessionFactory.openSession()) {
            final Transaction tx = session.beginTransaction();
            session.save(postEntity);
            tx.commit();
        }
    }

    @Override
    public void update(PostEntity postEntity) {

    }

    @Override
    public void delete(int id) {

    }
}
