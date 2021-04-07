package fud.modulo.credito.presenter;

import android.util.Log;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import fud.modulo.credito.models.CreditInteractor;
import fud.modulo.credito.views.CreditViews;

public class PresenterCreditImpl implements CreditPresenter, CreditInteractor.OnCreditFinishedListener {

    CreditViews creditViews;
    CreditInteractor creditInteractor;

    public PresenterCreditImpl(CreditViews creditoView, CreditInteractor creditInteractor) {
        this.creditViews = creditoView;
        this.creditInteractor = creditInteractor;
    }

    @Override
    public void validatePrestamo(String quantity) {
        creditInteractor.credit(quantity, this);
    }


    @Override
    public void valuesCreditDefault(int vMin, int vMax) {
        Log.d("TAG", "valuesCreditDefault: ");
        if(creditViews != null)
            creditViews.setValuesDefault(String.valueOf(vMin),String.valueOf(vMax));
    }

    @Override
    public void onSuccess(double total, double tax, String date) {
        if( creditViews != null ) {
            creditViews.navigateToHome();
            creditViews.setUpdateTax(tax);
            creditViews.setUpdateQuantity(total);
            creditViews.setUpdateDate(date);
            Log.d("miTAG1", "onSuccess: ");
        }else{
            Log.d("miTAG", "onSuccess: ");
        }
    }



    @Override
    public void onDestroy() {
        creditViews = null;
    }
}
