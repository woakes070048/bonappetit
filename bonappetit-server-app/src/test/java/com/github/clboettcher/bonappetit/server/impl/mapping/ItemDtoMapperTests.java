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
package com.github.clboettcher.bonappetit.server.impl.mapping;

/**
 * Tests for {@link ItemDtoMapper}.
 */
public class ItemDtoMapperTests {

    // TODO repair
//    @Test
//    public void testItemsWithoutOptions() throws Exception {
//        Set<Item> inputItems = Sets.newHashSet(
//                Item.builder()
//                        .id(1)
//                        .title("Test Item w/ options")
//                        .price(new BigDecimal("1.5"))
//                        .type(ItemType.FOOD)
//                        .build(),
//                Item.builder()
//                        .id(2)
//                        .title("Test Item w/o options")
//                        .price(new BigDecimal("2.5"))
//                        .type(ItemType.DRINK_ALCOHOLIC)
//                        .options(null)
//                        .build()
//        );
//
//        Set<ItemDto> expectedItemDtos = Sets.newHashSet(
//                ItemDto.builder()
//                        .id(1L)
//                        .title("Test Item w/ options")
//                        .price(new BigDecimal("1.5"))
//                        .type(ItemDtoType.FOOD)
//                        .build(),
//                ItemDto.builder()
//                        .id(2L)
//                        .title("Test Item w/o options")
//                        .price(new BigDecimal("2.5"))
//                        .type(ItemDtoType.DRINK_ALCOHOLIC)
//                        .options(null)
//                        .build()
//        );
//
//        assertThat(ItemDtoMapper.INSTANCE.mapToItemDtos(inputItems), is(expectedItemDtos));
//    }
}
