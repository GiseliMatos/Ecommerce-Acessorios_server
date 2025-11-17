package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IAddressService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, Long> implements IAddressService {

    private final AddressRepository addressRepository;
    private final AuthService authService;

    public AddressServiceImpl(AddressRepository addressRepository, AuthService authService) {
        this.addressRepository = addressRepository;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    public List<Address> findAllByUserId(Long userId) {
        return addressRepository.findAllByUserId(userId);
    }

    @Override
    public List<Address> findAllByAuthenticatedUser() {
        User user = authService.getAuthenticatedUser();
        return addressRepository.findAllByUserId(user.getId());
    }

    @Override
    public Address findById(Long id) {
        User user = authService.getAuthenticatedUser();
        
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        
        // Valida se o endereço pertence ao usuário autenticado
        if (address.getUser().getId() != user.getId()) {
            throw new RuntimeException("Você não tem permissão para acessar este endereço");
        }
        
        return address;
    }

    @Override
    public Address createAddress(AddressDTO addressDTO) {
        User user = authService.getAuthenticatedUser();
        
        Address address = Address.builder()
                .street(addressDTO.getStreet())
                .complement(addressDTO.getComplement())
                .zipCode(addressDTO.getZipCode())
                .city(addressDTO.getCity())
                .state(addressDTO.getState())
                .country(addressDTO.getCountry())
                .user(user)
                .build();
        
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, AddressDTO addressDTO) {
        User user = authService.getAuthenticatedUser();
        
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        
        // Valida se o endereço pertence ao usuário autenticado
        if (address.getUser().getId() != user.getId()) {
            throw new RuntimeException("Você não tem permissão para editar este endereço");
        }
        
        address.setStreet(addressDTO.getStreet());
        address.setComplement(addressDTO.getComplement());
        address.setZipCode(addressDTO.getZipCode());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        User user = authService.getAuthenticatedUser();
        
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        
        // Valida se o endereço pertence ao usuário autenticado
        if (address.getUser().getId() != user.getId()) {
            throw new RuntimeException("Você não tem permissão para deletar este endereço");
        }
        
        addressRepository.delete(address);
    }
}
