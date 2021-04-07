package fud.modulo.credito.models;

import android.util.Log;

import java.util.ArrayList;

import fud.modulo.credito.network.APIClient;
import fud.modulo.credito.pojo.SuccesCreditDataPOJO;
import fud.modulo.credito.pojo.ValidateCreditDataPOJO;
import fud.modulo.credito.pojo.ValidateCreditDetailsPOJO;
import fud.modulo.credito.presenter.PresenterCreditImpl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreditInteractorImpl implements CreditInteractor{

    double TAX;// = 0.0327;
    int min=100, max;
    int quantity = 0;
    private String date;
    private OnCreditFinishedListener listener;
    double taxAux;double total;


    public CreditInteractorImpl() {

    }


    @Override
    public void credit(String quantity, OnCreditFinishedListener listener) {
        this.listener = listener;
        this.quantity = Integer.parseInt(quantity);
        validateQuantity(quantity);

    }

    //calcula las cifras del credito
    private void validateQuantity(String quantity) {
        if(quantity.equalsIgnoreCase("0")){
            request();

        }else {
            //date ="23 de Enero de 2021";
            this.quantity = Integer.parseInt(quantity);

            taxAux = Math.ceil(this.quantity*TAX);
            total = Math.ceil(this.quantity+taxAux);
            listener.onSuccess(total, taxAux, date);
        }

    }

//datos que vienen de backend
    private void request() {
        ValidateCreditDetailsPOJO pjo = new ValidateCreditDetailsPOJO
                (
                "50000",
                        "150000",
                        "2025-12-03",
                        "0.05",
                        "Transacción aceptada"
        );

        min = Integer.parseInt(pjo.getAmountMin());
        max = Integer.parseInt(pjo.getAmounMax());
        date = pjo.getDateLimit();
        TAX = Double.parseDouble(pjo.getTax());
        Log.d("TAG" ,"onResponse: "+min
                +max
                +date
                +TAX );
        listener.valuesCreditDefault(min, max);

        taxAux = Math.ceil(min*TAX);
        total = Math.ceil(min+taxAux);
        listener.onSuccess(total, taxAux, date);
 /* Si tiene API utilice este fragmento de código con su respectivo endPoint
        Call<ValidateCreditDataPOJO> call = APIClient.getInstance()
                .getCredit("ID_USER");

        call.enqueue(new Callback<ValidateCreditDataPOJO>() {

            @Override
            public void onResponse(Call<ValidateCreditDataPOJO> call, Response<ValidateCreditDataPOJO> response) {
                if(response.isSuccessful()){
                    if(response.body().getSuccess().equalsIgnoreCase("1")){
                        ValidateCreditDetailsPOJO pjo = response.body().getData();

                            min = Integer.parseInt(pjo.getAmountMin());
                            max = Integer.parseInt(pjo.getAmounMax());
                            date = pjo.getDateLimit();
                            TAX = Double.parseDouble(pjo.getTax());
                           Log.d("TAG" ,"onResponse: "+min
                                    +max
                                    +date
                                    +TAX );
                        listener.valuesCreditDefault(min, max);

                        taxAux = Math.ceil(min*TAX);
                        total = Math.ceil(min+taxAux);
                        listener.onSuccess(total, taxAux, date);
                        }
                    }
                }


            @Override
            public void onFailure(Call<ValidateCreditDataPOJO> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t.getLocalizedMessage());
            }
        });*/
    }


}
