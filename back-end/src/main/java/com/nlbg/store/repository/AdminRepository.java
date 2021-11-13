package com.nlbg.store.repository;

import com.nlbg.store.domain.User.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
