
package com.iluwatar.flux.store;

import com.iluwatar.flux.action.Content;
import com.iluwatar.flux.action.ContentAction;
import com.iluwatar.flux.action.MenuAction;
import com.iluwatar.flux.action.MenuItem;
import com.iluwatar.flux.view.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Date: 12/12/15 - 10:18 PM
 *
 * @author Jeroen Meulemeester
 */
public class MenuStoreTest {

  @Test
  public void testOnAction() throws Exception {
    final MenuStore menuStore = new MenuStore();

    final View view = mock(View.class);
    menuStore.registerView(view);

    verifyZeroInteractions(view);

    // Menu should not react on content action ...
    menuStore.onAction(new ContentAction(Content.COMPANY));
    verifyZeroInteractions(view);

    // ... but it should react on a menu action
    menuStore.onAction(new MenuAction(MenuItem.PRODUCTS));
    verify(view, times(1)).storeChanged(eq(menuStore));
    verifyNoMoreInteractions(view);
    assertEquals(MenuItem.PRODUCTS, menuStore.getSelected());

  }

}
