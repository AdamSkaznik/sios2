package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Address;
import local.wpr.start.sios.repository.AddressRepository;
import local.wpr.start.sios.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private static final Logger LOG = LoggerFactory.getLogger(AddressServiceImpl.class);
    @Autowired
    AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public List<Address> getAllAddress() {
//        try {
            return addressRepository.findAll();
//        } catch (Exception e){
//            return e.getMessage();
//        }
//        return addressRepository.findAll();
    }

    @Override
    public Address getAdresById(Integer addressId) {
        return addressRepository.getReferenceById(addressId);
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
}
