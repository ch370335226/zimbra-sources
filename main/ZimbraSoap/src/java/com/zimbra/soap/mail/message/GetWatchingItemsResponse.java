/*
 * ***** BEGIN LICENSE BLOCK *****
 * Zimbra Collaboration Suite Server
 * Copyright (C) 2011, 2012 VMware, Inc.
 * 
 * The contents of this file are subject to the Zimbra Public License
 * Version 1.3 ("License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 * http://www.zimbra.com/license.
 * 
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * ***** END LICENSE BLOCK *****
 */

package com.zimbra.soap.mail.message;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.zimbra.common.soap.MailConstants;
import com.zimbra.common.soap.OctopusXmlConstants;
import com.zimbra.soap.mail.type.WatchingTarget;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name=OctopusXmlConstants.E_GET_WATCHING_ITEMS_RESPONSE)
public class GetWatchingItemsResponse {

    /**
     * @zm-api-field-description Watching targets
     */
    @XmlElement(name=MailConstants.E_TARGET /* target */, required=false)
    private List<WatchingTarget> targets = Lists.newArrayList();

    public GetWatchingItemsResponse() {
    }

    public void setTargets(Iterable <WatchingTarget> targets) {
        this.targets.clear();
        if (targets != null) {
            Iterables.addAll(this.targets,targets);
        }
    }

    public void addTarget(WatchingTarget target) {
        this.targets.add(target);
    }

    public List<WatchingTarget> getTargets() {
        return Collections.unmodifiableList(targets);
    }

    public Objects.ToStringHelper addToStringInfo(Objects.ToStringHelper helper) {
        return helper
            .add("targets", targets);
    }

    @Override
    public String toString() {
        return addToStringInfo(Objects.toStringHelper(this)).toString();
    }
}
