/*
 * Date: 05-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.model.utils.MzQuantMLElementConfig.java
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

package uk.ac.liv.pgb.jmzqml.model.utils;

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

    /**
     * Get the boolean value of indexed attribute.
     *
     * @return the value of indexed attribute.
     */
    public boolean isIndexed() {
        return indexed;
    }

    /**
     * Set the value of indexed attribute.
     *
     * @param indexed the value of indexed attribute.
     */
    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    /**
     * Get the string value of xpath attribute.
     *
     * @return the value of xpath attribute.
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * Set the value of xpath attribute.
     *
     * @param xpath the value of xpath attribute.
     */
    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    /**
     * Get the boolean value of cached attribute.
     *
     * @return the value of cached attribute.
     */
    public boolean isCached() {
        return cached;
    }

    /**
     * Set the value of cached attribute.
     *
     * @param cached the value of cache attribute.
     */
    public void setCached(boolean cached) {
        this.cached = cached;
    }

    /**
     * Get the boolean value of idMapped attribute.
     *
     * @return the value of idMapped attribute.
     */
    public boolean isIdMapped() {
        return idMapped;
    }

    /**
     * Set the value of idMapped attribute.
     *
     * @param idMapped the value of idMapped attribute.
     */
    public void setIdMapped(boolean idMapped) {
        this.idMapped = idMapped;
    }

    /**
     * Get the value of clazz attribute.
     *
     * @return the value of clazz attribute.
     */
    public Class getClazz() {
        return clazz;
    }

    /**
     * Set the value of clazz attribute.
     *
     * @param clazz the value of clazz attribute.
     */
    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    /**
     * Get the value of cvParamClass attribute.
     *
     * @return the value of cvParamClass attribute.
     */
    public Class getCvParamClass() {
        return cvParamClass;
    }

    /**
     * Set the value of cvParamClass attribute.
     *
     * @param cvParamClass the value of cvParamClass attribute.
     */
    public void setCvParamClass(Class cvParamClass) {
        this.cvParamClass = cvParamClass;
    }

    /**
     * Get the value of userParamClass attribute.
     *
     * @return the value of userParamClass attribute.
     */
    public Class getUserParamClass() {
        return userParamClass;
    }

    /**
     * Set the value of userParamClass attribute.
     *
     * @param userParamClass the value of userParamClass attribute.
     */
    public void setUserParamClass(Class userParamClass) {
        this.userParamClass = userParamClass;
    }

    /**
     * Get the value of autoRefResolving attribute.
     *
     * @return the value of autoRefResolving attribute.
     */
    public boolean isAutoRefResolving() {
        return autoRefResolving;
    }

    /**
     * Set the value of autoRefResolving attribute.
     *
     * @param autoRefResolving the value of autoRefResolving attribute.
     */
    public void setAutoRefResolving(boolean autoRefResolving) {
        this.autoRefResolving = autoRefResolving;
    }

    /**
     * Get the value of refResolverClass attribute.
     *
     * @return the value of refResolverClass attribute.
     */
    public Class getRefResolverClass() {
        return refResolverClass;
    }

    /**
     * Set the value of refResolverClass attribute.
     *
     * @param refResolverClass the value of refResolverClass attribute.
     */
    public void setRefResolverClass(Class refResolverClass) {
        this.refResolverClass = refResolverClass;
    }

    /**
     * Get the value of tagName attribute.
     *
     * @return the value of tagName attribute.
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Set the value of tagName attribute.
     *
     * @param tagName the value of tagName attribute.
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
