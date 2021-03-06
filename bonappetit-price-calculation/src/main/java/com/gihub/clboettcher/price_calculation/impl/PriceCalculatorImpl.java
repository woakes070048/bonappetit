/*
 * Copyright (c) 2016 Claudius Boettcher (pos.bonappetit@gmail.com)
 *
 * This file is part of BonAppetit. BonAppetit is an Android based
 * Point-of-Sale client-server application for small restaurants.
 *
 * BonAppetit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BonAppetit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with BonAppetit.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gihub.clboettcher.price_calculation.impl;

import com.gihub.clboettcher.price_calculation.api.PriceCalculator;
import com.github.clboettcher.bonappetit.domain.menu.RadioItem;
import com.github.clboettcher.bonappetit.domain.order.*;
import com.google.common.base.Preconditions;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

/**
 * Default impl of {@link PriceCalculator}.
 */
public class PriceCalculatorImpl implements PriceCalculator {

    @Override
    public BigDecimal calculateTotalPrice(ItemOrder itemOrder) {
        Preconditions.checkNotNull(itemOrder, "itemOrder");
        Preconditions.checkNotNull(itemOrder.getPrice(), "itemOrder.getPrice()");
        BigDecimal result = itemOrder.getPrice();

        final Set<OptionOrder> optionOrders = itemOrder.getOptionOrders();
        if (CollectionUtils.isNotEmpty(optionOrders)) {
            for (OptionOrder optionOrder : optionOrders) {
                if (optionOrder instanceof ValueOptionOrder) {
                    ValueOptionOrder valueOptionOrder = (ValueOptionOrder) optionOrder;
                    final BigDecimal valueOptionOrderPrice = valueOptionOrder.getOption().getPriceDiff().multiply(
                            new BigDecimal(String.valueOf(valueOptionOrder.getValue())));
                    result = result.add(valueOptionOrderPrice);
                } else if (optionOrder instanceof RadioOptionOrder) {
                    RadioOptionOrder radioOptionOrder = (RadioOptionOrder) optionOrder;
                    RadioItem selectedItem = radioOptionOrder.getSelectedItem();
                    result = result.add(selectedItem.getPriceDiff());
                } else if (optionOrder instanceof CheckboxOptionOrder) {
                    CheckboxOptionOrder checkboxOptionOrder = (CheckboxOptionOrder) optionOrder;
                    result = result.add(checkboxOptionOrder.getOption().getPriceDiff());
                } else {
                    throw new IllegalArgumentException(String.format("Could not calculate price for option order with " +
                            "unknown type %s", (optionOrder != null ? optionOrder.getClass().getSimpleName() : "<null>")));
                }
            }
        }

        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
