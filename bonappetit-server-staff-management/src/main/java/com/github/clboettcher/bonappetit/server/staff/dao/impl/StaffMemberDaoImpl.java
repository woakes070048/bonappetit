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
package com.github.clboettcher.bonappetit.server.staff.dao.impl;

import com.github.clboettcher.bonappetit.server.staff.dao.StaffMemberDao;
import com.github.clboettcher.bonappetit.server.staff.et.StaffMemberEntity;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

/**
 * Default impl of {@link StaffMemberDao}.
 */
@Component
public class StaffMemberDaoImpl implements StaffMemberDao {

    /**
     * The repository for {@link StaffMemberEntity}s.
     */
    private StaffMemberEntityRepository staffMemberEntityRepository;

    /**
     * Constructor setting the specified properties.
     *
     * @param staffMemberEntityRepository see {@link #staffMemberEntityRepository}.
     */
    @Autowired
    public StaffMemberDaoImpl(StaffMemberEntityRepository staffMemberEntityRepository) {
        this.staffMemberEntityRepository = staffMemberEntityRepository;
    }

    @Override
    public Set<StaffMemberEntity> getStaffMembers() {
        Iterable<StaffMemberEntity> allEntities = staffMemberEntityRepository.findAll();
        if (!allEntities.iterator().hasNext()) {
            return Collections.emptySet();
        } else {
            return Sets.newHashSet(allEntities);
        }
    }
}
