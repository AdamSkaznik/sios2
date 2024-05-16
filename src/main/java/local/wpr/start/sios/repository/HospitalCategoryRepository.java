package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalCategoryRepository extends JpaRepository<HospitalCategory, Long> {

//    String zap = "SELECT * FROM tab_hospital_category";
//    @Query(value = zap, nativeQuery = true)
//    List<HospitalCategory> findAll();
}
