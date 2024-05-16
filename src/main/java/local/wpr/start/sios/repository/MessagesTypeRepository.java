package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.MessagesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesTypeRepository extends JpaRepository<MessagesType, Integer> {
}
