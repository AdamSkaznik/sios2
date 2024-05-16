package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddress();
    Address getAdresById(Integer addressId);

    void saveAddress(Address address);
}
