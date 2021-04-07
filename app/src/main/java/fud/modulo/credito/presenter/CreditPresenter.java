package fud.modulo.credito.presenter;

import fud.modulo.credito.models.CreditInteractor;

public interface CreditPresenter {


    void validatePrestamo(String quantity);

    void onDestroy();



}
