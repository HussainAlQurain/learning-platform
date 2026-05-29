package com.example.demo.views;

import com.example.demo.views.component.LogoutButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.server.menu.MenuEntry;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.PermitAll;


@Layout()
@PermitAll
public class MainLayout extends AppLayout {
    public static final String TITLE = "Marhala";
    private final AuthenticationContext authenticationContext;
    MainLayout(AuthenticationContext authenticationContext) {
        setPrimarySection(Section.DRAWER);
        this.authenticationContext = authenticationContext;
        if(authenticationContext.isAuthenticated()) {
            addToDrawer(createHeader(), new Scroller(createSideNav()), new LogoutButton(authenticationContext));
        }
        else {
            addToDrawer(createHeader(), new Scroller(createSideNav()));
        }
    }

    private Component createHeader()
    {
        var appLogo = VaadinIcon.COGS.create();
        appLogo.setColor("#009900");

        var appName = new Span(TITLE);
        appName.getStyle().setFontWeight(Style.FontWeight.BOLD);

        var header = new VerticalLayout(appLogo, appName);
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        return header;
    }
    private SideNav createSideNav()
    {
        var nav = new SideNav();
        MenuConfiguration.getMenuEntries().forEach(entry -> nav.addItem(createSideNavItem(entry)));
        return nav;
    }

    private SideNavItem createSideNavItem(MenuEntry menuEntry)
    {
        var item = new SideNavItem(menuEntry.title(), menuEntry.path());
        item.setMatchNested(true);
        if (menuEntry.icon() != null)
        {
            item.setPrefixComponent(new Icon(menuEntry.icon()));
        }
        return item;
    }

}
