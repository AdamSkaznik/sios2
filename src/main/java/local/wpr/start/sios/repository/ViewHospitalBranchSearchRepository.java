package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.ViewHospitalBranchSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewHospitalBranchSearchRepository extends JpaRepository<ViewHospitalBranchSearch, Long> {
    String zapSearch = "SELECT * FROM v_hospital_branch_search WHERE hospital_id = ?1";
    @Query(value = zapSearch, nativeQuery = true)
    List<ViewHospitalBranchSearch> getSearch(Long id);
}
