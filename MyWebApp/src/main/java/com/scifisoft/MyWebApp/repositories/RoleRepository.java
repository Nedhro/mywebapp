package com.scifisoft.MyWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scifisoft.MyWebApp.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
