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
package com.github.clboettcher.bonappetit.server.persistence.impl.entity.menu;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * An option that consists of multiple items of which one must be selected.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class RadioOptionEntity extends AbstractOptionEntity {

    /**
     * The default selected item.
     * <p/>
     * This item should be selected per default when this option is available.
     * <p/>
     * Must be contained ind the list of items as returned by {@link #getRadioItems()}.
     */
    @OneToOne
    @JoinColumn(name = "RADIO_ITEM_ID")
    private RadioItemEntity defaultSelected;

    /**
     * The items that this option consists of.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "OPTION_ID", nullable = false)
    private Set<RadioItemEntity> radioItems;

    /**
     * Constructor setting the specified properties.
     *
     * @param id              see {@link #getId()}.
     * @param title           see {@link #getTitle()}.
     * @param index           see {@link #getIndex()}.
     * @param defaultSelected see {@link #getDefaultSelected()}.
     * @param radioItems      see {@link #getRadioItems()}.
     */
    @Builder
    public RadioOptionEntity(long id, String title, Integer index, RadioItemEntity defaultSelected, Set<RadioItemEntity> radioItems) {
        super(id, title, index);
        this.defaultSelected = defaultSelected;
        this.radioItems = radioItems;
    }
}
