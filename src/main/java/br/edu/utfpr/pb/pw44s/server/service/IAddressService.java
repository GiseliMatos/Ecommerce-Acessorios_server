package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;

import java.util.List;

public interface IAddressService extends ICrudService<Address, Long> {
    List<Address> findAllByUserId(Long userId);
    
    List<Address> findAllByAuthenticatedUser();
    
    Address findById(Long id);
    
    Address createAddress(AddressDTO addressDTO);
    
    Address updateAddress(Long id, AddressDTO addressDTO);
    
    void deleteAddress(Long id);
}
