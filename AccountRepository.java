package net.javaguides.banking.repository;

import net.javaguides.banking.entity.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<account,Long> {

}
