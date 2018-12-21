package com.plivo.contactBook.Service;

import com.plivo.contactBook.Entity.Contact;
import com.plivo.contactBook.Repository.ContactRepository;
import com.plivo.contactBook.Utilities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;


    public Response addToContactBook(Contact contact)
    {
        String mobileNumer = null;
        Response response = new Response();

        mobileNumer = contact.getMobileNumber();
        Contact c1 = contactRepository.findById(mobileNumer).orElse(null);

        if(c1==null)
        {
            Contact c2 = contactRepository.findByEmailId(contact.getEmailId());
            if(c2==null)
            {
                contactRepository.save(contact);
                response.setStatus(200);
                response.setMessage("SUCCESS");
            }else{
                response.setStatus(602);
                response.setMessage("Given email is linked with another mobile");
            }

        }else{

            response.setStatus(601);
            response.setMessage("MobileNumber already exists");
        }

        return response;
    }

    public Response editFromContactBook(Contact contact, String type){

        String mobileNumer = null;
        String emailId = null;
        String name = null;
        Response response = new Response();

        mobileNumer = contact.getMobileNumber();
        emailId = contact.getEmailId();
        name = contact.getName();
        Contact c1 = contactRepository.findById(mobileNumer).orElse(null);
        Contact c2 = contactRepository.findByEmailId(contact.getEmailId());

        if(type.equals("mobileNumber")){

            if(c1!=null && contact.getEmailId().equals(c1.getEmailId()))
            {
                contactRepository.delete(c1);
                contactRepository.save(contact);
                response.setStatus(200);
                response.setMessage("SUCCESS");
            }
        }else if(type.equals("emailId")){

            if(c2==null)
            {
                contactRepository.save(contact);
                response.setStatus(200);
                response.setMessage("SUCCESS");
            }else{
                response.setStatus(603);
                response.setMessage("email already exists");
            }
        }else if(type.equals("name")){

            if(contact.getEmailId().equals(c1.getEmailId()) && contact.getMobileNumber().equals(c2.getMobileNumber())){
                contactRepository.save(contact);
                response.setStatus(200);
                response.setMessage("SUCCESS");
            }else{
                response.setStatus(604);
                response.setMessage("something went wrong");
            }
        }


        return response;
    }

    public Response deletFromContactBook(String mobileNumber){

        Response response = new Response();
        Contact contact = contactRepository.findById(mobileNumber).orElse(null);
        if(contact!=null){
            contactRepository.delete(contact);
            response.setStatus(200);
            response.setMessage("SUCCESS");
        }else{
            response.setStatus(605);
            response.setMessage("contact not found");
        }

        return response;
    }

    public Contact searchByEmail(String email){
        return contactRepository.findByEmailId(email);
    }

    public Page<Contact> userList(String name, Pageable pageable) {
        return contactRepository.findByName(name, pageable);
    }
}
