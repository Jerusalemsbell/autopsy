/*
 * Autopsy Forensic Browser
 *
 * Copyright 2015-16 Basis Technology Corp.
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
package org.sleuthkit.autopsy.imagegallery.actions;

import java.util.HashSet;
import org.controlsfx.control.action.Action;
import org.sleuthkit.autopsy.imagegallery.ImageGalleryController;
import org.sleuthkit.autopsy.imagegallery.datamodel.Category;

/**
 *
 */
public class CategorizeGroupAction extends Action {

    public CategorizeGroupAction(Category cat, ImageGalleryController controller) {
        super(cat.getDisplayName(), actionEvent ->
                new CategorizeAction(controller, cat, new HashSet<>(controller.viewState().get().getGroup().getFileIDs()))
                .handle(actionEvent)
        );
    }
}
