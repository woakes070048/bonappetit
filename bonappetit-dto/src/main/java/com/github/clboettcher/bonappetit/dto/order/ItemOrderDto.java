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
package com.github.clboettcher.bonappetit.dto.order;

import com.github.clboettcher.bonappetit.dto.menu.ItemDto;
import com.github.clboettcher.bonappetit.dto.staff.StaffMemberDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@ApiModel(description = "An order for an item")
public class ItemOrderDto {

    @ApiModelProperty(value = "The ordered item", required = true)
    private ItemDto item;

    @ApiModelProperty(value = "The ordered options of the ordered item")
    private Set<OptionOrderDto> optionOrders;

    @ApiModelProperty(value = "The person or location that this order should be delivered to", required = true,
            example = "Table 4")
    private String deliverTo;

    @ApiModelProperty(value = "The staff member who took this order", required = true)
    private StaffMemberDto staffMember;

    @ApiModelProperty(value = "The time this order was taken", required = true)
    private Date orderTime;

    @ApiModelProperty(value = "A note further describing this order", example = "Without onions")
    private String note;

    @Builder
    public ItemOrderDto(ItemDto item, Set<OptionOrderDto> optionOrders, String deliverTo, StaffMemberDto staffMember, Date orderTime, String note) {
        this.item = item;
        this.optionOrders = optionOrders;
        this.deliverTo = deliverTo;
        this.staffMember = staffMember;
        this.orderTime = orderTime;
        this.note = note;
    }
}
