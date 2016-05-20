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
    public final boolean isIndexed() {
        return indexed;
    }

    /**
     * Set the value of indexed attribute.
     *
     * @param indexed the value of indexed attribute.
     */
    public final void setIndexed(final boolean indexedp) {
        this.indexed = indexedp;
    }

    /**
     * Get the string value of xpath attribute.
     *
     * @return the value of xpath attribute.
     */
    public final String getXpath() {
        return xpath;
    }

    /**
     * Set the value of xpath attribute.
     *
     * @param xpath the value of xpath attribute.
     */
    public final void setXpath(final String xpathp) {
        this.xpath = xpathp;
    }

    /**
     * Get the boolean value of cached attribute.
     *
     * @return the value of cached attribute.
     */
    public final boolean isCached() {
        return cached;
    }

    /**
     * Set the value of cached attribute.
     *
     * @param cached the value of cache attribute.
     */
    public final void setCached(final boolean cachedp) {
        this.cached = cachedp;
    }

    /**
     * Get the boolean value of idMapped attribute.
     *
     * @return the value of idMapped attribute.
     */
    public final boolean isIdMapped() {
        return idMapped;
    }

    /**
     * Set the value of idMapped attribute.
     *
     * @param idMapped the value of idMapped attribute.
     */
    public final void setIdMapped(final boolean idMappedp) {
        this.idMapped = idMappedp;
    }

    /**
     * Get the value of clazz attribute.
     *
     * @return the value of clazz attribute.
     */
    public final Class getClazz() {
        return clazz;
    }

    /**
     * Set the value of clazz attribute.
     *
     * @param clazz the value of clazz attribute.
     */
    public final void setClazz(final Class clazzp) {
        this.clazz = clazzp;
    }

    /**
     * Get the value of cvParamClass attribute.
     *
     * @return the value of cvParamClass attribute.
     */
    public final Class getCvParamClass() {
        return cvParamClass;
    }

    /**
     * Set the value of cvParamClass attribute.
     *
     * @param cvParamClass the value of cvParamClass attribute.
     */
    public final void setCvParamClass(final Class cvParamClassp) {
        this.cvParamClass = cvParamClassp;
    }

    /**
     * Get the value of userParamClass attribute.
     *
     * @return the value of userParamClass attribute.
     */
    public final Class getUserParamClass() {
        return userParamClass;
    }

    /**
     * Set the value of userParamClass attribute.
     *
     * @param userParamClass the value of userParamClass attribute.
     */
    public final void setUserParamClass(final Class userParamClassp) {
        this.userParamClass = userParamClassp;
    }

    /**
     * Get the value of autoRefResolving attribute.
     *
     * @return the value of autoRefResolving attribute.
     */
    public final boolean isAutoRefResolving() {
        return autoRefResolving;
    }

    /**
     * Set the value of autoRefResolving attribute.
     *
     * @param autoRefResolving the value of autoRefResolving attribute.
     */
    public final void setAutoRefResolving(final boolean autoRefResolvingp) {
        this.autoRefResolving = autoRefResolvingp;
    }

    /**
     * Get the value of refResolverClass attribute.
     *
     * @return the value of refResolverClass attribute.
     */
    public final Class getRefResolverClass() {
        return refResolverClass;
    }

    /**
     * Set the value of refResolverClass attribute.
     *
     * @param refResolverClass the value of refResolverClass attribute.
     */
    public final void setRefResolverClass(final Class refResolverClassp) {
        this.refResolverClass = refResolverClassp;
    }

    /**
     * Get the value of tagName attribute.
     *
     * @return the value of tagName attribute.
     */
    public final String getTagName() {
        return tagName;
    }

    /**
     * Set the value of tagName attribute.
     *
     * @param tagName the value of tagName attribute.
     */
    public final void setTagName(final String tagNamep) {
        this.tagName = tagNamep;
    }

}
