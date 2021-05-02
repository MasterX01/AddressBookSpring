package com.bl.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.addressbook.model.Person;

@Repository
public interface IAddressBookRepo extends JpaRepository<Person, Integer> {

	List<Person> findByCityOrState(String search);
}
