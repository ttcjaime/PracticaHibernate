package com.jaimemendo.practica1ud3.model.repository;

import java.util.function.Consumer;

public interface ITransitionScreen {

        void navigateControl(Consumer<ITransitionScreen> accion);
        void goScreen(Consumer<ITransitionScreen> accion);
        void confirmNavigation(Object object, Consumer<ITransitionScreen> accion);

}
