/*
 * Date: 05-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.model.utils.MzQuantMLElementConfig.java
 *
 * jmzquantml is Copyright 2012 University of Liverpool.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.liv.jmzqml.model.utils;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 05-Jul-2012 15:16:59;
 */
public class MzQuantMLElementConfig {

    private String tagName;
    private boolean indexed;
    private String xpath;
    private boolean cached;
    private boolean idMapped;
    private Class clazz;
    private Class cvParamClass;
    private Class userParamClass;
    private boolean autoRefResolving;
    private Class refResolverClass;

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public boolean isCached() {
        return cached;
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    public boolean isIdMapped() {
        return idMapped;
    }

    public void setIdMapped(boolean idMapped) {
        this.idMapped = idMapped;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Class getCvParamClass() {
        return cvParamClass;
    }

    public void setCvParamClass(Class cvParamClass) {
        this.cvParamClass = cvParamClass;
    }

    public Class getUserParamClass() {
        return userParamClass;
    }

    public void setUserParamClass(Class userParamClass) {
        this.userParamClass = userParamClass;
    }

    public boolean isAutoRefResolving() {
        return autoRefResolving;
    }

    public void setAutoRefResolving(boolean autoRefResolving) {
        this.autoRefResolving = autoRefResolving;
    }

    public Class getRefResolverClass() {
        return refResolverClass;
    }

    public void setRefResolverClass(Class refResolverClass) {
        this.refResolverClass = refResolverClass;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
