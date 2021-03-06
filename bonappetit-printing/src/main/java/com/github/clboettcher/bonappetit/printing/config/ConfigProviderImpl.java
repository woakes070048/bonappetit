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
package com.github.clboettcher.bonappetit.printing.config;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

/**
 * Default impl of {@link ConfigProvider}.
 */
@Component
public class ConfigProviderImpl implements ConfigProvider {

    /**
     * The titles of the options or radio items which should be printed in an emphasised way.
     */
    private Set<String> emphasisedOptionTitles;

    /**
     * The titles of the options or radio items which should not be printed at all.
     */
    private Set<String> notPrintedOptionTitles;


    /**
     * Constructor initializing the provider with values form config.
     *
     * @param environment The spring environment to access the configuration.
     */
    @Autowired
    public ConfigProviderImpl(Environment environment) {
        Preconditions.checkNotNull(environment, "environment");
        this.emphasisedOptionTitles = split(environment.getRequiredProperty("printing.options.emphasised"));
        this.notPrintedOptionTitles = split(environment.getRequiredProperty("printing.options.notPrinted"));
    }

    /**
     * Splits the given comma separated {@code string} into trimmed elements, omitting empty strings.
     *
     * @param string The string to split, may be null or empty.
     * @return The splitted string.
     */
    private Set<String> split(String string) {
        if (StringUtils.isBlank(string)) {
            return Collections.emptySet();
        }

        return Sets.newHashSet(Splitter.on(',')
                .omitEmptyStrings()
                .trimResults()
                .split(string));
    }

    @Override
    public Set<String> getEmphasisedOptionTitles() {
        return emphasisedOptionTitles;
    }

    @Override
    public Set<String> getNotPrintedOptionTitles() {
        return notPrintedOptionTitles;
    }
}
