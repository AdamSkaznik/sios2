package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
    List<Role> findAll();

    String zapHospital = "SELECT * FROM tab_role WHERE role iLike 'HOSPITAL%'";
    @Query(value = zapHospital, nativeQuery = true)
    List<Role> findRoleToHospital();

    String zapWkrm = "SELECT * FROM tab_role WHERE role iLike 'HOSPITAL%' OR role iLike 'WKRM%'";
    @Query(value = zapWkrm, nativeQuery = true)
    List<Role> findRoleToWkrm();

    String zapOrm = "SELECT * FROM tab_role WHERE role iLike 'HOSPITAL%' OR role iLike 'ORM%'";
    @Query(value = zapOrm, nativeQuery = true)
    List<Role> findRoleToOrm();

}
