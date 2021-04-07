package fud.modulo.credito.models;

public interface CreditInteractor {

    interface OnCreditFinishedListener{
        void valuesCreditDefault(int vMin, int vMax);
        void onSuccess(double total, double tax, String date);
    }

    void credit(String quantity, OnCreditFinishedListener listener);

}
