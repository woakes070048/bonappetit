/*
* Copyright (c) 2015 Claudius Boettcher (pos.bonappetit@gmail.com)
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
package com.github.clboettcher.bonappetit.common.dto.staff;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Represents a staff member of the restaurant.
 */
public class StaffMemberDto {

    /**
     * See {@link #getName()}.
     */
    private String name;

    public StaffMemberDto() {
    }

    private StaffMemberDto(Builder builder) {
        setName(builder.name);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * @return The name of this staff member.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name see {@link #getName()}.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("name", name)
                .toString();
    }

    /**
     * {@code StaffMember} builder static inner class.
     */
    public static final class Builder {
        private String name;

        private Builder() {
        }

        /**
         * Sets the {@code name} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code name} to set
         * @return a reference to this Builder
         */
        public Builder name(String val) {
            name = val;
            return this;
        }

        /**
         * Returns a {@code StaffMember} built from the parameters previously set.
         *
         * @return a {@code StaffMember} built with parameters of this {@code StaffMember.Builder}
         */
        public StaffMemberDto build() {
            return new StaffMemberDto(this);
        }
    }
}