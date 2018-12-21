package com.plivo.contactBook.Repository;

import com.plivo.contactBook.Entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact,String> {

    Contact findByEmailId(String emailId);

    Page<Contact> findByName(String name, Pageable pageable);


    //Contact findByName(String name);

    //Iterable<Contact> findByName(String name);
}
