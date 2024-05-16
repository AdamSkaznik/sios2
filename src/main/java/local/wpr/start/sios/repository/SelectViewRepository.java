package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.SelectView;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectViewRepository extends JpaRepository<SelectView, Long> {
}
