
package com.iluwatar.flux.view;

import com.iluwatar.flux.action.MenuItem;
import com.iluwatar.flux.dispatcher.Dispatcher;
import com.iluwatar.flux.store.MenuStore;
import com.iluwatar.flux.store.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * MenuView is a concrete view.
 *
 */
public class MenuView implements View {

  private static final Logger LOGGER = LoggerFactory.getLogger(MenuView.class);

  private MenuItem selected = MenuItem.HOME;

  @Override
  public void storeChanged(Store store) {
    MenuStore menuStore = (MenuStore) store;
    selected = menuStore.getSelected();
    render();
  }

  @Override
  public void render() {
    for (MenuItem item : MenuItem.values()) {
      if (selected.equals(item)) {
        LOGGER.info("* {}", item);
      } else {
        LOGGER.info(item.toString());
      }
    }
  }

  public void itemClicked(MenuItem item) {
    Dispatcher.getInstance().menuItemSelected(item);
  }
}
