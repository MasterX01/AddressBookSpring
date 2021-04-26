package com.bl.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.addressbook.model.Person;

@Repository
public interface IAddressBookRepo extends JpaRepository<Person, Integer> {

}
