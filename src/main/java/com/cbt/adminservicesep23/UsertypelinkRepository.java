package com.cbt.adminservicesep23;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsertypelinkRepository extends JpaRepository<Usertypelink, String> {

    List<Usertypelink> findByUsername(String username);

    List<Usertypelink> findByType(String type);

}