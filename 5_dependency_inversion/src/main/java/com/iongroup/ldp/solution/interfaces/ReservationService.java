package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.model.Cart;

public interface ReservationService {
 void reserveInventory(Cart cart) throws Exception;
}
