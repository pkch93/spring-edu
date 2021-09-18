package edu.pkch.spring.order;

public interface OrderService {
    Order create(Long memberId, String itemName, int itemPrice);
}
