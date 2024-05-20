package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.SelectView;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectViewRepository extends JpaRepository<SelectView, Long> {

    String zapSelectHospital = "SELECT * FROM v_hospital_select WHERE hospital_id = ?1 AND oddzial iLIKE %?2%";
    @Query(value = zapSelectHospital, nativeQuery = true)
    public List<SelectView> findByOddzialName(Long id, String oddzial);
}
