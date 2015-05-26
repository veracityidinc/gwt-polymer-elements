# gwt-polymer
Allows to use polymer elements in GWT projects.

## Demo
  http://vaadin.github.io/gwt-polymer/demo.html

## Use the ready to use Polymer/Paper library for GWT

We have produced a `.jar` file which includes all the visual components of
Polymer and Paper collections, so as you don't have to deal with the process of
creating it.

 - If your project uses maven, configure it to use the Sonatype snapshot repository and add the dependency:

  ```
   <repositories>
     <repository>
       <id>sonatype-snapshots</id>
       <url>http://oss.sonatype.org/content/repositories/snapshots</url>
       <snapshots><enabled>true</enabled></snapshots>
       <releases><enabled>false</enabled></releases>
     </repository>
    ...
   </repositories>
   <dependencies>
     <dependency>
       <groupId>com.vaadin.components</groupId>
       <artifactId>gwt-polymer-elements</artifactId>
       <version>1.0-SNAPSHOT</version>
       <scope>provided</scope>
     </dependency>
   </dependencies>
  ```

- otherwise you can [download](https://oss.sonatype.org/content/repositories/snapshots/com/vaadin/components/gwt-polymer-elements/1.0-SNAPSHOT/)
  the `.jar` archive and put it in your gwt project classpath

- Finally add this line to your GWT module file:
 ```
  <inherits name="com.vaadin.components.gwt.polymer.PolymerElements"/>

 ```

## Build your own set of components.

You might want to select the components for your project, in this case you need to
follow these instructions:

 1.  Preparation: install `node.js`, `npm` and `bower` in your system, and check
 that `npm` and `bower` are in your PATH.
 1.  Go to the `gwt-polymer-elements` directory
 1.  Run `npm install`
 1.  Edit the `bower.json` file and add/remove the components you need for your project.
 1.  By default, the "dependencies" section of the `bower.json` file includes all paper
     elements
 1.  Any time you modify the list of components you have to run `bower install`.
 1.  Run `gulp gwt-api` in order to create all java files needed for GWT in the
     `gwt-polymer-elements/src/main/java/` folder.
 1.  Run `mvn clean install` to install the components library in you local maven repo.
 1.  You might save the `.jar` generated in the folder `gwt-polymer-elements/target` folder
 1.  To customize the name of the distributable artefact run
     `mvn clean install -Dname=your-library -Drelease=your-version`
 1.  If you want to run the demo, go to the demo folder `../gwt-polymer-demo`
 1.  Run `mvn gwt:run` to run the demo in SuperDevMode, otherwise run `mvn clean package` to
 obtain the `target/demo.war` application

## Screenshots

 - Example with GWT widgets: [all-in-one](http://prntscr.com/6k8np9)
 - Example with polymer GWT elements: [all-in-one](http://prntscr.com/6k8nm6)
 - Code generator in action: [Screencast](http://screencast.com/t/UMz0MG9nxhs)