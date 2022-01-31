package com.dxc.login.repository;
import java.util.Optional;

import com.dxc.login.models.ERole;
import com.dxc.login.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    
}
