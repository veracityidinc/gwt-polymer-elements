# gwt-polymer-elements

[![Join the chat at https://gitter.im/vaadin/gwt-polymer-elements](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/vaadin/gwt-polymer-elements?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)


## NOTICE: This library is no longer supported by Vaadin

Vaadin transfers the ownership of this library, thus Vaadin no longer provides support or does active development on it. 

We took this decision because once demonstrated that polymer elements could be easily be integrated in GWT, we want to invest our team’s time in adding valuable user benefits to Vaadin Core Elements, and pass the baton to the community to do integrations with other frameworks.

**In addition, we are happy to announce that ownership of the repository will be transferred by 20 Apr 2017 to [@manolo](https://github.com/manolo), who will continue to maintain it.**

**If you are willing to participate as a collaborator, please leave a comment in [#151](https://github.com/vaadin/gwt-polymer-elements/issues/151). The collaborators will be granted access after transferring. We encourage contribution in any form and shape.**

## Introduction

- **Polymer**: is a JavaScript library for building web applications with Web Components.
- **Polymer-Elements**: is a collection of widgets built in Polymer. The collection is divided in sections: _Iron, Paper, Gold, Neon, Platinum, Vaadin,_ etc.
-  **GWT-Polymer-Elements**: is a Java wrapper enabling Polymer Elements to be used in GWT projects. Right now it includes wrappers for [Iron](https://elements.polymer-project.org/browse?package=iron-elements),
[Paper](https://elements.polymer-project.org/browse?package=paper-elements),
[App](https://elements.polymer-project.org/browse?package=app-elements),
[Platinum](https://elements.polymer-project.org/browse?package=platinum-elements) and
[Vaadin](https://vaadin.com/elements) collections, but more might be added in the future.

 The library has been generated using the Vaadin [gwt-api-generator](https://github.com/veracityid/gwt-api-generator), an utility able to inspect polymer webcomponents and emit GWT Java code.

 Because Polymer differentiates between collections, gwt-polymer-elements classes are prefixed with the same prefixes (_Iron, Paper, Vaadin_), in order to easily refer to the original web component, and to easily find the documentation related with it.

## Demo
 Visit our [show case](http://manolo.github.io/gwt-polymer-elements/demo/) to see how components look like, and to take a look to the example code using each component.

## Javadocs
 When we parse the original components code to generate the Java API, we copy all the existing JS documentation so as it's available in the [javadoc](http://vaadin.github.io/gwt-polymer-elements/api/). Note that sometimes descriptions would refer to JS, but we consider that it's better to maintain the info.


## Using the GWT library

You need at least GWT-2.8.0 to use the library.

### Add vaadin gwt-polymer-elements to your CLASSPATH
The `.jar` file includes all the java code and web components of
Polymer Iron and Paper collections, so as you don't have to deal with the process of downloading and deploying all js wrapped libraries and components.

##### Using maven

 - If your project uses maven add the following dependency to your `pom.xml`

  ```xml
   <dependencies>
     <dependency>
       <groupId>com.vaadin.polymer</groupId>
       <artifactId>gwt-polymer-elements</artifactId>
       <version>1.11.3-SNAPSHOOT</version>
       <scope>provided</scope>
     </dependency>
   </dependencies>
  ```

##### Manually
- otherwise you can [download](http://repo1.maven.org/maven2/com/vaadin/polymer/vaadin-gwt-polymer-elements/)
  the `vaadin-gwt-polymer-elements-1.9.3.1.jar` archive and put it in your gwt project classpath.

### Update your module configuration

- Add this line to your `*.gwt.xml` module file:

 ```xml
  <inherits name="com.vaadin.polymer.Elements"/>

 ```

### Add the Web Components Polyfill (Optional). 

- Only Chrome has full native support for Web Components nowadays, therefore, to make your project work with all modern browsers, you have to include the WebComponents Polyfill.

  If you use the polymer components as `Widgets`, the library will lazy load it when needed.
Otherwise load it very early in your `.html` host page as it is shown in the following code.

```html
<head>
    <script src="myapp/bower_components/webcomponentsjs/webcomponents.js"></script>
    <script src="myapp/myapp.nocache.js"></script>
</head>
```

## Consuming Web Components in GWT

Vaadin `gwt-polymer-elements` bundles classes to build your application using either `Widgets` or JsInterop `Elements`. The former is the classic approach, while the latter will become the new tendency.

But Right now, `Elements` is the most difficult way because GWT lacks of a complete `Elemental-2.0` API relying on `JsInterop`.
We provide a very small set of elemental interfaces limited to those needed for our implementation, they will be replaced by Elemental-2.0 when it was available.

In summary, for classic and production GWT projects it would be easier to use the `Widget` since the API would not have important changes. Otherwise, if you want to get rid of the widget hierarchy we recommend to start using the `Element` API mixing it with some DOM manipulation library like `gwtquery` or just the methods included in the elemental API.


 - Using the classic **Widget API** in Java.

  ```java
  PaperButton button = new PaperButton();
  button.setIcon("polymer");
  button.setLabel("Polymer");
  button.setRaised(true);

  button.addClickHandler(new ClickHandler() {
    public void onClick(ClickEvent event) {
      // ...
    }
  });

  RootPanel.get().add(button);
  ```

  _Note: Widget constructors accept any HTML content as argument which is appended to the web component rendered DOM_

 - Using the **Element API** in Java.

  ```java
  // Create a new instance of PaperButton
  PaperButtonElement button = Polymer.createElement(PaperButtonElement.TAG);
  // Set some properties
  button.setIcon("polymer");
  button.setLabel("Polymer");
  button.setRaised(true);

  // Add event listeners
  button.addEventListener("click", new EventListener() {
      public void onBrowserEvent(Event event) {
      // ...
      }
  });

  // Append to the html document
  RootPanel.get().getElement().appendChild(button);
  ```

 - Using `Widgets` or `Elements` in **UiBinder**

  ```xml
   <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'
    xmlns:g='urn:import:com.google.gwt.user.client.ui'
    xmlns:p='urn:import:com.vaadin.polymer.paper.widget'>

   <ui:style>
     .container paper-button.colored {
       background: #4285f4;
       color: #fff;
     }
   </ui:style>

   <g:HTMLPanel>
     <!-- As Widget -->
     <p:PaperButton toggles="true" raised="true" active="true" addStyleNames="{style.colored}">active</p:PaperButton>

     <!-- As Element -->
     <paper-button raised="" noink="">Click me</paper-button>
   </g:HTMLPanel>

  ```

## **Styling** your application.

  Polymer uses Shadow DOM styling rules for providing scoped styling of the element’s local DOM. It supports  some extra syntax which is not understable by the GWT GSS parser.

  Polymer takes care of its syntax parsing any `<style>` block you might have in your host page, but if you want to specify some styling rules in UiBinder, you have to add your style blocks to any panel.

  ```xml
<ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'
    xmlns:g='urn:import:com.google.gwt.user.client.ui'
    xmlns:p='urn:import:com.vaadin.polymer.paper.widget'>

<g:HTMLPanel>
  <style is="custom-style">
     paper-toolbar paper-icon-button {
        --paper-icon-button-ink-color: var(--paper-indigo-500);
     }
  </style>
  <p:PaperToolbar>
     <p:PaperIconButton icon="menu"/>
     <span class="title">Toolbar</span>
  </p:PaperToolbar>
</g:HTMLPanel>
  ```

  For more information about polymer styling syntax visit their [documentation](https://www.polymer-project.org/1.0/docs/devguide/styling.html)

## Notes

### Java Sources
  If you want to dive into `.java` sources, we don't maintain generated files, thus you need to download the [vaadin-gwt-polymer-elements-x.x.x-sources.jar](http://repo1.maven.org/maven2/com/vaadin/polymer/vaadin-gwt-polymer-elements/) bundle.
  Otherwise you might take a look java helper classes and templates look in the [gwt-api-generator](https://github.com/manolo/gwt-api-generator) project.

### Importing Web Components
  Before using any component, you have to import the appropriate files. But `gwt-polymer-elements` comes with some utilities so as you it would be done automatically.

 - **Widgets** :
  When you use a widget, the import happens automatically
 ```
     PaperButton button = new PapperButton();
 ```
 - **Elements** :
  Create new components through the `Polymer` helper class
 ```
     PaperButtonElement button = Polymer.createElement(PaperButtonElement.TAG);
 ```
 - **Dynamic imports** :
  `Polymer` has a couple of methods to do the import dynamically
 ```
     Polymer.importHref("paper-button/paper-button.html");
 ```
 - **Static imports** :
  Adding tags to the hosted page head is the traditional way to make webcomponents available if you want them in a mixed application (DOM, JS, or GWT) or if you want to be sure that web components are available from the beginning.
 ```
    <link rel='import' href='application_context/bower_components/paper-button/paper-button.html'></link>
 ```

### Asynchronous issues
   Web Components could be registered and initialised asynchronously. Thus `gwt-polymer-elements` comes with some methods which helps to run callbacks when the component is actually ready.
   

 ```
   PaperButtonElement button = Polymer.createElement(PaperButtonElement.TAG);
   Polymer.ready(button, new Function() {
      public Object call(Object args) {
         // Set button properties here
      }
   })

   PolymerButton button = new PolymerButton();
   // You could set methods here
   button.setFoo(bar);

   button.ready(new Function() {
      public Object call(Object args) {
        // But you have to enclose in a callback calls to element methods
      }
   });


   Polymer.importHref(Arrays.asList("paper-tabs", "paper-tab-element"), new Function() {
      public Object call(Object args) {
         // Create your elements here and call their methods
      }
   })

 ```

## Contributors

## Building the project

To compile the vaadin `gwt-polymer-elements` library by yourself.

 1. Clone the repository with `$ git checkout https://github.com/veracityidinc/gwt-polymer-elements.git`
 1. Change to the project folder `$ cd gwt-polymer-elements`
 1. Run $ ./install.sh to download all components to the src/main/resources folder, to create all java files needed for GWT in the src/main/java/ folder and to compile and install the components library in you local maven repo.

 ## Building on different branch than master; i.e. stop polluting the master

  1. Create a new branch; e.g. `$ git checkout -b bpetridean`
  1. Open `package.json` and in `postinstall` line replace `master` with `bpetridean`; e.g. `"postinstall": "node_modules/.bin/gwt-api-generator --package=git@github.com:veracityidinc/gwt-polymer-elements.git#bpetridean --groupId=com.vaadin.polymer --artifactId=gwt-polymer-elements --pom && mvn clean install"`
  1. Add, commit and push your changes in scope of the newly created branch; e.g. `bpetridean`

  ## Building on localhost

  1. Open `package.json` and in `postinstall` line remove `package` arg; e.g. `"postinstall": "node_modules/.bin/gwt-api-generator --groupId=com.vaadin.polymer --artifactId=gwt-polymer-elements --pom && mvn clean install"`
  1. Run `bower install` to download all dependencies
  1. Run `npm install` to build the java wrappers and install the jar in scope of local `.m2`