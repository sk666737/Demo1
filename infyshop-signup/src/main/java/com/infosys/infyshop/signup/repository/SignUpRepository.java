package com.infosys.infyshop.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosys.infyshop.signup.entity.SignUp;

public interface SignUpRepository extends JpaRepository<SignUp, String>{

}
