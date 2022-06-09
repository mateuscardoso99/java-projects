package com.example.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api.models.ERole;
import com.example.api.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
  //Optional pode ser entendido como sendo uma caixa que pode ou não ter um valor dentro, se não tiver nada, dizemos que a caixa está vazia, evita NullPointerException
}
