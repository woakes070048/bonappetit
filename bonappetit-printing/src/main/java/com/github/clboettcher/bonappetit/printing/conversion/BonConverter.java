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
package com.github.clboettcher.bonappetit.printing.conversion;

import com.github.clboettcher.bonappetit.domain.order.ItemOrder;
import com.github.clboettcher.bonappetit.printing.entity.Bon;

import java.util.Set;

/**
 * Contract for a converter from {@link ItemOrder} to {@link Bon}.
 */
public interface BonConverter {

    /**
     * Converts the given {@code orders} to {@link Bon}s.
     *
     * @param orders The orders to convert.
     * @return The conversion result.
     */
    Set<Bon> toBons(Set<ItemOrder> orders);
}
