/**
 * Copyright (C) 2015 Alfresco Software Limited.
 *
 * This file is part of the Alfresco SDK Samples project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.alfresco.tutorials.pages

import geb.Page

/**
 * Alfresco Share Repository Browser Page Object
 *
 * @author marting.bergljung@alfresco.com
 */
class RepositoryPage extends Page {
    // The relative URL of the page;
    // used by the to() method to determine which URL to send the HTTP request to.
    static url = "page/repository"

    // A closure that indicates whether the current page is this one or not -
    // called by the at() method; it should return a boolean, but you can also include assertions.
    static at = { title == "Alfresco » Repository Browser" }

    // A description of the page content, allowing for easy access to the parts declared here.
    // If it is not working for some content items then have a look at the Geb reports directory,
    // which contains the HTML that Geb is seeing... (i.e.
    // integration-test-runner/target/geb-reports/org/alfresco/tutorials/testSpecs/SurfModuleExtensionsTestSpec)
    static content = {
        /*
        <div class="create-content">
            <span class="yui-button yui-push-button yui-menu-button" id="template_x002e_documentlist_v2_x002e_repository_x0023_default-createContent-button">
                <span class="first-child">
                    <button type="button" aria-haspopup="true" tabindex="0"
                            id="template_x002e_documentlist_v2_x002e_repository_x0023_default-createContent-button-button">
                                    Create... ▾</button>
        */
        createMenuButton { $("div.create-content span span button", text: startsWith("Create...")) }

        /*
        <div class="bd">
            <ul class="first-of-type">
                <li id="yui-gen0" class="yuimenuitem first-of-type" groupindex="0" index="0">
                    <a rel="" href="/share/page/create-content?destination=%7BnodeRef%7D&amp;itemId=acme:document&amp;mimeType=text/plain" class="yuimenuitemlabel">
                    */
        createAcmeDocumentLink(to: CreateAcmeDocumentPage) { $("a", href : contains("itemId=acme:document")) }

        /*
        <a rel="|path|/Data%20Dictionary|" class="filter-change" href="#">Data Dictionary</a>
         */
        dataDictionaryFolderLink(to : RepositoryPage) { $("a", rel : contains("|path|/Data%20Dictionary|")) }
    }
}