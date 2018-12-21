package com.plivo.contactBook.Controller;

import com.plivo.contactBook.Entity.Contact;
import com.plivo.contactBook.Repository.ContactRepository;
import com.plivo.contactBook.Service.ContactService;
import com.plivo.contactBook.Utilities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    ContactService contactService;

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    Response addContact(@RequestBody Contact contact){

        return contactService.addToContactBook(contact);
    }

    @RequestMapping(path = "/edit", method = RequestMethod.PUT)
    Response editContact(@RequestBody Contact contact, @RequestParam String type){

        return contactService.editFromContactBook(contact,type);
    }


    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    Response deletContact(@RequestParam String mobileNumber){

        return contactService.deletFromContactBook(mobileNumber);
    }

    @RequestMapping(path = "/listByEmailId", method = RequestMethod.GET)
    public Contact findByEmail(@RequestParam String emailId) {

        return contactService.searchByEmail(emailId);
    }

    @RequestMapping(path = "/listByName", method = RequestMethod.GET)
    public Page<Contact> userList(@RequestParam String name, Pageable pageable) {

        Page<Contact> pages = contactService.userList(name, pageable);
        return pages;
    }




}
