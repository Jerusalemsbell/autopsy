/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.keywordsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Action;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.nodes.Node.Property;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;
import org.sleuthkit.autopsy.directorytree.ExternalViewerAction;
import org.sleuthkit.autopsy.directorytree.ExtractAction;
import org.sleuthkit.autopsy.directorytree.NewWindowViewAction;
import org.sleuthkit.datamodel.Content;
import org.sleuthkit.datamodel.ContentVisitor;
import org.sleuthkit.datamodel.File;

/**
 * Filter Node to add a "Snippet" property containing the first snippet of
 * content matching the search that the Node was found with, and to provide
 * the full highlighted content as a MarkupSource
 */
class KeywordSearchFilterNode extends FilterNode {

    String solrQuery;

    KeywordSearchFilterNode(HighlightedMatchesSource highlights, Node original, String solrQuery) {
        super(original, null, new ProxyLookup(Lookups.singleton(highlights), original.getLookup()));
        this.solrQuery = solrQuery;
    }

    String getSnippet() {
        final Content content = this.getOriginal().getLookup().lookup(Content.class);
        final String snippet = LuceneQuery.querySnippet(solrQuery, content.getId());
        return snippet;
    }

    Property<String> getSnippetProperty() {

        Property<String> prop = new PropertySupport.ReadOnly("snippet",
                String.class, "Context", "Snippet of matching content.") {

            @Override
            public Object getValue() {
                return getSnippet();
            }
        };

        prop.setValue("suppressCustomEditor", Boolean.TRUE); // remove the "..." (editing) button

        return prop;
    }

    @Override
    public Node.PropertySet[] getPropertySets() {
        Node.PropertySet[] propertySets = super.getPropertySets();

        for (int i = 0; i < propertySets.length; i++) {
            Node.PropertySet ps = propertySets[i];

            if (ps.getName().equals(Sheet.PROPERTIES)) {
                Sheet.Set newPs = new Sheet.Set();
                newPs.setName(ps.getName());
                newPs.setDisplayName(ps.getDisplayName());
                newPs.setShortDescription(ps.getShortDescription());

                Property[] oldProperties = ps.getProperties();

                int j = 0;
                for (Property p : oldProperties) {
                    if (j++ == 1) {
                        newPs.put(getSnippetProperty());
                    }
                    newPs.put(p);
                }

                propertySets[i] = newPs;
            }
        }

        return propertySets;
    }
    
    /**
     * Right click action for the nodes that we want to pass to the directory
     * table and the output view.
     *
     * @param popup
     * @return actions
     */
    @Override
    public Action[] getActions(boolean popup) {

        List<Action> actions = new ArrayList<Action>();
        
        Content content = this.getOriginal().getLookup().lookup(Content.class);
        actions.addAll(content.accept(new GetPopupActionsContentVisitor()));
        
        //actions.add(new IndexContentFilesAction(nodeContent, "Index"));

        return actions.toArray(new Action[actions.size()]);
    }
    
    
    private class GetPopupActionsContentVisitor extends ContentVisitor.Default<List<Action>> {
        
        @Override
        public List<Action> visit(File f) {
            List<Action> actions = new ArrayList<Action>();
            actions.add(new NewWindowViewAction("View in New Window", KeywordSearchFilterNode.this));
            actions.add(new ExternalViewerAction("Open in External Viewer", getOriginal()));
            actions.add(new ExtractAction("Extract File", getOriginal()));
            return actions;
        }
        @Override
        protected List<Action> defaultVisit(Content c) {
            return Collections.EMPTY_LIST;
        }
        
    }
}
