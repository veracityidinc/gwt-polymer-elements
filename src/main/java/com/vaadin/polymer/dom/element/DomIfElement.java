/*
 * This code was generated with Vaadin Web Component GWT API Generator, 
 * from polymer project by The Polymer Authors (http://polymer.github.io/AUTHORS.txt)
 * that is licensed with http://polymer.github.io/LICENSE.txt license.
 */
package com.vaadin.polymer.dom.element;

import com.vaadin.polymer.elemental.*;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

/**
 * 
 */
@JsType
public interface DomIfElement extends HTMLElement {

    public static final String TAG = "dom-if";
    public static final String SRC = "polymer/polymer.html";


    /**
     * 
     *
     * JavaScript Info:
     * @property if
     * @type Boolean
     * 
     */
    @JsProperty boolean getIf();
    /**
     * 
     *
     * JavaScript Info:
     * @property if
     * @type Boolean
     * 
     */
    @JsProperty void setIf(boolean value);
  
    /**
     * 
     *
     * JavaScript Info:
     * @method render
     * 
     */
    void render();

    /**
     * 
     *
     * JavaScript Info:
     * @property restamp
     * @type Boolean
     * 
     */
    @JsProperty boolean getRestamp();
    /**
     * 
     *
     * JavaScript Info:
     * @property restamp
     * @type Boolean
     * 
     */
    @JsProperty void setRestamp(boolean value);
  
    /**
     * 
     *
     * JavaScript Info:
     * @method attached
     * 
     */
    void attached();

    /**
     * 
     *
     * JavaScript Info:
     * @method detached
     * 
     */
    void detached();

    /**
     * 
     *
     * JavaScript Info:
     * @property extends
     * @type string
     * 
     */
    @JsProperty String getExtends();
    /**
     * 
     *
     * JavaScript Info:
     * @property extends
     * @type string
     * 
     */
    @JsProperty void setExtends(String value);
  
}
