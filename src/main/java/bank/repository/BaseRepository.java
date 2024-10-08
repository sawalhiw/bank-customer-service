package bank.repository;

import bank.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, String> {
}
