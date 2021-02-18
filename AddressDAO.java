package com.cognixia.jumo.jdbc.connect;

import java.util.List;

public interface AddressDAO {
    List<Address> getAllAddresses();
    Address getAddress(int id);
    boolean addAddress(Address address);
    boolean updateAddress(Address address);
    boolean deleteAddress(int id);
}
