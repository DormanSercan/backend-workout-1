package com.sercandorman.bookesh.helper;

import com.sercandorman.bookesh.dto.CartDTO;
import com.sercandorman.bookesh.model.Order;
import com.sercandorman.bookesh.model.OrderFoodAndBeverage;
import com.sercandorman.bookesh.model.FoodAndBeverage;
import com.sercandorman.bookesh.repository.FoodAndBeverageRepository;
import com.sercandorman.bookesh.repository.OrderFoodAndBeverageRepository;
import com.sercandorman.bookesh.shared.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class APIHelper {

    public static List<OrderFoodAndBeverage> prepareOrderFoodAndBeverageList(Order order, List<CartDTO> cartDTOList) {
        return cartDTOList.stream()
                .map(cartItemDTO -> new OrderFoodAndBeverage(order, new FoodAndBeverage(cartItemDTO.getFoodAndBeverageId()), cartItemDTO.getQuantity()))
                .collect(Collectors.toList());
    }

    public static double calculateCartTotalPrice(List<CartDTO> cartDTOList, FoodAndBeverageRepository foodAndBeverageRepository) {
        double totalPrice = cartDTOList.stream()
                .map(cartDTO -> {
                    FoodAndBeverage foodAndBeverage = foodAndBeverageRepository.findByIdOrThrow(cartDTO.getFoodAndBeverageId());
                    return foodAndBeverage.getPrice() * cartDTO.getQuantity();
                })
                .mapToDouble(Double::doubleValue)
                .sum();
        return totalPrice;
    }
}
