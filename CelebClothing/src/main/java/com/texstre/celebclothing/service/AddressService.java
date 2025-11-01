package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.DeliveryAddress;
import com.texstre.celebclothing.entity.UserDetails;
import com.texstre.celebclothing.repository.AddressRepository;
import com.texstre.celebclothing.util.AddressMapper;
import com.texstre.celebclothing.util.NullAwareBeanUtilsBean;
import com.texstre.celebclothing.util.UserMapper;
import com.texstre.model.DeliveryAddressDTO;
import com.texstre.model.UserDTO;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private AddressMapper addressMapper;

    public void addDeliveryAddress(DeliveryAddressDTO delAddressDTO) {
        DeliveryAddress deliveryAdd = DeliveryAddress.builder()
                .linkedUsrId(delAddressDTO.getUserId())
                .contactName(delAddressDTO.getContactName())
                .contactNum(delAddressDTO.getContactNum())
                .addressLine1(delAddressDTO.getAddressLine1())
                .addressLine2(delAddressDTO.getAddressLine2())
                .city(delAddressDTO.getCity())
                .state(delAddressDTO.getState())
                .pinCode(delAddressDTO.getPinCode())
                .country(delAddressDTO.getCountry())
                .build();
        addressRepo.save(deliveryAdd);
    }

    public List<DeliveryAddress> getAllDeliveryAddresses(String userId) {
        return addressRepo.findByLinkedUsrId(userId);
    }

    @Transactional
    public DeliveryAddress updateAddress(DeliveryAddressDTO updatableAddr) {
        Optional<DeliveryAddress> existingAddr = addressRepo.findById(updatableAddr.getAddressId());
        if(existingAddr.isPresent()) {
            BeanUtilsBean nullAwareBeanUtils = new NullAwareBeanUtilsBean();
            try {
                DeliveryAddress updAddrEntity = existingAddr.get();
                // Not allowing updation of Address ID & Linked User ID
                updatableAddr.setAddressId(null);
                updatableAddr.setUserId(null);
                nullAwareBeanUtils.copyProperties(updAddrEntity,
                        addressMapper.deliveryAddressDTOToDeliveryAddress(updatableAddr));
                return addressRepo.save(updAddrEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void removeDeliveryAddress(Long addressId) {
        addressRepo.deleteById(addressId);
    }

    public DeliveryAddress getDeliveryAddressById(Long addressId) {
        return addressRepo.findById(addressId).orElse(null);
    }
}

